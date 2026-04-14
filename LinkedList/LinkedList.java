package LinkedList;



public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node{
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }


    public  LinkedList (int value){
        Node newNode = new Node(value);
        head= newNode;
        tail= newNode;
        length = 1;
    }

    public  void printList(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.value + " ");
            temp=temp.next;
        }
        System.out.println();
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head=newNode;
            tail=newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(length==0){
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

     public boolean insert(int index , int value){
         if(index < 0 || index >length) return false;

         if(index==0){
             prepend(value);
             return true;
         }
         if(index==length){
             append(value);
             return true;
         }

         Node newNode = new Node(value);
         Node temp = get(index-1);
         newNode.next = temp.next;
         temp.next = newNode;
         length++;
         return true;


     }

    public Node removeLast(){
        if(length==0) return null;
        Node temp = head;
        Node pre = head;
        while (temp.next!=null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if(length == 0){
            head=null;
            tail=null;
        }
        return temp;
    }

    public Node removeFirst(){
        if(length==0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        if(length==0){
            tail = null;
        }
        return temp;
    }

    public Node remove(int index){
        if(index<0 || index>=length) return  null;
        if(index==0) {
            return  removeFirst();
        }
        if(index==length-1){
            return removeLast();
        }

        Node pre = get(index-1);
        Node temp = pre.next;
        pre.next = temp.next;
        temp.next=null;
        length--;
        return temp;


    }

    public Node get(int index){
        if(index<0 || index > length) return  null;
        Node temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index , int value){
        Node temp = get(index);
        if(temp!=null){
            temp.value = value;
            return true;
        }
        return  false;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for(int i = 0;i<length ;i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
    // tim node o giua
    public Node findMiddleNode(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // kiem tra co vong lap hay khong
    public Boolean hasLoop(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null ){
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast){
                return true;
            }
        }
        return false;
    }
    // xoa vi tri thu k tu cuoi len
    public Node findKthFromEnd(int k){
        Node slow = head;
        Node fast = head;

        for(int i=0;i<k;i++){
            if(fast==null){
                return null;
            }
            fast = fast.next;
        }

        while(fast !=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }
    // xoa trung lap
    public void removeDuplicates(){
        if(head==null){
            return;
        }
        Node current = head;

        while (current!=null){
            Node runner = current;
            while (runner.next!=null){
                if(current.value==runner.next.value){
                    runner.next = runner.next.next;
                }else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }

    }
    // chuyen doi nhi phan sang thap phan
    public int binaryToDecimal(){
        Node temp = head;
        int sum = 0;

        while(temp!=null){
            sum = sum * 2 + temp.value;
            temp = temp.next;
        }
        return sum;

    }
    public void partitionList(int x) {
       if(head==null) return;

       Node newNode1 = new Node(0);
       Node temp1=newNode1;
       Node newNode2 = new Node(0);
       Node temp2=newNode2;

       Node current = head;
       while(current!=null){
           if(current.value<x){
               temp1.next = current;
               temp1 = current;
           }else {
               temp2.next = current;
               temp2 = current;
           }
           current = current.next;
       }
       temp2.next=null;
       temp1.next = newNode2.next;
       head=newNode1.next;

    }

    public void reverseBetween(int startIndex, int endIndex) {
        // Check: If linked list is empty, nothing to reverse.
        // Exit the method.
        if (head == null) return;

        // Create a 'dummyNode' that precedes the head.
        // Simplifies handling edge cases.
        Node dummyNode = new Node(0);
        dummyNode.next = head;

        // 'previousNode' is used to navigate to the node
        // right before our sublist begins.
        Node previousNode = dummyNode;

        // Move 'previousNode' to node just before sublist.
        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }

        // 'currentNode' marks the first node of sublist.
        Node currentNode = previousNode.next;

        // Loop reverses the section from startIndex to endIndex.
        for (int i = 0; i < endIndex - startIndex; i++) {

            // 'nodeToMove' is the node we'll move to sublist start.
            Node nodeToMove = currentNode.next;

            // Detach 'nodeToMove' from its current position.
            currentNode.next = nodeToMove.next;

            // Attach 'nodeToMove' at the beginning of the sublist.
            nodeToMove.next = previousNode.next;

            // Move 'nodeToMove' to the start of our sublist.
            previousNode.next = nodeToMove;
        }

        // Adjust 'head' if the first node was part of sublist.
        head = dummyNode.next;
    }

    public void swapPairs(){

        if(head==null || head.next==null) return;

        Node nodeFake = new Node(0);
        nodeFake.next = head;

        Node temp = nodeFake;

        while (true){
            Node first = temp.next;
            Node second = first.next;

            first.next = second.next;
            second.next = first;
            temp.next = second;
            temp=first;
            if(temp.next!=null && temp.next.next!=null){
                first =first.next;
                second = first.next;
            }else {
                break;
            }
        }

        head = nodeFake.next;
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

}
