import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        // 최대공약수
        int GCD = 0;
        for (int i = 1; i <= a; i++) {
            if ((a % i == 0) && (b % i == 0)) {
                GCD = i;
            }
        }

        // 최소공배수
        int LCM = 0;
        int j = a;
        int k = 1;
        while (true) {
            if ((j % a == 0) && (j % b == 0)) {
                LCM = j;
                break;
            }
            k++;
            j = a * k;
        }

        sb.append(GCD).append("\n").append(LCM);
        System.out.println(sb);
        br.close();
    }
}
