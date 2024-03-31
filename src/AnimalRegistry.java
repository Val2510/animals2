import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

class AnimalRegistry {
    private Map<String, Animal> animalMap;

    public AnimalRegistry() {
        this.animalMap = new HashMap<>();
    }

    public void addAnimal(Animal animal) {
        animalMap.put(animal.getName(), animal);
    }

    public Animal getAnimal(String name) {
        return animalMap.get(name);
    }

    public ArrayList<String> getCommandsByName(String name) {
        Animal animal = getAnimal(name);
        if (animal != null) {
            return animal.getCommands();
        } else {
            System.out.println("Animal not found in the registry.");
            return null;
        }
    }


    public void addCommandByName(String name, String command) {
        Animal animal = getAnimal(name);
        if (animal != null) {
            animal.getCommands().add(command);
            System.out.println("Command added successfully.");
        } else {
            System.out.println("Animal not found in the registry. Command not added.");
        }
    }
    public void printAnimalsByBirthDate() {
        List<Animal> animals = animalMap.values().stream()
                .sorted(Comparator.comparing(Animal::getBirthDate))
                .collect(Collectors.toList());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Animals sorted by birth date:");
        for (Animal animal : animals) {
            LocalDate birthDate = animal.getBirthDate();
            System.out.println(animal.getName() + " (" + dateFormat.format(Date.from(birthDate.atStartOfDay(ZoneId.systemDefault()).toInstant())) + ")");
        }
    }
    public int countAnimals() {
        return animalMap.size();
    }
    public void printCommandsByName(String name) {
        ArrayList<String> commands = getCommandsByName(name);
        if (commands != null) {
            System.out.println("Commands for " + name + ":");
            for (String command : commands) {
                System.out.println(command);
            }
        }
    }
}
