import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // byte 값으로 문자 한 개만 읽으며 대응되는 아스키코드를 저장하는 System.in 사용
        int text = System.in.read();
        System.out.println(text);
    }
}