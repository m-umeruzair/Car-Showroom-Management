package classes;

public class Car {
    private String carname;
    private String carcolour;
    private String carvariant;
    private int carprice;

    private static Car car=null;

    public Car(){}
    public static Car getInstance(){
        if (car==null)
            car = new Car();
        return car;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public void setcarcolour(String carcolour) {
        this.carcolour = carcolour;
    }

    public void setCarvariant(String carvariant) {
        this.carvariant = carvariant;
    }

    public void setCarprice(int carprice) {
        this.carprice = carprice;
    }

    public String getCarname() {
        return carname;
    }

    public String getcarcolour() {
        return carcolour;
    }

    public int getCarprice() {
        return carprice;
    }

    public String getCarvariant() {
        return carvariant;
    }
}
