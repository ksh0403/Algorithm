import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 세로 크기
        int m = Integer.parseInt(st.nextToken()); // 가로 크기

        char[][] board = new char[n][m]; // 입력받은 체스판
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int minPaint = Integer.MAX_VALUE;

        // 8x8 체스판을 모든 가능한 위치에서 검사
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int cntW = 0; // 첫 칸이 'W'로 시작하는 체스판을 다시 칠해야 하는 횟수
                int cntB = 0; // 첫 칸이 'B'로 시작하는 체스판을 다시 칠해야 하는 횟수

                // 8x8 부분 체스판 검사
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        // 현재 위치의 원래 색상
                        char current = board[i + x][j + y];
                        // 체스판의 규칙에 맞는 색상 계산 (짝짝 또는 홀홀)
                        if ((x + y) % 2 == 0) {
                            if (current != 'W') cntW++; // 첫 칸이 'W'로 시작했을 때 다른 색이면 다시 칠함
                            if (current != 'B') cntB++; // 첫 칸이 'B'로 시작했을 때 다른 색이면 다시 칠함
                        } else {
                            if (current != 'B') cntW++; // 첫 칸이 'W'일 때 'B'로 칠해야 하는 자리
                            if (current != 'W') cntB++; // 첫 칸이 'B'일 때 'W'로 칠해야 하는 자리
                        }
                    }
                }

                // 최소값 갱신
                minPaint = Math.min(minPaint, Math.min(cntW, cntB));
            }
        }

        System.out.println(minPaint); // 최종 결과 출력
        br.close();
    }
}
