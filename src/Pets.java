import java.time.LocalDate;
import java.util.ArrayList;

class Pets extends Animal {
    public Pets(String name, String type, LocalDate birthDate, ArrayList<String> commands) {
        super(name, type, birthDate, commands);
    }
}
