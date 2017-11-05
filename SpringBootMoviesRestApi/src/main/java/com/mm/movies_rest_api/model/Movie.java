package com.mm.movies_rest_api.model;



import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Table("movies")
public class Movie {

    @PrimaryKey
    private UUID guid;

    @Column
    private Long id;

    @Column
    private Long budget;

    @Column
    private String title;

    @Column("original_title")
    private String originalTitle;

    @Column
    private Double vote;

    @Column("vote_count")
    private Long voteCount;

    @Column
    private Set<Genre> genres;

    @Column("original_language")
    private String originalLanguage;

    @Column("home_page")
    private String homepage;

    @Column
    private String overview;

    @Column
    private String status;

    @Column
    private String tagline;

    @Column
    private Double runtime;

    @Column
    private Long revenue;

    @Column
    private Set<Keyword> keywords;

    @Column("release_date")
    private Date releaseDate;

    @Column
    private Double popularity;

    @Column
    private Set<ProductionCompany> productionCompanies;

    @Column
    private Set<ProductionCountry> productionCountries;

    @Column
    private Set<SpokenLanguage> spokenLanguages;

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public Double getVote() {
        return vote;
    }

    public void setVote(Double vote) {
        this.vote = vote;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public Double getRuntime() {
        return runtime;
    }

    public void setRuntime(Double runtime) {
        this.runtime = runtime;
    }

    public Long getRevenue() {
        return revenue;
    }

    public void setRevenue(Long revenue) {
        this.revenue = revenue;
    }

    public Set<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<Keyword> keywords) {
        this.keywords = keywords;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Set<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(Set<ProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public Set<ProductionCountry> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(Set<ProductionCountry> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public Set<SpokenLanguage> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(Set<SpokenLanguage> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }
}
