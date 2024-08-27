package solutions.pack4;
import java.util.ArrayList;

public class MyLinkedListTricky_660988 extends MyLinkedList_660988 {
    public void q1_rotate_counter_clockwise(int k) {
        while (k > 0) {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            add(p.data);
            delete(p.data);
            k--;
        }
    }

    public void q2_reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void q3_remove_dup() {
        Node current = head;
        while (current != null) {
            Node p = current.next;
            while (p != null) {
                if (current.data == p.data) {
                    delete(current.data);
                }
                p = p.next;
            }
            current = current.next;
        }

    }

    public void q4_add_one() {
        Node current = head;
        Node prev = null;
        int size = size() - 1;
        boolean added = false;
        while (size != 0) {
            current = head;
            prev = null;
            int size_inner = size;
            while (size_inner != 0) { // Defining current and prev
                prev = current;
                if (current.next != null){
                    current = current.next;
                }
                size_inner--;
            }
            if (!added){
                current.data++;
                added = true;
            }
            if (current.data == 10){
                current.data = 0;
                prev.data++;
            }
            size--;
        }
    }

    public boolean q5_isPalindrome(){
        int size = size();
        int loophalf = size/2 - 1;
        ArrayList<Integer> firsthalf = new ArrayList<>();
        ArrayList<Integer> secondhalf = new ArrayList<>();
        Node current = head;
        for (int i = 0; i <= loophalf; i++){
            firsthalf.add(current.data);
            current = current.next;

        }
        if (size % 2 == 1){
            current = current.next;
        }

        for (int i = 0; i <= loophalf; i++){
            secondhalf.add(current.data);
            current = current.next;
        }

        for (int element : firsthalf){
            if (element != secondhalf.get(loophalf)){
                return false;
            }
            loophalf--;
        }
        return true;
    }

}
