package com.example.test.demo.service;

import java.util.ArrayList;

public class Tw {

    private ArrayList<String> codeLines;
    private ArrayList<Integer> ctc;
    private ArrayList<Integer> cnc;
    private ArrayList<Integer> ci;
    private ArrayList<Integer> tw;

    public Tw(ArrayList<String> codeLines, ArrayList<Integer> ctc, ArrayList<Integer> cnc, ArrayList<Integer> ci) {
        this.ctc = ctc;
        this.cnc = cnc;
        this.ci = ci;
        this.codeLines = codeLines;
        this.tw = new ArrayList<>(codeLines.size());
    }

    private void calculateTw() {

        for (int i = 0; i < codeLines.size(); i++) {
            tw.add(ctc.get(i) + cnc.get(i) + ci.get(i));
        }

    }

    public ArrayList<Integer> getTw() {
        calculateTw();
        return tw;
    }

}