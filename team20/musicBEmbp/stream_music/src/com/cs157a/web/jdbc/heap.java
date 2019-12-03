package com.cs157a.web.jdbc;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This heap class with song, is to help main function to implement
 * the HeapSort Algorithm to sort the web song
 */
public class heap {

    private int heapSize;

    public heap(ArrayList<song> A) {
        heapSize = A.size();
    }

    public void maxHeapify(ArrayList<song> A, int i) {

        int largest;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < heapSize && A.get(l).getAlbumOrder() > A.get(i).getAlbumOrder()) {
            largest = l;
        }else{
            largest = i;
        }

        if (r < heapSize && A.get(r).getAlbumOrder() > A.get(largest).getAlbumOrder()) {
            largest = r;
        }
        if (largest != i) {
            Collections.swap(A, i, largest);
            maxHeapify(A, largest);
        }
    }

    public void buildMaxHeap(ArrayList<song> A) {

        this.heapSize = A.size();
        for (int i = (A.size() / 2) - 1; i >= 0; i--) {
            maxHeapify(A, i);
        }
    }

    public void HeapSort(ArrayList<song> A) {
        buildMaxHeap(A);
        for (int i = A.size() - 1; i > 0; i--) {
            Collections.swap(A, i, 0);
            heapSize--;
            maxHeapify(A, 0);
        }
    }

    public song HeapExtractMax(ArrayList<song> A) {
        if (heapSize < 1) {
            throw new RuntimeException("heap underflow");
        }
        song max = heapMaximum(A);
        A.set(0, A.get(heapSize - 1));
        heapSize--;
        maxHeapify(A, 0);
        return max;
    }

    public void heapIncreaseKey(ArrayList<song> A, int i, song key) {
        if (key.getAlbumOrder() < A.get(i).getAlbumOrder()) {
            throw new RuntimeException("new key is smaller than current key");
        }
        A.set(i, key);
        while (i > 0 && A.get(getParent(i)).getAlbumOrder() < A.get(i).getAlbumOrder()) {
            Collections.swap(A, i, getParent(i));
            i = getParent(i);
        }
    }

    public void MaxHeapInsert(ArrayList<song> A, song key) {
        heapSize++;
        A.add(key);
        A.get(heapSize - 1).setId((int) Double.NEGATIVE_INFINITY);
        heapIncreaseKey(A, heapSize, key);//then give the leaf real value
    }

    public song heapMaximum(ArrayList<song> A){
        return A.get(0);
    }

    public  int getParent(int i) {
        return (i - 1 / 2);
    }

}
