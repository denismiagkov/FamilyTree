import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human {
    private String status;
    private String name;
    private String surname;
    private String sex;
    public LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;


    public Human(String status, String name, String surname, String sex, LocalDate birthDate, Human mother, Human father) {
        this.status = status;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.birthDate = birthDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human(String status, String name, String surname, String sex, LocalDate birthDate) {
        this(status, name, surname, sex, birthDate, null, null);
    }

    public void addChild(Human h2) {
        if (this.sex.equals("female")) {
            if (h2.getMother() != null) {
                if (this.equals(h2.getMother())) {
                    if (!this.children.contains(h2))
                        this.children.add(h2);
                }
            }
        } else if (this.sex.equals("male")) {
            if (h2.getFather() != null) {
                if (this.equals(h2.getFather())) {
                    if (!this.children.contains(h2))
                        this.children.add(h2);
                }
            }
        }
    }

    public void addAllChildren(FamilyTree obj) {
        for (Human h : obj.familyTree) {
            this.addChild(h);
        }
    }

    @Override
    public String toString() {
        return String.format("%s: " + "%s " + "%s, " + "%tF\n", status, surname, name, birthDate);
    }

    @Override
    public boolean equals(Object obj) {
        Human t = (Human) obj;
        return name == t.name && surname == t.surname && birthDate == t.birthDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, deathDate, mother, father, children);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String Status) {
        this.status = status;
    }
}
