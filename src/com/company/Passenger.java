package com.company;

public class Passenger  {
    private String cusName;
    private String cusSurname;
    public int expenses;

    Passenger(String cname,String sname,int Expenses)
    {
        this.cusName=cname;
        this.cusSurname=sname;
        this.expenses=Expenses;
    }
    public String getcusName() {
        return cusName;
    }
    void setcusName(String Cname) {
        this.cusName = Cname;
    }
    public String getcusSurname() {
        return cusSurname;
    }
    void setcusSurname(String Sname) {
        this.cusSurname = Sname;
    }
    public int getexpenses() {
        return expenses;
    }
    void setexpenses(int exp) {
        this.expenses = exp;
    }


}
