package com.mm.csv;

import com.mm.csv.mapper.Mapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public final class CsvHelper {

    public CsvHelper() {}

    public <T> List<T> parse(InputStream inputStream, Mapper<T> mapper) throws CsvParsingException {
        CSVParser csvParser=null;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            csvParser = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(bufferedReader);
            List<T> list = new ArrayList<T>();
            csvParser.forEach(csvRecord -> list.add(mapper.map(csvRecord)));
            return list;
        } catch (IOException ioe) {
            throw new CsvParsingException(ioe);
        }
        finally {
            IOUtils.closeQuietly(csvParser);
        }
    }
}
