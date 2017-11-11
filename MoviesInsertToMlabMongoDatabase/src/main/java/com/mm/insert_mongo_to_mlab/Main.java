package com.mm.insert_mongo_to_mlab;

import com.mm.csv.CsvHelper;
import com.mm.insert_mongo_to_mlab.codecs.MovieCodec;
import com.mm.insert_mongo_to_mlab.codecs.MovieCodecProvider;
import com.mm.insert_mongo_to_mlab.csv.MovieCsvMapper;
import com.mm.insert_mongo_to_mlab.model.Movie;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.csv.CSVParser;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final String HOST = "ds145275.mlab.com";
    private static final int PORT = 45275;
    private static final String USERNAME = "mihailov27";
    private static final String PASSWORD = "juvenista89";
    private static final String DB_NAME = "mm";

    public static void main(String[] argv) {
        MongoClient mongoClient=null;
        try{
            // codecs
            CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
                    MongoClient.getDefaultCodecRegistry(),
                    CodecRegistries.fromProviders(new MovieCodecProvider()),
                    CodecRegistries.fromCodecs(new MovieCodec()));
            // create options with codecs.
            MongoClientOptions options = MongoClientOptions.builder().codecRegistry(codecRegistry).build();
            // create mongo client.
            mongoClient = new MongoClient(new ServerAddress(HOST, PORT),
                    Arrays.asList(MongoCredential.createCredential(USERNAME,DB_NAME, PASSWORD.toCharArray())),options);
            MongoDatabase mmDb = mongoClient.getDatabase(DB_NAME);
            MongoCollection<Movie> mmCollection = mmDb.getCollection("movies", Movie.class);
            // delete all existing records in movies.
            mmCollection.deleteMany(new Movie());
            // insert movies
            InputStream is = Main.class.getResourceAsStream("/tmdb_5000_movies.csv");
            CsvHelper csvHelper = new CsvHelper();
            List<Movie> movies = csvHelper.parse(is, new MovieCsvMapper());
            for(int i=0; i < movies.size(); i+=50) {
                int from = i;
                int to = i+50 > movies.size() ? movies.size() : i+50 ;
                List<Movie> chunkOfMovies = movies.subList(from, to);
                mmCollection.insertMany(chunkOfMovies);
            }
        } finally {
            if (mongoClient != null) {
                mongoClient.close();
            }
        }
    }
}
