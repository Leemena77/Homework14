package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] items;
    private int size;

    public SearchEngine(int capacity) {
        this.items = new Searchable[capacity];
        this.size = 0;
    }
    public void add(Searchable item) {
        if (size < items.length) {
            items[size] = item;
            size++;
        } else {
            System.out.println("Невозможно добавить элемент: поисковый движок заполнен");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultIndex = 0;

        for (int i = 0; i < size && resultIndex < 5; i++) {
            if (items[i] != null) {
                String searchTerm = items[i].getSearchTerm();
                if (searchTerm != null && searchTerm.toLowerCase().contains(query.toLowerCase())) {
                    results[resultIndex] = items[i];
                    resultIndex++;
                }
            }
        }

        return results;
    }

    public int getSize() {
        return size;
    }

    public boolean isFull() {
        return size >= items.length;
    }
}