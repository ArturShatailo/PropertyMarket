
public class Residential extends Property{

    private Proprietor owner;

    public Residential(Address address, double square) {
        super("Residential", address, square);
    }

    @Override
    public void setOwner(Proprietor owner) {
        this.owner = owner;
    }

    @Override
    public double calculateTax() {
        return Tech.roundMet(square*taxPerS/owner.getSubsidy());
    }

    @Override
    public String toString(){
        return "type: "+getType()+", address: "+getAddress().toString()+", square: "+square+", price: "+price+", marketPrice: "+marketPrice+", tax: "+calculateTax()+", owner: "+owner+", profit: "+profit;
    }

    @Override
    public void calculateProfit() {
        profit = Tech.roundMet(square*rentPerS);
    }
}
