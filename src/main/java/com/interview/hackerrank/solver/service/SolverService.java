package com.interview.hackerrank.solver.service;

import static com.interview.hackerrank.utils.AppConstants.ERROR;

import com.interview.hackerrank.solver.Problem;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: kdohyeon
 * @date: 2019-12-27
 **/
@Slf4j
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
                                               log.error("Error while solving problem of {}", problem.getProblemName(), e);
                                               return "[" + ERROR + "]" + problem.getProblemName();
                                           }
                                       })
                       .collect(Collectors.toList());
    }
}
