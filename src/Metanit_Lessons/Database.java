package Metanit_Lessons;

import java.util.ArrayList;

public class Database {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> ages = new ArrayList<>();

        names.add("Alice");
        ages.add(25);
        names.add("Bob");
        ages.add(30);
        names.add("Charlie");
        ages.add(35);
        // Add 17 more entries to the database

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + " is " + ages.get(i) + " years old.");
        }
    }
}

