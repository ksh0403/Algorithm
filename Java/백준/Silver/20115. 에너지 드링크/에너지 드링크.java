import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Long[] drink = new Long[n];
        for (int i = 0; i < n; i++) {
            drink[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(drink);

        double sum = drink[n-1];
        for (int j = 0; j < n-1; j++) {
            sum += (double) drink[j] / 2;
        }

        System.out.println(sum);
        br.close();
    }
}
