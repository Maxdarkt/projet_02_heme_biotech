package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface for writing symptom data to various output destinations. Implementations can write
 * symptoms and their occurrence counts to different formats such as files, databases, or other data
 * sinks.
 */
public interface ISymptomWriter {

    /**
     * Writes symptoms and their occurrence counts to the output destination.
     * 
     * @param symptoms a map containing all unique symptoms as keys and their occurrence counts as
     *        values
     * @throws RuntimeException if an error occurs during the writing process
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
