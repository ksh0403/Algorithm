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
        Integer[] score = new Integer[n];
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(score);
        int m = score[n-1];
        double sum = 0;
        for (int j = 0; j < n; j++) {
            sum += (double) score[j]/m * 100;
        }

        System.out.println(sum/n);
        br.close();
    }
}