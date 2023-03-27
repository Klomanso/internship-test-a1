package com.example.internship_test_a1.task3.utility.parser;

import com.opencsv.bean.customconverter.ConverterLanguageToBoolean;

/*
 * Utility class which helps to convert string into boolean (more details in opencsv docs)
 * Used in "CsvLogin" class "isActive" field
 * */
public class ConvertStringToBoolean<T, I> extends ConverterLanguageToBoolean<T, I> {
        private static final String True = "True";
        private static final String False = "False";
        private static final String[] TRUE_STRINGS = new String[]{"true", "yes", "1", "y", "w"};
        private static final String[] FALSE_STRINGS = new String[]{"false", "no", "n", "0", "f"};

        public ConvertStringToBoolean() {
        }

        protected String getLocalizedTrue() {
                return "True";
        }

        protected String getLocalizedFalse() {
                return "False";
        }

        protected String[] getAllLocalizedTrueValues() {
                return TRUE_STRINGS;
        }

        protected String[] getAllLocalizedFalseValues() {
                return FALSE_STRINGS;
        }
}
