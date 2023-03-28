package com.example.internship_test_a1.task3.utility.parser.impl;

import com.example.internship_test_a1.task3.model.utility.CsvPosting;
import com.example.internship_test_a1.task3.utility.parser.CsvParser;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

@Data
@Component
public class CsvPostingsParser implements CsvParser<CsvPosting> {

        @Value("${file.postings.path}")
        private String postingFilePath;

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
