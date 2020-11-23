package com.practice.arrays.week1.set2;

import java.util.Arrays;

// time O( n * k * log k), space O(k)
class MinHeapNode{
    int element; // The element to be stored

    // index of the array from
    // which the element is taken
    int i;

    // index of the next element
    // to be picked from array
    int j;

    public MinHeapNode(int element, int i, int j){
        this.element = element;
        this.i = i;
        this.j = j;
    }
}

class MinHeap{
    MinHeapNode[] heapArray;
    int heap_size;

    // Constructor: Builds a heap from
    // a given array a[] of given size
    public MinHeap(MinHeapNode[] a, int size){
        heap_size = size;
        heapArray = a;
        int i = (heap_size - 1)/2;
        while (i >= 0)
        {
            MinHeapify(i);
            i--;
        }
    }

    // A recursive method to heapify a subtree
    // with the root at given index This method
    // assumes that the subtrees are already heapified
    void MinHeapify(int i){
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && heapArray[l].element < heapArray[i].element)
            smallest = l;
        if (r < heap_size && heapArray[r].element < heapArray[smallest].element)
            smallest = r;
        if (smallest != i)
        {
            swap(heapArray, i, smallest);
            MinHeapify(smallest);
        }
    }
    int left(int i) {
        return (2*i + 1);
    }

    int right(int i) {
        return (2*i + 2);
    }

    MinHeapNode getMin(){
        if(heap_size <= 0)
        {
            System.out.println("Heap underflow");
            return null;
        }
        return heapArray[0];
    }

    void replaceMin(MinHeapNode root) {
        heapArray[0] = root;
        MinHeapify(0);
    }

    void swap(MinHeapNode[] arr, int i, int j) {
        MinHeapNode temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void mergeKSortedArrays(int[][] arr, int k){
        MinHeapNode[] hArr = new MinHeapNode[k];
        int resultSize = 0;
        for(int i = 0; i < arr.length; i++)
        {
            MinHeapNode node = new MinHeapNode(arr[i][0],i,1);
            hArr[i] = node;
            resultSize += arr[i].length;
        }
        MinHeap minHeap = new MinHeap(hArr, k);

        int[] result = new int[resultSize];

        for(int i = 0; i < resultSize; i++) {
            MinHeapNode root = minHeap.getMin();
            result[i] = root.element;

            // Find the next element that will replace current
            // root of heap. The next element belongs to same
            // array as the current root.
            if(root.j < arr[root.i].length) {
                root.element = arr[root.i][root.j++];
            }else {
                root.element = Integer.MAX_VALUE;
            }
            // Replace root with next element of array
            minHeap.replaceMin(root);
        }
        System.out.println("Merged array is :" + Arrays.toString(result));
    }

    // Driver code
    public static void main(String[] args){
        int[][] arr= {{2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}};
        mergeKSortedArrays(arr,arr.length);
    }
}
