package com.example.test.demo.service;

import com.example.test.demo.util.CsRegex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cs {

    private ArrayList<String> codeLines;
    private ArrayList<Integer> ctc;

    public Cs(ArrayList<String> codeLines) {

        this.codeLines = codeLines;
        this.ctc = new ArrayList<>(codeLines.size());

    }

    private int getSizeCount(String line) {

        Pattern pattern = Pattern.compile("(" + CsRegex.REGEX_ARITHMETIC + "|" + CsRegex.REGEX_RELATION + "|"
                + CsRegex.REGEX_LOGICAL + "|" + CsRegex.REGEX_BITWISE + "|" + CsRegex.REGEX_MISCELLANEOUS + "|" + CsRegex.REGEX_ASSIGNMENT + "|"
                + CsRegex.REGEX_MANIPULATORS + "|" + CsRegex.REGEX_TEXT + "|" + CsRegex.REGEX_VARIABLE + "|" + CsRegex.REGEX_NUM + ")");
        Matcher matcher = pattern.matcher(line);

        Pattern removePattern = Pattern.compile("(" + CsRegex.REGEX_REMOVE + ")");
        Matcher removeMatcher = removePattern.matcher(line);

        Pattern doublePattern = Pattern.compile("(" + CsRegex.REGEX_TWO + ")");
        Matcher doubleMatcher = doublePattern.matcher(line);

        int i = 0;
        while (matcher.find()) {
            i++;
        }

        while (removeMatcher.find()) {
            i--;
        }

        while (doubleMatcher.find()) {
            i += 2;
        }

        return i;

    }

    public ArrayList<Integer> getCs() {

        codeLines.forEach(line -> ctc.add(getSizeCount(line)));
        return ctc;

    }

}
