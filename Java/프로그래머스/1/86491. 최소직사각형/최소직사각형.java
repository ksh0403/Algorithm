class Solution {
    public int solution(int[][] sizes) {
        int max_w = 0; // 가장 긴 가로 길이
        int max_h = 0; // 가장 긴 세로 길이
        
        for (int[] card : sizes) {
            // 세로 길이가 더 길면 눕힘
            if (card[0] < card[1]) {
                int temp = card[0];
                card[0] = card[1];
                card[1] = temp;
            }
            
            if (max_w < card[0]) {
                max_w = card[0];
            }
            if (max_h < card[1]) {
                max_h = card[1];
            }
        }
        
        return max_w * max_h;
    }
}