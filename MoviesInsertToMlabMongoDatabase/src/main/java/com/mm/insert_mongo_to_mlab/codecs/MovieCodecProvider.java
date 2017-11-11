package com.mm.insert_mongo_to_mlab.codecs;

import com.mm.insert_mongo_to_mlab.model.Movie;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

public class MovieCodecProvider implements CodecProvider {

    public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {
        if(clazz == Movie.class) {
            return (Codec<T>) new MovieCodec();
        }
        return null;
    }
}
