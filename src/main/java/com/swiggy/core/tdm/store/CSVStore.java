package com.swiggy.core.tdm.store;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CSVStore {


    public static Object[][] getRestaurantCountTestData() throws URISyntaxException {
        URI uri = CSVStore.class.getClassLoader().getResource("test.data/restaurant-count.csv").toURI();
        System.out.println(uri);
        Object[][] data;
        try (Reader reader = Files.newBufferedReader(Path.of(Paths.get(uri).toString()));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            List<CSVRecord> list = csvParser.getRecords();
            data = new Object[list.size()][2];
            int rowIndex = 0;
            for (CSVRecord csvRecord : list) {
                // Accessing Values by Column Index
                String city = csvRecord.get(0);
                String tabIndex = csvRecord.get(1);
                System.out.println(city + " " + tabIndex);
                data[rowIndex][0] = city;
                data[rowIndex][1] = tabIndex;
                rowIndex++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
