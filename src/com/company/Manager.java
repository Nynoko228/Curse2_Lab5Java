package com.company;

import java.util.ArrayList;
import java.util.Scanner;

import com.company.*;
public class Manager<T> {
    static ArrayList<Task> LstofTasks = new ArrayList<Task>();
    static ArrayList<Subtask> LstofSub = new ArrayList<Subtask>();
    static ArrayList<BigTask> LstofBig = new ArrayList<BigTask>();

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
        String a = scanner.nextLine();
        int b = scanner.nextInt();
        String c = scanner.nextLine();
        LstofTasks.add(new Task(a, b, c));
    }
    public void addTaskB(){
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        int b = scanner.nextInt();
        String c = scanner.nextLine();
        ArrayList<Subtask> lst = new ArrayList<>();
        System.out.println("Введите количество подзадач: ");
        int cnt = scanner.nextInt();
        for(int i = 0; i < cnt; i++) {
            String d = scanner.nextLine();
            int e = scanner.nextInt();
            String f = scanner.nextLine();
            lst.add(new Subtask(d, e, f, b));
        }
        LstofBig.add(new BigTask(a, b, c, lst));
    }
    public void addTaskS(){
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        int b = scanner.nextInt();
        String c = scanner.nextLine();
        int d = scanner.nextInt();
        LstofSub.add(new Subtask(a, b, c, d));
        for (int i = 0; i < LstofBig.size(); i++){
            if((LstofBig.get(i).id == d) && (c == LstofBig.get(i).StatusofTask)){
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
            }
        }
    }

    public void Del(){
        Scanner scanner = new Scanner(System.in);
        int item = scanner.nextInt();
        for (int i = 0; i < LstofTasks.size(); i++){
            if (LstofTasks.get(i).id == item){
                LstofTasks.remove(i);
            }}
        for (int i = 0; i < LstofBig.size(); i++) {
            if (LstofBig.get(i).id == item) {
                LstofBig.remove(i);
            }
        }
        for (int i = 0; i < LstofSub.size(); i++){
            if (LstofSub.get(i).id == item){
                LstofSub.remove(i);
            }
        }
    }

    public void Remake(){
        System.out.println("Введите id задачи: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        for (int i = 0; i < LstofTasks.size(); i++){
            if (LstofTasks.get(i).id == id){
                System.out.println("Введите id большой задачи: ");
                int idB = scanner.nextInt();
                for (int j = 0; j < LstofBig.size(); j++){
                    if ((LstofBig.get(j).id == idB) &&(LstofTasks.get(i).StatusofTask == LstofBig.get(j).StatusofTask)){
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
                    }
            }
        }
    }
}

}
