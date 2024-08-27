package solutions.pack4;

public class MyLinkedList_660988 {
    public class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
        }
    }

    Node head = null;

    public int size() {
        Node p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    public void add(int d) {
        Node p = new Node(d);
        p.next = head;
        head = p;
    }

    public void add(int[] d) {
        int length = d.length;
        while (length > 0) {
            Node p = new Node(d[length - 1]);
            p.next = head;
            head = p;
            length--;
        }
    }

    public void insert(int d) {
        Node newNode = new Node(d);
        if (head == null || head.data >= d) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node p = head;
        while (p.next != null && p.next.data < d) {
            p = p.next;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insert(int[] d) {
        for (int element : d) {
            insert(element);
        }
    }

    public void delete(int d) {
        Node p = head;
        while (p.next != null) {
            if (p.next.data == d) {
                p.next = p.next.next;
                return;
            }
            p = p.next;
        }
    }

    public int find(int d) {
        int count = 0;
        Node p = head;
        while (p != null) {
            if (p.data == d) {
                return count;
            }
            count++;
            p = p.next;
        }
        return -1;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("head ");
        Node p = head;
        while (p != null) {
            sb.append("--> [");
            sb.append(p.data);
            sb.append("] ");
            p = p.next;
        }
        sb.append("-> null");
        return new String(sb);
    }
}
