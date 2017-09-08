package com.hand13.soft;

/**
 * Created by hd110 on 2017/9/9.
 */
public class MergeSort {
    public static void merge(int [] a,int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] temp1 = new int[n1];
        int[] temp2 = new int[n2];
        for (int i = 0; i <n1; i++) {
            temp1[i] = a[p + i];
        }
        for (int i = 0; i < n2; i++) {
            temp2[i] = a[q+i+1];
        }
        int l=0,m=0;
        for(int i = p; i <= r; i++) {
            if(l == n1) {
                a[i] = temp2[m];
                m++;
            }
            else if(m == n2) {
                a[i] = temp1[l];
                l++;
            }
            else if (temp1[l] <= temp2[m]) {
                a[i] = temp1[l];
                l++;
            }
            else {
                a[i] = temp2[m];
                m++;
            }
        }
    }
    public static void mergeAndSort(int [] a,int p, int r) {
        if(p < r) {
            int q = (p+r)/2;
            mergeAndSort(a, p, q);
            mergeAndSort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }
    public static void main(String[] args) {
        int[] a = {6,5,3,21,7};
        mergeAndSort(a,0,a.length - 1);
        for (int s : a){
            System.out.println(s);
        }
    }
}
