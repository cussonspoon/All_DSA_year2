package Labs;

import solutions.pack4.MyLinkedList_660988;
// import solutions.pack3_ArrAndList.MyLinkedListTricky;

public class Lab4a_LinkedList {
    public static void main(String[] args) {
        System.out.println("\n-demo1--------");
        demo1();
        System.out.println("-demo2--------");
        demo2();
    }
    static void demo1() {
        MyLinkedList_660988 list = new MyLinkedList_660988();
        list.add(5);
        list.add(1);
        list.insert(4);
        list.insert(3);
        System.out.println(list);
        list.delete(2);
        System.out.println("5 is at " + list.find(5));
        System.out.println(list);
    }
    static void demo2() {
        int [] arr = {50,40,30,20,10};
        MyLinkedList_660988 mList = new MyLinkedList_660988();
        mList.insert(arr);
        System.out.println(mList);
    }
}