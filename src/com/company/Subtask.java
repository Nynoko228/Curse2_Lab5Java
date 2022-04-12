package com.company;

import com.company.*;
public class Subtask extends Task {
    int idBig;

    public Subtask(String a, int b, String c, int d){
        super(a, b, c);
        idBig = d;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return false;
    }
}
