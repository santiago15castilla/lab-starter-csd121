import static java.lang.IO.*;                        //In this program allows me to use the println function without the System.out
import java.io.FileWriter;                           //write files
import java.io.IOException;                          //handle write errors
import java.util.ArrayList;                          //dynamic list (pretty similar to python lists)
import java.util.Scanner;                            //read user's input

/**
 * Shopping List
 * Create a shopping list and write it in a file txt.
 */
class ShoppingList {                                 //class declaration
    /**
     * Counts the total number of items in the shopping list.
     * @param items ArrayList containing shopping items
     * @return The total count of items
     */
    static int countItems(ArrayList<String> items) {      //static class (not an object)
        return items.size();                              //A list of strings as parameters and returns an int which represents the # of items
    }                                                     //size returns how many elements are in the list

    /**
     * Runs the shopping list program.
     */
    void main() {                                   //Like in python, this main function runs our program, this is the place for the loops and main functionality.
        Scanner scanner = new Scanner(System.in);   //reads keyboard input (system.in is like a standard input)
        ArrayList<String> shoppingList = new ArrayList<>();  //List to store strings
        String userInput = "";                      //variable to store the user's input
        int itemnumber = 1;                         //counting number of items starting in 1

        println("\n (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧SHOPPING LIST 📝 \n");        //Prints to interact with the user
        println("Enter items for your shopping list.");
        println("Type 'done' when finished.\n");
                                                       //trim removes any spaces and cleans the input
        while (!userInput.trim().equalsIgnoreCase("done")) { //This while runs as long as the user's input is different to 'done'. The 'ignoreCase' allows us to get inputs in lower or upper case
            try {                                      //inside the while loop we create a try loop for error handling
                print("Item " + itemnumber + ": ");    //prints the 'itemnumber' variable
                userInput = scanner.nextLine();

                if (!userInput.equalsIgnoreCase("done") && !userInput.trim().isEmpty()) { //checks if the input was 'done' and if the list is not empty.
                    shoppingList.add(userInput);      //adds the input to the list
                    itemnumber++;
                } else if (userInput.trim().isEmpty()) {
                    println("Please enter a valid item.\n");
                }
            } catch (Exception e) {                   //catch is the equivalent to "except" in python.
                println("Error: " + e.getMessage());
            }
        }


        if (shoppingList.isEmpty()) {             // Check if our list is empty and if is true, print the text below.
            println("\nNo items added. Please add your shopping items.");
            scanner.close();
            return;
        }


        println("\n YOUR SHOPPING LIST ✅");    //if this line runs is because the loop above was finished. these prints are just a friendly list resume with the user.
        println("Total items: " + countItems(shoppingList));  //prints the variable that contains the # of items
        println();

        for (int i = 0; i < shoppingList.size(); i++) {       //loop in the list to display its items and increment 1 in each loop.
            println((i + 1) + ". " + shoppingList.get(i));
        }

        try {                                                               //Similar error handle than in python, try block to write the file.
            FileWriter writer = new FileWriter("shopping_list.txt"); //create a new file with the "shopping_list.txt" name. if the file already exists. it rewrites it.
            writer.write("MY SHOPPING LIST 📝\n");

            for (int i = 0; i < shoppingList.size(); i++) {    //Same logic as console printing.
                writer.write((i + 1) + ". " + shoppingList.get(i) + "\n");
            }

            writer.write("\nTotal items: " + countItems(shoppingList));  //after write all the items, it prints in the file the # of items.
            writer.close();

            println("\nList saved to 'shopping_list.txt'");                  //print confirming to the user that the file was created successfully.

        } catch (IOException e) {                                       //Handle file errors. Again pretty similar than in Python, just different syntax.
            println("Error saving file: " + e.getMessage());
        }

        scanner.close();                                                 //program end
        println("Done!");
}    }