package external.util;

import java.time.LocalDateTime;

public class Logger {
    public static void logToConsole(CharSequence message) {
        LocalDateTime dt = LocalDateTime.now();
        System.out.printf("%1$tD %1tT : %2$s%n", dt, message);
        if (message instanceof StringBuilder stringBuilder) {
            stringBuilder.setLength(0);
        }
    }
}
