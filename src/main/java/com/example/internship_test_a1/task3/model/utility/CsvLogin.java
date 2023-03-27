package com.example.internship_test_a1.task3.model.utility;

import com.example.internship_test_a1.task3.utility.parser.ConvertStringToBoolean;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class CsvLogin {

        public static final char SEPARATOR = ',';
        private static final String WHITESPACE_TRIM = "^\\s*(\\S(.*\\S)?)\\s*$";

        @CsvBindByName(column = "Application", capture = WHITESPACE_TRIM)
        private String application;

        @CsvBindByName(column = "AppAccountName", capture = WHITESPACE_TRIM)
        private String appAccountName;

        @CsvBindByName(column = "IsActive", capture = WHITESPACE_TRIM)
        @CsvCustomBindByName(column = "IsActive", converter = ConvertStringToBoolean.class)
        private Boolean isActive;

        @CsvBindByName(column = "JobTitle", capture = WHITESPACE_TRIM)
        private String jobTitle;

        @CsvBindByName(column = "Department", capture = WHITESPACE_TRIM)
        private String department;
}
