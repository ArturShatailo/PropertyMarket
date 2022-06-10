import java.util.Scanner;

public class Tech {

    //"GetInputFunction" is a scanner of input that returns Integer entered by user
    public static int GetInputFunction(){
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    //"GetInputStringFunction" is a scanner of input that returns String entered by user
    public static String GetInputStringFunction(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    //Get random int value from min to max
    public static int getRandom(int min, int max){
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    //Get random double value from min to max range
    public static Double getRandomDouble(double min, double max) {
        return roundMet((Math.random() * (max - min)) + min);
    }

    //cut double value to 2 digits after decimal
    public static double roundMet(double a){
        double b = Math.pow(10, 2);
        return Math.ceil(a * b) / b;
    }

    //The method generates new Address object and fill it with random values from static arrays.
    public static Address randomAddress(){

        String [] cities = {"Dnipro", "Kyiv", "Odessa", "Lviv"};
        String [] type = {"RD", "ST"};
        String [] name = {"Shevchenko", "Polya", "Heroiv maydanu", "Yavornitskoho", "Derebasivska", "Polska", "Franko", "Svobody"};

        Address address = new Address();
        address.setCity(cities[Tech.getRandom(0, cities.length-1)]);
        address.setType(type[Tech.getRandom(0, type.length-1)]);
        address.setName(name[Tech.getRandom(0, name.length-1)]);
        address.setNumber(String.valueOf(Tech.getRandom(0, 200)));

        return address;
    }

}
