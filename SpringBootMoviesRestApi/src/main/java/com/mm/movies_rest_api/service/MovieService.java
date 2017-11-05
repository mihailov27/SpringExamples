package com.mm.movies_rest_api.service;

import com.mm.movies_rest_api.model.Movie;
import com.mm.movies_rest_api.utils.SearchResultList;

import java.util.UUID;

public interface MovieService {

    Movie findById(UUID uuid);

    Movie findById(Long id);

    SearchResultList<Movie> findByVote(Double vote);

    Long count();
}
