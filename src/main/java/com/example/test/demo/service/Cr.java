package com.example.test.demo.service;

import com.example.test.demo.util.CrRegex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cr {

    private String methodName;
    private int i = 0;
    private int x = 0;
    private int z = 0;
    private ArrayList<String> codeLines;
    private ArrayList<Integer> cr;
    private ArrayList<Integer> cps;
    private ArrayList<String> recursiveMethods;
    private boolean insideMethod = false;

    public Cr(ArrayList<String> codeLines, ArrayList<Integer> cps) {

        this.codeLines = codeLines;
        this.cps = cps;
        this.cr = new ArrayList<>(codeLines.size());
        this.recursiveMethods = new ArrayList<>();

    }

    private int getRecursiveMethods(String line) {

        Pattern pattern_open = Pattern.compile("(" + CrRegex.REGEX_OPEN + ")");
        Matcher matcher_open = pattern_open.matcher(line);

        Pattern pattern_close = Pattern.compile("(" + CrRegex.REGEX_CLOSE + ")");
        Matcher matcher_close = pattern_close.matcher(line);

        while (matcher_open.find()) {
            i++;
        }

        while (matcher_close.find()) {
            if (i > 0)
                i--;
        }

        Pattern pattern = Pattern.compile("[a-z0-9_].+?\\(");
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {

            if (i > -1) {
                if (methodName != null) {
                    if (line.contains(methodName)) {
                        recursiveMethods.add(methodName);
                    }
                }
            }

            if (line.contains("class") || line.contains("if") || line.contains("switch") || line.contains("catch")
                    || line.contains("return") || line.contains(";")) {
                continue;
            } else {
                String[] sub = line.split("\\(");
                String x = sub[0].replace("public", "").replace("private", "").replace("protected", "")
                        .replace("static", "").replace("final", "").trim();
                if (x.split(" ").length > 1)
                    methodName = x.split(" ")[1];
                else
                    methodName = x;
            }

        }

        return i;

    }

    private int calculateCr(String line) {

        if (z == 0)
            insideMethod = false;

        for (String method : recursiveMethods) {

            if (line.contains(method) && line.contains("{")) {
                insideMethod = true;
                x = 1;
            }

            if (insideMethod && line.contains("{")) {
                z++;
            }


            if (insideMethod && line.contains("}")) {
                if (z > 0)
                    z--;
            }

        }

        if (insideMethod)
            x = 1;
        else
            x = 0;

        return x;

    }

    public ArrayList<Integer> getCr() {
        codeLines.forEach(line -> getRecursiveMethods(line));
        for (int j = 0; j < codeLines.size(); j++) {
            cr.add(calculateCr(codeLines.get(j)) * cps.get(j) * 2);
        }
        return cr;
    }

    public void display() {

        for (int y = 0; y < codeLines.size(); y++) {
            getRecursiveMethods(codeLines.get(y));
        }

        for (int y = 0; y < codeLines.size(); y++) {
            cr.add(calculateCr(codeLines.get(y)));
        }

    }
}
