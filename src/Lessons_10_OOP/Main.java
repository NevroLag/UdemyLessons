package Lessons_10_OOP;

public class Main {
    /*
    Лекция 13. Параметризированные методы
    */
    public static void main(String[] args) {
        /*Test test = new Test();
        int square = test.square(80);
        double sqrt = Math.sqrt(36);
        System.out.println(square);*/
        Box box = new Box();
        box.setDimens(15, 15, 15);
        System.out.println(box.volume());
    }
}
