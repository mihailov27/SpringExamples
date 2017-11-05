package com.mm.movies_rest_api.utils;

import java.util.ArrayList;
import java.util.List;

public class SearchResultList<T> {

    private final int count;

    private final List<T> results;

    public SearchResultList(List<T> results){
        this.results = results;
        this.count = results!=null ? results.size():0;
    }

    public long getCount() {
        return count;
    }

    public List<T> getResults() {
        return results;
    }
}

