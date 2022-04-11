package com.company;

import java.util.ArrayList;

public class BigTask extends Task {
    ArrayList<Subtask> lst = new ArrayList<>();

    public static String CheckStatus(String a, String b){ //a - BigTask  b - Task/Subtask
        if (a == b){
            return a;
        }
        else{
            if ((a == "IN_PROGRESS") || (b == "IN_PROGRESS")){
                return "IN_PROGRESS";
            }
            else if(((a == "NEW")&&(b == "DONE"))||((a == "DONE") && (b == "NEW"))){
                return "IN_PROGRESS";
            }
        }
        return null;
    }

    public BigTask(String a, int b, String c, ArrayList<Subtask> list) {
        super(a, b, c);
        lst = list;
    }
}
