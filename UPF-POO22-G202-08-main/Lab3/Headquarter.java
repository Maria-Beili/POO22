import java.util.Date;
import java.util.LinkedList;

public class Headquarter {

    //Atributs
    private String name;
    private String email;
    private LinkedList<Member> membersList;
    private Delegate head;
    private Organization organization;
    private LinkedList<City> citiesList;
    private LinkedList<InfoAction> actionsParticipated;

    //Constructor
    public Headquarter(String n, String e, Organization o){
        name = n;
        email = e;
        organization = o;
        membersList = new LinkedList<Member>();
        citiesList = new LinkedList<City>();
        actionsParticipated = new LinkedList<InfoAction>();
    }

    //Mètodes
    public void addMember(Member m){
        membersList.add(m);
    }

    public Organization getOrganization(){
        return organization;
    }

    public void setHead(Delegate d){
        head = d;
    }

    public Delegate getHeadOf(){
        return head;
    }

    public void addCity(City c){
        citiesList.add(c);
    }

    public void printHeadquarter(){
        System.out.print("  " + name + "\n");   
        System.out.print("          Head:");
        head.printDelegate();
    }
    
    public String toString(){
        return name;
    }

    public void singUpAction(Action a, int members, int nonmembers, boolean press){
        InfoAction info = new InfoAction(a, this, nonmembers, nonmembers, press);
        actionsParticipated.add(info);
        a.addHeadquarter(this);
    }

    public Action getAction(Date d){
        int length = actionsParticipated.size();
        for(int i=0; i<length; i++){
            Action a = actionsParticipated.get(i).getAction();
            Date action_date = a.getDate();
            if (action_date.equals(d)){
                return a;
            }
        }
        return null;
    }

    public LinkedList<InfoAction> getInfoAction(){
        return actionsParticipated;
    }

}
