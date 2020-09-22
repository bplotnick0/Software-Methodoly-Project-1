import java.lang.*;

public class ShoppingBag {
    private GroceryItem[] bag; // array-based implementation of the bag
    private int size; // number of items currently in the bag


    public ShoppingBag() {
        this.bag = new GroceryItem[5];
        this.size = 0;
    }

    private int find(GroceryItem item) { // helper method to find an item
        for (int i = 0; i < size; i++) {
            if (bag[i].name.equals(item.name)) {
                return i;
            }
        }
    }

    private void grow() {
        int bagSize = bag.length;
        GroceryItem[] temp = new GroceryItem[bagSize + 5];
        System.arraycopy(bag, 0, temp, size);
        bag = temp;
    } // helper method to grow the capacity

    public void add(GroceryItem item) {
        if (size == bag.length) {
            grow();
        }
        bag[size] = item;
        size++;
    }

    public boolean remove(GroceryItem item) {
        int itemIndex = find(item);
        if (itemIndex == null) {
            return false;
        }
        bag[itemIndex] = bag[size - 1];
        bag[size - 1] = null;
        size--;
        return true;
    }

    public double salesPrice() { // sales total; the sum of the prices in the bag
        double total = 0;
        for (int i = 0; i < size; i++) {
            total = total + bag[i].getPrice();
        }
        return total;
    }

    public double salesTax() { // sales tax total of the taxable items in the bag
        double total = 0;
        for (int i = 0; i < size; i++) {
            if (bag[i].taxable) {
                total = total + bag[i].price;
            }
        }
        return total;
    }

    public void print() {
        if (size == 0){
            System.out.println("The bag is empty!");
        } else {
            System.out.println("You have " + size + " item(s) in the bag: ");
            for (i = 0; i < size; i++){
                System.out.println(bag[i]);
            }
            System.out.println("**End of list");
        }
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}