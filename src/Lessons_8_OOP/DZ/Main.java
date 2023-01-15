package Lessons_8_OOP.DZ;

/*
Создать класс Человек, в котором будет 3 поля: имя, возраст, и вес.
В классе Main создать 5 экземпляров класса Человек, присвоить значения их полям и вывести на экран их средний возраст.
    */
public class Main {
    public static void main(String[] args) {
        Human a = new Human();
        a.name = "Petr";
        a.age = 15;
        a.weight = 37.4;
        Human b = new Human();
        b.name = "Alex";
        b.age = 23;
        b.weight = 67.2;
        Human c = new Human();
        c.name = "Kate";
        c.age = 36;
        c.weight = 87.9;
        Human d = new Human();
        d.name = "Anna";
        d.age = 72;
        d.weight = 77.6;
        Human f = new Human();
        f.name = "Nikos";
        f.age = 60;
        f.weight = 100.6;
        int averageAge = (a.age + b.age + c.age + d.age + f.age) / 5;
        System.out.println("Средний возраст участников = " + averageAge);

        // Eще один способ решения.
        Human[] men = new Human[5];
        men[0] = a;
        men[1] = b;
        men[2] = c;
        men[3] = d;
        men[4] = f;

        int sum = 0;
        for (int i = 0; i < men.length; i++) {
            sum += men[i].age;
        }
        System.out.println("Средний возраст участников = " + sum / (double) men.length);
    }
}
