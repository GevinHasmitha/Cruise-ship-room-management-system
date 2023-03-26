package com.company;

public class QueueClass {
    private  int front = 0;
    private  int end = 0;
    String qItems[] = new String[20];     //array to store queue elements
    private int chch;

    public QueueClass(){
        this.front=front;
        this.end=end;
        this.qItems=qItems;
        this.chch=chch;
    }

    public int getchch() {
        return chch;
    }
    void setchch(int exp) {
        this.chch = exp;
    }

    public void addQueue(String item) {   //adds items to queue
        this.qItems[ this.end ] = item;
        this.end++;
    }

    public String takeQueue() {           //returns consecutive values in queue
        if (this.end > this.front) {
            this.front++;
            return this.qItems[ this.front - 1 ];
        } else {
            System.out.println("Queue is empty");
            return "0000";  //this return value will help to identify that the queue is empty
                            //and that the cabin will be fully empty after deletion of previous passenger
        }
    }
}
