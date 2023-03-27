package com.example.internship_test_a1.task3.utility.parser;

import java.io.FileNotFoundException;
import java.util.List;

public interface CsvParser<T> {
        List<T> parse() throws FileNotFoundException;
}
