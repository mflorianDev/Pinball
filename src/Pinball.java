import Elements.Bumper;
import Elements.Ramp;
import Elements.Target;
import Pattern.Command.Command;
import Pattern.Command.ElementControl;
import Pattern.Composite.Component;
import Pattern.Composite.ElementComposite;
import Pattern.StateGame.*;
import Pattern.VisitorGame.StateVisit;

import java.util.Scanner;

public class Pinball implements StateVisit {

    private final Board board = new Board();
    //private final PinballContext pinballContext = new PinballContext();
    private ElementComposite mainBoard = null;
    private ElementComposite rampBoard = null;
    private final ElementControl elementControl = new ElementControl();
    //private final PinballScanner pinballScanner = new  PinballScanner();
    private final RandomGenerator randomGenerator = new RandomGenerator();

    //private boolean userInput = true;
    //private boolean isPlaying = true;
    private StateContextGame stateContextGame = null;
    private Boolean isBallInBoard = false;
    private String expectedLandingLocation = null;
    private Component winTarget = null;
    private int totalPoints = 0;

    // Singleton
    private static Pinball instance = null;

    private Pinball() {
    }

    public static Pinball Instance() {
        if (instance == null) {
            instance = new Pinball();
        }
        return instance;
    }

    public void start(){
        // Initialize necessary game instances
        initPinballMachine();
        // TODO: new instances can be initialized here
        // Initialize Scanner
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert a coin to start a new game!");
        // Initialize main game loop for player input processing
        while(true) {
            System.out.println("GUIDE: \n" +
                    "press some listed key to interact \n" +
                    "i -> insert coins, p -> play, q -> quit\n" +
                    "a -> left flipper, d -> right flipper, s -> plunger");
            System.out.print("\nInput: ");
            char input = scan.next().charAt(0);
            switch (input){
                case 'i':
                    System.out.print("Insert amount (Float Number): ");
                    Float insert = scan.nextFloat();
                    stateContextGame.increaseCredit(insert);
                    break;
                case 'p':
                    if (stateContextGame.getGameState().equals("StateReady")){
                        stateContextGame.play();
                    }
                    break;
                case 'a':
                    if (stateContextGame.getGameState().equals("StatePlaying")
                            || stateContextGame.getGameState().equals("StateEnd")
                            && isBallInBoard){
                        // StateEnd: win method is active, game over will be called automatic on ball loss
                            userBallInteraction("a");
                     }
                    break;

                case 'd':
                    // If in playing mode and ball in board
                    if (stateContextGame.getGameState().equals("StatePlaying") && isBallInBoard){
                        userBallInteraction("d");
                    } else if (stateContextGame.getGameState().equals("StateEnd") && isBallInBoard){
                        // win method is active, game over will be called automatically on ball loss
                        userBallInteraction("d");
                    }
                    break;
                case 's':
                    // if in playing mode and ball not yet initalized then initalize ball
                    if (stateContextGame.getGameState().equals("StatePlaying")){
                        isBallInBoard = true;
                        ballRoll(mainBoard, false);
                    }
                    // if game state in end mode and ball not yet initialized set winnig target and initalize ball
                    else if (stateContextGame.getGameState().equals("StateEnd") && !isBallInBoard){
                        setWinTarget();
                        ballRoll(mainBoard, false);
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

    private void initPinballMachine() {
        System.out.println("Welcome to the Pinball Machine!\n");
        // Create board and print included elements
        this.mainBoard = board.createMainBoard();
        board.mainBoard.printBoardElements();
        this.rampBoard = board.createRampBoard();
        board.rampBoard.printBoardElements();
        System.out.println();
        // Initalize game state
        stateContextGame = new StateContextGame();
    }

    // Simulate ball rolling accross a board composite (ElementComposite)
    private void ballRoll(ElementComposite boardComposite, Boolean ballInRamp){
        boolean ballInLoop = true;
        int numberOfElements = boardComposite.getComponentList().size();
        do {
            int randomInteger = randomGenerator.getRandomInteger(0, numberOfElements);
            Component component = boardComposite.getComponentList().get(randomInteger);
            Command command = (Command) component;
            this.elementControl.touchedElement(command);
            // Get points of hit element and add to totalPoints
            totalPoints += component.getPoints();
            System.out.println("Total points: " + totalPoints);
            if (component.getClass() == Ramp.class){
                System.out.println("\nThe ball is now inside a Ramp!");
                /*
                TODO: change parameter to dynamically choosen ElementComposite.
                    Problem: How to access the Element of type ElementComposite?
                 */
                ballRoll(rampBoard, true);
            }
            // Check if hit component is same as winning target
            if (component == winTarget){
                stateContextGame.win();
                System.out.println("Congratulations! You have reached a total score of " + totalPoints);
                ballInLoop = false;
                isBallInBoard = false;
            } else{
                ballInLoop = randomGenerator.isBallInLoop();
            }
        } while (ballInLoop);
        if (ballInRamp){
            System.out.println("The ball is leaving the ramp!\n");
        } else {
            expectedLandingLocation = randomGenerator.getExpectedLandingLocation();
            // if ball lost inform game state
            if (expectedLandingLocation == "lost"){
                ballIsLost();
                System.out.println("Ball unfortunately landed in the die hole.\n" +
                        "The ball is lost!");
            } else {
                System.out.println("Press button " + expectedLandingLocation + " to hit the ball!");
            }
        }
    }

    // process interaction of ball movement and user input
    private void userBallInteraction(String userInput){
        // check if user action equals expected landing location of ball
        if (expectedLandingLocation == userInput){
            ballRoll(mainBoard, false);
        } else {
            ballIsLost();
        }
    }

    private void ballIsLost(){
        stateContextGame.ballLoss();
        winTarget = null;
        isBallInBoard = false;
    }

    private void setWinTarget(){
        // Only mainBoard components can be a winTarget (no ramp or ramp components!)
        int numberOfElements = board.mainBoard.getComponentList().size();
        Component randomComponent;
        do {
            int randomInteger = randomGenerator.getRandomInteger(0, numberOfElements);
            randomComponent = mainBoard.getComponentList().get(randomInteger);
        } while (randomComponent.getClass().getSimpleName().equals("Ramp"));
        winTarget = randomComponent;
    }


    // --- Visit methods for game state ---
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


    // --- Visit methods for components ---


    @Override
    public int visit(Bumper bumper) {
        return bumper.getPointsOrCredit();
    }

    @Override
    public int visit(Target target) {
        return target.getPointsOrCredit();
    }

    @Override
    public int visit(Ramp ramp) {
        return ramp.getPointsOrCredit();
    }


    /*
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

     */



}