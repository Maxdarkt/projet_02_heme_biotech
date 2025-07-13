package com.hemebiotech.analytics;

/**
 * Main class that demonstrates the analytics functionality. This class orchestrates the reading,
 * counting, sorting, and writing of symptoms.
 */
public class Main {

    /**
     * Main method that executes the symptom analytics process.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // 1. declare the input and output files
        String inputFile = "symptoms.txt";
        String outputFile = "result.out";

        System.out.println("------------------------------------------------");
        System.out.println("Start Analytics with input file: " + inputFile);
        System.out.println("------------------------------------------------\n");

        // 2. create the reader and writer
        ISymptomReader reader = new ReadSymptomDataFromFile(inputFile);
        ISymptomWriter writer = new WriteSymptomDataToFile(outputFile);

        // 3. create the counter
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        // 4. get the symptoms
        counter.getSymptoms();

        // 5. sort the symptoms
        counter.sortSymptoms();

        // 6. count the symptoms
        counter.countSymptoms();

        // 7. write the symptoms
        counter.writeSymptoms();

        // 8. display the symptoms
        counter.displaySymptoms();

        System.out.println(
                "------------------------------------------------------------------------");
        System.out.println("End Analytics: the result has been written to the file: " + outputFile);
        System.out.println(
                "------------------------------------------------------------------------");
    }
}
