package first.Comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Checker implements Comparator<Player> {

    public int compare(Player a, Player b) {
        if (a.score < b.score)
            return 1;
        else if (a.score > b.score)
            return -1;
            int minLength = Math.min(a.name.length(), b.name.length());
            for (int i=0; i < minLength; i++) {
                int aChar = Character.getNumericValue(a.name.charAt(i));
                int bChar = Character.getNumericValue(b.name.charAt(i));
                return comparison(aChar, bChar);

            }
            return comparison(a.name.length(), b.name.length());
    }

    private int comparison(int a, int b) {
        if (a < b)
            return -1;
        else if (a > b)
            return 1;
        return 0;
    }
}

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}