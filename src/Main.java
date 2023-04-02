import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        tree.addKin(new Human("мать матери ego", "Галина", "Бородихина", LocalDate.of(1932, 1, 23)));
        tree.addKin(new Human("отец матери ego", "Николай", "Мягков", LocalDate.of(1932, 12, 23)));
        tree.addKin(new Human("сын матери матери ego: ", "Юрий", "Мягков", LocalDate.of(1954, 05, 8), tree.getHuman("Галина", "Бородихина"), tree.getHuman("Николай", "Мягков")));
        tree.addKin(new Human("мать  ego", "Татьяна", "Мягкова", LocalDate.of(1958, 5, 16), tree.getHuman("Галина", "Бородихина"), tree.getHuman("Николай", "Мягков")));
        tree.addKin(new Human("дочь матери матери ego: ", "Марина", "Мягкова", LocalDate.of(1964, 8, 5), tree.getHuman("Галина", "Бородихина"), tree.getHuman("Николай", "Мягков")));
        tree.addKin(new Human("ego", "Денис", "Мягков", LocalDate.of(1984, 1, 22), tree.getHuman("Татьяна", "Мягкова"), null));
        tree.addKin(new Human("дочь сына матери матери ego", "Наталья", "Мягкова", LocalDate.of(1978, 9, 23), null, tree.getHuman("Юрий", "Мягков")));
        tree.addKin(new Human("дочь сына матери матери ego", "Лариса", "Мягкова", LocalDate.of(1983, 8, 7), null, tree.getHuman("Юрий", "Мягков")));
        tree.addKin(new Human("дочь дочери матери матери ego", "Юлия", "Констман", LocalDate.of(1988, 4, 12), tree.getHuman("Марина", "Мягкова"), null));
        tree.addKin(new Human("сын ego", "Матвей", "Мягков", LocalDate.of(2021, 10, 5)));

        //Human h1 = new Human("ego", "Денис", "Мягков", LocalDate.of(1984, 1, 22));
        //Human h2 = new Human("мать  ego", "Татьяна", "Мягкова", LocalDate.of(1958, 5, 16));
        //Human h3 = new Human("мать матери ego", "Галина", "Бородихина", LocalDate.of(1932, 1, 23));
        //Human h4 = new Human("отец матери ego", "Николай", "Мягков", LocalDate.of(1932, 12, 23));
        //Human h5 = new Human("сын матери матери ego: ", "Юрий", "Мягков", LocalDate.of(1954, 05, 8));
        //Human h6 = new Human("дочь матери матери ego: ", "Марина", "Мягкова", LocalDate.of(1964, 8, 5), tree.getHuman("Галина", "Бородихина"), tree.getHuman("Николай", "Мягков"));
        //Human h7 = new Human("сын ego", "Матвей", "Мягков", LocalDate.of(2021, 10, 5));
        //Human h8 = new Human("дочь сына матери матери ego", "Наталья", "Мягкова", LocalDate.of(1978, 9, 23));
        //Human h9 = new Human("дочь сына матери матери ego", "Лариса", "Мягкова", LocalDate.of(1983, 8, 7));
        //Human h10 = new Human("дочь дочери матери матери ego", "Юлия", "Констман", LocalDate.of(1988, 4, 12));

        /*h1.setMother(tree.getHuman());
        h2.setMother(h3);
        h2.setFather(h4);
        h5.setMother(h3);
        h5.setFather(h4);
        h6.setMother(h3);
        h6.setFather(h4);
        h7.setFather(h1);
        h8.setFather(h5);
        h9.setFather(h5);
        h10.setMother(h6);

        FamilyTree tree = new FamilyTree();
        tree.addKin(h1);
        tree.addKin(h2);
        tree.addKin(h3);
        tree.addKin(h4);
        tree.addKin(h5);
        tree.addKin(h6);
        tree.addKin(h7);
        tree.addKin(h8);
        tree.addKin(h9);
        tree.addKin(h10);*/

        // System.out.println(genTree);

        //h3.addAllChildren(tree);
        //h5.addAllChildren(tree);
        //System.out.println(h3.getChildren());
        //System.out.println(h5.getChildren());

        //System.out.println(tree.getOldest());
        //System.out.println(tree.getYoungest());
        //System.out.println(tree.getHuman("Денис", "Мягков"));
        System.out.println(tree.getHuman("сын ego"));
        System.out.println(tree.getChildren("Галина", "Бородихина"));


    }
}