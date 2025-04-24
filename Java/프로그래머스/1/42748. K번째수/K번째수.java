import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int idx = 0; idx < commands.length; idx++) {
            int i = commands[idx][0];
            int j = commands[idx][1];
            int k = commands[idx][2];
            
            int[] arr = new int[j-i+1];
            for (int a = 0; a < j-i+1; a++) {
                arr[a] = array[i-1+a];
            }
            
            Arrays.sort(arr);
            answer[idx] = arr[k-1];
        }

        return answer;
    }
}