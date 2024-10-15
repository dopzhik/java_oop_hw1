
import java.io.Serializable;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Person implements Serializable{
    private final long serialVersionUID = 1L;
    public String name;
    private int age;
    private char sex;
    public Person mother;
    public Person father;
    HashSet<Person> suns = new HashSet<>();
    HashSet<Person> daughters = new HashSet<>();
    public Person spouse;
    public String sisters;
    public String brothers; 

    public Person(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpouce() {
        if (this.spouse == null) {
            return "нет супруга";
        }
        return spouse.name;
    }

    public String getMother() {
        if (this.mother == null) {
            return "нет матери";
        }
        return mother.name;
    }

    public String getFather() {
        if (this.father == null) {
            return "нет отца";
        }
        return father.name;
    }

    public String getSuns() {
        if (this.suns.isEmpty()) {
            return "нет сыновей";
        }
        String s = this.suns.stream().map(x -> x.name).collect(Collectors.joining(", "));
        return s;
    }

    public String getDaughters() {
        if (this.daughters.isEmpty()) {
            return "нет дочерей";
        }
        return this.daughters.stream().map(x -> x.name).collect(Collectors.joining(", "));
    }

    public String getBrothers() {
        if (this.father == null) {
            return "";
        }
        brothers = father.suns.stream().map(x -> x.name).filter(x -> !x.equals(this.name))
                .collect(Collectors.joining(", "));
        if (brothers.isEmpty()) {
            return "";
        }
        return brothers;

    }

    public String getSisters() {
        if (this.father == null) {
            return "";
        }
        sisters = father.daughters.stream().map(x -> x.name).filter(x -> !x.equals(this.name))
                .collect(Collectors.joining(", "));
        if (sisters.isEmpty()) {
            return "";
        }
        return sisters;

    }

    public void setSpouse(Person person) {
        this.spouse = person;
        person.spouse = this;
    }

    public void setParent(Person parent) {
        if (parent.sex == 'm') {
            this.father = parent;
            this.mother = parent.spouse;
            // this.sisters.addAll(parent.daughters);
            // this.brothers.addAll(parent.suns);
        } else {
            this.mother = parent;
            this.father = parent.spouse;
            // this.sisters.addAll(parent.daughters);
            // this.brothers.addAll(parent.suns);
        }
        if (this.sex == 'm') {
            parent.suns.add(this);
            parent.spouse.suns.add(this);
        } else {
            parent.daughters.add(this);
            parent.spouse.daughters.add(this);
        }
    }

    @Override
    public String toString() {
        return "Имя = " + name + ", Возраст = " + age + ", Пол = " + sex;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        result = prime * result + sex;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        if (sex != other.sex)
            return false;
        return true;
    }
}
