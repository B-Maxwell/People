import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.Collections;
import jodd.json.JsonSerializer;

/**
 * Created by Ben Maxwell on 2/13/17.
 */


public class PeopleProcessor {

    ArrayList<Person> people = new ArrayList<>();
    Map<String, ArrayList<Person>> peopleHashMap = new HashMap<>();


    public void loadFile() throws Exception {
        File f = new File("people.csv");
        Scanner scanner = new Scanner(f);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] columns = line.split(",");
            Person personInfo = new Person(columns[0], columns[1], columns[2], columns[3], columns[4], columns[5]);
            people.add(personInfo);
        }
    }

    public void loadHashMap(){

        for (Person person : people){
            String country = person.country;
            ArrayList<Person> countryOfCitizen = peopleHashMap.get(country);
            if(countryOfCitizen == null){
                countryOfCitizen = new ArrayList<>();
            }
            countryOfCitizen.add(person);
            peopleHashMap.put(country, countryOfCitizen);
        }
    }

    public void sortHashMap(){
        for (ArrayList<Person> people: peopleHashMap.values()) {
            Collections.sort(people);
        }
    }

    public void displayHashMap(){
        for (Map.Entry entry : peopleHashMap.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
    }

    public void createPeopleJsonFile() throws Exception{

        File output = new File("people.json");
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.deep(true).serialize(peopleHashMap);
        FileWriter fw = new FileWriter(output);
        fw.write(json);
        fw.close();
    }
}
