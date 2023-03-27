package com.example.internship_test_a1.task3.utility.parser.impl;

import com.example.internship_test_a1.task3.model.utility.CsvPosting;
import com.example.internship_test_a1.task3.utility.parser.CsvParser;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.Data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

@Data
public class CsvPostingsParser implements CsvParser<CsvPosting> {

        private static String postingFilePath = "src/main/resources/csv/postings.csv";

        @Override
        public List<CsvPosting> parse() throws FileNotFoundException {
                return new CsvToBeanBuilder<CsvPosting>(new FileReader(postingFilePath))
                        .withSeparator(CsvPosting.SEPARATOR)
                        .withType(CsvPosting.class)
                        // This filter is used to skip empty lines in postings.csv
                        .withFilter(stringValues -> Arrays.stream(stringValues)
                                .anyMatch(value -> value != null && value.length() > 0))
                        .build()
                        .parse();
        }

}
