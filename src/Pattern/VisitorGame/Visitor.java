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

    // Visit game components
    public void visit(Bumper bumper);
    public void visit(Target target);
    public void visit(Ramp ramp);

}
