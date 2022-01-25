import java.util.Random;

public class RandomGenerator {

    public int getRandomInteger(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    // if value between 1-3 ball keeps in loop else ball falls down
    public boolean isBallInLoop(){
        Random random = new Random();
        int upperbound = 3;
        int value = random.nextInt(upperbound);
        if (value == 0){
            return false;
        } else {
            return true;
        }
    }

    // generate expected landing location of ball as String ("left" flipper, "right" flipper, "lost")
    public String getExpectedLandingLocation(){
        String userAction = "";
        Random random = new Random();
        int upperbound = 3;
        int randomInteger = random.nextInt(upperbound);
        // TODO: implement System.out to inform user of matching input value to hit the ball
        switch (randomInteger) {
            case 0:
                // left flipper == a
                userAction = "a";
                break;
            case 1:
                // right flipper == d
                userAction = "d";
                break;
            case 2:
                // ball loss == lost
                userAction = "lost";
                break;
        }
        return userAction;
    }

}
