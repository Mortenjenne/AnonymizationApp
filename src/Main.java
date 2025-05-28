
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static FileIO fileIO = new FileIO();

    public static void main(String[] args) {
        List<String> activityLog = getActivityLog("data/activityLog.txt");
        List<String> studentNames = addStudentNamesToBeAnomymized();
        List<String> anonymizedList = anonymizeActivityLog(activityLog,studentNames,"Den studerende");

        printAnonymizedList(anonymizedList);
        saveAnonymizedActivityLog(anonymizedList);
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

    public static List<String> addStudentNamesToBeAnomymized() {
        List<String> studentNames = new ArrayList<>();
        studentNames.add("Anders");
        studentNames.add("Katrine");
        studentNames.add("Joakim");
        studentNames.add("Stine");
        return studentNames;
    }

    public static List<String> getActivityLog(String path) {
        return fileIO.loadTextFile(path);
    }

    public static void saveAnonymizedActivityLog (List<String> anonymizedActivityLog) {
        fileIO.saveAnonymizedText(anonymizedActivityLog);
    }
}