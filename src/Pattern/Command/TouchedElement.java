package Pattern.Command;

//Empfänger
public class TouchedElement {


    public void printTouchedElement(int elementPoints, String elementName){
        System.out.println("The ball touched a " + elementName + ". You got " + elementPoints + " points.");
    }

}
