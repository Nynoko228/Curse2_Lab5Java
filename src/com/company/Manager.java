package com.company;

import java.util.ArrayList;
import java.util.Scanner;

import com.company.*;
public class Manager {
    static ArrayList<Task> LstofTasks = new ArrayList<Task>();
    static ArrayList<Subtask> LstofSub = new ArrayList<Subtask>();
    static ArrayList<BigTask> LstofBig = new ArrayList<BigTask>();
    static ArrayList<Integer> LstID = new ArrayList<Integer>();
    int cnt = 0;



    public static void ShowAll(){
        for (int i = 0; i < LstofTasks.size(); i++){
            System.out.println("Название задачи и id: " + LstofTasks.get(i).NameofTask + " " + LstofTasks.get(i).id);
        }
        for (int i = 0; i < LstofBig.size(); i++){
            System.out.println("Название большой задачи и id: " + LstofBig.get(i).NameofTask + " " + LstofBig.get(i).id);
        }
        for (int i = 0; i < LstofSub.size(); i++){
            System.out.println("Название задачи и id: " + LstofSub.get(i).NameofTask + " " + LstofSub.get(i).id);
        }
    }

    public void DelAll(){
        LstofSub.clear();
        LstofBig.clear();
        LstofTasks.clear();
    }

    public void getTaskonID(){
        Scanner scanner = new Scanner(System.in);
        int item = scanner.nextInt();
        for (int i = 0; i < LstofTasks.size(); i++){
            if (LstofTasks.get(i).id == item){
            System.out.println("Название задачи: " + LstofTasks.get(i).NameofTask);
        }}
        for (int i = 0; i < LstofBig.size(); i++) {
            if (LstofBig.get(i).id == item) {
                System.out.println("Название задачи: " + LstofBig.get(i).NameofTask);
            }
        }
        for (int i = 0; i < LstofSub.size(); i++){
            if (LstofSub.get(i).id == item){
                System.out.println("Название задачи: " + LstofSub.get(i).NameofTask);
            }
        }
    }

