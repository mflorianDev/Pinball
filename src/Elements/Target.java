package Elements;

import Pattern.Command.Command;
import Pattern.Command.TouchedElement;
import Pattern.Composite.Component;
import Pattern.VisitorGame.AcceptVisitor;
import Pattern.VisitorGame.Visitor;

public class Target extends Command implements Component, AcceptVisitor {

    private int targetPointsMain = 500;
    private int targetPointsRamp = 250;
    private final TouchedElement touchedElement;
    private final boolean isInMainboard;

    public Target(boolean isInMainboard) {
        this.touchedElement = new TouchedElement();
        this.isInMainboard = isInMainboard;
    }

    @Override
    public void execute() {
        if(isInMainboard){
            touchedElement.printTouchedElement(targetPointsMain, "Target");
        }
        else {
            touchedElement.printTouchedElement(targetPointsRamp, "Target in a Ramp");
        }
    }
    @Override
    public void printBoardElements() {
        System.out.print("Target");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getElementPoints() {
        if (isInMainboard) {
            return targetPointsMain;
        } else {
            return targetPointsRamp;
        }
    }
}

