package Pattern.Composite;

import java.util.ArrayList;
import java.util.List;

//Kompositum
public class ElementComposite implements Component {

    private List<Component> childComponents = new ArrayList<Component>();
    private final String name;

    public ElementComposite(String name){
        this.name = name;
    }

    @Override
    public void printBoardElements() {
        System.out.print("Your " + this.name + " board consists of: ");
        for (Component component : childComponents) {
            component.printBoardElements();
            if(childComponents.indexOf(component) == childComponents.size() - 1){
                System.out.println("");
            }
            else{
                System.out.print(", ");
            }
        }
    }

    public void add(Component component) {
        childComponents.add(component);
    }

    public void remove(Component component) {
        childComponents.remove(component);
    }

    public List<Component> getComponentList(){
        return childComponents;
    }


}
