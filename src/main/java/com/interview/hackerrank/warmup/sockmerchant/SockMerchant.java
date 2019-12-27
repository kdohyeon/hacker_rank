package com.interview.hackerrank.warmup.sockmerchant;

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
public class SockMerchant implements ProblemSolver {
    @Override
    public boolean getValid() {
        return true;
    }

    @Override
    public String getProblemName() {
        return "Sock Merchant";
    }

    @Override
    public String getProblemDescription() {
        return "Sock Merchant";
    }

    @Override
    public String getProblemLink() {
        return "https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup";
    }

    @Override
    public String getPackagePath() {
        return "/warmup/sockmerchant";
    }

    @Override
    public List solveProblem(File input) throws FileNotFoundException {
        Scanner scanner = new Scanner(input);

        int n = getN(scanner);
        int[] ar = getArray(scanner, n);

        int result = sockMerchant(n, ar);

        return Lists.newArrayList(result);
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

    private int getN(Scanner scanner) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        return n;
    }

    private int sockMerchant(int n, int[] ar) {
        boolean[] flagged = new boolean[n];
        for (int i = 0; i < ar.length; i++) {
            if (flagged[i]) {
                continue;
            }

            for (int j = i+1; j < ar.length; j++) {
                if (ar[i] == ar[j]) {
                    flagged[i] = true;
                    flagged[j] = true;
                    break;
                }
            }
        }

        int cnt = 0;
        for (boolean b : flagged) {
            if (b) {
                cnt++;
            }
        }

        return cnt/2;
    }
}
