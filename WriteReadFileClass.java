import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;


public class WriteReadFileClass implements WriteReadFile {

    @Override
    public void saveToFile(HashSet<Person> persons, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(persons);
        }
        

    }

    @Override
    public HashSet<Person> loadFromFile(String filename) throws  IOException, ClassNotFoundException {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (HashSet<Person>) ois.readObject();
        }
    }

}
