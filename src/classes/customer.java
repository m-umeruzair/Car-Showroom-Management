package classes;

import java.util.InputMismatchException;

public class customer extends Person {
    private int salary;
    private String address;
    private int phoneno;

    private static customer customer=null;

    public customer(){}
    public static customer getInstance(){
        if (customer==null)
            customer = new customer();
        return customer;
    }

    public customer(String name,String gender,String address){
        super(name,gender);
        this.address=address;

    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setPhoneno(int phoneno)throws NumberFormatException{
        this.phoneno = phoneno;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneno() {
        return phoneno;
    }

    public int getSalary() {
        return salary;
    }
}
