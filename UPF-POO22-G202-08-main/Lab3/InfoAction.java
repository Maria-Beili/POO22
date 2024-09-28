public class InfoAction {
    
    //Atributs
    private Action action;
    private Headquarter headquarter;
    private Integer numMembers;
    private Integer numNonMembers;
    private Boolean pressCoverage;

    //Constructor
    public InfoAction(Action a, Headquarter h, int nm, int nn, boolean pc){
        action = a;
        headquarter = h;
        numMembers = nm;
        numNonMembers = nn;
        pressCoverage = pc;
    }

    //Mètodes 
    public Action getAction(){
        return action;
    }

}
