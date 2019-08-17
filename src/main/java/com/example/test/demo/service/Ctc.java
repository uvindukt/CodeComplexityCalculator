package com.example.test.demo.service;

import com.example.test.demo.util.CtcRegex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ctc {

    private ArrayList<String> codeLines;
    private ArrayList<Integer> ctc;

    public Ctc(ArrayList<String> codeLines) {

        this.codeLines = codeLines;
        this.ctc = new ArrayList<>(codeLines.size());

    }

    private int getConditionCount(String line) {

        Pattern pattern = Pattern
                .compile("(" + CtcRegex.REGEX_IF + ")");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {

            pattern = Pattern
                    .compile("(" + CtcRegex.REGEX_IF + "|" + CtcRegex.REGEX_SWITCH + "|" + CtcRegex.REGEX_LOGICAL + "|" + CtcRegex.REGEX_BITWISE + ")");
            matcher = pattern.matcher(line);

        } else {

            pattern = Pattern
                    .compile("(" + CtcRegex.REGEX_IF + "|" + CtcRegex.REGEX_SWITCH + ")");
            matcher = pattern.matcher(line);

        }

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;

    }

    private int getCatchCount(String line) {

        Pattern pattern = Pattern.compile("(" + CtcRegex.REGEX_CATCH + ")");
        Matcher matcher = pattern.matcher(line);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;

    }

    private int getLoopCount(String line) {

        Pattern pattern = Pattern.compile("(" + CtcRegex.REGEX_WHILE + ")");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {

            pattern = Pattern.compile("(" + CtcRegex.REGEX_WHILE + "|" + CtcRegex.REGEX_DO_WHILE + "|" + CtcRegex.REGEX_FOR + "|" + CtcRegex.REGEX_LOGICAL + "|" + CtcRegex.REGEX_BITWISE + ")");
            matcher = pattern.matcher(line);

        } else {

            pattern = Pattern.compile("(" + CtcRegex.REGEX_WHILE + "|" + CtcRegex.REGEX_DO_WHILE + "|" + CtcRegex.REGEX_FOR + ")");
            matcher = pattern.matcher(line);

        }

        int count = 0;
        while (matcher.find()) {
            count += 2;
        }

        return count;

    }

    public ArrayList<Integer> getCtc() {

        codeLines.forEach(line -> ctc.add(getCatchCount(line) + getConditionCount(line) + getLoopCount(line)));
        return ctc;

    }

}
