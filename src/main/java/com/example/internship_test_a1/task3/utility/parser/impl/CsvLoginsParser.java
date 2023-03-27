package com.example.internship_test_a1.task3.utility.parser.impl;

import com.example.internship_test_a1.task3.model.utility.CsvLogin;
import com.example.internship_test_a1.task3.utility.parser.CsvParser;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.Data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Data
public class CsvLoginsParser implements CsvParser<CsvLogin> {

        private static String loginsFilePath = "src/main/resources/csv/logins.csv";

        @Override
        public List<CsvLogin> parse() throws FileNotFoundException {
                return new CsvToBeanBuilder<CsvLogin>(new FileReader(loginsFilePath))
                        .withSeparator(CsvLogin.SEPARATOR)
                        .withType(CsvLogin.class)
                        .build()
                        .parse();
        }

}
