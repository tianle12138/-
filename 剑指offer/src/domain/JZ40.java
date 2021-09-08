package domain;

public class JZ40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        heapSort(arr);
        for (int i = 0; i < k; i++) {
            res[i] = arr[arr.length - 1 - i];
        }
        return  res;
    }

    private void heapSort(int[] arr) {
        initMinHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            minHeapify(arr, 0, i);
        }
    }

    private void initMinHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            minHeapify(arr,i,arr.length);
        }
    }

    private void minHeapify(int[] arr, int i, int heapSize) {
        int lchild = 2*i + 1;
        int rchild = lchild + 1;
        int minIndex = i;
        if (lchild < heapSize && arr[minIndex] > arr[lchild]) {
            minIndex = lchild;
        }
        if (rchild < heapSize && arr[minIndex] > arr[rchild]) {
            minIndex = rchild;
        }
        if(minIndex != i){
            swap(arr,i,minIndex);
            minHeapify(arr,minIndex,heapSize);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
