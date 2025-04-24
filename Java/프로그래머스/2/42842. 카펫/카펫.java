class Solution {
    public int[] solution(int brown, int yellow) {
        int size = brown + yellow; // 카펫의 면적 (총 격자 수)
        
        for (int h = 3; h <= Math.sqrt(size); h++) {
            if (size % h != 0) continue; // 나누어 떨어지지않으면 패스 (직사각형이니까)
            
            int w = size / h; // 가로
            if ((w - 2) * (h - 2) == yellow) {
                return new int[]{w, h};
            }
            
        }
        
        return new int[]{0, 0}; // 예외 처리 (실제로 도달 X)
    }
}