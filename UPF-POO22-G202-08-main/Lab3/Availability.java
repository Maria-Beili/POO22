import java.util.List;

public class Availability {
    
    //Atributs
    private List<String> daysList;
    private List<Integer> hoursList;

    //Constructor
    public Availability(List<String> d, List<Integer> h){
        daysList = d;
        hoursList = h; 
    }

    public void printDays(){
        System.out.print("              Days available:" + "\n");
        System.out.print("                  ");
        for (int i=0; i<daysList.size(); i++){
            System.out.print(daysList.get(i) + ", ");
        }
        System.out.print("\n");
    }

    public void printHours(){
        System.out.print("              Hours available:" + "\n");
        System.out.print("                  ");
        for (int i=0; i<hoursList.size(); i++){
            System.out.print(hoursList.get(i) + ", ");
        }
        System.out.print("\n");
    }
}
