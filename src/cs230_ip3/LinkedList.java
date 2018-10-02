/*
$Tommy Prevatt
 */
package cs230_ip3;

public class LinkedList {

    Node head;
    Node next;
    LinkedList list;

    /*
    This method allows one to add a node to the back of the linked list.
     */
    public void append(Node nodeObj) {
        if (head == null) {
            head = nodeObj;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = nodeObj;

    }

    /*
    Some call this a "prepend" method (although prepend isn't actually a word). 
    This creates a stack by putting a new node into the first position of a linked
    list. This is a "last in first out" approach. 
     */
    public void push(Node nodeObj) {
        Node newHead = nodeObj;
        newHead.next = head;
        head = newHead;

    }

    /*
    This removes, or "POPS" the first node in the linked list. It also returns 
    that node in case the data from it is needed for any purpose. 
     */
    public Node pop() {
        Node tempNode = head;
        head = head.next;
        return tempNode;

    }

    /*
    Counts the length of the node. Some choose to have an iterative static integer
    that iterates with each node added. I just think it's easier to program using
    a method instead of having to use a dot notation and find the appropriate veriable.
    
    If I did this over, I would use the word "size" instead of length...
     */
    public int length() {
        Node current = head;
        int i = 0;
        while (current != null) {
            i++;
            current = current.next;
        }
        return i;
    }

    /*
    Removes the node form the index specified. 
     */
    public Node remove(int i) {
        Node currentNode = head;
        int indexCounter = 0;
        int targetIndex = i - 1;
        if (i == 0) {
            pop();
            return currentNode;
        }
        /* why doesn't this section work if chosing to remove the
                            index after the last available node?
        
        if(i<0 || i > length()){
            System.out.println("There is no such node.");
            return;
        }*/
        if (currentNode != null) {
            while (indexCounter < targetIndex && currentNode.next != null) {
                indexCounter++;
                currentNode = currentNode.next;
            }
            if (indexCounter == targetIndex) {
                Node tempNode = currentNode.next;
                currentNode.next = currentNode.next.next;
                return tempNode;
            }
        }
        return currentNode;
    }

    /*
    this sorts the list using the insertion sort method. 
     */
    public void sort() {
        for (int i = 1; i < length(); i++) {
            int n = i;
            Node temp;
            while (n > 0 && get(n - 1).getName().compareTo(get(n).getName()) > 0) {
                temp = remove(n);
                add(n - 1, temp);
                n = n - 1;
            }
        }
    }

    /*
    this adds a node at the index specified. 
     */
    public void add(int i, Node newNode) {
        Node currentNode = head;
        int indexCounter = 0;
        int targetIndex = i - 1;
        if (currentNode != null) {
            while (indexCounter < targetIndex && currentNode.next != null) {
                indexCounter++;
                currentNode = currentNode.next;
            }
            if (indexCounter == targetIndex) {
                newNode.next = currentNode.next;
                currentNode.next = newNode;
            } else if (i == 0) {
                push(newNode);
            }
        } else if (i == 0) {
            head = newNode;
        }
    }

    /*
    this retrieves a node at the specified index.
     */
    public Node get(int index) {
        if (index < 0 || index > length()) {
            System.out.println("The requested node is outside of the list");
            Node nullNode = null;
            return nullNode;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /*
    This displays the contents of the entire linked list. It uses the overridden
    toString() method in the Node class. 
     */
    public void displayLink() {
        Node current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    /*
    This prints only the names of the contributors in the nodes. This is a requirement
    of IP3.
     */
    public void printAllNames() {
        Node current = head;
        while (current != null) {
            System.out.println(current.name);
            current = current.next;
        }
    }

}
