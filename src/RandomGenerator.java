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

}
