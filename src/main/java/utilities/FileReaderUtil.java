package utilities;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReaderUtil {
    public static String readFile(String path) {

        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            return builder.toString();

        } catch (IOException exp) {
            exp.printStackTrace();
        }
        return null;
    }

}
