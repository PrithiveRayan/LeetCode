package Interview75.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {

    public String predictPartyVictory(String senate) {

//        Queue<Integer> radiant = new LinkedList<>();
//        Queue<Integer> dire = new LinkedList<>();
//        for(int i=0; i<senate.length(); i++){
//            if(senate.toLowerCase().charAt(i) == 'r')
//                radiant.add(i);
//            else
//                dire.add(i);
//        }
//
//        while (!radiant.isEmpty() && !dire.isEmpty()) {
//            int rIndex = radiant.poll();
//            int dIndex = dire.poll();
//            if (rIndex < dIndex) {
//                radiant.add(rIndex + senate.length());
//            } else {
//                dire.add(dIndex + senate.length());
//            }
//        }
//        return radiant.isEmpty() ? "Dire" : "Radiant";

        int n = senate.length();
        Deque<Integer> qr = new ArrayDeque<>();
        Deque<Integer> qd = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                qr.offer(i);
            } else {
                qd.offer(i);
            }
        }
        while (!qr.isEmpty() && !qd.isEmpty()) {
            if (qr.peek() < qd.peek()) {
                qr.offer(qr.peek() + n);
            } else {
                qd.offer(qd.peek() + n);
            }
            qr.poll();
            qd.poll();
        }
        return qr.isEmpty() ? "Dire" : "Radiant";

    }

    public static void main(String[] args) {
        Dota2Senate ds = new Dota2Senate();
//        System.out.println(ds.predictPartyVictory("RD"));
//        System.out.println(ds.predictPartyVictory("RDD"));
        System.out.println(ds.predictPartyVictory("RDRDRDD"));
    }
}
