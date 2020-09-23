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
            return ("itemName:" + " " + name + " " + "$" + price + " " + ":" + "" + tax);
        }else {
            return ("itemName:" + " " + name + " " + "$" + price + " " + ":" + "" + noTax);
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

    public static void main (String[] args){
        GroceryItem a = new GroceryItem("meat", 2.99, false);
        GroceryItem b = new GroceryItem("meat", 2.99, false);
        GroceryItem c = new GroceryItem("cheese", 1.99, false);
        System.out.println(b.toString());
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));


    }


}
