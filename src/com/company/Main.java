package com.company;

import com.company.*;

public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        for (int i = 0; i < 3; i++) {
            manager.addTask();
            manager.ShowAll();
        }
//        manager.addTask();
//        manager.ShowAll();
        manager.addTaskB();
        manager.ShowAll();
        manager.addTaskB();
        manager.ShowAll();
        manager.Del();
        manager.ShowAll();
        manager.Del();
        manager.ShowAll();
    }
}
