package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Analytics counter that processes symptom data by reading, counting, sorting, and writing
 * symptoms. This class orchestrates the entire analytics workflow using dependency injection for
 * reader and writer.
 */
public class AnalyticsCounter {

    private final ISymptomReader reader;
    private final ISymptomWriter writer;
    private List<String> symptoms;
    private Map<String, Integer> symptomCounts;

    /**
     * Constructor to initialize the analytics counter with reader and writer dependencies.
     *
     * @param reader the symptom reader implementation
     * @param writer the symptom writer implementation
     */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Retrieves the list of symptoms from the data source using the reader. The symptoms are stored
     * as an instance variable for further processing.
     */
    public void getSymptoms() {
        this.symptoms = reader.getSymptoms();
    }

    /**
     * Sorts the symptoms list alphabetically using Java streams. This method modifies the internal
     * symptoms list in place.
     *
     * @throws IllegalArgumentException if the symptoms list is null
     */
    public void sortSymptoms() {
        if (this.symptoms == null) {
            throw new IllegalArgumentException("symptoms cannot be null");
        }

        this.symptoms = this.symptoms.stream().sorted().collect(Collectors.toList());
    }

    /**
     * Counts the occurrences of each symptom and stores the results in a TreeMap. The TreeMap
     * automatically sorts symptoms alphabetically by key.
     *
     * @throws RuntimeException if the symptoms list is null or empty
     */
    public void countSymptoms() {
        if (this.symptoms == null || this.symptoms.isEmpty()) {
            throw new RuntimeException("Symptoms cannot be null or empty");
        }

        this.symptomCounts = new TreeMap<>();
        for (String symptom : this.symptoms) {
            this.symptomCounts.merge(symptom, 1, Integer::sum);
        }
    }

    /**
     * Writes the counted and sorted symptoms to the output file using the writer. This method uses
     * the internal symptomCounts map which is already sorted by TreeMap.
     */
    public void writeSymptoms() {
        writer.writeSymptoms(this.symptomCounts);
    }

    /**
     * Displays the symptoms and their counts to the console. Also shows the total number of
     * symptoms processed.
     */
    public void displaySymptoms() {
        int sum = 0;

        System.out.println("Symptoms and their counts:");
        for (Map.Entry<String, Integer> entry : this.symptomCounts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            sum += entry.getValue();
        }

        System.out.println("\nTotal number of symptoms: " + sum);
    }
}
