package com.interview.hackerrank.problems.arrays.new_year_chaos;

import com.google.common.collect.Lists;
import com.interview.hackerrank.solver.ProblemSolver;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import org.springframework.stereotype.Component;

/**
 * @author: kdohyeon
 * @date: 2020-1-2
 **/
@Component
public class NewYearChaos implements ProblemSolver {
    @Override
    public boolean getValid() {
        return false;
    }

    @Override
    public String getProblemName() {
        return "New Year Chaos";
    }

    @Override
    public String getProblemDescription() {
        return "New Year Chaos";
    }

    @Override
    public String getProblemLink() {
        return "https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays";
    }

    @Override
    public String getPackagePath() {
        return "/problems/arrays/new_year_chaos";
    }

    @Override
    public List solveProblem(File input) throws FileNotFoundException {
        return Lists.newArrayList();
    }

    @Override
    public String process() {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
        return "overriden process";
    }

    @Override
    public List readFile(File file) throws FileNotFoundException {
        return Lists.newArrayList();
    }

    private void minimumBribes(int[] q) {

    }
}
