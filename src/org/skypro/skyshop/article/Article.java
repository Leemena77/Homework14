package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return title + "\n" + text;
    }

    @Override
    public String getSearchTerm() {
        return title + " " + text; // Название + текст статьи
    }

    @Override
    public String getContentType() {
        return "ARTICLE"; // Тип контента
    }

    @Override
    public String getName() {
        return title; // Название статьи
    }
}