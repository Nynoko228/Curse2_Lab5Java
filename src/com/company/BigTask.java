package com.company;

import java.util.ArrayList;

public class BigTask extends Task {
    ArrayList<Subtask> lst = new ArrayList<>();

    public static String CheckStatus(String a, String b){ //a - BigTask  b - Task/Subtask
        if (a.equals(b)){
            return a;
        }
        else{
            if ((a.equals("IN_PROGRESS")) || (b.equals("IN_PROGRESS"))){
                return "IN_PROGRESS";
            }
            else if(((a.equals("NEW"))&&(b.equals("DONE")))||((a.equals("DONE")) && (b.equals("NEW")))){
                return "IN_PROGRESS";
            }
        }
        return null;
    }

    public BigTask(String a, int b, String c, ArrayList<Subtask> list) {
        super(a, b, c);
        lst = list;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return false;
    }
}
