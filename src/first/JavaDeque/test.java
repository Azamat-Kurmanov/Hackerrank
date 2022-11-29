package first.JavaDeque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        HashSet<Integer> setUniq = new HashSet<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
//            System.out.println("num: " + num);
            deque.add(num);
//            System.out.println("deque: " + deque);
            setUniq.add(num);
//            System.out.println("setUniq: " + setUniq);
            if (deque.size() == m){
                if (setUniq.size() > max){
                    max = setUniq.size();
//                    System.out.println("setUniqMaxSize: " + max);
                }

                int firstElement = (int) deque.remove();
//                System.out.println("firstElement_remove: " + firstElement);
                if (!deque.contains(firstElement)){
                    setUniq.remove(firstElement);
//                    System.out.println("setUniq_remove: " + setUniq);
                }
            }
        }
        System.out.println(max);
    }
}
