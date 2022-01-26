import Elements.Bumper;
import Elements.Ramp;
import Elements.Target;
import Pattern.Composite.ElementComposite;

public class Board {

    public ElementComposite mainBoard =  new ElementComposite("main");
    public ElementComposite rampBoard = new ElementComposite("ramp");

    public ElementComposite createMainBoard(){
        Target target1 = new Target(true);
        Target target2 = new Target(true);
        Target target3 = new Target(true);
        Target target4 = new Target(true);

        Bumper bumper1 = new Bumper(true);
        Bumper bumper2 = new Bumper(true);
        Bumper bumper3 = new Bumper(true);
        Bumper bumper4 = new Bumper(true);
        Bumper bumper5 = new Bumper(true);

        Ramp ramp1 = new Ramp();
        Ramp ramp2 = new Ramp();

        mainBoard.add(bumper1);
        mainBoard.add(bumper2);
        mainBoard.add(ramp1);
        mainBoard.add(bumper3);
        mainBoard.add(target1);
        mainBoard.add(target2);
        mainBoard.add(bumper4);
        mainBoard.add(target3);
        mainBoard.add(target4);
        mainBoard.add(ramp2);
        mainBoard.add(bumper5);

        return mainBoard;
    }

    public ElementComposite createRampBoard(){
        Target rampTarget1 = new Target(false);
        Target rampTarget2 = new Target(false);

        Bumper rampBumper1 = new Bumper(false);
        Bumper rampBumper2 = new Bumper(false);
        Bumper rampBumper3 = new Bumper(false);

        rampBoard.add(rampBumper1);
        rampBoard.add(rampTarget1);
        rampBoard.add(rampBumper2);
        rampBoard.add(rampBumper3);
        rampBoard.add(rampTarget2);

        return rampBoard;
    }

}
