package com.mm.insert_mongo_to_mlab.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Genre {

    private Long id;

    private String name;

    public Genre() {

    }

    public Genre(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof Genre)) {
            return false;
        }
        Genre other = (Genre) obj;
        return new EqualsBuilder().append(this.id, other.id).append(this.name, other.name).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.id).append(this.name).toHashCode();
    }
}
