package coding;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Temp3 {

    public static void main(String[] args) {

        int[] a = {10, 20, 30, 40, 50};
        int index = 2;
        int[] b = new int[a.length-1];

        for (int i = 0; i < a.length; i++) {
            if(i < index) {
                b[i] = a[i];
            } else if(i == index) {
                continue;
            } else if(i > index) {
                b[i-1] = a[i];
            }
        }

        for(int element: b){
           System.out.println(element);
        }
    }








}