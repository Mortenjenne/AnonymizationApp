import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class StringHandlerTest {
    private StringHandler stringHandler;
    private String testText;
    private List<String> studentNames;

    @BeforeEach
    void setUp() {
        testText = "Anders fik ny gruppe";
        stringHandler = new StringHandler("Den studerende");
        studentNames = new ArrayList<>();
        studentNames.add("Anders");
        studentNames.add("Katrine");
        studentNames.add("Joakim");
        studentNames.add("Stine");
    }

    @Test
    void replaceText() {
        String anonymizedText = stringHandler.replaceText(testText, studentNames);
        String expected = "Den studerende fik ny gruppe";

        assertEquals(expected, anonymizedText);
    }

    @Test
    void textNotReplacedIfItDoesNotContainStudentNames() {
        String text = "Morten kom forsent igen";
        String anonymizedText = stringHandler.replaceText(text, studentNames);
        String expected = "Morten kom forsent igen";

        assertEquals(expected, anonymizedText);

    }

    @Test
    void replaceMultipleStudentNames() {
        String text = "Anders og Stine arbejdede sammen";
        String anonymizedText = stringHandler.replaceText(text, studentNames);
        String expected = "Den studerende og Den studerende arbejdede sammen";

        assertEquals(expected, anonymizedText);
    }

    @Test
    void replaceLowerCaseName() {
        String text = "I går afleverede joakim sin opgave til tiden.";
        String anonymizedText = stringHandler.replaceText(text, studentNames);
        String expected = "I går afleverede den studerende sin opgave til tiden.";

        assertEquals(expected, anonymizedText);
    }

    @Test
    void nameInsideAnotherWordIsNotReplaced() {
        String text = "Joakims opgave var ikke god";
        String anonymizedText = stringHandler.replaceText(text, studentNames);
        String expected = "Den studerendes opgave var ikke god";
        assertEquals(expected, anonymizedText);
    }
}