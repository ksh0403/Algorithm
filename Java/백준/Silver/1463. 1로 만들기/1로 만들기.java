import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        System.out.println(recur(n, 0));
    }

    static int recur(int n, int count) {
        // n이 2 미만인 경우 누적된 count값을 반환
        if (n < 2) {
            return count;
        }
        return Math.min(recur(n / 2, count + 1 + (n % 2)), recur(n / 3, count + 1 + (n % 3)));
    }
}