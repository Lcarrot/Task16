import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileDownloader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            URI uri = new URI(scanner.nextLine().trim());
            URL url = uri.toURL();
            Path downloadTo = Paths.get(uri.getPath()).normalize();
            downloadTo = Paths.get("C:\\Users\\olga1\\Desktop\\projects\\Task16" + File.separator +downloadTo.getFileName());
            InputStream inputStream = url.openStream();
            Files.copy(inputStream, downloadTo);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
