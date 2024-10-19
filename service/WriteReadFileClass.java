package service;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.FamilyTree;
import model.Person;


public class WriteReadFileClass implements WriteReadFile {

    @Override
    public void saveToFile(FamilyTree ft, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(ft);
        }
        

    }

    @Override
    public FamilyTree loadFromFile(String filename) throws  IOException, ClassNotFoundException {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (FamilyTree) ois.readObject();
        }
    }

}
