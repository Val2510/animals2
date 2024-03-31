import java.time.LocalDate;
import java.util.ArrayList;

class AnimalFactory {
    public static Animal createAnimal(String type, String name, LocalDate birthDate, ArrayList<String> commands) {
        switch (type.toLowerCase()) {
            case "dog":
                return new Dog(name, type, birthDate, commands);
            case "cat":
                return new Cat(name, type, birthDate, commands);
            case "hamster":
                return new Hamster(name, type, birthDate, commands);
            case "donkey":
                return new Donkey(name, type, birthDate, commands);
            case "camel":
                return new Camel(name, type, birthDate, commands);
            case "horse":
                return new Horse(name, type, birthDate, commands);
            default:
                throw new IllegalArgumentException("Unknown animal type: " + type);
        }
    }
}
