package Pattern.StateGame;

public class StatePlaying implements StatelikeGame {
    private float credit = 0;
    private int ballLossCounter = 0;

    public StatePlaying(float credit) {
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
            System.out.println("Last ball lost! Switch to EndState.\n" +
                    "Press 's' to operate the plunger to initialize the ball");
            STATE_CONTEXT.setState(new StateEnd(credit));
        } else {
            System.out.println("Ball lost! " + (3-ballLossCounter) + " balls left.\n" +
                    "Press 's' to operate the plunger to initialize the ball");
        }
    }

    @Override
    public void win(StateContextGame STATE_CONTEXT) {
        // Will never be called! No usability!
    }

}
