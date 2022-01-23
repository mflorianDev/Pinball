import java.util.Objects;
import java.util.Scanner;

public class PinballScanner {

    public double scanInsertCoin() throws Exception{
        double coin;

        do {
            try {
                do {
                    try {
                        System.out.print("Coin: ");
                        coin = new Scanner(System.in).nextDouble();
                        break;
                    } catch (Exception e) {
                        throw new Exception("Please enter a double!");
                    }
                }
                while (true);

                if(coin <= 0){
                    throw new Exception("Please enter a positive number!");
                }
                if(coin > 10) {
                    throw new Exception("The maximum credit is 10!");
                }
                    break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true);

        return coin;
    }

    public void pressStartButton(){
        do {
            try {
                System.out.print("Press s to start the game: ");
                String userInput = new Scanner(System.in).next();

                if(!userInput.equalsIgnoreCase("s")){
                    throw new Exception("Please enter s to start the game!");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true);

    }

    public boolean checkUserInputForLever(String lever){
        String letter = Objects.equals(lever, "right") ? "r" : "l";
        System.out.print("Press " + letter + " for the " + lever + " level: ");

        String userInput = new Scanner(System.in).next();
        if(Objects.equals(lever, "right") && userInput.equalsIgnoreCase(letter)){
            return true;
        }
        else if(Objects.equals(lever, "left") && userInput.equalsIgnoreCase(letter)){
            return true;
        }
        else{
            return false;
        }
    }
}

