package Pattern.StateGame;

import Pattern.VisitorGame.AcceptVisitor;
import Pattern.VisitorGame.StateVisit;

public class StateNoCredit implements StatelikeGame {
    private Float credit = null;

    public StateNoCredit(Float credit) {
        this.credit = credit;
    }

    @Override
    public void increaseCredit(final StateContextGame STATE_CONTEXT, final Float INSERT) {
        if (INSERT > 0) {
            credit += INSERT;
        } else {
            System.out.println("Inserted coin value must be greater than 0!");
            return;
        }
        credit += INSERT;
        if (credit == 0) {
            System.out.println("Press 'i' to insert some coins and to start a new game!");
        } else if (credit < 1) {
            System.out.println("Not enough credit to start a new game!\n" +
                    "Press 'i' to insert some coins.");
        } else {
            System.out.println("Ready to Play!\n" +
                    "Press 'p' to start a new game.");
            STATE_CONTEXT.setState(new StateReady(credit));
        }
    }

    @Override
    public void play(StateContextGame STATE_CONTEXT) {
        // Will never be called! No usability!
    }

    @Override
    public void ballLoss(StateContextGame STATE_CONTEXT) {
        // Will never be called! No usability!
    }

    @Override
    public void win(StateContextGame STATE_CONTEXT) {
        // Will never be called! No usability!
    }

}
