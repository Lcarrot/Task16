import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagDivCounter {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            URI uri = new URI(scanner.nextLine().trim()).normalize();
            URL url = uri.toURL();
            Pattern pattern = Pattern.compile("<div[^>]*>");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
            int count = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (IllegalArgumentException e) {
            System.out.println("URI isn't absolute");
        } catch (URISyntaxException e) {
            System.out.println("This URI isn't right");
        } catch (MalformedURLException e) {
            System.out.println("This URL isn't right");
        } catch (IOException e) {
            System.out.println("Can't right this file");
        }
    }
}
