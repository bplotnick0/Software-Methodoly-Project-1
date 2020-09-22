public class GroceryItem {
    private String name;
    private double price;
    private boolean taxable;

    public GroceryItem (String name, double price, boolean taxable) {
        this.name=name;
        this.price=price;
        this.taxable=taxable;
    }

... public boolean equals(Object obj){
        if (!(obj instanceof GroceryItem)){
            return false;
        }else if (((GroceryItem) obj).name == this.name && ((GroceryItem) obj).price == this.price && ((GroceryItem) obj).taxable == this.taxable) {
            return true;
        }else {
            return false;
        }

    }
    public String toString() {
        return ("itemName:" + " " + name + " " + "$" + price + " " + ":" + " tax free");

    }

    public static void main (String[] args){
        GroceryItem b = new GroceryItem("meat", "2.99", "false");
        System.out.println(b.toString());


    }
...

}
