package Elements;

import Pattern.Command.Command;
import Pattern.Command.TouchedElement;
import Pattern.Composite.Component;
import Pattern.VisitorGame.AcceptVisitor;
import Pattern.VisitorGame.Visitor;

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
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getElementPoints() {
        return rampPoints;
    }

}
