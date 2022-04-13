package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

import com.company.*;
public class Manager {
    static ArrayList<Task> LstofTasks = new ArrayList<Task>();
    static ArrayList<Subtask> LstofSub = new ArrayList<Subtask>();
    static ArrayList<BigTask> LstofBig = new ArrayList<BigTask>();
    static ArrayList<Integer> LstID = new ArrayList<Integer>();
    int cnt = 0;
    ArrayList<String> Progress = new ArrayList<String>();




    public static void ShowAll(){
        for (int i = 0; i < LstofTasks.size(); i++){
            System.out.println("Название задачи: " + LstofTasks.get(i).NameofTask + " id: " + LstofTasks.get(i).id + " статус задачи: " + LstofTasks.get(i).StatusofTask);
        }
        for (int i = 0; i < LstofBig.size(); i++){
            System.out.println("Название задачи: " + LstofBig.get(i).NameofTask + " id: " + LstofBig.get(i).id + " статус задачи: " + LstofBig.get(i).StatusofTask);
        }
        for (int i = 0; i < LstofSub.size(); i++){
            System.out.println("Название задачи: " + LstofSub.get(i).NameofTask + " id: " + LstofSub.get(i).id + " статус задачи: " + LstofSub.get(i).StatusofTask);
        }
    }

    public void DelAll(){
        LstofSub.clear();
        LstofBig.clear();
        LstofTasks.clear();
    }

    public void getTaskonID(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите id искомой задачи: ");
        int item = scanner.nextInt();
        for (int i = 0; i < LstofTasks.size(); i++){
            if (LstofTasks.get(i).id == item){
            System.out.println("Название задачи: " + LstofTasks.get(i).NameofTask + " id: " + LstofTasks.get(i).id + " статус задачи: " + LstofTasks.get(i).StatusofTask);
        }}
        for (int i = 0; i < LstofBig.size(); i++) {
            if (LstofBig.get(i).id == item) {
                System.out.println("Название задачи: " + LstofBig.get(i).NameofTask + " id: " + LstofBig.get(i).id + " статус задачи: " + LstofBig.get(i).StatusofTask);
            }
        }
        for (int i = 0; i < LstofSub.size(); i++){
            if (LstofSub.get(i).id == item){
                System.out.println("Название задачи: " + LstofSub.get(i).NameofTask + " id: " + LstofSub.get(i).id + " статус задачи: " + LstofSub.get(i).StatusofTask);
            }
        }
    }

