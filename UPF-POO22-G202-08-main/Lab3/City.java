import java.util.LinkedList;

public class City {
    
    //Atributs
    private String name;
    private Integer population;
    private LinkedList<Headquarter> hqsList;

    //Constructor
    public City(String n, int p) {
        name = n;
        population = p;
        hqsList = new LinkedList<Headquarter>();
    }

    //Mètodes
    public void addHQ(Headquarter h){
        hqsList.add(h);
    }

    public void printCity(){
        System.out.print("      City name:" + name + "\n");
        System.out.print("      Population:" + population + "\n");
        System.out.print("      Headquarters:");
        for (int i=0; i<hqsList.size(); i++){
            hqsList.get(i).printHeadquarter();
        }
        System.out.print("\n");
    }

    public String toString(){
        return name;
    }

}
