package com.mm.movies_rest_api.model;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.UserDefinedType;

@UserDefinedType("SPOKEN_LANGUAGE")
public class SpokenLanguage {

    @Column
    private String iso_639_1;

    @Column
    private String name;

    public String getIso_639_1() {
        return iso_639_1;
    }

    public void setIso_639_1(String iso_639_1) {
        this.iso_639_1 = iso_639_1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
