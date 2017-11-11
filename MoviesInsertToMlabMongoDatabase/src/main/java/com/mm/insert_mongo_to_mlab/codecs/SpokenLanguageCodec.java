package com.mm.insert_mongo_to_mlab.codecs;

import com.mm.insert_mongo_to_mlab.model.SpokenLanguage;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class SpokenLanguageCodec implements Codec<SpokenLanguage> {

    public SpokenLanguage decode(BsonReader bsonReader, DecoderContext decoderContext) {
        bsonReader.readStartDocument();
        String iso_639_1 = bsonReader.readString("iso_639_1");
        String name = bsonReader.readString("name");
        bsonReader.readEndDocument();
        return new SpokenLanguage(iso_639_1, name);
    }

    public void encode(BsonWriter bsonWriter, SpokenLanguage spokenLanguage, EncoderContext encoderContext) {
        bsonWriter.writeStartDocument();
        bsonWriter.writeString("name", spokenLanguage.getName());
        bsonWriter.writeString("iso_639_1", spokenLanguage.getIso_639_1());
        bsonWriter.writeEndDocument();
    }

    public Class<SpokenLanguage> getEncoderClass() {
        return SpokenLanguage.class;
    }
}
