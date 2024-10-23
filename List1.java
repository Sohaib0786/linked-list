public class List1 {

    static class node {
        int data;
        node next;

        public node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static node head = null;
    public static node tail = null;
    public static int size = 0;

    public static void addFirst(int data) {
        node newnode = new node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
        } else {
            newnode.next = head;
            head = newnode;
        }

    }

    public static void addLast(int data) {
        node newnode = new node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
        } else {
            tail.next = newnode;
            tail = newnode;
        }
    }

    public static void printlist(node head) {
        node temp = head;
        while (temp != null) {
            System.err.print(temp.data + "->");
            temp = temp.next;

        }
        System.out.print("null");
    }

    public static int calsize(node head) {
        node temp = head;
        int s = 0;
        while (temp != null) {
            s++;
            temp = temp.next;
        }

        return s;
    }

    public static void main(String args[]) {

        List1 ll = new List1();
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.addLast(6);

        ll.printlist(head);
        int result = ll.calsize(head);
        System.out.println();
        System.out.println(result);

    }

}
