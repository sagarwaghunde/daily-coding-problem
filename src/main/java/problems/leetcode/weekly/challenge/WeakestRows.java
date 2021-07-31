package problems.leetcode.weekly.challenge;

import java.util.Arrays;
import java.util.PriorityQueue;

public class WeakestRows {
    public static void main(String[] args) {
        int[][] m = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int k = 3;
        int[] result = kWeakestRows(m, k);
        System.out.println(Arrays.toString(result));
    }
    
    static public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<SoldierByRows> pq = new PriorityQueue<>((o1, o2) -> {
        if(o1.soldiers == o2.soldiers){
            return o2.row - o1.row;
        }
        return o2.soldiers - o1.soldiers;
        });
        for(int i = 0; i < mat.length; i++) {
            int soldiers = 0;
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 1) {
                    soldiers++;
                }
            }
            System.out.println("PQSize : " + pq.size());
            if(pq.size() >= k) {
                SoldierByRows pqTop = pq.peek();
                System.out.println("Top : {" + pqTop.row + "," + pqTop.soldiers + "}. Current : {" + i + "," + soldiers + "}");
                if(soldiers < pqTop.soldiers) {
                    pq.poll();
                    System.out.println("Add : {" + i + "," + soldiers + "}");
                    pq.add(new SoldierByRows(i, soldiers));
                }
            } else {
                System.out.println("Add : {" + i + "," + soldiers + "}");
                pq.add(new SoldierByRows(i, soldiers));
            }
            StringBuffer soFar = new StringBuffer();
        }
        int[] result = new int[k];
//        int index = 0;
        while(k > 0) {
            SoldierByRows pqTop = pq.poll();
            result[k-1] = pqTop.row;
            k--;
        }
        return result;
    }
    
    static class SoldierByRows {
        int row;
        int soldiers = 0;
        
        public SoldierByRows(int row, int soldiers) {
            this.row = row;
            this.soldiers = soldiers;
        }
    }
}
