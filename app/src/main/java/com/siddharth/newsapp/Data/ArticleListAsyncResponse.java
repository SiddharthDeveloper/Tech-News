package com.siddharth.newsapp.Data;

import java.util.ArrayList;


public interface ArticleListAsyncResponse {
    void processFinish(ArrayList<Article> articles);
}
