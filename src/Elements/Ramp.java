package Elements;

//Konkreter Befehl

//Rampe
//Target
//CommandBumper

import Pattern.Command.Command;
import Pattern.Command.TouchedElement;
import Pattern.Composite.Component;
import Pattern.VisitorGame.AcceptVisitor;
import Pattern.VisitorGame.StateVisit;

public class Ramp extends Command implements Component, AcceptVisitor {

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

    @Override
    public void accept(StateVisit stateVisit) {
        stateVisit.visit(this);
    }

    @Override
    public int getPointsOrCredit() {
        return this.rampPoints;
    }

    @Override
    public int getPoints() {
        return rampPoints;
    }
}
