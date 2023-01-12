package PetProject_1.one;

public class Main {
    public static void main(String[] args) {
/*
        Чтобы использовать этот класс, вы можете создать новый экземпляр класса VirtualPet, например:
*/
        VirtualPet pet = new VirtualPet("Fluffy");
/*
        Затем вы можете взаимодействовать с домашним животным, вызывая его методы, например:
*/
        pet.feed();
        pet.water();
        pet.sleep();
        pet.play();
        pet.tick();
        System.out.println();
    }
}

/*
Вы можете добавить в класс дополнительную функциональность, например, добавить графический интерфейс,
отобразить статус питомца, добавить параметры меню и т. д.
*/
