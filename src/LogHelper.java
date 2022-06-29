import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// adapted from https://github.com/thsc42/OperatingSystems/blob/master/src/utils/LogHelper.java
public class LogHelper {
    public static String getExactTime() {
        long now = System.currentTimeMillis();

        Date date = new Date(now);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        return df.format(date);
    }

    // log the task with exact timestamp
    public static void printTaskLog(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(LogHelper.getExactTime());
        sb.append(".................").append(message);
        System.out.println(sb);
    }

    public static void printThreadLog(String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(LogHelper.getExactTime());
        sb.append(" (Thread #");
        sb.append(Thread.currentThread().getId());
        sb.append("): ");
        sb.append(message);
        System.out.println(sb);
    }
}
