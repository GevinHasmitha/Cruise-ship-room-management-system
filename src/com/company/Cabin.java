package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



//import static com.company.Main.cabin;

public class Cabin {

     public Cabin(){      //constructor

    }

    QueueClass[] queue = new QueueClass[3];    //for each cabin, there is a queue
    Passenger[] passenArr = new Passenger[3];  //for each cabin, there ae three passengers

    private int passengerno;
    private int passenno;
    private String MainName,QueueMainName,Name;


    public String getMainName() {
        return MainName;
    }
    void setMainName(String Cname) {
        this.MainName = Cname;
    }

    void setpassengerno(int passenNo) {
        this.passengerno = passenNo;
    }
    public int getpassengerno() {
        return passengerno;
    }

    void setpassenno(int pNo) {
        this.passenno = pNo;
    }
    public int getpassenno() {
        return passenno;
    }

    void setQueueMainName(String name) {
        this.QueueMainName = name;
    }
    public String getQueueMainName() {
        return QueueMainName;
    }

    void setName(String name) {
        this.Name = name;
    }
    public String getName() {
        return Name;
    }


    public  void addcustomer(int roomNm) {    //adds passenger to cabin
        Scanner scanner = new Scanner(System.in);
        int roomexpenses;
        String roomName;
        String roomsurName;
        int passengerNo;

        System.out.println("How many passengers are there in this cabin?");
        passengerNo=scanner.nextInt();
        setpassengerno(passengerNo);
        for (int i=0;i<this.passengerno;i++) {
            if (this.passengerno==12){
                System.out.println("Enter ");
                continue;
            }
            System.out.println("Enter first name for"+" passenger "+ (i+1) +" in room " + roomNm + " :");
            roomName = scanner.next();
            System.out.println("Enter surname for"+" passenger "+ (i+1) +" in room " + roomNm + " :");
            roomsurName = scanner.next();
            System.out.println("Enter Expenses for"+" passenger "+ (i+1) +" in room " + roomNm + " :");
            roomexpenses=scanner.nextInt();
            passenArr[i] = new Passenger(roomName, roomsurName,roomexpenses);
        }


    }
}









