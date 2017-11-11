package com.mm.insert_mongo_to_mlab.codecs;

import com.mm.insert_mongo_to_mlab.model.Genre;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

public class GenreCodec implements Codec<Genre> {

    public Genre decode(BsonReader bsonReader, DecoderContext decoderContext) {
        bsonReader.readStartDocument();
        Long id = bsonReader.readInt64("id");
        String name = bsonReader.readString("name");
        bsonReader.readEndDocument();
        return new Genre(id, name);
    }

    public void encode(BsonWriter bsonWriter, Genre genre, EncoderContext encoderContext) {
        bsonWriter.writeStartDocument();
        bsonWriter.writeInt64("id", genre.getId());
        bsonWriter.writeString("name", genre.getName());
        bsonWriter.writeEndDocument();
    }

    public Class<Genre> getEncoderClass() {
        return Genre.class;
    }
}
