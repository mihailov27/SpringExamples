package com.mm.movies;

import com.datastax.driver.mapping.annotations.Field;
import com.datastax.driver.mapping.annotations.UDT;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@UDT(name = "SPOKEN_LANGUAGE", keyspace = "TEST")
public class SpokenLanguage {

    @Field
    private String iso_639_1;

    @Field
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
