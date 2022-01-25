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

    // Visit game states
    public void visit(StateNoCredit stateNoCredit);
    public void visit(StateReady stateReady);
    public void visit(StatePlaying statePlaying);
    public void visit(StateEnd stateEnd);



    // Visit game components
    public int visit(Bumper bumper);
    public int visit(Target target);
    public int visit(Ramp ramp);

}
