import java.util.*;

public class linkedlistpr {

    // implementation of a linked list from the scratch
    public static class node {
        // blueprint of class node
        int data;
        node next;

        public node(int data) { // basically this is the constructor of the class node
            this.data = data; // there is the initialisation of the data
            this.next = null;
        }
    }

    public static node head;
    public static node tail;
    public static int size;

    /*
     * ADDING THE FIRST NODE IN THE CLASS NODE
     * 
     * time complexity:- O(1) constant
     * 1.create new node
     * 2.new node's next =head
     * 3.head=new node
     */

    public static void addFirst(int data) {
        // step 1=create new node in the memory of the system
        node newnode = new node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
            return;
        }
        // step2 - newnode.next=head
        newnode.next = head; // link

        // step 3-head=newnode
        head = newnode;

    }

    /*
     * ADD LAST NODE IN THE LINKED LIST
     * time complexity:-O(1) constant
     * 
     * 1.create a node(newnode)
     * 2.tail.next=newnode
     * 3.tail=newnode
     */

    public static void addLast(int data) {
        node newnode = new node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
            return;
        }
        tail.next = newnode;
        tail = newnode;

    }

    // TO PRINT THE LINKED LIST
    // TIME COMPLEXITY:-O(n)

    public static void print() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
    }

    // ADD IN THE MIDDLE
    // add(index,data)
    /*
     * node temp=head
     * i=0
     * while(i<idx-1){
     * temp->next
     * i++
     * }
     * 
     * temp(prev)
     * 
     * 1.newnode's.next=temp.next
     * 2.temp.next=newnode
     */

    public static void add(int idx, int data) {

        if (idx == 0) {
            addFirst(data);
            return;
        }

        node newnode = new node(data);
        size++;
        node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        // i=idx-1; temp->prev
        newnode.next = temp.next;
        temp.next = newnode;
    }

    // Remove in a linked list

    public static int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;

        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // REMOVE LAST
    /*
     * prev.next=null
     * tail=prev
     */

    public static int removeLast() {
        if (size == 0) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // prev:i=size-2
        node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;// tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;

    }

    // SEARCH (ITERATIVE)
    /*
     * search for a key in a linked list.Return the position where it is found .if
     * not found ,then return -1
     */
    public int itrSearch(int key) {
        node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // SEARCH(RECURSIVE)
    /*
     * search for a key in a linked list.Return the position where it is found.if
     * not found,return -1.use recursion
     * 
     */
    // time complexity:-O(n)
    // space complexity:-O(n)

    public int helper(node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    /*
     * REVERSE ANY LINKED LIST
     * next=curr.next
     * curr.next=prev
     * prev=curr
     * curr=next
     */

    public void reverse() {
        node prev = null;
        node curr = tail = head;
        node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    /* FIND AND REMOVE Nth NODE FROM END */

    public void deleteNthfromEnd(int n) {
        // calculate size
        int sz = 0;
        node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if (n == sz) {
            head = head.next;// remove first
            return;
        }

        // size-n
        int i = 1;
        int iToFind = sz - n;
        node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;

    }

    // slow - fast approach
    public node findMid(node head) {
        node slow = head;
        node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;// +1
            fast = fast.next.next;// +2
        }
        return slow;// slow is my midnode
    }

    // TO CHECK WHEATHER THE LINKEDLIST IS PALINDROME OR NOT

    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        // step 1-find mid

        node midnode = findMid(head);

        // step2-reverse 2nd half
        node prev = null;
        node curr = midnode;
        node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // check if a palindrome or not

        node right = prev;// right half head
        node left = head;

        // step3- check left half & right half

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;

        }
        return true;
    }

    /*
     * DETECT LOOP/CYCLE IN A LL
     * FLOYD'S CYCLE FINDING ALGORITHM
     */

    public static boolean isCycle() { // Floyd's cycle finding algorithm
        node slow = head;
        node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;// +1
            fast = fast.next.next;// +2
            if (slow == fast) {
                return true;// cycle exist
            }

        }
        return false;// cycle does not exist
    }

    // REMOVE A CYCLE/LOOP IN A LINKED LIST

    public static void removeCycle() {
        // detect cycle
        node slow = head;
        node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                cycle = true;
                break;

            }
        }
        if (cycle == false) {
            return;
        }
        // find meeting point
        slow = head;
        node prev = null;// last node
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle-> last.next=null

        prev.next = null;
    }

    // MERGE SORT IN THE LINKED LIST

    private node getmid(node head) {
        node slow = head;
        node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;// mid node
    }

    private node merge(node head1, node head2) {
        node mergell = new node(-1);
        node temp = mergell;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergell.next;

    }

    public node mergeSort(node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        node mid = getmid(head);

        // left & right ms
        node righthead = mid.next;
        mid.next = null;
        node newleft = mergeSort(head);
        node newright = mergeSort(righthead);

        // merge
        return merge(newleft, newright);

    }

    // ZIGZAG IN THE LINKED LIST

    public void zigZag() {
        // find mid
        node slow = head;
        node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        node mid = slow;

        // reverse 2nd half

        node curr = mid.next;
        mid.next = null;
        node prev = null;
        node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node left = head;
        node right = prev;
        node nextl, nextr;

        // alt merge- zig-zag merge
        while (left != null && right != null) {
            nextl = left.next;
            left.next = right;
            nextr = right.next;
            right.next = nextl;

            left = nextl;
            right = nextr;

        }

    }

    public static void main(String args[]) {

        linkedlistpr ll = new linkedlistpr();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();
        // ll.head=ll.mergeSort(ll.head);
        ll.zigZag();
        ll.print();

        /*
         * head = new node(1);
         * head.next = new node(2);
         * node temp = new node(2);
         * head.next = temp;
         * head.next.next = new node(3);
         * // head.next.next.next=temp;
         * System.out.println(isCycle());
         * // removeCycle();
         * // System.out.println(isCycle());
         * // 1->2->3->1
         * /*
         * linkedlist ll=new linkedlist();
         * 
         * 
         * 
         * ll.addLast(1);
         * 
         * ll.addLast(2);
         * ll.addLast(2);
         * ll.addLast(2);
         * 
         * ll.print();
         * System.out.println(ll.checkPalindrome());
         * 
         * 
         */
        // ll.print();
        // System.out.println();
        // System.out.println(ll.size);
        // ll.removeLast();
        // ll.print();

        // System.out.println(ll.itrSearch(3));
        // System.out.println(ll.itrSearch(2));

        // System.out.println(ll.recSearch(3));
        // System.out.println(ll.recSearch(10));

        // ll.reverse();
        // ll.print();
        // ll.deleteNthfromEnd(3);
        // ll.print();

    }

}
