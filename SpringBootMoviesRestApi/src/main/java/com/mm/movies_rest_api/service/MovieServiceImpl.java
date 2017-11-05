package com.mm.movies_rest_api.service;

import com.mm.movies_rest_api.model.Movie;
import com.mm.movies_rest_api.repository.MovieRepository;
import com.mm.movies_rest_api.utils.SearchResultList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.repository.support.BasicMapId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie findById(UUID uuid) {
        return movieRepository.findOne(new BasicMapId().with("id", uuid));
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findByExternalId(id);
    }

    @Override
    public SearchResultList<Movie> findByVote(Double vote) {
        List<Movie> movies = movieRepository.findByVote(vote);
        return new SearchResultList<Movie>(movies);
    }

    @Override
    public Long count() {
        return movieRepository.count();
    }
}
