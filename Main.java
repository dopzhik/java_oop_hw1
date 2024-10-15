import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        FamilyTree ft = new FamilyTree();
        String filename = "file.data";

        HashSet<Person> persons = new HashSet<>();
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

        persons.add(ivan);
        persons.add(olya);
        persons.add(sergey);
        persons.add(boris);
        persons.add(andrey);
        persons.add(maria);
        persons.add(karina);
        persons.add(larisa);

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
            wrf.saveToFile(persons, filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HashSet<Person> newpersons = new HashSet<>();

        try {
            newpersons = wrf.loadFromFile(filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // for (Person p : persons) {
        //     System.out.println(p);
        // }

        for (Person np : newpersons) {
            System.out.println(np);
        }
    }
}
