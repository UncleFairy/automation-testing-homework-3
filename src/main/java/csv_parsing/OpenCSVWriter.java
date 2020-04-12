package csv_parsing;

import com.opencsv.CSVWriter;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class OpenCSVWriter {
    private static final String STRING_ARRAY_SAMPLE = "./OpenCSV.csv";

    public static void main(String[] args) throws IOException {
        try (
                Writer writer = Files.newBufferedWriter(Paths.get(STRING_ARRAY_SAMPLE));

                CSVWriter csvWriter = new CSVWriter(writer,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.NO_QUOTE_CHARACTER,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END);
        ) {
            String[] headerRecord = {"Model", "Cylinders", "Volume", "Power"};
            csvWriter.writeNext(headerRecord);

            csvWriter.writeNext(new String[]{"BCB", "4/16", "1598", "105"});
            csvWriter.writeNext(new String[]{"AGU", "4/20", "1781", "150"});
            csvWriter.writeNext(new String[]{"AQP", "6/24", "2792", "204"});
            csvWriter.writeNext(new String[]{"BFH", "6/24", "3189", "241"});
        }
    }
}