package com.mm.movies;

import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.UDT;

@UDT(name="PRODUCTION_COMPANY", keyspace = "TEST")
public class ProductionCompany {

    @Field
    private Long id;

    @Field
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}