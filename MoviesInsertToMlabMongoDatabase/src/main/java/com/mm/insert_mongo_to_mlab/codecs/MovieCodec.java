package com.mm.insert_mongo_to_mlab.codecs;

import com.mm.insert_mongo_to_mlab.model.Genre;
import com.mm.insert_mongo_to_mlab.model.Movie;
import org.bson.*;
import org.bson.codecs.*;

import java.util.List;
import java.util.UUID;

import static com.mm.insert_mongo_to_mlab.codecs.MovieCodec.Fields.*;

public class MovieCodec implements CollectibleCodec<Movie> {

    private final Codec<Document> documentCodec;

    public MovieCodec() {
        documentCodec = new DocumentCodec();
    }

    public MovieCodec(Codec<Document> documentCodec) {
        if(documentCodec==null) {
            throw new IllegalArgumentException("Document codec is null.");
        }
        this.documentCodec = documentCodec;
    }

    public void encode(BsonWriter writer, Movie movie, EncoderContext encoderContext) {

        Document document = new Document();
        if(movie.getId() != null) {
            document.append(ID, movie.getId());
        }
        if(movie.getGuid() != null) {
            document.append(GUID, movie.getGuid());
        }
        if(movie.getTitle() != null) {
            document.append(TITLE, movie.getTitle());
        }
        if(movie.getBudget() != null) {
            document.append(BUDGET, movie.getBudget());
        }
        if(movie.getOriginalLanguage() != null) {
            document.append(ORIGINAL_TITLE, movie.getOriginalTitle());
        }
        if(movie.getVote()!=null) {
            document.append(VOTE, movie.getVote());
        }
        if(movie.getVoteCount()!=null) {
            document.append(VOTE_COUNT, movie.getVoteCount());
        }
        if(movie.getHomepage()!=null) {
            document.append(HOMEPAGE, movie.getHomepage());
        }
        if(movie.getOverview() != null) {
            document.append(OVERVIEW, movie.getOverview());
        }
        if(movie.getStatus()!=null) {
            document.append(TAGLINE, movie.getTagline());
        }
        if(movie.getTagline()!=null) {
            document.append(STATUS, movie.getStatus());
        }
        if(movie.getRevenue()!=null) {
            document.append(REVENUE, movie.getRevenue());
        }
        if(movie.getRuntime() != null) {
            document.append(RUNTIME, movie.getRuntime());
        }
        documentCodec.encode(writer, document, encoderContext);
    }

    public Movie decode(BsonReader reader, DecoderContext decoderContext) {
        Document document = documentCodec.decode(reader, decoderContext);
        Movie movie = new Movie();
        String guidStr = document.getString(GUID);
        if(guidStr!=null) {
            movie.setGuid(UUID.fromString(guidStr));
        }
        movie.setId(document.getLong(ID));
        movie.setBudget(document.getLong(BUDGET));
        movie.setTitle(document.getString(TITLE));
        movie.setOriginalTitle(document.getString(ORIGINAL_TITLE));
        movie.setVote(document.getDouble(VOTE));
        movie.setVoteCount(document.getLong(VOTE_COUNT));
        List<Genre> genres = (List<Genre>) document.get(GENRES);
        movie.setGenres(genres);
        movie.setHomepage(document.getString(HOMEPAGE));
        movie.setOverview(document.getString(OVERVIEW));
        movie.setStatus(document.getString(STATUS));
        movie.setTagline(document.getString(TAGLINE));
        movie.setRevenue(document.getLong(REVENUE));
        movie.setRuntime(document.getDouble(RUNTIME));

        return movie;
    }

    public Movie generateIdIfAbsentFromDocument(Movie movie) {
        movie.setGuid(UUID.randomUUID());
        return movie;
    }

    public BsonValue getDocumentId(Movie movie) {
        return new BsonString(movie.getGuid().toString());
    }

    public Class<Movie> getEncoderClass() {
        return Movie.class;
    }

    public boolean documentHasId(Movie movie) {
        return movie.getGuid() != null;
    }

    static class Fields {
        static String GUID = "guid";
        static String ID = "id";
        static String BUDGET = "budget";
        static String TITLE = "title";
        static String ORIGINAL_TITLE = "originalTitle";
        static String VOTE = "vote";
        static String VOTE_COUNT = "voteCount";
        static String GENRES = "genres";
        static String HOMEPAGE = "homepage";
        static String OVERVIEW = "overview";
        static String TAGLINE = "tagline";
        static String STATUS = "status";
        static String REVENUE = "revenue";
        static String RUNTIME = "runtime";
    }
}
