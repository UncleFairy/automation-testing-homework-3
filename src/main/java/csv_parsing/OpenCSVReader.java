package csv_parsing;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OpenCSVReader {
    private static final String SAMPLE_CSV_FILE_PATH = "./OpenCSV.csv";

    public static void main(String[] args) throws IOException, CsvValidationException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("Model : " + nextRecord[0]);
                System.out.println("Cylinders : " + nextRecord[1]);
                System.out.println("Volume : " + nextRecord[2]);
                System.out.println("Power : " + nextRecord[3]);
                System.out.println("==========================");
            }
        }
    }
}