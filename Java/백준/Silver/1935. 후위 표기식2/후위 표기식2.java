import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 BufferedReader 와 BufferedWriter
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 피연산자의 개수 N
        int n = Integer.parseInt(br.readLine());

        // 후위 표기식
        String postfix = br.readLine();

        // 각 피연산자에 대응하는 값을 담는 배열
        double arr[] = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // LinkedList 로 스택 구현
        LinkedList<Double> s_list = new LinkedList<>();

        // 후위 표기식 계산법
        // 1. 숫자는 스택에 넣음
        // 2. 연산자가 나오면 숫자 2개를 pop하여 계산
        // (이때 먼저 pop되는 숫자가 두 번째 값, 나중에 pop되는 숫자가 첫 번째 값)
        // 3. 계산한 값은 다시 스택에 넣음

        // 주어진 후위 표기식 계산
        for (int i = 0; i < postfix.length(); i++) {
            // 1. 숫자는 스택에 넣음 (이 문제에서는 영대문자인지 검사해야 함)
            if (postfix.charAt(i) >= 65 && postfix.charAt(i) <= 90) {
                // A의 아스키 코드가 65이므로 [영대문자 - 65] 값을 arr 배열에서 얻어옴
                s_list.addLast(arr[(int)postfix.charAt(i) - 65]);
            } else {
                // 2. 연산자가 나오면 숫자 2개를 pop하여 계산
                // (이때 먼저 pop되는 숫자가 두 번째 값, 나중에 pop되는 숫자가 첫 번째 값)
                double second = s_list.pollLast();
                double first = s_list.pollLast();
                double result = 0;

                String operator = postfix.substring(i, i+1);
                switch (operator) {
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = first - second;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    case "/":
                        result = first / second;
                        break;
                }

                // 3. 계산한 값은 다시 스택에 넣음
                s_list.addLast(result);
            }
        }

        // 스택에 마지막에 남은 연산 결과 출력 (소숫점 둘째 자리까지)
        String answer = String.format("%.2f", s_list.poll());
        bw.write(answer);

        // Reader 버퍼 닫기
        br.close();

        // Writer 버퍼 비운 뒤 닫기
        bw.flush();
        bw.close();
    }
}