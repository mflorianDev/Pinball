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
    private final TouchedElement points;

    public Ramp() {
        this.points = new TouchedElement();
    }

    @Override
    public void execute() {
        points.printTouchedElement(rampPoints, "Ramp");
    }

    @Override
    public void printBoardElements() {
        System.out.print("Ramp");
    }
}
