public class Property implements Calculation, MarketConstants{

    private final String type;
    private final Address address;
    protected double square;
    protected double price;
    protected double marketPrice;
    protected double profit;

    public Property(String type, Address address, double square) {
        this.type = type;
        this.address = address;
        this.square = square;
    }

    public String getType() {
        return type;
    }

    public double getSquare() {
        return square;
    }

    public double getProfit() {
        return profit;
    }

    @Override
    public void calculateMarketPrice(double sq) {
        marketPrice = Tech.roundMet(sq * pricePerS * square);
    }

    @Override
    public double calculateTax() {
        return Tech.roundMet(square*taxPerS);
    }

    @Override
    public void calculateProfit() {
        profit = Tech.roundMet(square*rentPerS);
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public void calculatePrice() {
        price = Tech.roundMet((square * pricePerS + marketPrice) / 2);
    }

    public void setOwner(Proprietor owner) {
    }

}
