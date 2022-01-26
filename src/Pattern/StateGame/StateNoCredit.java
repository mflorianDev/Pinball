package Pattern.StateGame;

public class StateNoCredit implements StatelikeGame {
    private float credit = 0;

    public StateNoCredit(Float credit) {
        this.credit = credit;
    }

    @Override
    public void increaseCredit(final StateContextGame STATE_CONTEXT, final float INSERT) {
        credit += INSERT;
        if (credit == 0) {
            System.out.println("Insert a coin to start a new game!");
        } else if (credit < 1) {
            System.out.println("Not enough credit to start a new game! Please insert more coins.");
        } else {
            System.out.println("Ready to Play! Press 'p' to start a new game.");
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
