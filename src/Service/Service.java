package Service;

import FamilyTree.FamilyTree;
import Human.Human;
import Human.HumanComparatorById;
import Human.HumanComparatorByName;
import Human.HumanComparatorByBirthDate;
import FileOperations.InOutTxt;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class Service {
    private int id;
    private FamilyTree familyTree;

    public Service(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void addHuman(String status, String name, String surname, LocalDate birthDate, Human mother, Human father) {
        familyTree.addKin(new Human(id++, status, name, surname, birthDate, mother, father));
    }

    public void addHuman(String status, String name, String surname, LocalDate birthDate) {
        familyTree.addKin(new Human(id++, status, name, surname, birthDate));
    }

    public void sortByName() {
        familyTree.getFamilyTree().sort(new HumanComparatorByName());
    }

    public void sortByID() {
        familyTree.getFamilyTree().sort(new HumanComparatorById());
    }

    public void sortByBirthDate() {
        familyTree.getFamilyTree().sort(new HumanComparatorByBirthDate());
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }

    public void saveTree() throws IOException {
        InOutTxt copy = new InOutTxt();
        copy.saveData(familyTree, "tree");
    }

    public void loadTree() throws IOException, ClassNotFoundException {
        InOutTxt copy = new InOutTxt();
        FamilyTree tree = (FamilyTree) copy.loadData("tree");


    }
}