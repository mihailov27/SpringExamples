package com.mm.movies_rest_api.model;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.UserDefinedType;

@UserDefinedType("PRODUCTION_COUNTRY")
public class ProductionCountry {

    @Column
    private String iso_3166_1;

    @Column
    private String name;

    public String getIso_3166_1() {
        return iso_3166_1;
    }

    public void setIso_3166_1(String iso_3166_1) {
        this.iso_3166_1 = iso_3166_1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
