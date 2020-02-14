package com.siddharth.newsapp.Activites;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.siddharth.newsapp.Data.Article;
import com.siddharth.newsapp.Data.ArticleAdapter;
import com.siddharth.newsapp.Data.ArticleData;
import com.siddharth.newsapp.Data.ArticleListAsyncResponse;
import com.siddharth.newsapp.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArticleAdapter articleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ArticleData().getNewsList(new ArticleListAsyncResponse() {
            @Override
            public void processFinish(final ArrayList<Article> articles) {

                recyclerView = findViewById(R.id.recyclerView);
                articleAdapter = new ArticleAdapter(articles, getApplicationContext());

                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(articleAdapter);

                articleAdapter.setOnClickListener(new ArticleAdapter.OnItemClickListner() {
                    @Override
                    public void onItemClick(View view, int position) {

                        Article article = articles.get(position);

                        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                        intent.putExtra("url", article.getNewsUrl());
                        startActivity(intent);

                    }
                });


            }
        });
    }
}

