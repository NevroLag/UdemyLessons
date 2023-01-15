package Lessons_8_OOP;

public class Main {
    public static void main(String[] args) {
        Box myBox = new Box();
        myBox.height = 10.2;
        myBox.length = 15;
        myBox.width = 11.3;
        Box box2 = new Box();
        box2.height = 5;
        box2.length = 5;
        box2.width = 5;
        Box box3 = new Box();
        box3.height = 10;
        box3.length = 10;
        box3.width = 10;
        double volume = myBox.height * myBox.length * myBox.width;
        double volume2 = box2.height * box2.length * box2.width;
        double volume3 = box3.height * box3.length * box3.width;
        System.out.println("Коробка 1 = " + volume +
                "\nКоробка 2 = " + volume2 +
                "\nКоробка 3 = " + volume3);
    }
}
