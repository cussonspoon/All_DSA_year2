package solutions.pack9;

public class MyHeapSort_660988 extends MyMinHeap_660988 {
    public String sort() {
        StringBuilder sb = new StringBuilder();
        int OriginalSize = size;

        for (int i = 0; i < OriginalSize; i++) {
            sb.append(remove()).append(" ");
        }
        return sb.toString();
    }
}
