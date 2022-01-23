package Pattern.Command;

import java.util.ArrayList;
import java.util.List;

//Aufrufer
public class ElementControl {
    private List<Command> commandHistory;

    public ElementControl() {
        commandHistory = new ArrayList<>();
    }

    public void touchedElement(Command command) {
        commandHistory.add(command);
        command.execute();
    }

}
