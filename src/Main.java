import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FileIO fileIO = new FileIO();
        List<String> activityLog = fileIO.loadTextFile("data/activityLog.txt");
        StringHandler stringHandler = new StringHandler("Den studerende");

        List<String> anonymizedActivityLog = new ArrayList<>();
        List<String> studentNames = new ArrayList<>();
        studentNames.add("Anders");
        studentNames.add("Katrine");
        studentNames.add("Joakim");
        studentNames.add("Stine");

        for (String s : activityLog) {
            String anonymizedText = stringHandler.replaceText(s, studentNames);
            anonymizedActivityLog.add(anonymizedText);
            System.out.println(anonymizedText);
        }

        fileIO.saveAnonymizedText(anonymizedActivityLog);

    }
}