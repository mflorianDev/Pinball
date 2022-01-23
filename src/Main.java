
public class Main {

    public static void main(String[] args) throws Exception {

        Pinball pinball = new Pinball();

        pinball.initPinballMachine();

        pinball.insertCoin();

        pinball.pressStartButton();

        pinball.playGame();

    }
}
