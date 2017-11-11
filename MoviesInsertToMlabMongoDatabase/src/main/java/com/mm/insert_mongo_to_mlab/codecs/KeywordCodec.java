package com.mm.insert_mongo_to_mlab.codecs;

import com.mm.insert_mongo_to_mlab.model.Keyword;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class KeywordCodec implements Codec<Keyword> {

    public void encode(BsonWriter bsonWriter, Keyword keyword, EncoderContext encoderContext) {
        bsonWriter.writeStartDocument();
        bsonWriter.writeInt64("id", keyword.getId());
        bsonWriter.writeString("name", keyword.getName());
        bsonWriter.writeEndDocument();
    }

    public Keyword decode(BsonReader bsonReader, DecoderContext decoderContext) {
        bsonReader.readStartDocument();
        Long id = bsonReader.readInt64("id");
        String name = bsonReader.readString("name");
        bsonReader.readEndDocument();
        return new Keyword(id, name);
    }

    public Class<Keyword> getEncoderClass() {
        return Keyword.class;
    }
}
