package com.happyfeet.util;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogUtil {
    private static final String LOG_FILE = "logs/app.log";

    public static void logError(String mensaje, Exception e) {
    try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
        fw.write(LocalDateTime.now() + " - ERROR: " + mensaje + " - " + e.getMessage() + "\n");
    } catch (IOException ioException) {
        ioException.printStackTrace();
    }
    }

    public static void logInfo(String mensaje) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
            fw.write(LocalDateTime.now() + " - INFO: " + mensaje + "\n");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}



