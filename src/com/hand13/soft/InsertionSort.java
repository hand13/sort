package com.hand13.soft;

/**
 * Created by hd110 on 2017/9/9.
 */
public class InsertionSort {
    public static void sort(int[] a) {
        for (int k = 1; k <= a.length-1; k++) {
            int i = k -1;
            int key = a[k];
            while (i>=0 && a[i] > key) {
                a[i+1] = a[i];
                i--;
            }
            a[i+1] = key;
        }
    }
    public static void main(String[] args) {
        int[] a = {4,3,1,5,9,8,6};
        sort(a);
        /*for(int i: a) {
            System.out.println(i);
        }*/
        int [] i = {1,0,1,0,1};
        int [] j = {1,1,0,1,1};
        int [] c = add(i,j);
        if(c == null)
            return;
        for (int s: c) {
            System.out.println(s);
        }
    }
    public static int [] add(int[] a,int [] b) {
        if (a.length != b.length)
            return null;
        int tmp = 0;
        int [] c = new int[a.length +1];
        for (int i = 0; i < a.length; i++) {
            int k = a[i] + b[i] +tmp;
            c[i] = k%2;
            tmp = (k - c[i])/2;
        }
        c[a.length] = tmp;
        return c;
    }
}
