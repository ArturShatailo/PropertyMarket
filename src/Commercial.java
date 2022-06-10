public class Commercial extends Property{

    private Proprietor owner;

    public Commercial(Address address, double square) {
        super("Commercial", address, square);
    }

    @Override
    public void setOwner(Proprietor owner) {
        this.owner = owner;
    }

    @Override
    public double calculateTax() {
        return Tech.roundMet(profit < 100.0 ? 0 : square * taxPerS * (profit/1000));
    }

    @Override
    public String toString(){
        return "type: "+getType()+", address: "+getAddress().toString()+", square: "+square+", price: "+price+", marketPrice: "+marketPrice+", tax: "+calculateTax()+", owner: "+owner+", profit: "+profit;
    }

    @Override
    public void calculateProfit() {
        profit = Tech.roundMet(square*rentPerS / Tech.getRandomDouble(1, rentPerS));
    }

}
