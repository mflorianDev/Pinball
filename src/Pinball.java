import Pattern.Command.Command;
import Pattern.Command.ElementControl;
import Pattern.Composite.ElementComposite;
import Pattern.State.PinballContext;
import Pattern.StateGame.*;
import Pattern.VisitorGame.StateVisit;

import java.util.Objects;
import java.util.Scanner;

public class Pinball implements StateVisit {

    private final Board board = new Board();
    private final PinballContext pinballContext = new PinballContext();
    private ElementComposite mainBoard = null;
    private ElementComposite rampBoard = null;
    private final ElementControl elementControl = new ElementControl();
    private final PinballScanner pinballScanner = new  PinballScanner();
    private final RandomGenerator randomGenerator = new RandomGenerator();

    private boolean userInput = true;
    private boolean isPlaying = true;
    private StateContextGame stateContextGame = null;
    private Boolean isBallInBoard = false;
    private String expectedLandingLocation = null;
    private String winTarget = null;


    public void initPinballMachine() {
        System.out.println("Wellcome to the Pinball Machine!\n");
        // Create board and print included elements
        this.mainBoard = board.createMainBoard();
        board.mainBoard.printBoardElements();
        this.rampBoard = board.createRampBoard();
        board.rampBoard.printBoardElements();
        System.out.println();

        // Initalize game state
        stateContextGame = new StateContextGame();
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

    public void start(){
        // Initialyze neccessary game instances
        initPinballMachine();
        // TODO: add missing instances
        // Initialyse Scanner
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert a coin to start a new game!");
        // Initialyze main game loop for player input processing
        while(true) {
            System.out.println("GUIDE: \n" +
                    "press some listed key to interact \n" +
                    "i -> insert coins, p -> play, q -> quit\n" +
                    "a -> left flipper, d -> right flipper, s -> plunger");
            System.out.print("Input: ");
            char input = scan.next().charAt(0);
            switch (input){
                case 'i':
                    System.out.print("Insert amount (Float Number): ");
                    Float insert = scan.nextFloat();
                    stateContextGame.increaseCredit(insert);
                    break;
                case 'p':
                    if (stateContextGame.getGameState() == "StateReady"){
                        stateContextGame.play();
                    }
                    break;
                case 'a':
                case 'd':
                    // If in playing mode and ball in board
                    if (stateContextGame.getGameState() == "StatePlaying" && isBallInBoard){
                        userBallInteraction();
                    } else if (stateContextGame.getGameState() == "StateEnd" && isBallInBoard){
                        /* TODO: implement win situation with call of "stateContextGame.win()"
                            or game over situation (will called by itself on ball-loss)
                         */
                        //userBallInteraction();
                        stateContextGame.win();
                    }
                    break;
                case 's':
                    // if in playing mode and ball not yet initalized then initalize ball
                    if (stateContextGame.getGameState() == "StatePlaying"){
                        isBallInBoard = true;
                        ballRoll();
                    }
                    // if game state in end mode and ball not yet initialized set winnig target and initalize ball
                    else if (stateContextGame.getGameState() == "StateEnd" && !isBallInBoard){
                        // TODO: adapt to composite and add ramp element as possible "winTarget"
                        int numberOfElements = board.mainBoard.getComponentList().size();
                        int randomInteger = randomGenerator.getRandomInteger(0, numberOfElements);
                        winTarget = this.mainBoard.getComponentList().get(randomInteger).getClass().getSimpleName();
                        // TODO: simulate moving ball with possibility of hitting winTarget
                        // stateContextGame.win() or wait for another round of userInput;
                    }
                    break;
                case 'q':
                    System.exit(0);
                    break;
                default:
                    System.out.print("Input could not be processed. Try again.");
                    break;
            }
            System.out.println();
        }
    }

    // Simulate ball rolling accross the board
    private void ballRoll(){
        Boolean ballInLoop = true;
        int numberOfElements = board.mainBoard.getComponentList().size();
        do {
            int randomInteger = randomGenerator.getRandomInteger(0, numberOfElements);
            Command element = (Command) this.mainBoard.getComponentList().get(randomInteger);
            String elementComponent =  this.mainBoard.getComponentList().get(randomInteger).getClass().getSimpleName();
            this.elementControl.touchedElement(element);
            ballInLoop = randomGenerator.isBallInLoop();
        } while (ballInLoop);
        expectedLandingLocation = randomGenerator.getExpectedLandingLocation();
        // if ball lost inform game state
        if (expectedLandingLocation == "lost"){
            stateContextGame.ballLoss();
            isBallInBoard = false;
        }
    }

    // process interaction of ball movement and user input
    private void userBallInteraction(){
        // check if user action equals expected landing location of ball
        if (expectedLandingLocation == "a" || expectedLandingLocation == "d"){
            ballRoll();
        } else {
            stateContextGame.ballLoss();
            isBallInBoard = false;
        }
    }

    /*
     Possible player actions during game:
     - left flipper action:
        check if state == playing
        check if left flipper corresponds to expected input to hit the ball
        if ball was missed -> state.ballLoss()
     - left flipper action:
         check if state == playing
        check if left flipper corresponds to expected input to hit the ball
        if ball was missed -> state.ballLoss()
     - plunger action:
        check if state == playing && ball in starting position
        if ball in starting position:
            -> init random generator (two options):
                1) to init one hit element (target, bumper, ramp)
                2) or fall down to flipper options (left, right, exit). Exit should have less probability!
            -> if  1) reinitiate random generator
        if ball was missed -> state.ballLoss()
     */

    @Override
    public void visit(StateReady stateReady) {
        // Do something
    }

    @Override
    public void visit(StateNoCredit stateNoCredit) {
        // Do something
    }

    @Override
    public void visit(StatePlaying statePlaying) {
        // Do something
    }

    @Override
    public void visit(StateEnd stateEnd) {
        // Do something
    }

}