import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static final int LIMIT = 98765;
    public static ArrayList<Integer> pn = new ArrayList<>();
    public static HashSet<Integer> pnSum = new HashSet<>();
    public static HashSet<Integer> pnMult = new HashSet<>();
    public static boolean[] v = new boolean[10];
    public static int k, m, answer = 0;

    public static void main(String[] args) throws Exception {
        initPn();
        initPnSumAndMult();
        pn = null;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        bf(0, 0);
        System.out.println(answer);
    }

    public static void initPn() {
        boolean[] isPn = new boolean[LIMIT+1];
        int sqrtN = (int)Math.sqrt(LIMIT);
        for (int i = 3; i <= sqrtN; i+=2) {
            if (isPn[i]) continue;
            int base = i+i;
            while (base <= LIMIT) {
                isPn[base] = true;
                base+=i;
            }
        }
        pn.add(2);
        for (int i = 3; i <= LIMIT; i+=2) {
            if (!isPn[i]) pn.add(i);
        }
    }

    public static void initPnSumAndMult() {
        for (int i = 0; i < pn.size(); i++) {
            for (int j = i; j < pn.size(); j++) {
                int pn1 = pn.get(i);
                int pn2 = pn.get(j);
                long mult = 1l*pn1*pn2;
                if (mult <= LIMIT)
                    pnMult.add((int)mult);
                if (pn1!=pn2) {
                    int sum = pn1+pn2;
                    if (sum <= LIMIT)
                        pnSum.add(sum);
                }
            }
        }
    }

    public static boolean isValid(int cur) {
        if (!pnSum.contains(cur)) return false;
        while (cur%m==0)
            cur/=m;
        if (!pnMult.contains(cur)) return false;
        return true;
    }

    public static void bf(int idx, int cur) {
        if (idx == k) {
            if (isValid(cur))
                answer++;
            return;
        }
        for (int i = 0; i <= 9; i++) {
            if (i==0 && idx==0 || v[i]) continue;
            v[i] = true;
            bf(idx+1, cur*10+i);
            v[i] = false;
        }
    }
}