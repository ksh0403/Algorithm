import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        PriorityQueue<String> par = new PriorityQueue<>();
        for (int i = 0; i < participant.length; i++) {
            par.add(participant[i]);
        }
        
        PriorityQueue<String> com = new PriorityQueue<>();
        for (int i = 0; i < completion.length; i++) {
            com.add(completion[i]);
        }
        
        // 비교
        for (int i = 0; i < completion.length; i++) {
            String com_str = com.poll();
            String par_str = par.poll();
            if (!com_str.equals(par_str)) {
                return par_str;
            }
        }
        return par.poll();
    }
}