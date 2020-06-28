package com.openCSVDemo.services.write;

import com.openCSVDemo.models.CSVUser;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteToCSV {
    public WriteToCSV(String PATH) throws IOException,
            CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {
        try (
                Writer writer = Files.newBufferedWriter(Paths.get(PATH));
        ) {
            StatefulBeanToCsv<CSVUser> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            List<CSVUser> myUsers = new ArrayList<>();
            myUsers.add(new CSVUser("Sudhanshu Ghinmin", "sghinmine54@gmail.com", "+91-8551973494", "India"));
            myUsers.add(new CSVUser("Snehal Ghinmine", "snehal.ghinmine@outlook.com", "+91-9822917991", "India"));

            beanToCsv.write(myUsers);
        }
    }
}