/**
 ShoppingBag class holds an array of GroceryItems
 Its functions include adding/removing items, calculating tax and price of items in bag and printing the contents of the bag.
 @author Ben Plotnick, Michael Sherbine
 **/

import java.lang.*;

public class ShoppingBag {
    private GroceryItem[] bag; // array-based implementation of the bag
    private int size; // number of items currently in the bag

    /**
     ShoppingBag constructor instantiates a new GroceryItem array of size 5 and
     sets the size (amount of items in the bag) to 0.
     **/
    public ShoppingBag() {
        this.bag = new GroceryItem[5];
        this.size = 0;
    }

    /**
     The remove method calls this method to find the index of the item to be removed
     @param item to be removed
     @return index of item in bag array or -1 if item is not in bag
     **/

    private int find(GroceryItem item) { // helper method to find an item
        for (int i = 0; i < size; i++) {
            if (bag[i].getName().equals(item.getName()) && bag[i].getPrice() == item.getPrice()) {
                return i;
            }
        }
        return -1;
    }

    /**
     Increases capacity by 5 if number of items exceeds the size of the array
     **/
    private void grow() {
        int bagSize = bag.length;
        GroceryItem[] temp = new GroceryItem[bagSize + 5];
        System.arraycopy(bag, 0,temp,0,size);
        bag = temp;
    } // helper method to grow the capacity

    /**
    Adds GroceryItem to bag
     @param item to be added
     **/
    public void add(GroceryItem item) {
        if (size == bag.length) { // check if number of items is = to current size of the bag
            grow();
        }
        bag[size] = item; // place item at end of the bag
        size++;
    }

    /**
    Removes item from bag
     @param item to be removed
     @return true if item was removed, false if item was not found in bag
     **/

    public boolean remove(GroceryItem item) {
        int itemIndex = find(item);
        if (itemIndex == -1) {
            return false;
        }
        bag[itemIndex] = bag[size - 1]; //replace item removed with item at end of bag
        bag[size - 1] = null;
        size--;
        return true;
    }

    /**
     Calculate the sum of the prices in the bag
     @return total price
     **/

    public double salesPrice() { // sales total; the sum of the prices in the bag
        double total = 0;
        for (int i = 0; i < size; i++) {
            total = total + bag[i].getPrice();
        }
        return total;
    }
    /**
     Calculate sales tax of taxable items
     @return total sales tax
     **/
    public double salesTax() { // sales tax total of the taxable items in the bag
        double totalTax = 0;
        for (int i = 0; i < size; i++) {
            if (bag[i].getTaxable()) {
                totalTax = totalTax + bag[i].getPrice() * 0.06625;
            }
        }
        return totalTax;
    }

    /**
     Prints items in the bag to console
     **/
    public void print() {
        if (size == 0){
            System.out.println("The bag is empty!");
        } else {
            System.out.println("You have " + size + " item(s) in the bag: ");
            for (int i = 0; i < size; i++){
                System.out.println(bag[i]);
            }
            System.out.println("**End of list");
        }
    }

    public int getSize() {
        return size;
    }

    public GroceryItem[] getBag(){
        return bag;
    }

        public static void main (String[]args){ //testbed main
            GroceryItem a = new GroceryItem("meat", 2.99, false);
            GroceryItem b = new GroceryItem("milk", 2.99, true);
            GroceryItem c = new GroceryItem("cheese", 1.99, false);
            GroceryItem d = new GroceryItem("meat", 2.99, false);
            GroceryItem e = new GroceryItem("chicken", 2.99, true);
            GroceryItem f = new GroceryItem("salmon", 1.00, true);
            ShoppingBag bag = new ShoppingBag(); // test the constructor

            bag.add(a); // test the add method
            bag.add(b);
            bag.add(c);
            bag.add(d);
            bag.add(e);
            bag.add(f); // added 6 items to test the grow method
            bag.print(); // test the print method and to check all 6 items are in the bag

            System.out.println("Remove test true: " + bag.remove(c));// test remove method true case
            GroceryItem g = new GroceryItem("bread", 1.00, true); // create new item not to be added to check false case of remove
            System.out.println("Remove test false: " + bag.remove(g));// test remove method false case

            System.out.println("Item index: " + bag.find(a)); // test find method

            System.out.println("Size before grow method: " + bag.getBag().length);//test grow method
            bag.grow();
            System.out.println("Size after grow method: " + bag.getBag().length);//test grow method

            System.out.println("Tax: " + bag.salesTax());// test the salesTax() method
            System.out.println("Sales price: " + bag.salesPrice());// test the salesPrice() method


        }
    }
