package com.csvdemo;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * This method is not sutiable for lagre csv files
 */
public class ReadCSVIntoMemory {
    private static final String PATH = "src/main/resources/user.csv";

    public static void main(String[] args) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(PATH));
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<CSVUser> csvUsers = csvToBean.parse();
            for (CSVUser csvUser : csvUsers) {
                System.out.println("Name: " + csvUser.getName());
                System.out.println("Email: " + csvUser.getEmail());
                System.out.println("Phone: " + csvUser.getPhoneNo());
                System.out.println("Country: " + csvUser.getCountry() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}