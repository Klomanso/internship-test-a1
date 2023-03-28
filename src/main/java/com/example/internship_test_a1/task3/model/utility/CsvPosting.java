package com.example.internship_test_a1.task3.model.utility;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvNumber;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@NoArgsConstructor
@Component
public class CsvPosting {

        public static final char SEPARATOR = ';';
        private static final String WHITESPACE_TRIM = "^\\s*(\\S(.*\\S)?)\\s*$";

        @CsvBindByName(column = "Mat. Doc.", capture = WHITESPACE_TRIM)
        private String matDoc;

        @CsvBindByName(column = "Item", capture = WHITESPACE_TRIM)
        @CsvNumber("#")
        private Integer item;

        @CsvBindByName(column = "Doc. Date", capture = WHITESPACE_TRIM)
        @CsvDate("dd.MM.yyyy")
        private Date docDate;

        @CsvBindByName(column = "Pstng Date", capture = WHITESPACE_TRIM)
        @CsvDate("dd.MM.yyyy")
        private Date postingDate;

        @CsvBindByName(column = "Material Description", capture = WHITESPACE_TRIM)
        private String materialDescription;

        @CsvBindByName(column = "Quantity", capture = WHITESPACE_TRIM)
        @CsvNumber("#")
        private Long quantity;

        @CsvBindByName(column = "BUn", capture = WHITESPACE_TRIM)
        private String unit;

        @CsvBindByName(column = "Amount LC", locale = "de-DE", capture = WHITESPACE_TRIM)
        @CsvNumber("#.##")
        private Double amountLC;

        @CsvBindByName(column = "Crcy", capture = WHITESPACE_TRIM)
        private String currency;

        @CsvBindByName(column = "User Name", capture = WHITESPACE_TRIM)
        private String userName;
}
