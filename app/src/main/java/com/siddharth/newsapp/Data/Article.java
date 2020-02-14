package com.siddharth.newsapp.Data;


public class Article {
    private String author;
    private String title;
    private String description;
    private String newsUrl;
    private String imageUrl;
    private String publishedDate;


    String getAuthor() {
        return author;
    }

    void setAuthor(String author) {
        this.author = author;
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

    String getImageUrl() {
        return imageUrl;
    }

    void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    String getPublishedDate() {
        return publishedDate;
    }

    void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }
}
