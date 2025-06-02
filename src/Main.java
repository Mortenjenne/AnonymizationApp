
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static FileIO fileIO = new FileIO();

    public static void main(String[] args) {

        List<String> activityLog = getActivityLog("data/activityLog.txt");
        List<String> studentNames = loadStudentNames("data/studentNames.txt");
        List<String> anonymizedList = anonymizeActivityLog(activityLog,studentNames,"Den studerende");

        printAnonymizedList(anonymizedList);
        saveAnonymizedActivityLog(anonymizedList,"data/anonymizedText.txt");
    }

    public static void printAnonymizedList(List<String> anonymizedActivityLog) {
        if (anonymizedActivityLog == null || anonymizedActivityLog.isEmpty()) {
            System.out.println("Ingen data at vise.");
            return;
        }

        for (String s : anonymizedActivityLog) {
            System.out.println(s);
        }
    }

    public static List<String> anonymizeActivityLog(List<String> activityLog, List<String> studentNames, String replacementText) {
        StringHandler stringHandler = new StringHandler();
        List<String> anonymizedActivityLog = new ArrayList<>();

        for (String text: activityLog) {
            String anonymizedText = stringHandler.replaceTextWithRegex(text, studentNames,replacementText);
            anonymizedActivityLog.add(anonymizedText);
        }
        return anonymizedActivityLog;
    }

    public static List<String> loadStudentNames(String path) {
        List<String> studentNames = fileIO.loadTextFile(path);
        List<String> trimmedStudentNames = new ArrayList<>();

        for(String student: studentNames){
            trimmedStudentNames.add(student.trim());
        }

        return trimmedStudentNames;
    }

    public static List<String> getActivityLog(String path) {
        return fileIO.loadTextFile(path);
    }

    public static void saveAnonymizedActivityLog (List<String> anonymizedActivityLog, String path) {
        fileIO.saveAnonymizedText(anonymizedActivityLog,path);
    }
}