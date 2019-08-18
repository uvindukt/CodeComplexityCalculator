package com.example.test.demo.service;

import com.example.test.demo.util.CiRegex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ci {

    private int y;
    private int x = 0;
    private ArrayList<String> codeLines;
    private ArrayList<Integer> ci;
    private HashSet<String> classNames = new HashSet<>();
    private HashSet<String> cc = new HashSet<>();

    public Ci(ArrayList<String> codeLines) {

        this.codeLines = codeLines;
        this.ci = new ArrayList<>(codeLines.size());
        this.y = 0;

    }

    private int getCount(String line) {

        Pattern pattern_open = Pattern.compile("(" + CiRegex.REGEX_OPEN + ")");
        Matcher matcher_open = pattern_open.matcher(line);

        Pattern pattern_close = Pattern.compile("(" + CiRegex.REGEX_CLOSE + ")");
        Matcher matcher_close = pattern_close.matcher(line);

        while (matcher_open.find()) {
            y++;
        }

        while (matcher_close.find()) {
            if (y > 0)
                y--;
        }

        return y;

    }

    private int getClasses(String line, int y) {

        Pattern pattern = Pattern.compile("(" + CiRegex.REGEX_CLASS + ")");
        Matcher matcher = pattern.matcher(line);

        if (y == 0 && !line.contains("}"))
            x = 0;

        while (matcher.find()) {

            int index = line.lastIndexOf("class");
            String[] substring = line.substring(index).split(" |\\{");
            String className = substring[1].trim();

            Iterator<String> it = classNames.iterator();

            while (it.hasNext()) {

                String l = it.next();

                if (l.split(",")[0].equals(className)) {

                    x = l.split(",").length;

                }

            }

            if (line.contains("extends")) {

                index = line.lastIndexOf("extends");
                substring = line.substring(index).split(" |\\{");
                String parentClassName = substring[1].trim();
                classNames.add(className + "," + parentClassName);

            } else {

                classNames.add(className);

            }

        }

        return x;

    }

    private void process() {

        codeLines.forEach(line -> getClasses(line, 0));

        Iterator<String> it = classNames.iterator();

        cc.addAll(classNames);

        while (it.hasNext()) {
            String relation = it.next();

            if (relation.contains(",")) {
                String[] cls = relation.split(",");
                Iterator<String> it2 = classNames.iterator();

                while (it2.hasNext()) {
                    String relation2 = it2.next();

                    if (relation2.contains(",")) {
                        String[] cls2 = relation2.split(",");

                        for (int i = 0; i < cls2.length - 1; i++) {

                            if (cls[i].equals(cls2[cls2.length - 1])) {
                                cc.remove(relation2);
                                cc.add(relation2 + "," + cls[cls.length - 1]);
                            }

                        }

                    }

                }

            }

        }

        classNames.removeAll(classNames);
        classNames.addAll(cc);

    }

    public ArrayList<Integer> getCi() {

        process();

        codeLines.forEach(line -> ci.add(getClasses(line, getCount(line))));
        return ci;

    }

}
