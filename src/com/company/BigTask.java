package com.company;

import java.util.ArrayList;

public class BigTask extends Task {
    ArrayList<Subtask> lst = new ArrayList<>();

    public BigTask(String a, int b, String c, ArrayList<Subtask> list) {
        super(a, b, c);
        lst = list;
    }
}
