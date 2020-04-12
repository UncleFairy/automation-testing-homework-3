package csv_parsing;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class CommonsCSVWriter {
    private static final String SAMPLE_CSV_FILE = "./CommonsCSV.csv";

    public static void main(String[] args) throws IOException {
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("Model", "Cylinders", "Volume", "Power"));
        ) {
            csvPrinter.printRecord("BCB", "4/16", "1598", "105");
            csvPrinter.printRecord("AGU", "4/20", "1781", "150");
            csvPrinter.printRecord("AQP", "6/24", "2792", "204");
            csvPrinter.printRecord("BFH", "6/24", "3189", "241");

             csvPrinter.flush();
        }
    }
}