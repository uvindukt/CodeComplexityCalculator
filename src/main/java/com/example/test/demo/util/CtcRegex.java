package com.example.test.demo.util;

public class CtcRegex {

    public static final String REGEX_IF = "if[ ]+\\(|\\sif[ ]+\\(|\\sif\\(";
    public static final String REGEX_SWITCH = "case[ ]+\\(|\\scase[ ]+\\(|\\scase\\(|default[ ]+:";
    public static final String REGEX_LOGICAL = "&&|[ ]+&&[ ]+|\\|\\||[ ]+\\|\\|";
    public static final String REGEX_BITWISE = "&|[ ]+&[ ]+|\\||[ ]+\\|";
    public static final String REGEX_WHILE = "while[ ]+\\(|\\swhile[ ]+\\(|\\swhile\\(";
    public static final String REGEX_FOR = "for[ ]+\\(|\\sfor[ ]+\\(|\\sfor\\(";
    public static final String REGEX_DO_WHILE = "do while[ ]+\\(|\\sdo while[ ]+\\(|\\sdo while\\(";
    public static final String REGEX_CATCH = "catch[ ]+\\(|\\scatch[ ]+\\(|\\scatch\\(";

}
