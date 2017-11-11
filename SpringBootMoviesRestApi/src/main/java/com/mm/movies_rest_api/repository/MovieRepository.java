package com.mm.movies_rest_api.repository;

import com.mm.movies_rest_api.model.Movie;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovieRepository extends CassandraRepository<Movie> {

    List<Movie> findByVote(Double vote);

    @Query("SELECT * FROM Movies WHERE id = ?0")
    Movie findByExternalId(Long id);
}
