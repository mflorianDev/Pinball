package Elements;

//Konkreter Befehl

//Rampe
//Target
//CommandBumper

import Pattern.Command.Command;
import Pattern.Command.TouchedElement;
import Pattern.Composite.Component;

public class Ramp extends Command implements Component {

    private int rampPoints = 100;
    private final TouchedElement touchedElement;

    public Ramp() {
        this.touchedElement = new TouchedElement();
    }

    @Override
    public void execute() {
        touchedElement.printTouchedElement(rampPoints, "Ramp");
    }

    @Override
    public void printBoardElements() {
        System.out.print("Ramp");
    }
}
