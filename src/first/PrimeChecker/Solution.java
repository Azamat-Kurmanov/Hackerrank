package first.PrimeChecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(in));
        int rows = 1;
        int maxRows = 5;

        Set<Integer> listInner = new HashSet<>();
        while(rows<=maxRows){
            int num1 = Integer.parseInt(br.readLine());
            int num = num1==1 ? 2 : num1;
            if (checkPrime(num)) {
                listInner.add(num);
                for (Integer list : listInner) {
                    System.out.print(list+" ");
                }
                System.out.println();
            }
            rows++;
        }
    }


    public static boolean checkPrime(int number){
        for (int i = 2; i < number; i++) {
            if (number%i==0){
                return false;
            }
        }
        return true;
    }
}
