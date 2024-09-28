import java.util.LinkedList;

public class Regular extends Member{
    
    //Atributs
    private Delegate responsible;
    private LinkedList<Vehicle> vehiclesList;

    //Constructor
    public Regular(String n, int p, String e, Headquarter h, Delegate r){
        super(n,p,e,h);
        responsible = r;
        vehiclesList = new LinkedList<Vehicle>();
    }

    //Mètodes
    public void addVehicle(Vehicle v){
        vehiclesList.add(v);
    }


}
