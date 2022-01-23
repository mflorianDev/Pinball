import Pattern.Command.Command;
import Pattern.Command.ElementControl;
import Pattern.Composite.ElementComposite;
import Pattern.State.PinballContext;

import java.util.Objects;

public class Pinball {

    private final Board board = new Board();
    private final PinballContext pinballContext = new PinballContext();
    private ElementComposite mainBoard = null;
    private ElementComposite rampBoard = null;
    private final ElementControl elementControl = new ElementControl();
    private final PinballScanner pinballScanner = new  PinballScanner();
    private final RandomGenerator randomGenerator = new RandomGenerator();

    private boolean userInput = true;
    private boolean isPlaying = true;

    public void initPinballMachine() {
        System.out.println("Wellcome to the Pinball Machine!\n");

        this.mainBoard = board.createMainBoard();
        board.mainBoard.printBoardElements();
        this.rampBoard = board.createRampBoard();
        board.rampBoard.printBoardElements();

        //pinballContext.writeName();
        System.out.println("");
    }

    public void insertCoin() throws Exception {
        System.out.println("Please insert a coin to start the game!");

        double credit = pinballScanner.scanInsertCoin();

        System.out.println("Your Credit is: " + credit + "\n");

        //pinballContext.setState(new ReadyState());
        //pinballContext.writeName();
    }

    public void pressStartButton(){
        pinballScanner.pressStartButton();
        //pinballContext.setState(new PlayingState());
        //pinballContext.writeName();
    }

    public void playGame(){
        System.out.println("\nThe ball is now on the field!\n");
        int numberOfElements = board.mainBoard.getComponentList().size();

        while(this.isPlaying && this.userInput){
            int randomInteger = randomGenerator.getRandomInteger(0, numberOfElements);
            Command element = (Command) this.mainBoard.getComponentList().get(randomInteger);
            String elementComponent =  this.mainBoard.getComponentList().get(randomInteger).getClass().getSimpleName();
            this.elementControl.touchedElement(element);

            if(Objects.equals(elementComponent,"Ramp")) {
                this.ballInARamp();
            }

            this.userAction();
        }
    }

    private void userAction(){
        String userAction = randomGenerator.generateUserAction();

        if(Objects.equals(userAction, "right") || Objects.equals(userAction, "left")){
            //TODO: Timer implementation!

            this.userInput = pinballScanner.checkUserInputForLever(userAction);
            if(!this.userInput) {
                System.out.println("\nYou operated the wrong lever!");
            }
        }
       else {
           this.isPlaying = false;
           System.out.println("\nThe ball is lost!");
        }
    }

    private void ballInARamp(){
        System.out.println("\nThe ball is now inside a Ramp!");
        randomGenerator.playForAFewTimesCounter = 0;

        boolean continuePlaying = true;
        int numberOfElements = board.rampBoard.getComponentList().size();

        while (continuePlaying){
            int randomInteger = randomGenerator.getRandomInteger(0, numberOfElements);
            Command element = (Command) this.rampBoard.getComponentList().get(randomInteger);
            this.elementControl.touchedElement(element);

            continuePlaying = randomGenerator.getTrueOrFalse();
        }

        System.out.println("The ball is leaving the ramp!\n");
    }

}