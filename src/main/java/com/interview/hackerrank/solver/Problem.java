package com.interview.hackerrank.solver;

/**
 * @author: kdohyeon
 * @date: 2019-12-27
 **/
public interface Problem {
    /**
     * 해당 문제를 풀지 안풀지에 대한 여부를 확인합니다.
     * */
    boolean getValid();

    /**
     * 문제 이름을 기입합니다.
     * */
    String getProblemName();

    /**
     * 문제 설명을 기입합니다.
     * */
    String getProblemDescription();

    /**
     * 문제 링크를 기입합니다.
     * */
    String getProblemLink();

    /**
     * 문제를 풉니다.
     * */
    boolean process();
}
