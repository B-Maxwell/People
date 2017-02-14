
public class Main {

    public static void main(String[] args) throws Exception {

        PeopleProcessor processor = new PeopleProcessor();

        processor.loadFile();
        processor.loadHashMap();
        processor.sortHashMap();
        processor.displayHashMap();
        processor.createPeopleJsonFile();
    }
}

