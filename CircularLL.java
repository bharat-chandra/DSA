@SuppressWarnings("unused")
public class CircularLL {
    private Node head;
    private Node tail;
    private int size;

    public CircularLL() {
        this.size = 0;
    }

    public void insertAtFirst(int value){
        Node node = new Node(value);
        if(head==null){
            head=node;
            tail=node;
            size++;
            return;
        }
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void insertAtLast(int value){
        Node node = new Node(value);
        if(head == null){
            head = node;
        }
        if(tail == null){
            tail = node;
        }
        tail.next = node;
        node.next = head;
        tail = node;
        size++;
    }

    public void insertAtIndex(int index, int value){
        if(index == 1){
            insertAtFirst(value);
            return;
        }
        if(index == size+1){
            insertAtLast(value);
            return;
        }
        Node node = new Node(value);
        Node temp = head;
        for(int i = 1; i < index -1 ; i++){
            temp = temp.next;
            // System.out.println("currently at : "+temp.value);
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public void display(){
        Node temp = head;
        do{
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        } while(temp!=head);
        System.out.print("END");
    }
    
    public void deleteAtFirst(){
        if(head == null){
            return;
        } else {
            head = head.next;
        }
        size--;
    }

    public void deleteAtLast(){
        Node temp = head;
        if(head == null){
            return;
        } else if(head.next == null){
            head = null;
            return;
        } else {
            while(temp.next.next!=null)
                temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        System.out.println(tail.value);
        size--;
    }
    
    public void deleteAtIndex(int pos){
        Node temp = head;
        for(int i=1;i<pos-1;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    private class Node {

        private int value;
        private Node next;
        
        public Node(int value) {
            this.value = value;
        }
        
        public Node(int value, CircularLL.Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }
    public static void main(String[] args) {
       CircularLL list = new CircularLL();
        list.insertAtLast(1);
        list.insertAtLast(2);
        list.insertAtLast(3);
        list.insertAtLast(5);
        list.insertAtIndex(4,4);
        list.deleteAtIndex(5);
        list.display();
    }
}
