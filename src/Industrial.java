public class Industrial extends Property{

    private Proprietor owner;

    public Industrial(Address address, double square) {
        super("Industrial", address, square);
    }

    @Override
    public void setOwner(Proprietor owner) {
        this.owner = owner;
    }

    @Override
    public String toString(){
        return "type: "+getType()+", address: "+getAddress().toString()+", square: "+square+", price: "+price+", marketPrice: "+marketPrice+", tax: "+calculateTax()+", owner: "+owner+", profit: "+profit;
    }

    @Override
    public void calculateMarketPrice(double sq) {
        marketPrice = Tech.roundMet(sq * pricePerSindustrial * square);
    }

    @Override
    public void calculateProfit() {
        profit = Tech.roundMet(square * rentPerSindustrial);
    }

    @Override
    public void calculatePrice() {
        price = Tech.roundMet((square * pricePerS + marketPrice) / 2);
    }

}
