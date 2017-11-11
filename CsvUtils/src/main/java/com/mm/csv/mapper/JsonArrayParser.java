package com.mm.csv.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.mm.csv.CsvParsingException;

import java.io.IOException;
import java.util.List;

public class JsonArrayParser {

    private ObjectMapper objectMapper = new ObjectMapper();

    public <T> List<T> parseJsonArray(String json, Class<T> clazz) throws CsvParsingException {
        try {
            CollectionType typeReference = TypeFactory.defaultInstance().constructCollectionType(List.class, clazz);
            return objectMapper.readValue(json, typeReference);
        } catch(IOException ioe) {
            throw new CsvParsingException(ioe);
        }
    }
}
