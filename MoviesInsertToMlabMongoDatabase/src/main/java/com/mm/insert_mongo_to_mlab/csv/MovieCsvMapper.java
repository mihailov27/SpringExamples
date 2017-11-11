package com.mm.insert_mongo_to_mlab.csv;

import com.mm.csv.CsvParsingException;
import com.mm.csv.mapper.BaseMapper;
import com.mm.insert_mongo_to_mlab.model.*;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;

public class MovieCsvMapper extends BaseMapper<Movie> {

    public Movie map(CSVRecord csvRecord) throws CsvParsingException {
        if(csvRecord==null) {
            throw new IllegalArgumentException("Csv record is null.");
        }
        Movie movie=new Movie();
        movie.setId(getLong(csvRecord, Keys.ID));
        movie.setTitle(get(csvRecord, Keys.TITLE));
        movie.setOriginalTitle(get(csvRecord, Keys.ORIGINAL_TITLE));
        movie.setBudget(getLong(csvRecord, Keys.BUDGET));
        movie.setVote(getDouble(csvRecord, Keys.VOTE));
        movie.setVoteCount(getLong(csvRecord, Keys.VOTE_COUNT));
        movie.setHomepage(get(csvRecord, Keys.HOME_PAGE));
        movie.setOriginalLanguage(get(csvRecord, Keys.ORIGINAL_LANGUAGE));
        movie.setOverview(get(csvRecord, Keys.OVERVIEW));
        movie.setStatus(get(csvRecord, Keys.STATUS));
        movie.setTagline(get(csvRecord, Keys.TAGLINE));
        movie.setRevenue(getLong(csvRecord, Keys.REVENUE));
        movie.setRuntime(getDouble(csvRecord, Keys.RUNTIME));
        movie.setReleaseDate(getDate(csvRecord, Keys.RELEASE_DATE));
        movie.setPopularity(getDouble(csvRecord, Keys.POPULARITY));
        movie.setProductionCompanies(toSetFromJsonArray(csvRecord, Keys.PRODUCTION_COMPANIES,
                ProductionCompany.class));
        movie.setProductionCountries(toSetFromJsonArray(csvRecord, Keys.PRODUCTION_COUNTRIES,
                ProductionCountry.class));
        movie.setSpokenLanguages(toSetFromJsonArray(csvRecord, Keys.SPOKEN_LANGUAGES, SpokenLanguage.class));
        movie.setGenres(new ArrayList<Genre>(toSetFromJsonArray(csvRecord, Keys.GENRES, Genre.class)));
        movie.setKeywords(toSetFromJsonArray(csvRecord, Keys.KEYWORDS, Keyword.class));
        return movie;
    }

    public static class Keys {
        public static final String ID = "id";
        public static final String TITLE = "title";
        public static final String ORIGINAL_TITLE = "original_title";
        public static final String BUDGET = "budget";
        public static final String VOTE = "vote_average";
        public static final String VOTE_COUNT = "vote_count";
        public static final String HOME_PAGE = "homepage";
        public static final String ORIGINAL_LANGUAGE = "original_language";
        public static final String GENRES = "genres";
        public static final String OVERVIEW = "overview";
        public static final String STATUS = "status";
        public static final String TAGLINE = "tagline";
        public static final String REVENUE = "revenue";
        public static final String RUNTIME = "runtime";
        public static final String RELEASE_DATE = "release_date";
        public static final String KEYWORDS = "keywords";
        public static final String POPULARITY = "popularity";
        public static final String PRODUCTION_COMPANIES = "production_companies";
        public static final String PRODUCTION_COUNTRIES = "production_countries";
        public static final String SPOKEN_LANGUAGES = "spoken_languages";
    }
}
