package com.hemebiotech.analytics;

import java.util.List;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {
		// Get all symptoms and read them
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");

		List<String> allSymptoms = reader.getSymptoms();

		for (String symptom : allSymptoms) {
			System.out.println(symptom);
		}

	}
}
