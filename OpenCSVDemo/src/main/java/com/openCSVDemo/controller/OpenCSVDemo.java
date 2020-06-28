package com.openCSVDemo.controller;

import com.openCSVDemo.services.convert.CSVToJSON;
import com.openCSVDemo.services.read.ReadAllAtOnce;
import com.openCSVDemo.services.read.ReadOneAtATime;
import com.openCSVDemo.services.read.ReadUsingBean;
import com.openCSVDemo.services.write.WriteToCSV;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;

public class OpenCSVDemo {
    static String CSV_READ_PATH = "src/main/resources/reading/user.csv";
    static String CSV_WRITE_PATH = "src/main/resources/writing/user.csv";
    static String JSON_WRITE_PATH = "src/main/resources/writing/user.json";
    public static void main(String args[]) throws IOException,
            CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {
        System.out.println("Read records one by one\n");
        new ReadOneAtATime(CSV_READ_PATH);

        System.out.println("Read all records at once and display\n");
        new ReadAllAtOnce(CSV_READ_PATH);

        System.out.println("Read records using bean\n");
        new ReadUsingBean(CSV_READ_PATH);

        System.out.println("Writing to CSV");
        new WriteToCSV(CSV_WRITE_PATH);

        System.out.println("Converting from csv to json");
        new CSVToJSON(CSV_READ_PATH, JSON_WRITE_PATH);
    }
}
