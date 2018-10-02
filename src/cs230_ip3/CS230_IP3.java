package cs230_ip3;

import java.io.*;
import java.util.*;

public class CS230_IP3 {

    public static void main(String[] args) throws FileNotFoundException, IOException, NullPointerException {

        /*
        This next section creates a buffered reader object and calls on the inbut method. 
        That input method reads the file and creates new nodes out of the data. 
         */
        Node nodeObj = null;
        File file = new File("contributors.csv");
        FileReader reader = new FileReader(file);
        BufferedReader buffered = new BufferedReader(reader);

        String line = buffered.readLine();
        LinkedList link = new LinkedList();
        while (line != null) {
            nodeObj = input(line);
            link.push(nodeObj); //change "push" to "append" to change order of list creation.
            line = buffered.readLine(); //goes to next line in file for next iteration
        }

        /*
        This next section of code uses the different methods in the LinkedList class
        to add and sort the nodes in the LinkedList object. The standard output will
        also display what is happening. No input is required for this program.
         */
        System.out.println("The list in stack form is:");
        System.out.println();
        link.displayLink();
        System.out.println();
        System.out.println("Sorted alphabetically using insertion sort:");
        System.out.println();
        link.sort();
        link.displayLink();
        System.out.println();
        System.out.println("This tests the \"printAllNames()\" method which prints the names");
        System.out.println();
        link.printAllNames();
        System.out.println();
        Node oneNode = new Node("Albert Howrey", "Paris", "France", "9106787654", 42, 1234);
        System.out.println("This tests the \"add()\" method which inserts a new node at an index");
        System.out.println("We will add this node: " + oneNode);
        System.out.println();
        link.add(3, oneNode);
        link.printAllNames();
        System.out.println();
        System.out.println("Oops! Now they're out of order again!");
        System.out.println("Better fix that with the \"sort()\" method!");
        System.out.println();
        link.sort();
        link.printAllNames();
        System.out.println();
        System.out.println("That's better!");

    }

    /*
    This method is the input() method. it is used to parse the csv file and input
    the data into nodes.
     */
    private static Node input(String line) {

        String name;
        String city;
        String country;
        String phone;
        double contrib;
        int id;

        StringTokenizer st = new StringTokenizer(line, ",");
        name = st.nextToken();
        city = st.nextToken();
        country = st.nextToken();
        phone = st.nextToken();
        contrib = Double.parseDouble(st.nextToken());
        id = Integer.parseInt(st.nextToken());
        Node tempNode = new Node(name, city, country, phone, contrib, id);
        return tempNode;
    }

}
