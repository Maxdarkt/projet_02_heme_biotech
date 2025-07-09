package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Utility class for counting and sorting symptoms.
 */
public class SymptomCounter {
  
  /**
   * Counts the occurrences of each symptom from a list.
   *
   * @param symptoms list of symptoms to count
   * @return a map where keys are symptom names and values are counts
   * @throws RuntimeException if symptoms list is null or empty
   */
  public static Map<String, Integer> countSymptoms(List<String> symptoms) {
    Map<String, Integer> symptomCounts = new HashMap<>();

    if (symptoms == null || symptoms.isEmpty()) {
      throw new RuntimeException("Symptoms cannot be null or empty");
    }

    for (String symptom : symptoms) {
      symptomCounts.merge(symptom, 1, Integer::sum);
    }

    return symptomCounts;
  }

  /**
   * Sorts symptoms by their names in ascending order.
   *
   * @param symptomCounts map of symptoms with their counts
   * @return a sorted map of symptoms
   * @throws IllegalArgumentException if symptomCounts is null
   */
  public static Map<String, Integer> sortSymptoms(Map<String, Integer> symptomCounts) {
    if (symptomCounts == null) {
      throw new IllegalArgumentException("SymptomCounts cannot be null");
    }

    return new TreeMap<>(symptomCounts);
  }
} 