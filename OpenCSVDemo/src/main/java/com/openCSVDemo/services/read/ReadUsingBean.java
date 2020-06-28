package com.openCSVDemo.services.read;

import com.openCSVDemo.models.CSVUser;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class ReadUsingBean {
    public ReadUsingBean(String PATH) {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(PATH));
        ) {
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVUser> csvUserIterator = csvToBean.iterator();

            while (csvUserIterator.hasNext()) {
                CSVUser csvUser = csvUserIterator.next();
                System.out.println(csvUser.print());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
