package Lessons_10_OOP.DZ;

public class Rect {
    double length;
    double width;

    void setDimens(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double perimeter() {
        return (length + width) * 2;
    }

    double area() {
        return length * width;
    }
}
