package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>();

        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(query)) {
                results.put(searchable.getName(), searchable);
            }
        }

        return results;
    }

    public List<Searchable> getSearchables() {
        return searchables;
    }
}