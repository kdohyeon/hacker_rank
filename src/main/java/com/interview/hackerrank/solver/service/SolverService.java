package com.interview.hackerrank.solver.service;

import static com.interview.hackerrank.utils.AppConstants.ERROR;

import com.interview.hackerrank.solver.Problem;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: kdohyeon
 * @date: 2019-12-27
 **/
@Service
public class SolverService {
    @Autowired
    private List<Problem> problems;

    public List<String> solve() {
        return problems.stream()
                       .filter(Problem::getValid)
                       .map(problem -> {
                                           try {
                                               return problem.process();
                                           } catch (IOException e) {
                                               e.printStackTrace();
                                               return "[" + ERROR + "]" + problem.getProblemName();
                                           }
                                       })
                       .collect(Collectors.toList());
    }
}
