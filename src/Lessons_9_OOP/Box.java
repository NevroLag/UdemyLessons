package Lessons_9_OOP;

public class Box {
    double width;
    double height;
    double length;

    void showVolume() {
        double volume = width * height * length;
        System.out.println(volume);
    }

    double volume() {
        return width * height * length;
    }
}
