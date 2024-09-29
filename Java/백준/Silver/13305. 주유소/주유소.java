import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        long[] distance = new long[n-1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n-1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        long[] oil_price = new long[n];
        long min_price = Long.MAX_VALUE; // 가장 싼 기름 가격
        int min_loc = Integer.MAX_VALUE; // 가장 싼 기름을 파는 위치
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            oil_price[i] = Long.parseLong(st.nextToken());

            if (oil_price[i] < min_price) {
                min_price = oil_price[i];
                min_loc = i;
            }
        }

        long cost = 0; // 총 비용
        
        int destination = min_loc;
        
        long next_min_price = Long.MAX_VALUE;
        int next_min_loc = Integer.MAX_VALUE;
        while (destination != 0) {
            // 목적지 전까지 기름이 가장 싼 곳 찾기
            for (int i = 0; i < destination; i++) {
                if (oil_price[i] < next_min_price) {
                    next_min_price = oil_price[i];
                    next_min_loc = i;
                }
            }

            // next_min_loc에 도착하면 다음 목적지까지의 기름을 전부 구매
            long distance_sum = 0; // 다음 목적지까지 남은 거리
            for (int k = next_min_loc; k < destination; k++) {
                distance_sum += distance[k];
            }
            cost += distance_sum * next_min_price;

            // 목적지 재설정 + 변수 초기화
            destination = next_min_loc;
            next_min_price = Long.MAX_VALUE;
            next_min_loc = Integer.MAX_VALUE;
        }

        // min_loc에서는 최종 목적지까지의 기름을 전부 구매
        long rest_distance_sum = 0; // 남은 거리
        for (int k = min_loc; k < n-1; k++) {
            rest_distance_sum += distance[k];
        }
        cost += rest_distance_sum * min_price;

        System.out.println(cost);
        br.close();
    }
}
