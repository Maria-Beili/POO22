import java.util.Date;
import java.util.LinkedList;

public class Organization {
    
    //Atributs
    private String name;
    private LinkedList<Headquarter> placesList;
    private LinkedList<Action> actions;

    //Constructor
    public Organization(String n){
        name = n;
        placesList = new LinkedList<Headquarter>();
        actions = new LinkedList<Action>();
    }

    //Mètodes
    public void addHeadquarter(Headquarter h){
        placesList.add(h);
    }

    public LinkedList<Headquarter> getHQList(){
        return placesList;
    }

    public void printOrganization(){
        System.out.println("Organization:" + name);
        System.out.println("    Headquarters:");
        for (int i=0; i<placesList.size(); i++){
            System.out.println("        " + placesList.get(i));
        }
        System.out.print("\n");
    }
    

    public Delegate getHeadDelegate(Headquarter h){
        for (int i=0; i<placesList.size(); i++){
            if (h.equals(placesList.get(i))){
                return placesList.get(i).getHeadOf();
            }
        }
        return null;
    }

    public void addAction(Action a){
        actions.add(a);
    }

    public Action getAction(Date d){
        int length = placesList.size();
        for (int i=0; i<length; i++){
            Action a = placesList.get(i).getAction(d);
            if (a != null){
                return a;
            }
        }
        return null;
    }
}
