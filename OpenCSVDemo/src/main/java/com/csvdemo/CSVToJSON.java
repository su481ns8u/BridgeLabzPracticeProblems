package com.csvdemo;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CSVToJSON {
    private static final String CSV_PATH = "src/main/resources/user.csv";
    private static final String JSON_PATH = "src/main/resources/user.json";

    public static void main(String[] args) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(CSV_PATH));
            CsvToBeanBuilder<CSVUser> csvUserCsvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvUserCsvToBeanBuilder.withType(CSVUser.class);
            csvUserCsvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CSVUser> csvToBean = csvUserCsvToBeanBuilder.build();
            List<CSVUser> csvUsers = csvToBean.parse();
            Gson gson = new Gson();
            String json = gson.toJson(csvUsers);
            FileWriter writer = new FileWriter(JSON_PATH);
            writer.write(json);
            writer.close();
            BufferedReader br = new BufferedReader(new FileReader(JSON_PATH));
            CSVUser[] usrObj = gson.fromJson(br, CSVUser[].class);
            List<CSVUser> csvUserList = Arrays.asList(usrObj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
