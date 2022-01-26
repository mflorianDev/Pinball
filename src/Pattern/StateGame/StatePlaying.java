package Pattern.StateGame;

public class StatePlaying implements StatelikeGame {
    private float credit = 0;
    private int ballLossCounter = 0;

    public StatePlaying(Float credit) {
        this.credit = credit;
    }

    @Override
    public void increaseCredit(final StateContextGame STATE_CONTEXT, final float INSERT) {
        credit += INSERT;
        System.out.println("Credit increased. Game Continues!");
    }

    @Override
    public void play(StateContextGame STATE_CONTEXT) {
        // Will never be called! No usability!
    }

    @Override
    public void ballLoss(StateContextGame STATE_CONTEXT) {
        ballLossCounter++;
        if (ballLossCounter == 3){
            System.out.println("Last ball lost! Switch to EndState.");
            STATE_CONTEXT.setState(new StateEnd(credit));
        } else {
            System.out.println("Ball lost! " + (3-ballLossCounter) + " balls left.");
        }
    }

    @Override
    public void win(StateContextGame STATE_CONTEXT) {
        // Will never be called! No usability!
    }

}
