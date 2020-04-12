package csv_parsing;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CommonsCSVReader {
    private static final String SAMPLE_CSV_FILE_PATH = "./CommonsCSV.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String model = csvRecord.get(0);
                String cylinders = csvRecord.get(1);
                String volume = csvRecord.get(2);
                String power = csvRecord.get(3);

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Model : " + model);
                System.out.println("Cylinders : " + cylinders);
                System.out.println("Volume : " + volume);
                System.out.println("Power : " + power);
                System.out.println("---------------\n\n");
            }
        }
    }
}