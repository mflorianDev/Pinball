import Pattern.Singelton.Multiball;

public class Main {

    public static void main(String[] args) throws Exception {


        //Pinball.Instance() as Pinball is a Singelton
        Pinball pinball = Pinball.Instance();
        pinball.start();

        /*
        //just for testing the Multiball as a Singelton
        Multiball multiball = Multiball.Instance();
        multiball.write();
        */

    }
}
