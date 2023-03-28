package classes;

import java.util.InputMismatchException;

public class Admin extends Person{
    protected int adminid=1190;
    protected String apassword="programming1";
    public Admin(){}
    @Override
    public void setName(String name) {
        super.setName("Umer");
    }

    @Override
    public void setGender(String gender) {
        super.setGender("Male");
    }

    @Override
    public void setCnic(long cnic) throws InputMismatchException {
        super.setCnic(477721328137l);
    }

    public int getAdminid() {
        return adminid;
    }

    public String getApassword() {
        return apassword;
    }
}
