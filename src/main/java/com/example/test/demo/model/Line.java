package com.example.test.demo.model;

public class Line {

    private int index;
    private String text;
    private int cs;
    private int ctc;
    private int cnc;
    private int ci;
    private int tw;
    private int cps;
    private int cr;

    public Line() {
    }

    public Line(int index, String text, int cs, int ctc, int cnc, int ci, int tw, int cps, int cr) {
        this.index = index;
        this.text = text;
        this.cs = cs;
        this.ctc = ctc;
        this.cnc = cnc;
        this.ci = ci;
        this.tw = tw;
        this.cps = cps;
        this.cr = cr;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCs() {
        return cs;
    }

    public void setCs(int cs) {
        this.cs = cs;
    }

    public int getCtc() {
        return ctc;
    }

    public void setCtc(int ctc) {
        this.ctc = ctc;
    }

    public int getCnc() {
        return cnc;
    }

    public void setCnc(int cnc) {
        this.cnc = cnc;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public int getTw() {
        return tw;
    }

    public void setTw(int tw) {
        this.tw = tw;
    }

    public int getCps() {
        return cps;
    }

    public void setCps(int cps) {
        this.cps = cps;
    }

    public int getCr() {
        return cr;
    }

    public void setCr(int cr) {
        this.cr = cr;
    }
}
