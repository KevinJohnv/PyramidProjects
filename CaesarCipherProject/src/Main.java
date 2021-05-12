import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path filePath = Paths.get(System.getProperty("user.dir") + "\\resources\\CaesarCipher.txt");

        boolean created;

        try{
            Files.createFile(filePath);

        }catch (IOException e){
            System.out.println(e);
        }
    }
}
