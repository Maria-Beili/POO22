import java.util.Date;
import java.util.LinkedList;

public class Action {

    //Atributs
    private String purpose;
    private Date start;
    private Integer duration;
    private LinkedList<InfoAction> developedAction;

    //Constructor
    public Action(String p, java.util.Date d2, int d){
        purpose = p;
        start = d2;
        duration = d;
        developedAction = new LinkedList<InfoAction>();
    }

    //Mètodes
    public void addHeadquarter(Headquarter h){
        LinkedList<InfoAction> info = new LinkedList<InfoAction>();
        info = h.getInfoAction();
        for (int i=0; i<info.size(); i++){
            if(! developedAction.contains(info.get(i))){
                developedAction.add(info.get(i));
            }
        }

        
    }

    public Date getDate(){
        return start;
    }

    public String getPurpose(){
        return purpose;
    }
}
