public class GroceryItem {
    private String name;
    private double price;
    private boolean taxable;

    public GroceryItem (String name, double price, boolean taxable) {
        this.name=name;
        this.price=price;
        this.taxable=taxable;
    }

    public boolean equals(Object obj){
        if (!(obj instanceof GroceryItem)){
            return false;
        }else if (((GroceryItem) obj).name == this.name && ((GroceryItem) obj).price == this.price && ((GroceryItem) obj).taxable == this.taxable) {
            return true;
        }else {
            return false;
        }

    }
    public String toString() {
        String tax = "is taxable";
        String noTax = "tax free";
        if (this.taxable == true) {
            return (name + " " + "$" + (float)price + " " + ":" + " " + tax);
        }else {
            return (name + " " + "$" + (float)price + " " + ":" + " " + noTax);
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String newName){
        this.name = newName;
    }

    public double getPrice(){
        return price;
    }
    public void setPrice(double newPrice){
        this.price = newPrice;
    }

    public boolean getTaxable(){
        return taxable;
    }
    public void setTaxable(boolean newTaxable){
        this.taxable = newTaxable;
    }



}
