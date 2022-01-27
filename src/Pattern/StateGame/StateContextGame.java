package Pattern.StateGame;

public class StateContextGame {
    private StatelikeGame gameState;

    public StateContextGame() {
        setState(new StateNoCredit(0f));
    }

    public void setState(final StatelikeGame NEW_STATE) {
        gameState = NEW_STATE;
    }

    public void increaseCredit(final float INSERT) {
        gameState.increaseCredit(this, INSERT);
    }

    public void play() {
        gameState.play(this);
    }

    public void ballLoss() {
        gameState.ballLoss(this);
    }

    public void win() {
        gameState.win(this);
    }

    public String getGameState(){
        return this.gameState.getClass().getSimpleName();
    }

}



