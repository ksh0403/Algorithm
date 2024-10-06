import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] card = new int[n];
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        // 세 카드의 합 계산
        ArrayList<Integer> sumOfThree = new ArrayList<>();
        int a, b, c;
        for (int i = 0; i < n-2; i++) {
            a = card[i];
            for (int j = i+1; j < n-1; j++) {
                b = card[j];
                for (int k = j+1; k < n; k++) {
                    c = card[k];
                    sumOfThree.add(a+b+c);
                }
            }
        }

        // sumOfThree 리스트 정렬
        Collections.sort(sumOfThree);

        int result = -1;
        for (int i = 0; i < sumOfThree.size(); i++) {
            if (sumOfThree.get(i) <= m) {
                result = sumOfThree.get(i);
            } else {
                break;
            }
        }

        System.out.println(result);
        br.close();
    }
}
