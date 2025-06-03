
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static FileIO fileIO = new FileIO();

    public static void main(String[] args) {

        String activityLogPath = "data/activityLog.txt";
        String studentNamesPath = "data/studentNames.txt";
        String anonymizedTextPath = "data/anonymizedText.txt";
        String replacementText = "Den studerende";

        List<String> activityLog = loadActivityLog(activityLogPath);
        List<String> studentNames = loadStudentNames(studentNamesPath);
        List<String> anonymizedList = anonymizeActivityLog(activityLog,studentNames,replacementText);

        printAnonymizedList(anonymizedList);
        saveAnonymizedActivityLog(anonymizedList,anonymizedTextPath);
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
        if (activityLog == null || activityLog.isEmpty()) {
            System.out.println("Tom liste af tekst der skal anonymiseres, Venligst udfyld listen");
            return new ArrayList<>();
        }

        if (studentNames == null || studentNames.isEmpty()) {
            System.out.println("Tom liste af navne der skal anonymiseres, Venligst udfyld listen");
            return new ArrayList<>();
        }

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

    public static List<String> loadActivityLog(String path) {
        return fileIO.loadTextFile(path);
    }

    public static void saveAnonymizedActivityLog (List<String> anonymizedActivityLog, String path) {
        if(anonymizedActivityLog != null && !anonymizedActivityLog.isEmpty()) {
            fileIO.saveAnonymizedText(anonymizedActivityLog, path);
        } else{
            System.out.println("Ingen liste at gemme, listen er tom");
        }
    }
}