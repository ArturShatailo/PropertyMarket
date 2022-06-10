import java.util.ArrayList;

public class PropertyMarket implements Market, MarketConstants{


    //This method creates from 1 to 5 objects of each class Commercial, Industrial and Residential.
    public void startMarket() {

        int k = Tech.getRandom(1, 5);
        int m = Tech.getRandom(1, 5);
        int n = Tech.getRandom(1, 5);

        while(k > 0) {
            newLot(new Commercial(Tech.randomAddress(), Tech.getRandomDouble(30.0, 300.0)));
            k--;
        }
        while(m > 0) {
            newLot(new Industrial(Tech.randomAddress(), Tech.getRandomDouble(30.0, 300.0)));
            m--;
        }
        while(n > 0) {
            newLot(new Residential(Tech.randomAddress(), Tech.getRandomDouble(30.0, 300.0)));
            n--;
        }

        distributePrices();
    }

    //Calculating and defining 'marketPrice', 'price', 'profit' fields of all created Property objects before
    private void distributePrices() {
        lots.forEach(this::getMarketPrice);
        lots.forEach(Property::calculatePrice);
        lots.forEach(Property::calculateProfit);
    }

    public ArrayList<Property> getMarket(){
        return lots;
    }

    //This method adds created Property object to 'lots' collection implemented from Market interface and setting 'owner' field
    // of this Property as market object, also implemented from Market interface.
    public void newLot(Property p) {
            p.setOwner(market);
            lots.add(p);
    }

    //This method calculates constant of market price as square / average square of all Property of this type / (market size+1)
    //send this value into calculateMarketPrice() method of Property
    private void getMarketPrice(Property p) {
        double sq = p.square / (lots.stream()
                .filter(l -> l.getType().equals(p.getType()))
                .mapToDouble(Property::getSquare)
                .sum() / (getMarketSize(p)+1));

        p.calculateMarketPrice(sq);
    }

    //Calculate how much Property with the same type as received in parameter Property in 'lots' collection
    private long getMarketSize(Property p) {

        return lots.stream()
                .filter(l -> l.getType().equals(p.getType()))
                .count();

    }

    public void sellLot(int p) {
        lots.remove(p);
    }

    public void cleanMarket() {
        while(Tech.getRandom(0, (lots.size()-1)) > 0){
            lots.remove(Tech.getRandom(0, (lots.size()-1)));
        }
    }
}
