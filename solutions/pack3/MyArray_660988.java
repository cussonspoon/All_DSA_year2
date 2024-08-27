package solutions.pack3;

public class MyArray_660988 {
    protected int MAX_SIZE = 100000;
    protected int data[] = new int[MAX_SIZE];
    protected int size = 0;

    public MyArray_660988(int max) {
        data = new int[max];
        MAX_SIZE = max;
    }

    public MyArray_660988() {
        data = new int[MAX_SIZE];
    }

    public void add(int d) {
        if (size >= MAX_SIZE) {
            expand();
        }
        data[size] = d;
        size++;
    }

    public void insert(int d, int index) {
        if (size < MAX_SIZE) {
            for (int i = size; i > index; i--) { // Move the data after index
                data[i] = data[i - 1];
            }
            data[index] = d;
            size++;
        } else {
            System.out.println("Array is full");
        }
    }

    public int find(int d) {
        int index = 0;
        for (int element : data) {
            if (element == d) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public int binarySearch(int d) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (data[mid] == d) {
                return mid;
            }

            if (data[mid] < d) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public void delete(int index) {
        if (size == 0) {
            System.out.println("The array is empty");
        } else {
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            size--;
        }
    }

    boolean isFull() {
        if (size == data.length) {
            return true;
        } else {
            return false;
        }
    }

    boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void expandByK(int K) {
        int newSize = MAX_SIZE * K;
        int[] newData = new int[newSize];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
        MAX_SIZE = newSize;
    }

    public void expand() {
        int newSize = MAX_SIZE * 2;
        int[] newData = new int[newSize];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
        MAX_SIZE = newSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}