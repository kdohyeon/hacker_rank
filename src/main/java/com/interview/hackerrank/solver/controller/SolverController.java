package com.interview.hackerrank.solver.controller;

import com.interview.hackerrank.solver.Problem;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: kdohyeon
 * @date: 2019-12-27
 **/
@RestController
public class SolverController {
    @Autowired
    private List<Problem> problems;

    @GetMapping("/run")
    public void run() {
        int cnt = (int) problems.stream()
                                .filter(Problem::getValid)
                                .filter(problem -> {
                                    try {
                                        if (problem.process()) {
                                            System.out.println(problem.getProblemName() + " is correct");
                                            return true;
                                        }
                                        System.out.println(problem.getProblemName() + " is not correct");
                                        return false;
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        return false;
                                    }
                                }).count();
    }
}
