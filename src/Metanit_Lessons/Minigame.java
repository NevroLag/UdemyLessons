package Metanit_Lessons;

import java.util.Scanner;

public class Minigame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        while (true) {
            int num1 = (int) (Math.random() * 10);
            int num2 = (int) (Math.random() * 10);
            int correctAnswer = num1 + num2;

            System.out.println("What is " + num1 + " + " + num2 + "?");
            int answer = scanner.nextInt();

            if (answer == correctAnswer) {
                score++;
                System.out.println("Correct! Your score is now " + score + ".");
            } else {
                System.out.println("Incorrect. The correct answer was " + correctAnswer + ".");
                break;
            }
        }
    }
}

