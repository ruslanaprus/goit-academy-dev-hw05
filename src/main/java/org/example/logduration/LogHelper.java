package org.example.logduration;

import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;

public class LogHelper {

    private final Logger logger;

    public LogHelper(Logger logger) {
        this.logger = logger;
    }

    public void logDuration(int n, long startTime) {
        logDuration(n, startTime, TimeUnit.MILLISECONDS, "", "");
    }

    public void logDuration(int n, long startTime, TimeUnit timeUnit) {
        logDuration(n, startTime, timeUnit, "", "");
    }

    public void logDuration(int n, long startTime, TimeUnit timeUnit, String prefix, String suffix) {
        long endTime = System.nanoTime();
        long duration = timeUnit.convert(endTime - startTime, TimeUnit.NANOSECONDS);
        String unit = timeUnit.toString().toLowerCase();
        String formattedDuration = String.format("%,d", duration).replace(',', '_');

        StringBuilder message = new StringBuilder();
        if (prefix != null && !prefix.isEmpty()) {
            message.append(prefix).append(" ");
        }
        message.append("Finished Fibonacci number ").append(n).append(" in ").append(formattedDuration).append(" ").append(unit);
        if (suffix != null && !suffix.isEmpty()) {
            message.append(" from:").append(suffix);
        }

        logger.info(message.toString());
//        System.out.println(message.toString());
    }
}
