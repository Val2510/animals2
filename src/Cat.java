import java.time.LocalDate;
import java.util.ArrayList;

class Cat extends Pets {
    public Cat(String name, String type, LocalDate birthDate, ArrayList<String> commands) {
        super(name, type, birthDate, commands);
    }
}
