package education;

import java.util.Scanner;
import java.util.Arrays;


public class solution {

    public static void main(String[] args) {
        String s = "aa b";
        String alfabet = "abcdefghijklmnopqrstuvwxyz";
        String[] words = s.split(" ");
        int[] sum = new int[words.length];
        Arrays.fill(sum, 0);
        int max = 0;
        int maxindex = 0;
        for (int i = 0; i < words.length; i++){
            for (int n = 0; n < words[i].length(); n++){
                sum[i]+= alfabet.indexOf(words[i].charAt(n)) + 1;
            }
        }
        for (int i = 0; i < sum.length; i++){
            if (sum[i] > max) {
                max = sum[i];
                maxindex = i;
            }
        }
        System.out.println(words[maxindex]);
    }
}