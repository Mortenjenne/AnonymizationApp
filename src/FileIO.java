import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {

    public List<String> loadTextFile(String path) {
        List<String> fileData = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(!line.isEmpty()) {
                    fileData.add(line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found ");
        }
        return fileData;
    }

    public void saveAnonymizedText(List<String> textData, String path) {
        try {
            FileWriter writer = new FileWriter(path);
            for (String text : textData) {
                writer.write(text + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Couldn't save file to " + path);
        }
    }

}
