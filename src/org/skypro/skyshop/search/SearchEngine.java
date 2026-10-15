package org.skypro.skyshop.search;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Set<Searchable> search(String query) {
        return searchables.stream()
                .filter(searchable -> searchable.getSearchTerm().contains(query))
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(new SearchableComparator())
                ));
    }

    public Set<Searchable> getSearchables() {
        return searchables;
    }
}