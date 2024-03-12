public class DoubleLL {

    private Node head;
    private Node tail;
    private int size;

    public DoubleLL() {
        this.size = 0;
    }

    public void insertAtFirst(int value){
        Node node = new Node(value);
        if(head!=null){
            node.next = head;
            head.prev = node;
            head = node;

            tail = node;
        } else {
            head=node;
            if(tail==null)
                tail=node;
        }
        size++;
    }

    public void insertAtLast(int value) {
        if(head==null){
            insertAtFirst(value);
            return;
        }
        Node node = new Node(value);
        node.prev = tail;
        tail.next = node;
        tail = node;
        size++;
    }
    
    public void insertAtIndex(int index, int value) {
        if(index ==  1)
        {
            insertAtFirst(value);
            return;
        } else if (index == size+1) {
            insertAtLast(value);
            return;
        } else {
            Node node = new Node(value);
            Node temp = head;
            for(int i=1;i<index-1;i++){
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next.prev = node;
            node.prev = temp;
            temp.next = node;
        }
        size++;
    }
    
    public void deleteAtFirst(){
        if(head==null)
            return;
        head = head.next;
        head.prev = null;
        size--;
    }

    public void deleteAtLast() {
        if(tail == null)
            return;
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public void deleteAtIndex(int pos) {
        if(pos == 1){
            deleteAtFirst();
            return;
        }
        if(pos == size){
            deleteAtLast();
            return;
        }
        Node curr = head;
        for(int i=1;i<pos;i++){
            curr = curr.next;
        }
        curr.prev.next = curr.next;
        if(curr.next!=null){
            curr.next.prev = curr.prev;
        }
        size--;
    }
    
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.print("END");
        
    }

    public void displayInReverse(){
        Node temp = tail;
        while(temp!=null){
            System.out.print(temp.value+" -> ");
            temp = temp.prev;
        }
        System.out.print("END");
    }

    @SuppressWarnings("unused")
    private class Node {
        private int value;
        private Node next;
        private Node prev;
        
        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node(int value) {
            this.value = value;
        }
        
        public Node(int value, DoubleLL.Node next) {
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
        DoubleLL list = new DoubleLL();
        list.insertAtIndex(1,1);
        list.insertAtIndex(2,2);
        list.insertAtLast(4);
        list.insertAtLast(5);
        list.insertAtLast(6);
        list.insertAtLast(7);
        list.insertAtIndex(3, 3);
        list.deleteAtIndex(5);
        list.display();
        System.err.println();
        list.displayInReverse();
    }
}
