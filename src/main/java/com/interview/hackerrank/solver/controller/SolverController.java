package com.interview.hackerrank.solver.controller;

import com.interview.hackerrank.response.ApiResponse;
import com.interview.hackerrank.solver.service.SolverService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: kdohyeon
 * @date: 2019-12-27
 **/
@RestController
public class SolverController {
    @Autowired
    private SolverService solverService;

    @GetMapping("/run")
    public ApiResponse<List<String>> run() {

        try {
            return ApiResponse.success(solverService.solve());
        } catch (Exception e) {
            return ApiResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR.toString(), Arrays.toString(e.getStackTrace()));
        }
    }
}
