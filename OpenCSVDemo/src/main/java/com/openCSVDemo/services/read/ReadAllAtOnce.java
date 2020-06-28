package com.openCSVDemo.services.read;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadAllAtOnce {
    public ReadAllAtOnce(String PATH) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(PATH));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            List<String[]> records = csvReader.readAll();
            records.remove(0);
            records.forEach(record -> System.out.println
                            ("Name: " + record[0] +
                                    "\nEmail: " + record[1] +
                                    "\nPhone : " + record[2] +
                                    "\nCountry : " + record[3] + "\n"));
        }
    }
}