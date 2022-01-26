package Pattern.VisitorGame;

import Elements.Bumper;
import Elements.Ramp;
import Elements.Target;

public class ElementVisitor implements Visitor {

    private int elementPoints;

    public int getElementPoints() {
        return elementPoints;
    }

    @Override
    public void visit(Bumper bumper) {
        this.elementPoints = bumper.getPoints();
    }

    @Override
    public void visit(Target target) {
        this.elementPoints = target.getPoints();
    }

    @Override
    public void visit(Ramp ramp) {
        this.elementPoints = ramp.getPoints();
    }
}
