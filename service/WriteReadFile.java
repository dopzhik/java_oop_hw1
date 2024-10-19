package service;
import java.io.IOException;
import java.util.HashSet;

import model.FamilyTree;

public interface WriteReadFile {
    public void saveToFile(FamilyTree ft, String filename) throws IOException;

    public FamilyTree loadFromFile(String filename) throws IOException, ClassNotFoundException;
}


