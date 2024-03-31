import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnimalRegistry animalRegistry = new AnimalRegistry();

        boolean exit = false;
        while (!exit) {
            System.out.println("Animal Registry Menu:");
            System.out.println("1. Add Animal");
            System.out.println("2. Add Command to Animal");
            System.out.println("3. Print Animals by Birth Date");
            System.out.println("4. Count Animals");
            System.out.println("5. Print Commands by Animal Name");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addAnimal(scanner, animalRegistry);
                    break;
                case 2:
                    addCommand(scanner, animalRegistry);
                    break;
                case 3:
                    animalRegistry.printAnimalsByBirthDate();
                    break;
                case 4:
                    System.out.println("Number of animals in the registry: " + animalRegistry.countAnimals());
                    break;
                case 5:
                    System.out.print("Enter animal name: ");
                    String name = scanner.nextLine();
                    animalRegistry.printCommandsByName(name);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
        System.out.println("Exiting Animal Registry. Goodbye!");
    }

    private static void addAnimal(Scanner scanner, AnimalRegistry animalRegistry) {
        System.out.print("Enter animal type (dog, cat, hamster, donkey, camel, horse): ");
        String type = scanner.nextLine();
        System.out.print("Enter animal name: ");
        String name = scanner.nextLine();
        System.out.print("Enter animal birth date (YYYY-MM-DD): ");
        String dateString = scanner.nextLine();
        LocalDate birthDate = parseDate(dateString);

        if (birthDate != null) {
            ArrayList<String> commands = new ArrayList<>();
            System.out.print("Enter number of commands for the animal: ");
            int numCommands = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            for (int i = 0; i < numCommands; i++) {
                System.out.print("Enter command " + (i + 1) + ": ");
                String command = scanner.nextLine();
                commands.add(command);
            }

            Animal animal = AnimalFactory.createAnimal(type, name, birthDate, commands);
            animalRegistry.addAnimal(animal);
            System.out.println("Animal added to the registry.");
        }
    }

    private static void addCommand(Scanner scanner, AnimalRegistry animalRegistry) {
        System.out.print("Enter animal name: ");
        String name = scanner.nextLine();
        System.out.print("Enter command to add: ");
        String command = scanner.nextLine();
        animalRegistry.addCommandByName(name, command);
    }

    private static LocalDate parseDate(String dateString) {
        try {
            return LocalDate.parse(dateString);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD format.");
            return null;
        }
    }
}

