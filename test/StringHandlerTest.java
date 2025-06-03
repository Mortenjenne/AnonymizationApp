import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class StringHandlerTest {
    private StringHandler stringHandler;
    private String testText;
    private String replacementText;
    private List<String> studentNames;

    @BeforeEach
    void setUp() {
        testText = "Anders fik ny gruppe";
        replacementText = "Den studerende";
        stringHandler = new StringHandler();
        studentNames = new ArrayList<>();
        studentNames.add("Anders");
        studentNames.add("Katrine");
        studentNames.add("Joakim");
        studentNames.add("Stine");
    }

    @Test
    void replaceText() {
        String anonymizedText = stringHandler.replaceText(testText, studentNames,replacementText);
        String expected = "Den studerende fik ny gruppe";

        assertEquals(expected, anonymizedText);
    }

    @Test
    void textNotReplacedIfItDoesNotContainStudentNames() {
        String text = "Morten kom forsent igen";
        String anonymizedText = stringHandler.replaceText(text, studentNames,replacementText);
        String expected = "Morten kom forsent igen";

        assertEquals(expected, anonymizedText);

    }

    @Test
    void replaceMultipleStudentNames() {
        String text = "Anders og Stine arbejdede sammen";
        String anonymizedText = stringHandler.replaceText(text, studentNames,replacementText);
        String expected = "Den studerende og Den studerende arbejdede sammen";

        assertEquals(expected, anonymizedText);
    }

    @Test
    void nameInsideAnotherWordIsNotReplaced() {
        String text = "Joakims opgave var ikke god";
        String anonymizedText = stringHandler.replaceText(text, studentNames,replacementText);
        String expected = "Den studerendes opgave var ikke god";
        assertEquals(expected, anonymizedText);
    }
}