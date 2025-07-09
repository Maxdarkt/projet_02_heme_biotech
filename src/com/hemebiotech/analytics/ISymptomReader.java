package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of strings,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {

	/**
	 * Reads and returns the list of symptoms from the file.
	 * Duplicates are preserved in the returned list.
	 *
	 * @return a list of all symptoms read from the file
	 * @throws RuntimeException if an error occurs while reading the file
	 */
	List<String> getSymptoms ();
}
