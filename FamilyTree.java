
import java.io.Serializable;
import java.util.HashSet;
import java.util.stream.Collectors;

public class FamilyTree implements Serializable {
    private final long serialVersionUID = 1L;
    
    public String getChildren(Person person){        
        HashSet<Person> children = new HashSet<>();
        children.addAll(person.suns);
        children.addAll(person.daughters);
        if (children.isEmpty()) {
            return "нет детей";
        }
        return children.stream().map(x -> x.name).collect(Collectors.joining(", "));
        
    }

    public String findPersonByName(HashSet<Person> persons, String name) {
        String p = "";
        for (Person person : persons) {
            if (person.name.equalsIgnoreCase(name)) {
                p = person.toString();
            }
        }
        if (p.isEmpty()) {
            return "не найдено";
        }
        return p;
    }

    public String showFamilyTree(Person person){
        StringBuilder sb = new StringBuilder();
        sb.append("Меня зовут ").append(person.name).append(". ");
        if (person.suns != null || person.daughters != null) {
            sb.append("У меня есть дети: ").append(person.getSuns()).append(", ").append(person.getDaughters()).append(". ");
        }
        if (person.father != null) {
            sb.append("Мои родители ").append(person.father.name).append(" и ").append(person.mother.name).append(". ");
        }
        if (!(person.getBrothers()  + person.getSisters()).isEmpty()) {
            sb.append("У меня есть братья и сестры: ").append(person.getBrothers()).append(", ").append(person.getSisters()).append(". ");
        }
        if (person.father.father != null) {
            sb.append("У меня есть дедушка и бабушка ").append(person.father.father.name).append(" и ").append(person.father.mother.name).append(". ");
        }
        
        return sb.toString();
    }


}
