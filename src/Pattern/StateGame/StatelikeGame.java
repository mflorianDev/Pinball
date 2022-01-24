package Pattern.StateGame;

public interface StatelikeGame {

    void increaseCredit(final StateContextGame STATE_CONTEXT, final Float INSERT);

    void play(final StateContextGame STATE_CONTEXT);

    void ballLoss(final StateContextGame STATE_CONTEXT);

    void win(final StateContextGame STATE_CONTEXT);

}
