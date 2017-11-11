package com.mm.insert_mongo_to_mlab.codecs;

import com.mm.insert_mongo_to_mlab.model.ProductionCountry;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class ProductionCountryCodec implements Codec<ProductionCountry> {

    public void encode(BsonWriter bsonWriter, ProductionCountry productionCountry, EncoderContext encoderContext) {
        bsonWriter.writeStartDocument();
        bsonWriter.writeString("iso_3166_1", productionCountry.getIso_3166_1());
        bsonWriter.writeString("name", productionCountry.getName());
        bsonWriter.writeEndDocument();
    }

    public ProductionCountry decode(BsonReader bsonReader, DecoderContext decoderContext) {
        bsonReader.readStartDocument();
        String iso_3166_1 = bsonReader.readString("iso_3166_1");
        String name = bsonReader.readString("name");
        bsonReader.readEndDocument();
        return new ProductionCountry(iso_3166_1, name);
    }

    public Class<ProductionCountry> getEncoderClass() {
        return ProductionCountry.class;
    }
}
