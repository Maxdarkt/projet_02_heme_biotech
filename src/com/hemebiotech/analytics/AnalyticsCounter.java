package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        return reader.countSymptoms(symptoms);
    }

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptomCounts) {
        return reader.sortSymptoms(symptomCounts);
    }

    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }

    public void displaySymptoms(Map<String, Integer> symptoms) {
        int sum = 0;

        System.out.println("Symptoms and their counts:");
        for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            sum += entry.getValue();
        }

        System.out.println("\nTotal number of symptoms: " + sum);
    }

}
