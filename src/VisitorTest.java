import Elements.Bumper;
import Elements.Ramp;
import Elements.Target;
import Pattern.Composite.Component;
import Pattern.VisitorGame.ElementVisitor;


public class VisitorTest {
    int totalPoints;

    Board board = new Board();
    ElementVisitor visitor = new ElementVisitor();

    public void init(){
        System.out.println("in it");

        board.createMainBoard();

        Component component1 = board.mainBoard.getComponentList().get(0);
        Component component2 = board.mainBoard.getComponentList().get(2);
        Component component3 = board.mainBoard.getComponentList().get(4);

        System.out.println(totalPoints);
        totalPoints += getPointsFromTouchedElement(component1);

        System.out.println(totalPoints);
        totalPoints += getPointsFromTouchedElement(component2);

        System.out.println(totalPoints);
        totalPoints += getPointsFromTouchedElement(component3);

        System.out.println(totalPoints);

    }

    private int getPointsFromTouchedElement(Component component){
        if(component.getClass() == Ramp.class){
            ((Ramp) component).accept(visitor);
        }
        if(component.getClass() == Bumper.class){
            ((Bumper) component).accept(visitor);
        }
        if(component.getClass() == Target.class){
            ((Target) component).accept(visitor);
        }
        return visitor.getElementPoints();
    }

}
