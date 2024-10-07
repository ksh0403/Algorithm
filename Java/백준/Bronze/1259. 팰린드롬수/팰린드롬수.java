import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        while (!input.equals("0")) {
            String result = "yes";
            for (int i = 0; i < input.length(); i++) {
                if (!input.substring(i, i+1).equals(input.substring(input.length()-i-1, input.length()-i))) {
                    result = "no";
                    break;
                }
            }
            sb.append(result).append("\n");
            input = br.readLine();
        }
        System.out.println(sb);
        br.close();
    }
}