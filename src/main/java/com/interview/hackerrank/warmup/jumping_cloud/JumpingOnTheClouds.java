package com.interview.hackerrank.warmup.jumping_cloud;

import com.google.common.collect.Lists;
import com.interview.hackerrank.solver.ProblemSolver;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
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
        return "/warmup/jumping_clouds";
    }

    @Override
    public List solveProblem(File input) throws FileNotFoundException {
        return Lists.newArrayList();
    }

    @Override
    public List readFile(File file) throws FileNotFoundException {
        return Lists.newArrayList();
    }
}
