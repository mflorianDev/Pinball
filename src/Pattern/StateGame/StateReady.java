package Pattern.StateGame;


public class StateReady implements StatelikeGame {
    private float credit = 0;

    public StateReady(Float credit) {
        this.credit = credit;
    }

    @Override
    public void increaseCredit(final StateContextGame STATE_CONTEXT, final float INSERT) {
        if (INSERT > 0) {
            credit += INSERT;
        } else {
            System.out.println("Inserted coin value must be greater than 0!");
            return;
        }
        System.out.println("Credit increased. Press 'p' to start a new game!");
        STATE_CONTEXT.setState(new StateReady(credit));
    }

    @Override
    public void play(StateContextGame STATE_CONTEXT) {
        credit--;
        System.out.println("Game Started.\n" +
                "Press 's' to operate the plunger to initialize the ball");
        STATE_CONTEXT.setState(new StatePlaying(credit));
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
