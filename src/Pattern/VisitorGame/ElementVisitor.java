package Pattern.VisitorGame;

import Elements.Bumper;
import Elements.Ramp;
import Elements.Target;
import Pattern.Composite.Component;
import Pattern.StateGame.StateEnd;
import Pattern.StateGame.StateNoCredit;
import Pattern.StateGame.StatePlaying;
import Pattern.StateGame.StateReady;

public class ElementVisitor implements StateVisit{

    public int points;

    public int getPointsFromElement(Component component){
        int pointsFromElement = 0;

        if(component.getClass() == Ramp.class){
            this.visit((Ramp) component);
            pointsFromElement = this.points;
        }

        if(component.getClass() == Bumper.class){
            pointsFromElement = this.visit((Bumper) component);
        }

        if(component.getClass() == Target.class){
            this.visit((Target) component);
        }

        System.out.println(pointsFromElement);

        return pointsFromElement;
    }

    public void setPoints(int points) {
        this.points = points;
    }


    @Override
    public void visit(StateNoCredit stateNoCredit) {

    }

    @Override
    public void visit(StateReady stateReady) {

    }

    @Override
    public void visit(StatePlaying statePlaying) {

    }

    @Override
    public void visit(StateEnd stateEnd) {

    }


    @Override
    public int visit(Bumper bumper) {
        return bumper.getPointsOrCredit();
    }

    @Override
    public int visit(Target target) {
        return 0;
    }

    @Override
    public int visit(Ramp ramp) {
        setPoints(ramp.getPointsOrCredit());
        return 0;
    }
}
