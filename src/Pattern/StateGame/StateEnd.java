package Pattern.StateGame;

import Pattern.VisitorGame.AcceptVisitor;
import Pattern.VisitorGame.StateVisit;

public class StateEnd implements StatelikeGame, AcceptVisitor {
    private Float credit = null;

    public StateEnd(Float credit) {
        this.credit = credit;
    }

    @Override
    public void increaseCredit(StateContextGame STATE_CONTEXT, Float INSERT) {
        credit += INSERT;
        System.out.println("Credit increased. Game Continues!");
    }

    @Override
    public void play(StateContextGame STATE_CONTEXT) {
        // Will never be called! No usability!
    }

    @Override
    public void ballLoss(StateContextGame STATE_CONTEXT) {
        if (credit >= 1) {
            System.out.println("GAME OVER! Switch to Ready to Play!");
            STATE_CONTEXT.setState(new StateReady(credit));
        } else {
            System.out.println("GAME OVER! Credit Used Up! Switch to NO CREDIT.");
            STATE_CONTEXT.setState(new StateNoCredit(credit));
        }
    }

    @Override
    public void win(StateContextGame STATE_CONTEXT) {
        System.out.println("WINNER! New game will be started soon!");
        STATE_CONTEXT.setState(new StatePlaying(credit));
    }

    @Override
    public void accept(StateVisit stateVisit) {
        stateVisit.visit(this);
    }

    @Override
    public int getPointsOrCredit() {
        return 0;
    }

}
