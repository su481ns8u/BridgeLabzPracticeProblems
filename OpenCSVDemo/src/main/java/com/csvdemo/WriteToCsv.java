package com.csvdemo;

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

public class WriteToCsv {
    private static final String PATH = "src/main/resources/user.csv";

    public static void main(String[] args) throws IOException {
        try {
            Writer writer = Files.newBufferedWriter(Paths.get(PATH));
            StatefulBeanToCsv<CSVUser> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            List<CSVUser> myUsers = new ArrayList<>();
            myUsers.add(new CSVUser("Sudhanshu Ghinmine","sghinmine54@gmail.com","+91-8551973494","India"));
            myUsers.add(new CSVUser("Snehal Ghinmine","sghinmine311@gmail.com","+91-8007928757","India"));
            System.out.println(myUsers);
            beanToCsv.write(myUsers);
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }
}
