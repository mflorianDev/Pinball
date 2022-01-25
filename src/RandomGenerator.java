import java.util.Random;

public class RandomGenerator {
    public int playForAFewTimesCounter = 0;

    public int getRandomInteger(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public String generateUserAction(){
        int randomInteger;

        if(playForAFewTimesCounter < 5){
            randomInteger = getRandomInteger(0,2);
            playForAFewTimesCounter++;
        }
        else{
            randomInteger = getRandomInteger(0,3);
        }

        String userAction = "";

        if(randomInteger == 0){
            userAction = "left";
        }
        if(randomInteger == 1){
            userAction = "right";
        }
        if(randomInteger == 2){
            userAction = "lost";
        }

        return userAction;
    }


    public boolean getTrueOrFalse(){
        int randomInteger = getRandomInteger(0,2);
        boolean bool = false;

        if(playForAFewTimesCounter < 3){
            bool = true;
            playForAFewTimesCounter++;
        }
        else{
            if(randomInteger == 0){
                bool = true;
            }
        }
        return bool;
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
        int randomInteger = getRandomInteger(0,3);
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
            case 3:
                // ball loss == lost
                userAction = "lost";
                break;
        }
        return userAction;
    }

}
