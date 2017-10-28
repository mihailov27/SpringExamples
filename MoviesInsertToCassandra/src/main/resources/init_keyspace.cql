DROP KEYSPACE IF EXISTS TEST;

CREATE KEYSPACE TEST
WITH REPLICATION = {'class': 'SimpleStrategy', 'replication_factor' : 1};

CREATE TYPE TEST.GENRE (
  id bigint,
  name text
);

CREATE TYPE TEST.KEYWORD (
    id bigint,
    name text
);

CREATE TYPE TEST.PRODUCTION_COMPANY (
    id bigint,
    name text
);

CREATE TYPE TEST.PRODUCTION_COUNTRY (
    iso_3166_1 text,
    name text
);

CREATE TYPE TEST.SPOKEN_LANGUAGE (
    iso_639_1 text,
    name text
);

CREATE TABLE TEST.MOVIES (
    guid uuid PRIMARY KEY,
    id bigint,
    budget bigint,
    title varchar,
    original_title varchar,
    vote double,
    vote_count bigint,
    genres set<frozen <genre>>,
    original_language text,
    home_page text,
    overview text,
    status text,
    tagline text,
    runtime double,
    revenue bigint,
    keywords set<frozen <keyword>>,
    release_date timestamp,
    popularity double,
    productionCompanies set<frozen <production_company>>,
    productionCountries set<frozen <production_country>>,
    spokenLanguages set<frozen <spoken_language>>,
);


--- indexes

create index title_index on
test.movies(title);

create index vote_index
on test.movies(vote);



