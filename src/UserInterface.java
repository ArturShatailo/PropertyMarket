import java.util.ArrayList;

public class UserInterface {

    public PropertyMarket pM;
    public Proprietor p;

    UserInterface(PropertyMarket propertyMarket, Proprietor proprietor){
        this.pM = propertyMarket;
        this.p = proprietor;
    }

    public void newMonth() {
        pM.cleanMarket();
        pM.startMarket();
        startMonth();
        calculateMonth();
    }

    //Calculating of users balance according to Tax, Profit and Credit values
    private void calculateMonth() {
        System.out.println("\nYour balance is: "+p.getBalance()+
                ", expected tax: "+p.fullTax()+
                ", expected profit: "+p.fullProfit()+
                ", expected credit: "+p.creditFunds()+
                "\n");
        newMonth();
    }

    //This method creates visible interface for market actions (buy and sell) of property.
    private void startMonth() {
        System.out.println("The market is: ");
        System.out.println("Your balance is: "+ p.getBalance());
        buySession();
        System.out.println(p.getName() + ", on your balance: " + p.getBalance() + ", and you have the the following properties: ");
        sellSession();
    }

    //Method that display all available for selling Property objects in properties collection field of Proprietor object
    //calls menu that shows these objects and then calls methods that 'sell' object
    private void sellSession() {

        callMenu(p.getProperties());
        System.out.println("\nPress number of property to sell and press 'Enter'. Input '0' to close sell session\n");

        int a = Tech.GetInputFunction();
        if(a != 0) {
            if (p.getProperties().size() >= a) {
                pM.newLot(p.getProperties().get(a-1));
                p.sellProperty(a-1);
                sellSession();
            }
        }
    }

    //Method that display all available for selling Property objects in lots collection field of PropertyMarket object
    //calls menu that shows these objects and then calls methods that 'buy' object
    private void buySession() {

        callMenu(pM.getMarket());
        System.out.println("\nPress number of property to buy and press 'Enter'. Input '0' to close sell session\n");

        int a = Tech.GetInputFunction();
        if(a != 0) {
            if (pM.getMarket().size() >= a) {
                p.buyProperty(pM.getMarket().get(a-1));
                pM.sellLot(a-1);
                buySession();
            }
        }
    }

    //Menu creator based on Menu object and it's methods.
    private void callMenu(ArrayList<Property> property) {

        Menu menu = new Menu();
        for (Property p:property) {
            menu.arrayString.add(p.toString());
        }
        menu.menuBuilder();
    }

}
