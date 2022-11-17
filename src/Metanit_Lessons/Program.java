package Metanit_Lessons;

public class Program {
    public static void main(String[] args) {
        /*
        Person tom = new Person("Tom");
        tom.display();
        Employee sam = new Employee("Sam");
        sam.display();
        */

        Employee sam = new Employee("Sam", "Microsoft");
        sam.display();  // Sam
        sam.work();     // Sam works in Microsoft
    }
}
