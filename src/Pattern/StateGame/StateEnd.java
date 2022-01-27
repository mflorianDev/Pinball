package Pattern.StateGame;

import Pattern.VisitorGame.AcceptVisitor;
import Pattern.VisitorGame.StateVisit;

public class StateEnd implements StatelikeGame {
    private Float credit = null;

    public StateEnd(Float credit) {
        this.credit = credit;
    }

    @Override
    public void increaseCredit(StateContextGame STATE_CONTEXT, Float INSERT) {
        if (INSERT > 0) {
            credit += INSERT;
        } else {
            System.out.println("Inserted coin value must be greater than 0!");
            return;
        }
        System.out.println("Credit increased. Game Continues!");
    }

    @Override
    public void play(StateContextGame STATE_CONTEXT) {
        // Will never be called! No usability!
    }

    @Override
    public void ballLoss(StateContextGame STATE_CONTEXT) {
        if (credit >= 1) {
            System.out.println("***** GAME OVER! *****\n" +
                    "Remaining Credit: " + credit +". Switch to Ready to Play!\n" +
                    "Press 'p' to start a new game!");
            STATE_CONTEXT.setState(new StateReady(credit));
        } else {
            System.out.println("***** GAME OVER! *****\n" +
                    "Credit Used Up! Switch to NO CREDIT.\n" +
                    "Press 'i' to insert some coins.");
            STATE_CONTEXT.setState(new StateNoCredit(credit));
        }
    }

    @Override
    public void win(StateContextGame STATE_CONTEXT) {
        System.out.println("***** WINNER! *****\n" +
                "New game will be started!\n" +
                "Press 's' to operate the plunger to initialize the ball");
        STATE_CONTEXT.setState(new StatePlaying(credit));
    }

}
