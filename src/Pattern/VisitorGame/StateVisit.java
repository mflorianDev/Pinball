package Pattern.VisitorGame;

import Pattern.StateGame.StateEnd;
import Pattern.StateGame.StateNoCredit;
import Pattern.StateGame.StatePlaying;
import Pattern.StateGame.StateReady;

public interface StateVisit {

    public void visit(StateNoCredit stateNoCredit);
    public void visit(StateReady stateReady);
    public void visit(StatePlaying statePlaying);
    public void visit(StateEnd stateEnd);
}
