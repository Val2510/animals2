import java.time.LocalDate;
import java.util.ArrayList;

abstract class Animal {
    private String name;
    private String type;
    private LocalDate birthDate;
    private ArrayList<String> commands;

    public Animal(String name, String type, LocalDate birthDate, ArrayList<String> commands) {
        this.name = name;
        this.type = type;
        this.birthDate = birthDate;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }
}
