package PetProject_1.one;

public class Main {
    public static void main(String[] args) {
        VirtualPet pet = new VirtualPet("Fluffy");
        pet.feed();
        pet.water();
        pet.sleep();
        pet.play();
        System.out.println();
    }
}