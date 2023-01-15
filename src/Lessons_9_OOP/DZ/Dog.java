package Lessons_9_OOP.DZ;

public class Dog {
    String nickname;
    String breed;
    int speed;

    void run() {
        String result = "";
        for (int i = 0; i < speed; i++) {
            result += "бегу";

            //Проверяем последнее ли это слово "бегу" - если последнее, то ставим точку, если нет, то ставим запятую и пробел
            if (i == speed - 1) {
                result += ".";
            } else {
                result += ", ";
            }
        }
        System.out.println(result);
    }

    String info() {
        return "Кличка собаки - " + nickname +
                "\nПорода собаки - " + breed +
                "\nСкорость собаки - " + speed + " км/ч";
    }
}
