package com.mm;

import com.datastax.driver.core.*;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.mm.csv.CsvHelper;
import com.mm.csv.CsvParsingException;
import com.mm.csv.mapper.MovieMapper;
import com.mm.movies.Movie;

import java.io.*;
import java.util.List;
import java.util.UUID;

public class PrintMovies {

    public static void main(String[] args) {
        try {
            //File moviesFile = new File("src/main/resources/tmdb_5000_movies.csv");
            InputStream is = PrintMovies.class.getResourceAsStream("/tmdb_5000_movies.csv");
            CsvHelper csvHelper = new CsvHelper();
            List<Movie> movies = csvHelper.parse(is, new MovieMapper());

            Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
            Session session = cluster.connect("TEST");

            MappingManager mappingManager = new MappingManager(session);
            Mapper<Movie> movieMapper = mappingManager.mapper(Movie.class);

            // truncate the table before start
            session.execute("TRUNCATE movies;");
            int count = 0;
            for (Movie movie : movies) {
                count+=1;
                if(count%50==0) {
                    try {
                        Thread.sleep(2000); // sleep on every 50 records, limited CPU
                    } catch (InterruptedException ie) { }
                }
                System.out.println("Inserting new movie: " + movie.getId());
                movie.setGuid(UUID.randomUUID());
                movieMapper.saveAsync(movie, Mapper.Option.ifNotExists(true));
            }
        } catch (CsvParsingException e) {
            e.printStackTrace();
        }
    }

}
