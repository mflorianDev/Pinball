package Elements;

import Pattern.Command.Command;
import Pattern.Command.TouchedElement;
import Pattern.Composite.Component;
import Pattern.VisitorGame.AcceptVisitor;
import Pattern.VisitorGame.Visitor;

public class Bumper extends Command implements Component, AcceptVisitor {

    private int bumperPointsMain = 200;
    private int bumperPointsRamp = 100;
    private final TouchedElement touchedElement;
    private final boolean isInMainboard;

    public Bumper(boolean isInMainboard) {
        this.touchedElement = new TouchedElement();
        this.isInMainboard = isInMainboard;
    }

    @Override
    public void execute() {
        if(isInMainboard){
            touchedElement.printTouchedElement(bumperPointsMain, "Bumper");
        }
        else{
            touchedElement.printTouchedElement(bumperPointsRamp, "Bumper in a Ramp");
        }
    }
    @Override
    public void printBoardElements() {
        System.out.print("Bumper");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int getPoints() {
        if(isInMainboard){
            return bumperPointsMain;
        }
        else{
            return bumperPointsRamp;
        }
    }
}
