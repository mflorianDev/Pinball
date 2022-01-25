package Pattern.VisitorGame;

import Elements.Bumper;
import Elements.Ramp;
import Elements.Target;
import Pattern.Composite.ElementComposite;
import Pattern.StateGame.StateEnd;
import Pattern.StateGame.StateNoCredit;
import Pattern.StateGame.StatePlaying;
import Pattern.StateGame.StateReady;

public interface StateVisit {

    // Visit game components
    public int visit(Bumper bumper);
    public int visit(Target target);
    public int visit(Ramp ramp);

}
