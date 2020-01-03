package com.interview.hackerrank.problems.warmup.jumping_clouds;

import com.google.common.collect.Lists;
import com.interview.hackerrank.solver.ProblemSolver;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import org.springframework.stereotype.Component;

/**
 * @author: kdohyeon
 * @date: 2019-12-27
 **/
@Component
public class JumpingOnTheClouds implements ProblemSolver {
    @Override
    public boolean getValid() {
        return true;
    }

    @Override
    public String getProblemName() {
        return "Jumping On The Clouds";
    }

    @Override
    public String getProblemDescription() {
        return "Jumping On The Clouds";
    }

    @Override
    public String getProblemLink() {
        return "https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup";
    }

    @Override
    public String getPackagePath() {
        return "/problems/warmup/jumping_clouds";
    }

    @Override
    public List solveProblem(File input) throws FileNotFoundException {
        Scanner scanner = new Scanner(input);

        int n = getN(scanner);
        int[] c = getArray(scanner, n);

        int result = jumpingOnClouds(c);

        return Lists.newArrayList(result);
    }

    private int getN(Scanner scanner) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        return n;
    }

    private int[] getArray(Scanner scanner, int n) {
        int[] ar = new int[n];
        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }
        return ar;
    }

    @Override
    public List readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List result = Lists.newArrayList();

        while (scanner.hasNext()) {
            result.add(scanner.nextLine());
        }

        return result;
    }

    private int jumpingOnClouds(int[] c) {
        int jumps = 0;
        int currStep = 0;

        for (int i = 0; i < c.length; i++) {
            if (i != currStep) {
                continue;
            }

            if (isEligibleForTwoStep(c, i)) {
                currStep += 2;
                jumps++;
            }

            if (isEligibleForOneStep(c, i)) {
                currStep += 1;
                jumps++;
            }
        }

        return jumps;
    }

    private boolean isEligibleForTwoStep(int[] c, int currStep) {
        if (currStep + 2 < c.length) {
            return c[currStep + 2] == 0;
        }
        return false;
    }

    private boolean isEligibleForOneStep(int[] c, int currStep) {
        if (!isEligibleForTwoStep(c, currStep)) {
            if (currStep + 1 < c.length) {
                return c[currStep + 1] == 0;
            }
        }
        return false;
    }
}
