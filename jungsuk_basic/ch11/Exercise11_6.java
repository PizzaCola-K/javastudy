package ch11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

class Exercise11_6 {
    public static void main(String[] args) {
        Set set = new LinkedHashSet();
        int[][] board = new int[5][5];
        for(int i = 0; set.size()<25;++i) {
            set.add((int)(Math.random()*30)+1+"");
        }

        Iterator it = set.iterator();

        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt((String)it.next());
                System.out.print((board[i][j] < 10 ? "  " :" ")+board[i][j]);
            }
            System.out.println();
        }
    }
}