    public void addTask(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название задачи, её id и статус: ");
        String a = scanner.nextLine();
        int b = scanner.nextInt();
        if (!LstID.contains(b)) {
            LstID.add(b);
            scanner.nextLine();
            String c = scanner.nextLine();
            LstofTasks.add(new Task(a, b, c));
        }
    }
    public void addTaskB(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название B задачи, её id и статус: ");
        String a = scanner.nextLine();
        int b = scanner.nextInt();
        if (!LstID.contains(b)) {
            LstID.add(b);
            scanner.nextLine();
            String c = scanner.nextLine();
            ArrayList<Subtask> lst = new ArrayList<>();
            System.out.println("Введите количество подзадач: ");
            int cnt = scanner.nextInt();
            for (int i = 0; i < cnt; i++) {
                System.out.println("Введите название задачи, её id и статус: ");
                String d = scanner.nextLine();
                int e = scanner.nextInt();
                if (!LstID.contains(e)) {
                    LstID.add(e);
                    scanner.nextLine();
                    String f = scanner.nextLine();
                    lst.add(new Subtask(d, e, f, b));
                }
            }
            BigTask bgt = new BigTask(a, b, c, lst);
            for (int i = 0; i < lst.size(); i++) {
                bgt.StatusofTask = bgt.CheckStatus(lst.get(i).StatusofTask, bgt.StatusofTask);
            }
            LstofBig.add(bgt);
        }
    }
    public void addTaskS() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название S задачи, её id и статус: ");
        String a = scanner.nextLine();
        int b = scanner.nextInt();
        if (!LstID.contains(b)) {
            LstID.add(b);
            scanner.nextLine();
            String c = scanner.nextLine();
            scanner.nextLine();
            int d = scanner.nextInt();
            LstofSub.add(new Subtask(a, b, c, d));
            for (int i = 0; i < LstofBig.size(); i++) {
            /*if((LstofBig.get(i).id == d) && (c == LstofBig.get(i).StatusofTask)){
                LstofBig.get(i).lst.add(new Subtask(a, b, c, d));
            }
            else{
                if ((c == "IN_PROGRESS") && ((LstofBig.get(i).id == d))){
                    LstofBig.get(i).StatusofTask = "IN_PROGRESS";
                    LstofBig.get(i).lst.add(new Subtask(a, b, c, d));
                }
                else if ((LstofBig.get(i).id == d) && (c == "NEW")){
                    LstofBig.get(i).StatusofTask = "NEW";
                    LstofBig.get(i).lst.add(new Subtask(a, b, c, d));
                }
            }*/
                if (LstofBig.get(i).id == d) {
                    LstofBig.get(i).StatusofTask = LstofBig.get(i).CheckStatus(LstofBig.get(i).StatusofTask, c);
                }
            }
        }
    }

    public void Del(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id задачи: ");
        int item = scanner.nextInt();
        for (int i = 0; i < LstofTasks.size(); i++){
            if (LstofTasks.get(i).id == item){
                LstID.remove(item);
                LstofTasks.remove(i);
            }}
        for (int i = 0; i < LstofBig.size(); i++) {
            if (LstofBig.get(i).id == item) {
                for (int j = 0; j < LstofBig.get(i).lst.size(); j++){
                     for(int l = 0; l < LstofSub.size(); l++){
                         if(LstofBig.get(i).lst.get(j).idBig == LstofSub.get(l).idBig){
                             LstID.remove(LstofSub.get(l).id);
                             LstofSub.remove(l);
                         }
                     }
                }
                LstID.remove(item);
                LstofBig.remove(i);
            }
        }
        for (int i = 0; i < LstofSub.size(); i++){
            if (LstofSub.get(i).id == item){
                for (int j = 0; j <LstofBig.size(); j++){
                    if((LstofBig.get(j).id == LstofSub.get(i).idBig) && (LstofBig.get(j).lst.size() == 1)){
                        LstofBig.remove(j);
                    }
                }
                LstID.remove(item);
                LstofSub.remove(i);
            }
        }
    }

    public void Remake(){
        System.out.println("Введите id задачи: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < LstofTasks.size(); i++){
            if (LstofTasks.get(i).id == id){
                System.out.println("Введите id большой задачи: ");
                int idB = scanner.nextInt();
                for (int j = 0; j < LstofBig.size(); j++){
                    /*if ((LstofBig.get(j).id == idB) &&(LstofTasks.get(i).StatusofTask == LstofBig.get(j).StatusofTask)){
                        LstofBig.get(i).lst.add(new Subtask(LstofTasks.get(i).NameofTask, LstofTasks.get(i).id, LstofTasks.get(i).StatusofTask, idB));
                        LstofTasks.remove(i);
                    }
                    else if((LstofBig.get(j).id == idB) &&(LstofTasks.get(i).StatusofTask == "IN_PROGRESS")){
                        LstofBig.get(j).StatusofTask = "IN_PROGRESS";
                        LstofBig.get(i).lst.add(new Subtask(LstofTasks.get(i).NameofTask, LstofTasks.get(i).id, LstofTasks.get(i).StatusofTask, idB));
                        LstofTasks.remove(i);
                    }
                    else if ((LstofBig.get(j).id == idB) &&(LstofTasks.get(i).StatusofTask == "NEW")){
                        LstofBig.get(j).StatusofTask = "NEW";
                        LstofBig.get(i).lst.add(new Subtask(LstofTasks.get(i).NameofTask, LstofTasks.get(i).id, LstofTasks.get(i).StatusofTask, idB));
                        LstofTasks.remove(i);
                    }*/
                    if (LstofBig.get(j).id == idB){
                        LstofBig.get(j).StatusofTask = LstofBig.get(j).CheckStatus(LstofBig.get(j).StatusofTask, LstofTasks.get(i).StatusofTask);
                        LstofBig.get(j).lst.add(new Subtask(LstofTasks.get(i).NameofTask, LstofTasks.get(i).id, LstofTasks.get(i).StatusofTask, idB));
                        LstofTasks.remove(i);
                    }
            }
        }
    }
}

}
