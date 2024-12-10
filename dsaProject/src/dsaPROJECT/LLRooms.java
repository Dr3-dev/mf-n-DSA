package dsaPROJECT;

public class LLRooms {
    
	   LLRooms next; 
	   private final int RMNO;
	   private final String RMDESC;
	   private final String RMTYPE;
	   private final double PRICE;
	   private final String BOOKST; 

	  public LLRooms(int RMNO,String RMDESC, String RMTYPE, double PRICE, String BOOKST) {
	    this.RMNO = RMNO;
	    this. RMDESC = RMDESC;
	    this.RMTYPE = RMTYPE;
	    this.PRICE = PRICE;
	    this.BOOKST = BOOKST;
	    this.next = null;
	  }
	  
	  public int getRoomNum(){
	      return RMNO;
	  }
	  public String getDesc(){
	      return RMDESC;
	  }
	  public String getType(){
	      return RMTYPE;
	  }
	  public double getPrice(){
	      return PRICE;
	  }
	  public String getStat(){
	      return BOOKST;
	  }
	  
	  void hotelDisplay(){
	      System.out.println("=========================");
	      System.out.println("Room ID No.: " + getRoomNum());
	      System.out.println("Room Description: " + getDesc());
	      System.out.println("Room Type: " + getType());
	      System.out.println("Price: " + getPrice());
	      System.out.println("Book Status: " + getStat());
	      System.out.println("");
	  }
	}


class Singly {

    private static class Node {
        LLRooms hotel;
        Node next;

        // Constructor
        Node(LLRooms hotel) {
            this.hotel = hotel;
            this.next = null;
        }
    }

    private Node head;

    public Singly() {
        this.head = null;
    }
    public void insert(int rmno, String rmdesc, String rmtype, double price, String bookst) {
    LLRooms insert = new LLRooms(rmno, rmdesc, rmtype, price, bookst);
    Node newNode = new Node(insert);
    
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
        
            while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        }
    }
    
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
        
            while (temp != null) {
                temp.hotel.hotelDisplay();
                System.out.println(" -> ");
                temp = temp.next;
        }
        System.out.println("null");
        }
    }
    // Delete a node by value
    public void delete(int rmno) {
        if (head == null) {
        System.out.println("List is empty");
        return;
        }
        // If the node to be deleted is the head
        if (head.hotel.getRoomNum() == rmno) {
            head = head.next;
            System.out.println("Room " + rmno + " has been successfully deleted.");
            return;
        }
        Node temp = head;
        
        while (temp.next != null && temp.next.hotel.getRoomNum() != rmno) {
            temp = temp.next;
        }
        
        if (temp.next == null) {
            System.out.println("Element not found");
        } else {
        temp.next = temp.next.next;
        }
    }    
}


class Doubly {
    private static class Node {
        LLRooms hotel;
        Node next;
        Node prev;

        Node(LLRooms hotel) {
            this.hotel = hotel;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;

    public Doubly() {
        this.head = null;
    }
        // Insert a new node at the end
        public void addRoom(int rmno, String rmdesc, String rmtype, double price, String bookst) {
        LLRooms addRoom = new LLRooms(rmno, rmdesc, rmtype, price, bookst);
        Node newNode = new Node(addRoom);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
            temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
}
}
        // Display the linked list in forward direction
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            
            Node temp = head;
        
            while (temp != null) {
                temp.hotel.hotelDisplay();
                System.out.println(" <-> ");
                temp = temp.next;
            }
        System.out.println("null");
        }
    }
    // Display the linked list in backward direction
    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
       
            while (temp.next != null) {
                temp = temp.next;
        }
        
            while (temp != null) {
                temp.hotel.hotelDisplay();
                System.out.println(" <-> ");
                temp = temp.prev;
        }
            System.out.println("null");
        }
    }
    // Delete a node by value
    public boolean delete(int rmno) {
        if (head == null) {
            System.out.println("List is Empty!");
            return false;
        }
        Node temp = head;
        // If the node to be deleted is the head
        if (head.hotel.getRoomNum() == rmno) {
            head = head.next; 
            System.out.println("Room " + rmno + " has been successfully deleted.");
            return true;
        }
        
        while (temp.next != null && temp.next.hotel.getRoomNum() != rmno) {
            temp = temp.next;
        }
        
        if (temp.next == null) {
            System.out.println("Element not found");
        } else {
        temp.next = temp.next.next;
        }
        return false;
    }
}