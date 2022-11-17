package Metanit_Lessons;

public class Employee extends Person {
    /*
    public Employee(String name) {
        super(name);
    */
    // если базовый класс определяет конструктор
    // то производный класс должен его вызвать


    //---------------------------------------------
    String company;

    public Employee(String name, String company) {

        super(name);
        this.company = company;
    }

    @Override
    public void display() {

        super.display();
        System.out.printf("Works in %s \n", company);
        /*
        System.out.printf("Name: %s \n", getName());
        System.out.printf("Works in %s \n", company);
        */
        System.out.println();
    }

    public void work() {
        System.out.printf("%s works in %s \n", getName(), company);
    }
}

