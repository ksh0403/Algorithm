import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Point> queue = new LinkedList<>();
        int qSize, mid;
        Point now;

        int K = Integer.parseInt(br.readLine());
        int num = (int) Math.pow(2, K) - 1;
        int[] list = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int x = 0; x < num; x++) {
            list[x] = Integer.parseInt(st.nextToken());
        }

        queue.add(new Point(0, num - 1));

        while (!queue.isEmpty()) {
            qSize = queue.size();

            for (int x = 0; x < qSize; x++) {
                now = queue.poll();
                
                // 부모
                mid = (now.left + now.right) / 2;
                
                sb.append(list[mid]).append(" ");
                if (now.left != now.right) {
                    // 왼쪽 자식
                    queue.add(new Point(now.left, mid - 1));
                    // 오른쪽 자식
                    queue.add(new Point(mid + 1, now.right));
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static class Point{
        int left, right;

        Point(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
