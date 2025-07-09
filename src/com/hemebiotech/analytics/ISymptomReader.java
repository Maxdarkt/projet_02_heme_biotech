package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

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

    /**
     * Counts the occurrences of each symptom from a provided list and returns a mapping of symptoms
     * to their respective counts.
     *
     * @param symptoms the list of symptoms to count
     * @return a map where the keys are symptom names (as strings) and the values are the counts of
     *         occurrences (as integers) for each symptom
     * @throws RuntimeException if the symptoms list is null or empty
     */
    Map<String, Integer> countSymptoms(List<String> symptoms);

    /**
     * Sorts the symptoms by their names in ascending order and returns a map of sorted symptoms
     * with their corresponding occurrence counts.
     *
     * @param symptomCounts the map of symptoms with their counts to be sorted
     * @return a sorted map where the keys are symptom names (as strings), arranged in ascending
     *         order, and the values are the counts of occurrences (as integers) for each symptom
     * @throws IllegalArgumentException if symptomCounts is null
     */
    Map<String, Integer> sortSymptoms(Map<String, Integer> symptomCounts);
}
