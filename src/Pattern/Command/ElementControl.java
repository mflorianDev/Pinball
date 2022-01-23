package Pattern.Command;

import java.util.ArrayList;
import java.util.List;

//Aufrufer
public class ElementControl {
    private List<Command> elements;

    public ElementControl() {
        elements = new ArrayList<>();
    }

    public void touchedElement(Command command) {
        elements.add(command);
        command.execute();
    }

}
