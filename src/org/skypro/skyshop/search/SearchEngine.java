package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<String> documents;

    public SearchEngine() {
        this.documents = new ArrayList<>();
    }

    public void addDocument(String document) {
        documents.add(document);
    }

    public List<String> search(String query) {
        List<String> results = new ArrayList<>();
        for (String document : documents) {
            if (document.contains(query)) {
                results.add(document);
            }
        }
        return results;
    }

    public List<String> getDocuments() {
        return documents;
    }
}