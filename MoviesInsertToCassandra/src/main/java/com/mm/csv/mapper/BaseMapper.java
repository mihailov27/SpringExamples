package com.mm.csv.mapper;

import com.mm.csv.CsvParsingException;
import org.apache.commons.csv.CSVRecord;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class BaseMapper<T> implements Mapper<T> {

    private final SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");

    protected final JsonArrayParser jsonArrayParser = new JsonArrayParser();

    protected String get(CSVRecord csvRecord, String key) {
        return csvRecord.get(key);
    }

    protected Integer getInteger(CSVRecord csvRecord, String key) {
        String value = get(csvRecord, key);
        return value != null ? Integer.valueOf(value):null;
    }

    protected Long getLong(CSVRecord csvRecord, String key) {
        String value = get(csvRecord, key);
        return value != null ? Long.valueOf(value):null;
    }

    protected Double getDouble(CSVRecord csvRecord, String key) {
        String value = get(csvRecord, key);
        return value != null && !value.isEmpty() ? Double.valueOf(value):null;
    }

    protected Date getDate(CSVRecord csvRecord, String key) throws CsvParsingException {
        String value = get(csvRecord, key);
        return value==null || value.isEmpty() ? null : toDate(value);
    }

    protected Date toDate(String value) throws CsvParsingException {
        try {
            if(value.matches("[0-9]{3,4}-[0-9]{2}-[0-9]{2}")) {
                return sdf.parse(value);
            } else {
                return null;
            }
        } catch(ParseException pe) {
            throw new CsvParsingException(pe);
        }
    }

    protected <M> Set<M> toSetFromJsonArray(CSVRecord csvRecord, String key, Class<M> type) {
        return new HashSet<M>(jsonArrayParser.parseJsonArray(get(csvRecord, key), type));
    }
}
