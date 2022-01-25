import Pattern.Singelton.Multiball;

public class Main {

    public static void main(String[] args) throws Exception {
/*
        VisitorTest vt = new VisitorTest();
        vt.init();
*/
        //just for testing the Multiball as a Singelton
        Multiball multiball = Multiball.Instance();
        multiball.write();

        //Pinball.Instance() as Pinball is a Singelton
        Pinball pinball = Pinball.Instance();
        pinball.start();


        /*
        pinball.initPinballMachine();

        pinball.insertCoin();

        pinball.pressStartButton();

        pinball.playGame();

         */

    }
}
