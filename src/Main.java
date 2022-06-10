import java.util.ArrayList;
public class Main{

    public static void main(String[] args) {

        PropertyMarket propertyMarket = new PropertyMarket();

        //Creating of User's object
        System.out.println("Input your name");
        Proprietor proprietor = new Proprietor(Tech.GetInputStringFunction(), 90, 500000.0);

        //User interface (menus) starting in the UI object methods
        UserInterface UI = new UserInterface(propertyMarket, proprietor);
        UI.newMonth();

    }



}
