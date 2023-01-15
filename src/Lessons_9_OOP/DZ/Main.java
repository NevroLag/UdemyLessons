package Lessons_9_OOP.DZ;
/*
Создать класс Dog (собака), в котором будет 3 поля: String кличка, String порода, int скорость.
Создать внутри класса два метода:
Метод run (бежать) - без параметров, тип void.
При вызове данного метода на экране выводиться строка "бегу, бегу, бегу ..." слово "бегу" должно вывестись столько раз,
сколько указано в переменной скорость.
Второй метод String info(); - возвращает строку с полной информацией о собаке (кличка, порода, скорость), этот метод
ничего не выводит на экран.
В классе Main продемонстрировать работу данных методов.
*/
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.nickname = "Bob";
        dog.breed = "Mops";
        dog.speed = 3;
        dog.run();
        /*String info = dog.info();
        System.out.println(info);*/
        System.out.println(dog.info());
    }
}
