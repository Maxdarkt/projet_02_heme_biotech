package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation that reads symptoms from a text file. Each line in the file represents a single
 * symptom.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
    private final String filepath;

    /**
     * Constructor to initialize the symptom reader.
     *
     * @param filepath full or relative path to the file containing symptoms (one per line)
     * @throws IllegalArgumentException if the filepath is null, empty, or if the file doesn't exist
     */
    public ReadSymptomDataFromFile(String filepath) {
        if (filepath == null || filepath.trim().isEmpty()) {
            throw new IllegalArgumentException("Filepath cannot be null or empty");
        }

        Path path = Paths.get(filepath);
        if (!Files.exists(path)) {
            throw new IllegalArgumentException("Specified file does not exist: " + filepath);
        }

        this.filepath = filepath;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getSymptoms() {
        List<String> symptoms = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    symptoms.add(line.trim());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to read symptoms file", e);
        }

        return symptoms;
    }
}
