public class MinHeapSort {

    public static void minHeapify(int[] A, int i, int heapSize) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;

        if (left < heapSize && A[left] < A[smallest])
            smallest = left;

        if (right < heapSize && A[right] < A[smallest])
            smallest = right;

        if (smallest != i) {
            int temp = A[i];
            A[i] = A[smallest];
            A[smallest] = temp;
            minHeapify(A, smallest, heapSize);
        }
    }

    public static void buildMinHeap(int[] A) {
        int n = A.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapify(A, i, n);
        }
    }

    public static void heapSort(int[] A) {
        buildMinHeap(A);
        int heapSize = A.length;

        for (int i = A.length - 1; i >= 1; i--) {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;

            heapSize--;
            minHeapify(A, 0, heapSize);
        }
    }

    public static void printArray(int[] A) {
        for (int num : A)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = {5, 3, 8, 4, 1, 2};
        System.out.println("Original array:");
        printArray(A);
        heapSort(A);
        System.out.println("Sorted array (Descending using Min-Heap):");
        printArray(A);
    }
}
