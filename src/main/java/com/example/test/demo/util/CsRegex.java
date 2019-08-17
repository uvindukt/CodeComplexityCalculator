package com.example.test.demo.util;

public class CsRegex {

    public static final String REGEX_TWO = "new|delete|throw|throws|&[^&]|\\*";
    public static final String REGEX_ARITHMETIC = "\\+[^\\+]|-[^-]|\\*|/|%|\\+\\+|--";
    public static final String REGEX_RELATION = "==|!=|>|<|>=|<=";
    public static final String REGEX_LOGICAL = "&&|\\|\\||!";
    public static final String REGEX_BITWISE = "\\|[^\\|]|\\^|~|<<|>>|<<<|>>>";
    public static final String REGEX_MISCELLANEOUS = ",|->|\\.|::";
    public static final String REGEX_ASSIGNMENT = "\\+=|-=|\\*=|/=|[^<>]=|>>>=|\\|=|&=|%=|<<=|>>=|\\^=";
    public static final String REGEX_KEY = "void|double|int|float|String|printf|println|cout|cin|if|for|while|do-while|switch|case";
    public static final String REGEX_MANIPULATORS = "endl|\\n";
    public static final String REGEX_TEXT = "\".*?\"";
    public static final String REGEX_VARIABLE = "[a-z_]\\w*";
    public static final String REGEX_NUM = "\\d+";
    public static final String REGEX_REMOVE = "public|static|else|try|return|new|delete|throw|throws";

}
