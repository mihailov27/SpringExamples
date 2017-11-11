package com.mm.insert_mongo_to_mlab.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ProductionCountry {

    private String iso_3166_1;

    private String name;

    public ProductionCountry() {

    }

    public ProductionCountry(String iso_3166_1, String name) {
        this.iso_3166_1 = iso_3166_1;
        this.name = name;
    }

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

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(iso_3166_1).append(name).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof ProductionCountry)) {
            return false;
        }
        ProductionCountry other = (ProductionCountry) obj;
        return new EqualsBuilder().append(this.iso_3166_1, other.iso_3166_1).append(this.name, other.name).isEquals();
    }
}
