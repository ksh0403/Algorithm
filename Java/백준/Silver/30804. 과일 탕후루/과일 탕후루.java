import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 과일 배열 초기화
        int[] fruit = new int[n]; // 과일 정보를 저장하는 배열
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            fruit[i] = Integer.parseInt(st.nextToken());
        }

        // 슬라이딩 윈도우 알고리즘 초기화
        int[] count = new int[10]; // 각 과일(1~9번)의 개수를 저장하는 배열
        int start = 0;             // 현재 슬라이딩 윈도우의 시작점
        int end = 0;               // 현재 슬라이딩 윈도우의 끝점
        int maxLength = 0;         // 과일 종류가 2개 이하인 구간의 최대 길이
        int distinctCount = 0;     // 현재 윈도우 내의 과일 종류 개수

        // 슬라이딩 윈도우 탐색 시작
        while (end < n) {
            // 1. 윈도우의 끝점에 과일 추가
            if (count[fruit[end]] == 0) {
                // 새로운 과일을 추가하는 경우 (종류 개수 증가)
                distinctCount++;
            }
            count[fruit[end]]++; // 해당 과일 개수 증가
            end++; // 윈도우 끝점을 한 칸 확장

            // 2. 윈도우 내 과일 종류가 2개를 초과하면 윈도우 시작점 이동
            while (distinctCount > 2) {
                count[fruit[start]]--; // 윈도우 시작점의 과일 개수 감소
                if (count[fruit[start]] == 0) {
                    // 과일 종류가 0이 되면 종류 개수 감소
                    distinctCount--;
                }
                start++; // 윈도우 시작점을 한 칸 이동
            }

            // 3. 현재 윈도우의 크기를 계산하여 최대 길이 갱신
            // 현재 윈도우의 길이는 (end - start)
            maxLength = Math.max(maxLength, end - start);
        }

        // 결과 출력: 과일 종류가 2개 이하인 최대 길이
        System.out.println(maxLength);

        br.close();
    }
}