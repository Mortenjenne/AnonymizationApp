
import java.util.List;

public class StringHandler {

    private String replacementText;

    public StringHandler(String replacementText) {
        this.replacementText = replacementText;
    }

    public void setReplacementText(String replacementText) {
        this.replacementText = replacementText;
    }

    public String replaceText(String text, List<String> studentNames) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        String anonymizedText = text;
        for (String studentName : studentNames) {

            if (anonymizedText.contains(studentName)) {
                anonymizedText = anonymizedText.replace(studentName, replacementText);
            }

            if (anonymizedText.contains(studentName.toLowerCase())) {
                anonymizedText = anonymizedText.replace(studentName.toLowerCase(), replacementText.toLowerCase());
            }
        }
        return anonymizedText;
    }

}
