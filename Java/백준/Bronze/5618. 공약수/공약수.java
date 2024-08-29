import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		if(n == 2) {
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			//두 수중 작은수까지만 반복하는 반복문
			for(int i = 1; i <= Math.min(A, B); i++) {
				if(A % i == 0 && B % i == 0) {
					System.out.println(i);
				}
			}
		}else {
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			//세 수중 작은수까지만 반복하는 반복문
			for(int i = 1; i <= Math.min(A, Math.min(B, C)); i++) {
				if(A % i == 0 && B % i == 0 && C % i == 0) {
					System.out.println(i);
				}
			}
		}
	}
}