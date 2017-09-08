package com.hand13.soft;

/**
 * Created by hd110 on 2017/9/9.
 */
public class QuickSort {
    public static int sort(int[]a, int start, int end) {
        if(start >= end)
            return -1;
        int i = start - 1;
        for (int j = start; j <= end; j++) {
            if(a[j] <= a[end]) {
                i++;
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        return i;
    }
    public static void quicksort(int []a,int start, int end) {
        int mid = sort(a,start,end);
        if(mid == -1)
            return;
        quicksort(a,start,mid - 1);
        quicksort(a,mid+1,end);
    }
    public static void main(String[] args) {
        int[] a= {4,3,6,5,7,7,1};
        quicksort(a,0,a.length-1);
        for(int i : a) {
            System.out.println(i);
        }
    }
}
