package Pattern.StateGame;


public class StateReady implements StatelikeGame {
    private float credit = 0;

    public StateReady(Float credit) {
        this.credit = credit;
    }

    @Override
    public void increaseCredit(final StateContextGame STATE_CONTEXT, final float INSERT) {
        credit += INSERT;
        System.out.println("Credit increased. Push play to start a new game!");
        STATE_CONTEXT.setState(new StateReady(credit));
    }

    @Override
    public void play(StateContextGame STATE_CONTEXT) {
        credit--;
        System.out.println("Game Started. Press 's' to operate the plunger to initialize the ball");
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
