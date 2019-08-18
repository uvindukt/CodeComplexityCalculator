package com.example.test.demo.service;

import com.example.test.demo.util.CncRegex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cnc {

    private int i = 0;
    private ArrayList<String> codeLines;
    private ArrayList<Integer> cnc;

    public Cnc(ArrayList<String> codeLines) {

        this.codeLines = codeLines;
        this.cnc = new ArrayList<>(codeLines.size());

    }

    private int getNestedCount(String line) {

        Pattern pattern_open = Pattern.compile("(" + CncRegex.REGEX_OPEN + ")");
        Matcher matcher_open = pattern_open.matcher(line);

        Pattern pattern_close = Pattern.compile("(" + CncRegex.REGEX_CLOSE + ")");
        Matcher matcher_close = pattern_close.matcher(line);

        while (matcher_open.find()) {
            i++;
        }

        while (matcher_close.find()) {
            if (i > 0)
                i--;
        }

        return i;

    }

    public ArrayList<Integer> getCnc() {

        codeLines.forEach(line -> cnc.add(getNestedCount(line)));
        return cnc;

    }

}
