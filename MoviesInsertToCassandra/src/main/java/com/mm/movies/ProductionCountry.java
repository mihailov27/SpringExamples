package com.mm.movies;

import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.UDT;

@UDT(name="PRODUCTION_COUNTRY", keyspace = "TEST")
public class ProductionCountry {

    @Field
    private String iso_3166_1;

    @Field
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
