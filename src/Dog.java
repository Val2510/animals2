import java.time.LocalDate;
import java.util.ArrayList;

class Dog extends Pets {
    public Dog(String name, String type, LocalDate birthDate, ArrayList<String> commands) {
        super(name, type, birthDate, commands);
    }
}
