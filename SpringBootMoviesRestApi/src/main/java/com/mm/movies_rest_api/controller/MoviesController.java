package com.mm.movies_rest_api.controller;

import com.mm.movies_rest_api.model.Movie;
import com.mm.movies_rest_api.service.MovieService;
import com.mm.movies_rest_api.utils.Messages;
import com.mm.movies_rest_api.utils.SearchResultList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController("/movies/api")
public class MoviesController {

    private MovieService movieService;

    private Messages messages;

    @Autowired
    public MoviesController(MovieService movieService, Messages messages) {
        this.movieService = movieService;
        this.messages = messages;
    }

    @RequestMapping(value = "/find-by-id/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        Movie movie = movieService.findById(id);
        return (movie!=null) ? ResponseEntity.ok(movie) : notExists(id);
    }

    @RequestMapping(value = "/find-by-uuid/{uuid}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("uuid") UUID uuid) {
        Movie movie = movieService.findById(uuid);
        return (movie!=null) ? ResponseEntity.ok(movie) : notExists(uuid);
    }

    @RequestMapping(value="/find-by-vote", method = RequestMethod.GET)
    public SearchResultList<Movie> findByVote(@RequestParam("vote") Double vote) {
        SearchResultList<Movie> searchResultList = movieService.findByVote(vote);
        return searchResultList;
    }

    private ResponseEntity notExists(Object id) {
        return new ResponseEntity(messages.getMessage("movie.not.found.by.id", new Object[]{id}),
                HttpStatus.NOT_FOUND);
    }
}
