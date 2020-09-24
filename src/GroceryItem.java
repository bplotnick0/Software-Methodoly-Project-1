/**
 GroceryItem class describes an instance of a single shopping item.
 Its functions include determining if two grocery items are the same,
        and converting all the properties of the item to 1 string.
 @author Ben Plotnick, Michael Sherbine
 **/

public class GroceryItem {
    private String name;
    private double price;
    private boolean taxable;

    /**
     Constructor for a grocery item, with all properties necessary for shopping.
     @param name of the item to be put in bag, price of item, whether or not item is taxable.
     */
    public GroceryItem (String name, double price, boolean taxable) {
        this.name=name;
        this.price=price;
        this.taxable=taxable;
    }

    /**
     Compares two grocery items, to see if all values are the same.
     @param Instance of object to be compared.
     @return true if two items are completely equal, false if not.
     */
    public boolean equals(Object obj){
        if (!(obj instanceof GroceryItem)){
            return false;
        }else if (((GroceryItem) obj).name == this.name && ((GroceryItem) obj).price == this.price && ((GroceryItem) obj).taxable == this.taxable) {
            return true;
        }else {
            return false;
        }

    }

    /**
     Concatenates all properties of grocery item into one string for display.
     @return Sinlge string for item to be displayed.
     */
    public String toString() {
        String tax = "is taxable";
        String noTax = "tax free";
        if (this.taxable == true) {
            return (name + " " + "$" + (float)price + " " + ":" + " " + tax);
        }else {
            return (name + " " + "$" + (float)price + " " + ":" + " " + noTax);
        }
    }

    /**
     Getter for item name.
     @param name of item
     @return name of item, for export
     */
    public String getName() {
        return name;
    }

    /**
     Setter for item name.
     @param name from getter
     */
    public void setName(String newName){
        this.name = newName;
    }

    /**
     Getter for item price.
     @param price of item
     @return price of item, for export
     */
    public double getPrice(){
        return price;
    }

    /**
     Setter for item price.
     @param price from getter.
     */
    public void setPrice(double newPrice){
        this.price = newPrice;
    }

    /**
     Getter for item taxability.
     @param taxability of item
     @return taxability of item, for export
     */
    public boolean getTaxable(){
        return taxable;
    }

    /**
     Setter for item name.
     @param name from getter
     */
    public void setTaxable(boolean newTaxable){
        this.taxable = newTaxable;
    }


}
