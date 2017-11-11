package com.mm.insert_mongo_to_mlab.codecs;

import com.mm.insert_mongo_to_mlab.model.ProductionCompany;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class ProductionCompanyCodec implements Codec<ProductionCompany> {

    public ProductionCompany decode(BsonReader bsonReader, DecoderContext decoderContext) {
        bsonReader.readStartDocument();
        Long id = bsonReader.readInt64("id");
        String name = bsonReader.readString("name");
        bsonReader.readEndDocument();
        return new ProductionCompany(id, name);
    }

    public void encode(BsonWriter bsonWriter, ProductionCompany productionCompany, EncoderContext encoderContext) {
        bsonWriter.writeStartDocument();
        bsonWriter.writeInt64("id", productionCompany.getId());
        bsonWriter.writeString("name", productionCompany.getName());
        bsonWriter.writeEndDocument();
    }

    public Class<ProductionCompany> getEncoderClass() {
        return ProductionCompany.class;
    }
}
