package pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static void waitFor(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy"); //("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return  dtf.format(now);
    }
}