    public void addTask(){
        Progress.add("NEW");
        Progress.add("DONE");
        Progress.add("IN_PROGRESS");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название задачи, её id и статус: ");
        String a = scanner.nextLine();
        int b = scanner.nextInt();
        if (!LstID.contains(b)) {
            scanner.nextLine();
            String c = scanner.nextLine();
            if (Progress.contains(c)) {
                LstID.add(b);
                LstofTasks.add(new Task(a, b, c));
            }
            else System.out.println("Вы ввели неправильный статус задачи");
        }
        else {System.out.println("Вы ввели уже существующий id!");}
    }
    public void addTaskB(){
        Progress.add("NEW");
        Progress.add("DONE");
        Progress.add("IN_PROGRESS");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название B задачи, её id и статус: ");
        String a = scanner.nextLine();
        int b = scanner.nextInt();
        if (!LstID.contains(b)) {
            scanner.nextLine();
            String c = scanner.nextLine();
            if (Progress.contains(c)) {
                LstID.add(b);
                ArrayList<Subtask> lst = new ArrayList<>();
                System.out.println("Введите количество подзадач: ");
                int cnt = scanner.nextInt();
                scanner.nextLine();
                for (int i = 0; i < cnt; i++) {
                    System.out.println("Введите название S задачи, её id и статус: ");
                    String d = scanner.nextLine();
                    int e = scanner.nextInt();
                    if (!LstID.contains(e)) {
                        scanner.nextLine();
                        String f = scanner.nextLine();
                        if (Progress.contains(f)) {
                            LstID.add(e);
                            LstofSub.add(new Subtask(d, e, f, b));
                            lst.add(new Subtask(d, e, f, b));
                        }
                        else System.out.println("Вы ввели неправильный статус задачи");
                    }
                }
                BigTask bgt = new BigTask(a, b, c, lst);
                for (int i = 0; i < lst.size(); i++) {
                    bgt.StatusofTask = bgt.CheckStatus(bgt.StatusofTask, lst.get(i).StatusofTask);
                }
                LstofBig.add(bgt);
            }
            else System.out.println("Вы ввели неправильный статус задачи");
        }
        else {System.out.println("Вы ввели уже существующий id!");}

    }
    public void addTaskS() {
        Progress.add("NEW");
        Progress.add("DONE");
        Progress.add("IN_PROGRESS");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название S задачи, её id и статус: ");
        String a = scanner.nextLine();
        int b = scanner.nextInt();
        if (!LstID.contains(b)) {
            scanner.nextLine();
            String c = scanner.nextLine();
            if (Progress.contains(c)) {
                LstID.add(b);
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
            else System.out.println("Вы ввели неправильный статус задачи");
        }
        else {System.out.println("Вы ввели уже существующий id!");}

    }

    public void Del(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id задачи: ");
        int item = scanner.nextInt();
        for (int i = 0; i < LstofTasks.size(); i++){
            if (LstofTasks.get(i).id == item){
                LstID.remove(item);
                LstofTasks.remove(i);
                break;
            }}
        ArrayList<Subtask> lst = new ArrayList<>();
        ArrayList<Integer> lst1 = new ArrayList<>();
        for (int i = 0; i < LstofBig.size(); i++) {
            if (LstofBig.get(i).id == item) {
                for (int j = 0; j < LstofBig.get(i).lst.size(); j++){
                     for(int l = 0; l < LstofSub.size(); l++){
                         if(LstofBig.get(i).lst.get(j).idBig == LstofSub.get(l).idBig){
                             lst1.add(LstofSub.get(l).id);
                             //System.out.println(LstofBig.get(i).lst.size());
                             LstofBig.get(i).lst.remove(j);
                             //System.out.println(LstofBig.get(i).lst.size());
                             //LstofSub.remove(l);
                             lst.add(LstofSub.get(l));
                         }
                     }
                }
                LstofSub.removeAll(lst);
                LstID.remove(item);
                LstID.removeAll(lst1);
                LstofBig.remove(i);
            }
        }
        for (int i = 0; i < LstofSub.size(); i++){
            if (LstofSub.get(i).id == item){
                for (int j = 0; j <LstofBig.size(); j++){
                    if((LstofBig.get(j).id == LstofSub.get(i).idBig) && (LstofBig.get(j).lst.size() == 1)){
                        LstofBig.remove(j);
                        break;
                    }
                    else if((LstofBig.get(j).id == LstofSub.get(i).idBig)){
                        for (int l = 0; l < LstofBig.get(j).lst.size(); l++){
                            if(LstofBig.get(j).lst.get(l).id == item){
                                System.out.println(LstofBig.get(j).lst.size());
                                LstofBig.get(j).lst.remove(l);
                                System.out.println(LstofBig.get(j).lst.size());
                                break;
                            }
                        }
                        System.out.println(LstofBig.get(j).lst.size());
//                        LstofBig.get(j).lst.remove((Subtask)(LstofSub.get(i))); // В lst хранится тип Subtask и такой remove надо переделать под тип Subtask
                        System.out.println(LstofBig.get(j).lst.size());
                    }
//                        for (int l = 0; l < LstofBig.get(j).lst.size(); l++) {
//                            if((LstofBig.get(j).id == LstofSub.get(i).idBig)){
//                            System.out.println(LstofBig.get(j).lst.size());
//                            LstofBig.get(j).lst.remove(l);
//                            System.out.println(LstofBig.get(j).lst.size());
//                            continue;
//                        }
//                    }

                }
                LstID.remove(item);
                LstofSub.remove(i);
                break;
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
