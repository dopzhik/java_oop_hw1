import java.io.IOException;
import model.FamilyTree;
import model.Person;
import service.WriteReadFileClass;

public class Main {

    public static void printFamily(FamilyTree family) {
        for (Person p : family) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        FamilyTree ft = new FamilyTree();
        String filename = "file.data";

        
        Person ruslan = new Person("Руслан", 60, 'm');
        Person luda = new Person("Людмила", 58, 'f');
        Person ivan = new Person("Иван", 30, 'm');
        Person olya = new Person("Ольга", 28, 'f');
        Person sergey = new Person("Сергей", 6, 'm');
        Person boris = new Person("Борис", 4, 'm');
        Person andrey = new Person("Андрей", 11, 'm');
        Person maria = new Person("Мария", 10, 'f');
        Person karina = new Person("Карина", 12, 'f');
        Person larisa = new Person("Лариса", 2, 'f');

        ft.addPerson(ivan);
        ft.addPerson(olya);
        ft.addPerson(sergey);
        ft.addPerson(boris);
        ft.addPerson(andrey);
        ft.addPerson(maria);
        ft.addPerson(karina);
        ft.addPerson(larisa);

        ruslan.setSpouse(luda);
        ivan.setParent(ruslan);
        ivan.setSpouse(olya);
        sergey.setParent(ivan);
        boris.setParent(ivan);
        maria.setParent(olya);
        karina.setParent(ivan);
        andrey.setParent(ivan);
        larisa.setParent(ivan);

        // System.out.println(persons);

        // System.out.println(ft.showFamilyTree(boris));
        // System.out.println(ft.showFamilyTree(karina));
        // System.out.println(ft.showFamilyTree(ivan));

        WriteReadFileClass wrf = new WriteReadFileClass();

        try {
            wrf.saveToFile(ft, filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FamilyTree family = new FamilyTree();

        try {
            family = wrf.loadFromFile(filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    

        printFamily(family);

        family.sortByName();
        System.out.println("");

        printFamily(family);

        family.sortByAge();

        System.out.println();

        printFamily(family);



        // for (Person np : newpersons) {
        //     System.out.println(np);
        // }
    }
}
