package com.da.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: recommender
 * Author:  Koitz-Hristov
 * Class that handles all necessary input/output operations to read the test inputs and generate the
 * test outputs.
 */
public class IOHandler {
    /**
     * Reads the input file and parses it line by line. Each line then represents on element of the
     * returned list.
     *
     * @param filePath the path to the input file.
     * @return the list of elements e.g. [insertHead(a),deleteHead,...].
     */
    public List<String> readInputFile(String filePath) {
        List<String> result = new ArrayList<>();
        String line;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            // add line by line to the list
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) bufferedReader.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Prints the result to an output file that has the same name as the input file but instead of the
     * extension ".in" the extension ".out" and is stored within the "testdata/output" folder.
     *
     * @param result        the result of the task implementation to be stored in an output file.
     * @param inputFilename the name of the input file.
     */
    public void printResultToOutputFile(String result, String inputFilename) {
        String output_filename = inputFilename.replace(".in", ".out");
        output_filename = output_filename.replace("input", "output");
        File outputFile = new File(output_filename);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(outputFile);
            fileWriter.write(result);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Error: Could not write to file " + outputFile.getAbsolutePath());
            System.exit(-1);
        } finally {
            try {
                if (fileWriter != null) fileWriter.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
