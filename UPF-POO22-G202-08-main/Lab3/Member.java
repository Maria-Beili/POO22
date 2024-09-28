public class Member {
    
    //Atributs
    private String name;
    private Integer phone;
    private String email; 
    private Availability available; 
    private Headquarter headquarter;

    //Constructor
    public Member(String n, int p, String e, Headquarter h){
        name = n;
        phone = p;
        email = e;
        headquarter = h;
    }

    //Mètodes
    public void setAvailabiliy(Availability a){
        available = a;
    }

    public Headquarter getHeadquarter(){
        return headquarter;
    }

    public String getName(){
        return name;
    }

    public void printAvailability(){
        available.printDays();
        available.printHours();
    }

}
