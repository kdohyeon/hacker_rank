package com.interview.hackerrank.solver;

import static com.interview.hackerrank.utils.AppConstants.DEFAULT_PACKAGE_PATH;
import static com.interview.hackerrank.utils.AppConstants.FAILURE;
import static com.interview.hackerrank.utils.AppConstants.SAMPLE_INPUT_PATH;
import static com.interview.hackerrank.utils.AppConstants.SAMPLE_OUTPUT_PATH;
import static com.interview.hackerrank.utils.AppConstants.SUCCESS;
import static com.interview.hackerrank.utils.AppConstants.USER_DIR;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @author: kdohyeon
 * @date: 2019-12-27
 **/
public interface ProblemSolver<T> extends Problem {
    default String process() throws IOException {
        // read
        File inputFile = new File(System.getProperty(USER_DIR) + DEFAULT_PACKAGE_PATH + getPackagePath() + SAMPLE_INPUT_PATH);
        File outputFile = new File(System.getProperty(USER_DIR) + DEFAULT_PACKAGE_PATH + getPackagePath() + SAMPLE_OUTPUT_PATH);
        List output = readFile(outputFile);

        // process
        List result = solveProblem(inputFile);

        // compare
        // TODO: make the comparison part to be multiple comparison
        return getResponseMessage(isCorrect(result, output));
    }

    default boolean isCorrect(List<T> result, List<T> output) {
        if (result.size() < 1 || output.size() < 1) {
            return false;
        }

        if (result.size() != output.size()) {
            System.out.println("result and output size does not match: " + result.size() + ", " + output.size());
            return false;
        }

        for (int i = 0; i < result.size(); i++) {
            if (!String.valueOf(result.get(i)).equals(String.valueOf(output.get(i)))) {
                return false;
            }
        }

        return true;
    }

    default String getResponseMessage(boolean result) {
        if (result) {
            return "[" + SUCCESS + "]" + getProblemName();
        }

        return "[" + FAILURE + "]" + getProblemName();
    };

    List<T> solveProblem(File input) throws FileNotFoundException;

    List<T> readFile(File file) throws FileNotFoundException;
}
