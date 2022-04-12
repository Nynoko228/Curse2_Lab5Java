package com.company;

public class Task {
    String NameofTask;
    int id;
    String StatusofTask;

    public Task(String a, int b, String c){
        NameofTask = a;
        id = b;
        StatusofTask = c;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return false;
    }

}
