import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        // 캘린더 객체
        Calendar calendar = Calendar.getInstance();

        // 날짜 포맷 설정
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // 현재 시간을 가져와 포맷대로 출력
        System.out.println(simpleDateFormat.format(calendar.getTime()));
    }
}