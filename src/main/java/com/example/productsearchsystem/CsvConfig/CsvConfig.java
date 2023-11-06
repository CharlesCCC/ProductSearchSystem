package com.example.productsearchsystem.CsvConfig;

import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CsvConfig {

    @Bean
    public CsvParser csvParser() {
        CsvParserSettings settings = new CsvParserSettings();
        settings.getFormat().setDelimiter('\t');
        settings.setMaxCharsPerColumn(5000000);

        settings.setHeaderExtractionEnabled(true);
        settings.setReadInputOnSeparateThread(false);
        settings.setLineSeparatorDetectionEnabled(true);
        settings.setQuoteDetectionEnabled(true);
        settings.setEscapeUnquotedValues(true);

        return new CsvParser(settings);
    }
}
