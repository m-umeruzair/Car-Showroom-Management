package classes;

import java.util.InputMismatchException;

public abstract class Person {
private String name;
private long cnic;
private String gender;
    Person(){}
    Person(String name,String gender){
        this.name=name;
        this.gender=gender;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCnic(long cnic)throws InputMismatchException {
        this.cnic = cnic;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public long getCnic() {
        return cnic;
    }
}
