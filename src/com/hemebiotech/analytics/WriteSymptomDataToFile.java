package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private static final String OUTPUT_FILE = "result.out";
    private static final String OUTPUT_FORMAT = "%s : %d%n";

    /**
     * Default constructor
     */
    public WriteSymptomDataToFile() {}

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void writeSymptoms(Map<String, Integer> sortedResult) {
        if (sortedResult == null || sortedResult.isEmpty()) {
            throw new IllegalArgumentException("Symptom count map cannot be null or empty");
        }

        int sum = 0;

        try (FileWriter writer = new FileWriter(OUTPUT_FILE)) {
            // Header
            writer.write("---------- ---------- ----------\n");
            writer.write("Symptoms and their counts:\n");
            writer.write("---------- ---------- ----------\n\n");

            // Content
            for (Map.Entry<String, Integer> entry : sortedResult.entrySet()) {
                writer.write(String.format(OUTPUT_FORMAT,
                    entry.getKey(),
                    entry.getValue())
                );
                sum += entry.getValue();
            }

            // Footer
            writer.write("\n");
            writer.write("---------- ---------- ----------\n");
            writer.write("Total number of symptoms: " + sum + "\n");
            writer.write("---------- ---------- ----------\n");
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + OUTPUT_FILE, e);
        }
    }
}
