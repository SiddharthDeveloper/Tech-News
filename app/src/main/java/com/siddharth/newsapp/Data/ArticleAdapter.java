package com.siddharth.newsapp.Data;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.siddharth.newsapp.R;
import com.siddharth.newsapp.Util.Util;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private ArrayList<Article> articles;
    private Context context;
    private OnItemClickListner itemClickListner;

    public ArticleAdapter(ArrayList<Article> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View articleRow = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_row, parent, false);

        return new ViewHolder(articleRow);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Article article = articles.get(position);

        holder.title.setText(article.getTitle());
        holder.description.setText(article.getDescription());
        holder.date.setText(Util.dateFormatted(article.getPublishedDate()));
        holder.author.setText(article.getAuthor());


        Picasso.with(context)
                .load(article.getImageUrl())
                .into(holder.articleImage);


    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public void setOnClickListener(OnItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView articleImage;
        private TextView author;
        private TextView description;
        private TextView title;
        private TextView date;

        ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            articleImage = itemView.findViewById(R.id.newsImage);
            author = itemView.findViewById(R.id.newsAuthor);
            description = itemView.findViewById(R.id.newsDescription);
            title = itemView.findViewById(R.id.newsTitle);
            date = itemView.findViewById(R.id.newsDate);
        }

        @Override
        public void onClick(View view) {
            itemClickListner.onItemClick(view, getAdapterPosition());
        }
    }

    //TODO: Item Click Listener..
    public interface OnItemClickListner {
        void onItemClick(View view, int position);
    }
}
