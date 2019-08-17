package com.example.test.demo.service;

import java.util.ArrayList;

public class Cps {

    private ArrayList<Integer> cs;
    private ArrayList<Integer> tw;
    private ArrayList<Integer> cps;
    private ArrayList<String> codeLines;

    public Cps(ArrayList<String> codeLines, ArrayList<Integer> cs, ArrayList<Integer> tw) {
        this.tw = tw;
        this.cs = cs;
        this.codeLines = codeLines;
        this.cps = new ArrayList<>(codeLines.size());
    }

    private void calculateCps() {

        for (int i = 0; i < codeLines.size(); i++) {
            cps.add(cs.get(i) * tw.get(i));
        }

    }

    public ArrayList<Integer> getCps() {
        calculateCps();
        return cps;
    }

}
