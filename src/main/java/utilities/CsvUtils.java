package utilities;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvUtils {
    // Read all data from CSV file
    public static List<String[]> readCsv(String filePath) {
        List<String[]> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            data = reader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void readCSVWithOpenCSV(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // Process each CSV row
                for (String value : nextLine) {
                    System.out.println(value);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    // Write new data to CSV file (overwrite existing data)
    public static void writeCsv(String filePath, List<String[]> data) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeAll(data);
            System.out.println("CSV file overwritten successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Append new data to CSV file (keep existing data)
    public static void appendCsv(String filePath, String[] newData) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath, true))) {
            writer.writeNext(newData);
            System.out.println("New row added: " + String.join(",", newData));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  Update a row based on a column value
    public static void updateCsvRow(String filePath, String searchValue, int columnIndex, String[] updatedRow) {
        List<String[]> allData = readCsv(filePath);
        boolean updated = false;

        for (int i = 0; i < allData.size(); i++) {
            if (allData.get(i)[columnIndex].equals(searchValue)) {
                allData.set(i, updatedRow); // Replace the row
                updated = true;
            }
        }

        if (updated) {
            writeCsv(filePath, allData);
            System.out.println("Row updated successfully.");
        } else {
            System.out.println("No matching row found for update.");
        }
    }

    // Delete a row from CSV based on a specific column value
    public static void deleteCsvRow(String filePath, String searchValue, int columnIndex) {
        List<String[]> allData = readCsv(filePath);
        List<String[]> updatedData = new ArrayList<>();

        for (String[] row : allData) {
            if (!row[columnIndex].equals(searchValue)) {
                updatedData.add(row);
            }
        }

        writeCsv(filePath, updatedData);
        System.out.println("Row deleted successfully.");
    }

    //  Display CSV content (for debugging)
    public static void printCsv(String filePath) {
        List<String[]> data = readCsv(filePath);
        for (String[] row : data) {
            System.out.println(String.join(",", row));
        }
    }

}
