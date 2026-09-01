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

    public Searchable findMostSuitable(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        Searchable mostSuitable = null;
        int maxCount = 0;
        String searchLower = search.toLowerCase();

        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                String searchTerm = items[i].getSearchTerm();
                if (searchTerm != null) {
                    String termLower = searchTerm.toLowerCase();
                    int count = countOccurrences(termLower, searchLower);

                    if (count > maxCount) {
                        maxCount = count;
                        mostSuitable = items[i];
                    }
                }
            }
        }

        if (mostSuitable == null || maxCount == 0) {
            throw new BestResultNotFound(search);
        }

        return mostSuitable;
    }

    private int countOccurrences(String text, String substring) {
        if (substring == null || substring.isEmpty() || text == null || text.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;
        int substringIndex = text.indexOf(substring, index);

        while (substringIndex != -1) {
            count++;
            index = substringIndex + substring.length();
            substringIndex = text.indexOf(substring, index);
        }

        return count;
    }

    public int getSize() {
        return size;
    }

    public boolean isFull() {
        return size >= items.length;
    }
}