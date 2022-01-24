package Pattern.StateGame;

public class StatePatternDemo {
    public static void main(String[] args) {

        StateContextGame state = new StateContextGame();
        // Insert no coin
        state.increaseCredit(0f);
        // Insert coin but too little credit
        state.increaseCredit(0.5f);
        // Insert coin, ready for game
        state.increaseCredit(1.5f);
        // Game started
        state.play();
        // Insert coin, game continues
        state.increaseCredit(1.5f);

        // 3 Balls lost, go to endstate
        state.ballLoss();
        state.ballLoss();
        state.ballLoss();

        // Winning new game
        state.win();
        state.ballLoss();
        state.ballLoss();
        state.ballLoss();

        // GameOver, switch to ready/noCredit
        state.ballLoss();

    }
}
