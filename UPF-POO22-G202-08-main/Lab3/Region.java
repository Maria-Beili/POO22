import java.util.LinkedList;

public class Region {
    
    //Atributs
    private String name;
    private LinkedList<City> citiesList;
    
    //Constructor
    public Region(String n){
        name = n;
        citiesList = new LinkedList<City>();
    }

    //Mètodes
    public void setCities(LinkedList<City> c){
        citiesList = c;
    }

    public LinkedList<City> getCities(){
        return citiesList;
    }

    public void printRegion(){
        System.out.println("\nRegion:" + name);
        for (int i=0; i<citiesList.size(); i++){
            citiesList.get(i).printCity();
        }
    }
}
