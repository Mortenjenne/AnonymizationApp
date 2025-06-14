
import java.util.List;
import java.util.Locale;

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

            anonymizedText = anonymizedText.replaceFirst("\\b" + studentName + "\\b", replacementText);

            anonymizedText = anonymizedText.replaceAll("\\b" + studentName + "\\b", replacementText.toLowerCase());
        }
        return anonymizedText;
    }
}
