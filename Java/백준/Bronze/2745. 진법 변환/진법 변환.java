import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, B
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String n = st.nextToken();
        long b = Long.parseLong(st.nextToken());

        // N을 한 글자씩 분리하여 리스트에 담음
        LinkedList<String> n_list = new LinkedList<>();
        for (int i = 0; i < n.length(); i++) {
             n_list.add(n.substring(i, i + 1));
        }

        // result
        long result = 0;
        for (int j = 0; j < n_list.size(); j++) {
            // 원소가 숫자인지, 알파벳인지에 따라 빼줘야하는 값이 다름
            if ((long)n_list.get(j).charAt(0) <= 57) {
                // 9의 아스키 코드 : 57
                // n_list에서 가져온 원소가 숫자이면 48(=0의 아스키코드 값)을 빼줌
                result += ((long)n_list.get(j).charAt(0) - 48) * (long)Math.pow(b, n_list.size() - 1 - j);
            } else {
                // A, B, ... : 65, 66, ...
                // n_list에서 가져온 원소가 알파벳이면 55(= 65-10)를 빼줌
                // 아스키코드로 되어 있는 값을 10진수로 맞춰주기 위함
                result += ((long)n_list.get(j).charAt(0) - 55) * (long)Math.pow(b, n_list.size() - 1 - j);
            }
        }

        System.out.println(result);
        br.close();
    }
}