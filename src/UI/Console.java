package UI;

import FamilyTree.FamilyTree;
import Human.Human;
import Presenter.Presenter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private Menu menu;
    private FamilyTree<Human> tree;

    public Console(FamilyTree<Human> tree) {
        this.scanner = new Scanner(System.in);
        this.work = true;
        this.menu = new Menu(this);
        this.tree = tree;
    }

    @Override
    public void print(String text) {
        System.out.println(text);

    }

    @Override
    public void start() {
        while (work) {
            System.out.println(menu.print());
            String choice = scanner.nextLine();
            if (check(choice)) {
                menu.execute(Integer.parseInt(choice));
            } else {
                fail();
            }

        }
    }

    private boolean check(String text) {
        return text.matches("[0-9]+") && Integer.parseInt(text) <= menu.getSize() && Integer.parseInt(text) > 0;
    }

    public void fail() {
        System.out.println("Ошибка ввода!");
    }

    public void finish() {
        System.out.println("Работа программы завершена");
        work = false;
    }

    public void addHuman() {
        System.out.println("Введите статус: ");
        String status = scanner.nextLine();
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию: ");
        String surname = scanner.nextLine();
        System.out.println("Введите дату рождения в формате ГГГГ ММ ДД: ");
        String[] date = scanner.nextLine().split(" ");
        LocalDate birthDate = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]),
                Integer.parseInt(date[2]));
        System.out.println("Введите имя матери: ");
        String motherName = scanner.nextLine();
        System.out.println("Введите фамилию матери: ");
        String motherSurname = scanner.nextLine();
        Human mother = null;
        if ((motherName != null) && (motherSurname != null)) mother = tree.getHuman(motherName, motherSurname);
        System.out.println("Введите имя отца: ");
        String fatherName = scanner.nextLine();
        System.out.println("Введите фамилию отца: ");
        String fatherSurname = scanner.nextLine();
        Human father = null;
        if ((fatherName != null) && (fatherSurname != null)) father = tree.getHuman(fatherName, fatherSurname);
        presenter.addHuman(status, name, surname, birthDate, mother, father);
    }

    public void getFamilyTree() {
        System.out.println(presenter.getFamilyTree());
    }

    public void saveChanges() throws IOException {
        presenter.saveChanges();
    }


    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;

    }
}
