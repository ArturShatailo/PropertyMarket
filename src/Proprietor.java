import java.util.ArrayList;

public class Proprietor {

    private final String name;
    private final ArrayList<Property> properties = new ArrayList<>();
    private final double subsidy;
    private double balance;
    private double credit;

    public Proprietor(String name, double subsidy, double balance) {
        this.name = name;
        this.subsidy = subsidy;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getSubsidy() {
        return subsidy;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    //This method receives Property object, set owner field to it as this value, add Property object to 'properties' collection
    //and deduct it's 'price' field value from this 'balance' field value.
    public void buyProperty(Property p){
        p.setOwner(this);
        properties.add(p);
        balance = Tech.roundMet(balance - p.price);
    }

    //This method receives int index of Property object, removes Property object from 'properties' collection according to index
    //and add it's 'price' field value to this 'balance' field value.
    public void sellProperty(int p){
        balance = Tech.roundMet(balance + properties.get(p).marketPrice);
        properties.remove(p);
    }

    @Override
    public String toString(){
        return "("+name+")";
    }

    //Calculating and summing up of all values from calculateTax() of Property objects in 'properties'
    //deduction this sum from balance.
    public double fullTax() {
        double taxes = properties.stream().mapToDouble(Property::calculateTax).sum();
        balance = Tech.roundMet(balance - taxes);
        return taxes;
    }

    //Calculating and summing up of all values of 'profit' fields values of Property objects in 'properties'
    //adding this sum to balance.
    public double fullProfit() {
        double profits = properties.stream().mapToDouble(Property::getProfit).sum();
        balance = Tech.roundMet(balance + profits);
        return profits;
    }

    //Calculation of 'credit' field as 0.6% from 'balance' field, but only if 'balance' has negative value
    //summing up balance and credit.
    public double creditFunds(){
        credit = balance < 0 ? Tech.roundMet(balance * 0.006) : 0;
        balance = balance + credit;
        return credit;
    }

}
