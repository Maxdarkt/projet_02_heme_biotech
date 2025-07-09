package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {

    /**
     * Write symptoms and their numbers in a file
     * @param symptoms All the unique symptoms with their occurrences
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
