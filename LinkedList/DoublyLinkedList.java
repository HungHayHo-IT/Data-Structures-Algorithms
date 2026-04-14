package LinkedList;

public class DoublyLinkedList {
     class Node {
         int value;
         Node next;
         Node prev;

         Node (int value){
             this.value = value;
         }
     }
     private Node head;
     private Node tail ;
     private int length;

     public DoublyLinkedList(int value){
         Node newNode = new Node(value);
         head = newNode;
         tail = newNode;
         length = 1;
     }
    public  void getHead(){
        System.out.println("Head: " +head.value);
    }

    public  void getTail(){
        System.out.println("Tail: " +tail.value);
    }

    public  void getLength(){
        System.out.println("Length: " +length);
    }
    public  void printList(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.value + " ");
            temp=temp.next;
        }
        System.out.println();
    }
    public Node get(int index){
         if(index<0 || index>=length) return null;
         Node temp = head;
         if(index<length/2){
             for(int i=0;i<index;i++){
                 temp = temp.next;
             }
         }else{
             temp = tail;
             for(int i=length-1;i>index;i--){
                 temp = temp.prev;
             }
         }
         return  temp;
    }
    public boolean set(int index , int value){
         Node temp = get(index);
         if(temp!=null){
             temp.value = value;
            return true;
         }
         return false;

    }
    public boolean insert(int index , int value){
           if(index< 0 || index>length) return false;
           if(index==0){
               prepend(value);
               return true;
           }
           if(index==length){
               append(value);
               return true;
           }
           Node newNode = new Node(value);
           Node before = get(index-1);
           Node after = before.next;

           newNode.next = after;
           newNode.prev = before;
           before.next = newNode;
           after.prev = newNode;
           length++;
           return true;

    }
    public Node remove(int index){
        if(index< 0 || index>=length) return null;
        if(index==0){
            return removeFirst();
        }
        if(index == length-1){
            return removeLast();
        }
        Node temp = get(index);
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        length--;
        return  temp;

    }

    public void append(int value){
         Node newNode = new Node(value);
         if (length==0){
             head = newNode;
             tail = newNode;
         }else {
             tail.next = newNode;
             newNode.prev = tail;
             tail = newNode;
         }
         length++;
    }
    public Node removeFirst(){
          if(length==0) return null;
          Node temp = head;
          if(length==1){
              head=null;
              tail=null;
          }else{

              head = head.next;
              head.prev=null;
              temp.next = null;
          }
          length--;
          return temp;
    }

    public Node removeLast(){
         if(length==0) return null ;
         Node temp = tail;
         if(length==1){
             head=null;
             tail=null;
         }else {
             tail = tail.prev;
             tail.next=null;
             temp.prev = null;
         }
         length--;
         return temp;
    }


    public void prepend(int value){
        Node newNode = new Node(value);
        if(length==0){
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public boolean isPalindrome(){
         if(head ==null) return false;
         if (length<=1) return true;

         Node dau = head;
         Node cuoi = tail;
         while(dau!=cuoi && dau.prev!=cuoi){
             if(dau.value!=cuoi.value){
                 return false;
             }
             dau=dau.next;
             cuoi=cuoi.prev;
         }
         return true;
    }

    public void reverse() {
        // If the list is empty or has only one node, no need to reverse
        if (head == null || head == tail) {
            return;
        }

        // Initialize current node starting from head
        Node current = head;
        Node temp = null;

        // Traverse through the list and swap next and prev pointers for each node
        while (current != null) {
            // Store the previous node temporarily
            temp = current.prev;

            // Swap the next and prev pointers
            current.prev = current.next;
            current.next = temp;

            // Move to the next node (which is actually the previous node after swapping)
            current = current.prev;
        }

        // Swap head and tail pointers
        temp = head;
        head = tail;
        tail = temp;
    }
}
