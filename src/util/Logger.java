package util;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author Admin
 */
public class Logger {

    private static String txtFilePath;

    private Logger() {
    }

    public static String getTxtFilePath() {
        return txtFilePath;
    }

    public static void setTxtFile(String txtFilePath) {
        Logger.txtFilePath = txtFilePath;
    }

    public static void logToConsole(String message) {
        System.out.println(message);
    }

    public static void logToFile(String messageLog) {
        Path path = Paths.get(txtFilePath);
        try (BufferedWriter writer = Files.newBufferedWriter(path,
                StandardCharsets.UTF_8,
                StandardOpenOption.APPEND,
                StandardOpenOption.CREATE)) {
            writer.write(messageLog + " : [" + LocalDateTime.now(ZoneOffset.UTC) + "]\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile() throws IOException {
        String fileInfo = null;
        RandomAccessFile reader = new RandomAccessFile(txtFilePath, "r");
        fileInfo = reader.readLine();
        reader.close();
        return fileInfo;
    }
}
