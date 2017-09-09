package com.hand13.soft;

/**
 * Created by hd110 on 2017/9/9.
 */
public class MaxHeap {
    public static int heapSize = 0;
    public static void build(int[] a, int i) {
        int right = (i << 1) + 2;
        int left = (i <<1) +1;
        int largest;
        if(left <heapSize && a[left] > a[i])
            largest = left;
        else
            largest = i;
        if(right <heapSize && a[right] > a[largest])
            largest = right;
        if(largest != i) {
            int tmp = a[largest];
            a[largest] = a[i];
            a[i] = tmp;
            build(a,largest);
        }
    }
    public static void allBuild(int[] a) {
        int j = a.length/2 - 1;
        for (int i =j; i >= 0; i--) {
            build(a,i);
        }
    }
    public static void heapsort(int [] a) {
        heapSize = a.length;
        allBuild(a);
        for (int i = a.length-1; i>0; i--) {
            int tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            heapSize = i;
            build(a,0);
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,5};
        heapsort(a);
        for (int i =0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
