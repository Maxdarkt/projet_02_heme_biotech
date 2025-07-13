package com.hemebiotech.analytics;

import java.util.List;

/**
 * Interface for reading symptom data from various sources. The primary focus is on the return value
 * from operations, which is a list of strings that may contain many duplications.
 *
 * Implementations are not required to order the list.
 */
public interface ISymptomReader {

    /**
     * Reads and returns the list of symptoms from the data source. Duplicates are preserved in the
     * returned list.
     *
     * @return a list of all symptoms read from the data source
     * @throws RuntimeException if an error occurs while reading the data source
     */
    List<String> getSymptoms();
}
