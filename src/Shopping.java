/**
 Shopping class handles input and output
 @author Ben Plotnick, Michael Sherbine
 **/
import java.util.Scanner;

public class Shopping {

    /**
     Runs the application
     **/
    public void run() {
        Scanner myObj = new Scanner(System.in);
        String input;
        ShoppingBag bag = new ShoppingBag(); // create ShoppingBag
        System.out.println("Lets start shopping!");
        while (!((input = myObj.nextLine()).equals("Q"))) {// while user does not input "Q" keep listening for input
            String[] inputString = input.split("\\s+"); //split input string into array

            if (inputString[0].equals("A") ) { // if user enters "A" create GroceryItem and add it to bag
                GroceryItem item = new GroceryItem(inputString[1], Double.parseDouble(inputString[2]), Boolean.parseBoolean(inputString[3]));
                bag.add(item);
                System.out.println(item.getName() + " added to bag");

            } else if(inputString[0].equals("R")){// if user enters "R" create GroceryItem with entered input and attempt to remove item
                GroceryItem item = new GroceryItem(inputString[1], Double.parseDouble(inputString[2]), Boolean.parseBoolean(inputString[3]));
                boolean remove = bag.remove(item);
                if(remove){
                    System.out.println(item.getName() + " " + item.getPrice() + " removed.");
                } else {
                    System.out.println("Unable to remove, this item is not in the bag.");
                }
            } else if(inputString[0].equals("P")) { // if user enters "P" print items in bag
                System.out.println("You have " + bag.getSize() + " item(s) in the bag: ");
                bag.print();
                System.out.println("** End of list");
            } else if(inputString[0].equals("C")){ // if user enters "C" print items and calculate total price
                if (bag.getSize() == 0){
                    System.out.println("Unable to check out, the bag is empty!");
                } else {
                    System.out.println("Checking out " + bag.getSize() + " item(s) in the bag: ");
                    bag.print();
                    System.out.println("Sales total: " + "$ " + String.format("%.2f", bag.salesPrice()));
                    System.out.println("Sales tax: " + "$" + String.format("%.2f", bag.salesTax()));
                    double totalPaid = bag.salesPrice() + bag.salesTax();
                    System.out.println("Total amount paid: " + "$" + String.format("%.2f", totalPaid));
                }
            } else { // if user enters anything else print invalid command
                System.out.println("Invalid command!");
            }
        }

        System.out.println("Thanks for shopping with us!");
    }
}
