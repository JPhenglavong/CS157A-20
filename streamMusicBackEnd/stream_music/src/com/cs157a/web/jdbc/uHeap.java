package com.cs157a.web.jdbc;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This heap class with song, is to help main function to implement
 * the HeapSort Algorithm to sort the web song
 */
public class uHeap {

    private int heapSize;

    public uHeap(ArrayList<user> A) {
        heapSize = A.size();
    }

    public void maxHeapify(ArrayList<user> A, int i) {

        int largest;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < heapSize && A.get(l).getId() > A.get(i).getId()) {
            largest = l;
        }else{
            largest = i;
        }

        if (r < heapSize && A.get(r).getId() > A.get(largest).getId()) {
            largest = r;
        }
        if (largest != i) {
            Collections.swap(A, i, largest);
            maxHeapify(A, largest);
        }
    }

    public void buildMaxHeap(ArrayList<user> A) {

        this.heapSize = A.size();
        for (int i = (A.size() / 2) - 1; i >= 0; i--) {
            maxHeapify(A, i);
        }
    }

    public void HeapSort(ArrayList<user> A) {
        buildMaxHeap(A);
        for (int i = A.size() - 1; i > 0; i--) {
            Collections.swap(A, i, 0);
            heapSize--;
            maxHeapify(A, 0);
        }
    }

    public user HeapExtractMax(ArrayList<user> A) {
        if (heapSize < 1) {
            throw new RuntimeException("heap underflow");
        }
        user max = heapMaximum(A);
        A.set(0, A.get(heapSize - 1));
        heapSize--;
        maxHeapify(A, 0);
        return max;
    }

    public void heapIncreaseKey(ArrayList<user> A, int i, user key) {
        if (key.getId() < A.get(i).getId()) {
            throw new RuntimeException("new key is smaller than current key");
        }
        A.set(i, key);
        while (i > 0 && A.get(getParent(i)).getId() < A.get(i).getId()) {
            Collections.swap(A, i, getParent(i));
            i = getParent(i);
        }
    }

    public void MaxHeapInsert(ArrayList<user> A, user key) {
        heapSize++;
        A.add(key);
        A.get(heapSize - 1).setId((int) Double.NEGATIVE_INFINITY);
        heapIncreaseKey(A, heapSize, key);//then give the leaf real value
    }

    public user heapMaximum(ArrayList<user> A){
        return A.get(0);
    }

    public  int getParent(int i) {
        return (i - 1 / 2);
    }

}
