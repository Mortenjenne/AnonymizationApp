
import java.util.List;

public class StringHandler {

    public StringHandler() {}

    public String replaceText(String text, List<String> studentNames, String replacementText) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        String anonymizedText = text;
        for (String studentName : studentNames) {
            if (anonymizedText.contains(studentName)) {
                anonymizedText = anonymizedText.replace(studentName, replacementText);
            }
        }
        return anonymizedText;
    }

    public String replaceTextWithRegex(String text, List<String> studentNames, String replacementText) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        String anonymizedText = text;
        for (String studentName : studentNames) {
            anonymizedText = anonymizedText.replaceAll("\\b" + studentName + "\\b", replacementText);
        }
        return anonymizedText;
    }
}
