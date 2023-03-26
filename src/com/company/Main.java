package com.company;


import java.io.*;
import java.util.Scanner;

public class Main {
    static String cabinname2;  //this variable is needed to be used in multiple method so declared at class level

    public static void main(String[] args) {


        String choice;
        Scanner scanner = new Scanner(System.in);


        Cabin[] cabin = new Cabin[5];                 //creates array of cabin objects
        for (int i = 0; i < cabin.length; i++) {
            cabin[i] = new Cabin();
        }

        //initialization
        for (int i = 0; i < cabin.length; i++) {
            cabin[i].setMainName("e");
        }

        while (true) {
            System.out.println(" V: Views All cabins\n" +            //navigation menu
                    " A: add a customer to a cabin\n " +
                    "E: Display Empty cabins\n " +
                    "D: Delete customer from cabin\n" +
                    " F: Find cabin from customer name \n" +
                    " S: Store program data into file \n " +
                    "L: Load program data from file\n" +
                    " O: View passengersOrdered alphabetically by name\n" +
                    " T: Print expenses of each passengers and the total expenses\n" +
                    " Q:Quit program");
            choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Q")) {    //equalsIgnoreCase ignores the cases sensitivity
                break;
            }

            if (choice.equalsIgnoreCase("V")) {     //view all cabins
                for (int i = 0; i < cabin.length; i++) {
                    if (cabin[i].getMainName().equals("e")) {
                        System.out.println("Room " + (i + 1) + " is empty ");
                    } else {
                        System.out.println("room " + (i + 1) + " occupied by " + cabin[i].getMainName());
                    }
                }
            }

            if (choice.equalsIgnoreCase("A")) {      //add passenger
                int roomNum;
                String cabinname;
                //     String cabinname2;
                while (true) {
                    //     int roomNum;
                    System.out.println("Enter room number (1-5) or 6 to stop:");
                    roomNum = scanner.nextInt();
                    if (roomNum == 6) {
                        break;
                    }
                    if (cabin[roomNum - 1].getMainName().equals("e")) {
                        System.out.println("Enter a name for your cabin :");
                        cabinname = scanner.next();
                        cabin[roomNum - 1].setMainName(cabinname);
                        cabin[roomNum - 1].addcustomer(roomNum);
                              cabin[roomNum-1].setQueueMainName("notnull");  //
                    } else {//this will execute when adding to queue
                        System.out.println("This cabin is already occupied, you will be added to the waiting list");

                        System.out.println("Enter a name for your cabin :");
                        cabinname2 = scanner.next();
                        cabin[roomNum - 1].setQueueMainName(cabinname2);
                        cabin[roomNum - 1].setName(cabinname2);    //this will help in the delete cabin part, to identify which cabins have a queue

                        int roomexpenses;
                        String roomName;
                        String roomsurName;
                        int passengerNo;

                        System.out.println("How many passengers are there in this cabin?");
                         passengerNo = scanner.nextInt();
                        cabin[roomNum - 1].setpassenno(passengerNo);  //a new variable and setter was created to store no of passengers for queue

                        try {
                           if (cabin[roomNum - 1].queue[0].getchch() == 0 ) {
                               System.out.println("");
                               //cabin[roomNum - 1].queue[0] = new QueueClass();  //creates new instance of QueueClass
                           }
                        }catch (NullPointerException e) {
                            cabin[roomNum - 1].queue[0] = new QueueClass();

                        }

                        for (int i = 0; i < cabin[roomNum - 1].getpassenno(); i++) {     //this part adds user input to queue

                        //    cabin[roomNum - 1].queue[0]=new QueueClass();
                            System.out.println("Enter first name for" + " passenger " + (i + 1) + " in room " + roomNum + " :");
                            roomName = scanner.next();
                            cabin[roomNum - 1].queue[0].addQueue(roomName);

                            System.out.println("Enter surname for" + " passenger " + (i + 1) + " in room " + roomNum + " :");
                            roomsurName = scanner.next();
                            cabin[roomNum - 1].queue[0].addQueue(roomsurName);

                            System.out.println("Enter Expenses for" + " passenger " + (i + 1) + " in room " + roomNum + " :");
                            roomexpenses = scanner.nextInt();
                            cabin[roomNum - 1].queue[0].addQueue(String.valueOf(roomexpenses));

                            cabin[roomNum - 1].queue[0].setchch(0);

                        }



                        //System.out.println("This cabin is already occupied, you are added to the waiting list");
                    }
                }
                scanner.nextLine();       //to capture the carriage return
            }


            if (choice.equalsIgnoreCase("E")) {         //displays empty cabins
                for (int i = 0; i < cabin.length; i++) {
                    if (cabin[i].getMainName().equals("e")) {
                        System.out.println("Room " + (i + 1) + " is empty ");
                    }
                }
            }


            if (choice.equalsIgnoreCase("D")) {        //deletes passengers from cabon

                int roomNum;
                System.out.println("Enter room number to delete passengers");
                roomNum = scanner.nextInt();

                if (cabin[roomNum - 1].getQueueMainName().equals(cabin[roomNum - 1].getName())) { //if something added to queue, this condition will return true
                    cabin[roomNum - 1].setMainName(cabin[roomNum - 1].getQueueMainName());

                    for (int i = 0; i < cabin[roomNum - 1].getpassenno(); i++) {

                        System.out.println();
                         cabin[roomNum - 1].passenArr[i]=new Passenger(cabin[roomNum - 1].queue[0].takeQueue(),cabin[roomNum - 1].queue[0].takeQueue(),Integer.parseInt(cabin[roomNum - 1].queue[0].takeQueue()));
                        //instead of editing previously created passenger arrays, I created new ones
                        //so that it wont return null when validating.


                    }
                    for (int i = 0; i < cabin.length; i++) {                      //
                        for (int j = 0; j < cabin[i].getpassenno(); j++) {        //  this part used to make cabin empty if all of queue elements removed
                            if (cabin[i].passenArr[j].getcusName().equals("0000") || cabin[i].passenArr[j].getcusSurname().equals("0000") || String.valueOf(cabin[i].passenArr[j].getcusName()).equals("0000") ) //
                                cabin[i].setMainName("e");
                                                                  //makes sure that if queue and cabin is both empty, cabin will be empty when stored in file
                        }
                    }



                cabin[roomNum - 1].setpassengerno(cabin[roomNum - 1].getpassenno());

                } else {                                      //this will execute if no elements in queue
                    cabin[roomNum - 1].setMainName("e");
                }
                scanner.nextLine();
            }

            if (choice.equalsIgnoreCase("F")) {           //finds any passenger from first name
                String cabinName;
                System.out.println("Enter first name of customer");
                cabinName = scanner.next();
                for (int i = 0; i < cabin.length; i++) {
                    for (int j = 0; j < cabin[i].getpassengerno(); j++) {
                        if (cabin[i].passenArr[j].getcusName().equals(cabinName)) {
                            System.out.println(cabinName + " is in cabin " + (i + 1));
                        }
                    }
                }
                scanner.nextLine();       //to capture the carriage return so that menu is displayed only once
            }

            if (choice.equalsIgnoreCase("S")) {         //stores the data into a file
                try {
                    FileWriter myWriter = new FileWriter("filename.txt");
                    for (int i = 0; i < cabin.length; i++) {
                        if (cabin[i].getMainName().equals("e")) {
                            myWriter.write("room " + (i + 1) + " is empty\n");
                            System.out.println("Successfully wrote to the file.");
                        } else {
                            for (int j = 0; j < cabin[i].getpassengerno(); j++) {

                                myWriter.write("Room " + (i + 1) + " is occupied by " + cabin[i].passenArr[j].getcusName() +
                                        " " + cabin[i].passenArr[j].getcusSurname() + " with expenses "
                                        + cabin[i].passenArr[j].getexpenses() + "\n");
                            }

                            System.out.println("Successfully wrote to the file.");
                        }

                    }

                    myWriter.close();

                } catch (IOException e) {
                    System.out.println("An error occurred.");
                }
            }


            if (choice.equalsIgnoreCase("L")) {            //load stored data from file
                try {
                    File inputFile = new File("filename.txt");
                    Scanner rf = new Scanner(inputFile);
                    String fileLine;
                    while (rf.hasNext()) {
                        fileLine = rf.nextLine();
                        System.out.println(fileLine);
                    }
                    rf.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                }
            }

            if (choice.equalsIgnoreCase("T")) {       //total and individual expenses of passengers
                int totExpenses = 0;
                for (int i = 0; i < cabin.length; i++) {
                    for (int j = 0; j < cabin[i].getpassengerno(); j++) {
                        System.out.println("Expenses for " + cabin[i].passenArr[j].getcusName() + " is " + cabin[i].passenArr[j].getexpenses());
                        totExpenses = totExpenses + cabin[i].passenArr[j].getexpenses();
                    }
                }
                System.out.println("The total expenses of all passengers is " + totExpenses);
            }

            if (choice.equalsIgnoreCase("Z")) {
                cabin[0].queue[0]=new QueueClass();
                cabin[0].queue[0].addQueue("rrrrrrrrrrrrrrrrrrrrrrr");
                cabin[0].queue[0].addQueue("rrrrrrrrrrrrrrrrrrrrrrr2");
                cabin[1].queue[0]=new QueueClass();
                cabin[1].queue[0].addQueue("eeeeeeeeeeeeeee");
                cabin[1].queue[0].addQueue("eeeeeeeeeeeeeee2");

                System.out.println(cabin[0].queue[0].takeQueue());
                System.out.println(cabin[0].queue[0].takeQueue());

            }



            }


    }
}



