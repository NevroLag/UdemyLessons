package Lessons_1;

public class Days {
    public static void main(String[] args) {
        int days = 5000;
        int years = days / 365;
        int month = (days % 365) / 31;
        int leftDays = days - years * 365 - month * 31;
        System.out.println("Общее кол-во дней: " + days);
        System.out.println("Лет: " + years);
        System.out.println("Месяцев: " + month);
        System.out.println("Дней: " + leftDays);
    }
}

/*
ДЗ (Решение в следующем уроке)
Создать новый класс, в котором вы вводите количество секунд,
а программа выводит в консоль, сколько это дней, часов, минут и секунд
*/