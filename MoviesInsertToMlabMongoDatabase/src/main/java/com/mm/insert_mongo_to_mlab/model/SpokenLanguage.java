package com.mm.insert_mongo_to_mlab.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class SpokenLanguage {

    private String iso_639_1;

    private String name;

    public SpokenLanguage() {

    }

    public SpokenLanguage(String iso_639_1, String name) {
        this.iso_639_1 = iso_639_1;
        this.name = name;
    }

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

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(iso_639_1).append(name).build().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(o==null)
            return false;
        if(o instanceof SpokenLanguage)
            return false;
        SpokenLanguage other = (SpokenLanguage) o;
        return new EqualsBuilder().append(this.iso_639_1, other.iso_639_1).append(this.name, other.name).build().booleanValue();
    }
}
