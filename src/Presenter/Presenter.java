package Presenter;

import FamilyTree.FamilyTree;
import Human.Human;
import Service.Service;
import UI.View;

import java.io.IOException;
import java.time.LocalDate;

public class Presenter {
    private Service service;
    private View view;

    public Presenter(Service service, View view) {
        this.service = service;
        this.view = view;
        view.setPresenter(this);
    }

    public FamilyTree getFamilyTree(){
        return service.getFamilyTree();

    }

    public void addHuman(String status, String name, String surname, LocalDate birthDate, Human mother, Human father) {
        service.addHuman(status, name, surname, birthDate, mother, father);
    }

    public void saveChanges() throws IOException {
        service.saveTree();
    }


}
