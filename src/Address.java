public class Address {

    private String city;
    private String type;
    private String name;
    private String number;

    public void setCity(String city) {
        this.city = city;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString(){
        return "city: "+city+", type: "+type+", name: "+name+", number: "+number;
    }

}
