package Pattern.VisitorGame;

import Elements.Bumper;
import Elements.Ramp;
import Elements.Target;
import Pattern.Composite.ElementComposite;
import Pattern.StateGame.StateEnd;
import Pattern.StateGame.StateNoCredit;
import Pattern.StateGame.StatePlaying;
import Pattern.StateGame.StateReady;

public interface Visitor {

    // Visit game elements
    void visit(Bumper bumper);
    void visit(Target target);
    void visit(Ramp ramp);

}
