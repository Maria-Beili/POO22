import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class TestDelegate {
    
    static private LinkedList<Region> regionsList;
    static private Organization organization;
    static private LinkedList<Delegate> headsList;

    public static void main(String[] args){
        
        regionsList = new LinkedList<Region>();
    
        LinkedList<String[]> regions = Utility.readXML("region");
        for(String[] array: regions){
                       
            Region region = new Region(array[0]);
            LinkedList<City> cities = new LinkedList<City>();
            int length = array.length;
            int middle = (length-1)/2; //-1 perquè array[0] és la regió
            
            LinkedList<String> city_names = new LinkedList<String>();
            for (int i=1; i<(middle+1); i++){    
                String cityname = array[i];
                city_names.add(cityname);
            }

            LinkedList<Integer> city_population = new LinkedList<Integer>();
            for(int i=(middle+1); i<length; i++){
                int population = Integer.parseInt(array[i]);
                city_population.add(population);
            }

            for (int i=0; i<city_names.size(); i++){
                City city = new City(city_names.get(i), city_population.get(i));
                cities.add(city);
            }
            
            region.setCities(cities);
            regionsList.add(region);
            
        }
        
        
        organization = new Organization("UPF");
        LinkedList<City> citiesList = new LinkedList<City>();
        for (int i=0; i<regionsList.size(); i++){
            LinkedList<City> region_cities = regionsList.get(i).getCities();
            for (int j=0; j<region_cities.size(); j++){
                City city = region_cities.get(j);
                citiesList.add(city);
            }
        }
                
        LinkedList<String[]> headquarters = Utility.readXML("headquarter");
        for (String[] array: headquarters){
            Headquarter headquarter = new Headquarter(array[0], array[1], organization);
            for(int i=2; i<array.length; i++){
                City city = Utility.getObject(array[i], citiesList);
                headquarter.addCity(city);
                city.addHQ(headquarter);
            }
            
            organization.addHeadquarter(headquarter);
        }


        headsList = new LinkedList<Delegate>();

        LinkedList<String[]> heads = Utility.readXML("head");
        for (String[] array: heads){
            int phone = Integer.parseInt(array[1]);
            Headquarter headOf = Utility.getObject(array[3], organization.getHQList());
            Delegate delegate = new Delegate(array[0], phone, array[2], headOf);
            delegate.setHeadOf(headOf);
            headOf.setHead(delegate);

            String[] head_days = array[4].split("\\.");
            List<String> days = Arrays.asList(head_days);
           
            String[] head_hours = array[5].split("\\.");
            List<String> string_hours = Arrays.asList(head_hours);
            List<Integer> hours = new ArrayList<Integer>();
            for (int i=0; i<head_hours.length; i++){
                hours.add(Integer.parseInt(string_hours.get(i)));
            }

            Availability delegate_availability = new Availability(days, hours);
            delegate.setAvailability(delegate_availability);

            headsList.add(delegate);            
        }
        
        
        //Primer imprimim la organització amb els headquarters per mirar que s'ha agafat bé la informació
        organization.printOrganization();

        //Després imprimim la informació per regions. 
        for (int i=0; i<regionsList.size(); i++){
            regionsList.get(i).printRegion();
        }

        Delegate creator = Utility.getObject("Dolors Gil", headsList);
        Delegate delegate = new Delegate("Simone", 567891234, "simone@upf.edu", creator.getHeadquarter());
        Image i = creator.genDelegateQR("Simone");
        creator.singUpDelegate(delegate, i, creator.getHeadquarter());

        Regular regular = new Regular("Samantha", 567891234, "samantha@upf.edu", creator.getHeadquarter(), creator);
        Image regular_i = creator.genRegularQR("Samantha");
        creator.singUpRegular(regular, regular_i, creator.getHeadquarter());

        Date d = new Date();
        Action a = new Action("Mathematical", d, 60);
        a.addHeadquarter(creator.getHeadquarter());
        creator.getHeadquarter().singUpAction(a, 20, 4, false);
        creator.proposeAction(a);
        System.out.println(organization.getAction(d).getPurpose());
    }

}
