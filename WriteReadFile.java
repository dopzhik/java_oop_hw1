import java.io.IOException;
import java.util.HashSet;

public interface WriteReadFile {
    public void saveToFile(HashSet<Person> persons, String filename) throws IOException;

    public HashSet<Person> loadFromFile(String filename) throws IOException, ClassNotFoundException;
}


