import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        FamilyTree ft = new FamilyTree();

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

        System.out.println(ft.showFamilyTree(boris));

    }
}
