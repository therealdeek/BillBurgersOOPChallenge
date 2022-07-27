package BillsBurgers;

/*
The objective of this project is to create, for a restaurant,
Bill's Burgers, a menu for three(3) burgers. One burger will be
the base burger, another a healthy option, and the last is a
deluxe burger. The base burger can have up to four additional
items, the healthy burger can have up to two additional items, and
the deluxe burger cannot have any additional items added. However,
the deluxe burger does come with a combo of chips and a drink.

For the additions, they should be able to be computed with the base
price(base burger price). Each class should contain constructors.
Each class of burgers should have methods returning the name and price.
Also, the two speciality burgers should override(hint) the base burger
as well.

The printout should contain information for each order, in detail,
to include the additions(if added).

You got this! So, try it first, and if you get stuck, please use this
code to compare your work.

 */

class Hamburger
{
    private String name;
    private String breadRollType;
    private String meatType;
    private double price;

    private String addition1Name;
    private double addition1Price;

    private String addition2Name;
    private double addition2Price;

    private String addition3Name;
    private double addition3Price;

    private String addition4Name;
    private double addition4Price;


   /*
   Constructor for the baseBurger class with parameters,
   parameter initialization using "this"
    */

    public Hamburger(String name, String breadRollType, String meatType,
                     double price)
    {
        this.name = name;
        this.breadRollType = breadRollType;
        this.meatType = meatType;
        this.price = price;

    }
    /*
    methods to return the additions added to the baseBurger
    (hint) notice the public void(void is the return type
    indicating a method)
     */

    public void hamburgerAddition1Name(String name, double price)
    {
        this.addition4Name = name;
        this.addition4Price = price;
    }

    public void hamburgerAddition2Name(String name, double price)
    {
        this.addition3Name = name;
        this.addition3Price = price;
    }

    public void hamburgerAddition3Name(String name, double price)
    {
        this.addition2Name = name;
        this.addition2Price = price;
    }

    public void hamburgerAddition4Name(String name, double price)
    {
        this.addition1Name = name;
        this.addition1Price = price;
    }

    // method to itemize the hamburger price
    public double itemizeHamburger()
    {
        double hamburgerPrice = this.price;

        System.out.println(this.name + " hamburger " + "on a "
                + this.breadRollType + " roll " + "with "
                + this.meatType + ", price is " + "$"+ this.price);

        //if statements for addition items added to the hamburger

        if(this.addition1Name != null)
        {
            hamburgerPrice += this.addition1Price;
            System.out.println("Added " + this.addition1Name + " for an extra " +
                    this.addition1Price);
        }

        if(this.addition2Name != null)
        {
            hamburgerPrice += this.addition2Price;
            System.out.println("Added " + this.addition2Name + " for an extra " +
                    this.addition2Price);
        }

        if(this.addition3Name != null)
        {
            hamburgerPrice += this.addition3Price;
            System.out.println("Added " + this.addition3Name + " for an extra " +
                    this.addition3Price);
        }

        if(this.addition4Name != null)
        {
            hamburgerPrice += this.addition4Price;
            System.out.println("Added " + this.addition4Name + " for an extra " +
                    this.addition4Price);
        }

        return hamburgerPrice;
    }

}
// Healthy Burger class

class HealthyBurger extends Hamburger
{
    private String healthyExtra1Name;
    private double healthyExtra1Price;

    private String healthyExtra2Name;
    private double healthyExtra2Price;


    public HealthyBurger(String meatType, double price)
    {
        super("Healty", "Brown Rye", meatType, price);
    }

    public void addHealthyAddition1(String name, double price)
    {
        this.healthyExtra1Name=name;
        this.healthyExtra1Price=price;
    }
    public void addHealthyAddition2(String name, double price)
    {
        this.healthyExtra2Name=name;
        this.healthyExtra2Price=price;
    }

    /*We have to override the baseBurger's itemizeHamburger method so the method
    can be used specific for the Healthy Burger class. The
    method from the baseBurger class is the template for us to
    use for every subclass(if needed)
     */

    @Override
    public double itemizeHamburger() {
        double hamburgerPrice = super.itemizeHamburger();

        if(this.healthyExtra1Name != null)
        {
            hamburgerPrice += this.healthyExtra1Price;
            System.out.println("Added " + this.healthyExtra1Name +
                    " for an extra " + this.healthyExtra1Price);
        }
        if(this.healthyExtra2Name != null)
        {
            hamburgerPrice += this.healthyExtra2Price;
            System.out.println("Added " + this.healthyExtra2Name +
                    " for an extra " + this.healthyExtra2Price);
        }
        return hamburgerPrice;
    }
}
// Deluxe Burger Class

class DeluxeBurger extends Hamburger
{
    public DeluxeBurger()
    {
        // we have edited the super class call to fill in the deluxe default
        super("Deluxe", "White", "Sausage & Bacon", 8.97);

        //at the time of object creation, these items are added to the deluxe price

        super.hamburgerAddition1Name("Chips", 2.75);
        super.hamburgerAddition2Name("Drink", 1.93);
    }

    @Override
    public void hamburgerAddition1Name(String name, double price) {
        System.out.println("Additional items cannot be added");
    }

    @Override
    public void hamburgerAddition2Name(String name, double price) {
        System.out.println("Additional items cannot be added");
    }

    @Override
    public void hamburgerAddition3Name(String name, double price) {
        System.out.println("Additional items cannot be added");
    }

    @Override
    public void hamburgerAddition4Name(String name, double price) {
        System.out.println("Additional items cannot be added");
    }
}

public class Test
{
    public static void main(String[]args)
    {
        Hamburger hamburger = new Hamburger("Basic", "White", "Sausage", 3.56);

        hamburger.hamburgerAddition1Name("Tomato", 0.25);
        hamburger.hamburgerAddition2Name("Lettuce", 0.75);
        hamburger.hamburgerAddition3Name("Cheese", 1.15);
        System.out.println("Total burger price is: " + "$"+ hamburger.itemizeHamburger());
        System.out.println();

        HealthyBurger healthyBurger = new HealthyBurger("Bacon", 5.67);
        healthyBurger.addHealthyAddition1("Lentils", 5.43);
        healthyBurger.addHealthyAddition2("Avocado", 3.41);
        System.out.println("Total Healthy Burger price is: "+healthyBurger.itemizeHamburger());
        System.out.println();

        DeluxeBurger db = new DeluxeBurger();
        db.hamburgerAddition1Name("pickles", .57);
        System.out.println("Total Deluxe Burger price is: "+ db.itemizeHamburger());



    }
}
