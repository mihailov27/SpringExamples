package com.mm.csv.mapper;

import com.mm.csv.CsvParsingException;
import org.apache.commons.csv.CSVRecord;

public interface Mapper<T> {

    T map(CSVRecord csvRecord) throws CsvParsingException;
}
