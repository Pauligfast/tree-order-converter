package com.company;

import java.util.Scanner;

public class Main {

    static Scanner inScan = new Scanner(System.in);

    public static void main(String[] args) {
        int sets = inScan.nextInt();

        for (int reps = 0; reps < sets; reps++) {

            int n = inScan.nextInt();

            String type = inScan.next();

            int[] postprearray = new int[n];

            for (int i = 0; i < n; i++) {
                postprearray[i] = inScan.nextInt();
            }
            int[] in = new int[n];

            String s = inScan.next();
            for (int i = 0; i < n; i++) {
                in[i] = inScan.nextInt();
            }
            if (type.equals("PREORDER")) {
                toPostorder(in, 0, n - 1, postprearray, 0, n - 1);
                System.out.println();
            } else {
                toPreorder(in, 0, n - 1, postprearray, 0, n - 1);
                System.out.println();
            }
        }
    }

    public static void toPostorder(int in[], int beginIn, int endIn, int pre[], int beginPo, int endPo) {

        if (beginIn > endIn) {
            return;
        }

        int index;

        for (index = beginIn; index <= endIn; index++) {
            if (in[index] == pre[beginPo]) {
                break;
            }
        }

        toPostorder(in, beginIn, index - 1, pre, beginPo + 1, beginPo + index - beginIn);
        toPostorder(in, index + 1, endIn, pre, beginPo + index - beginIn + 1, endIn);

        System.out.print(pre[beginPo] + " ");
    }

    public static void toPreorder(int in[], int beginIn, int endIn, int post[], int beginPo, int endPo) {

        if (endPo < beginPo) {
            return;
        }

        System.out.print(post[endPo] + " ");

        int index;
        for (index = beginIn; index <= endIn; ++index) {
            if (in[index] == post[endPo]) {
                break;
            }
        }

        toPreorder(in, beginIn, index - 1, post, beginPo, beginPo + index - beginIn - 1);
        toPreorder(in, index + 1, endIn, post, beginPo + index - beginIn, endPo - 1);
    }

}
