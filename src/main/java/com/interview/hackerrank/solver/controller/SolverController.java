package com.interview.hackerrank.solver.controller;

import com.interview.hackerrank.solver.Problem;
import java.util.List;
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
        List<String> stringStream = problems.stream().map(Problem::getProblemName).collect(Collectors.toList());

        System.out.println("hello world!");
    }
}
