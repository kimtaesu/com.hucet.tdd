import javafx.beans.binding.ObjectBinding;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class NameInverterTest {
    @Test
    public void nameInverter() {
        assertThat(invert(null), Is.is(""));
        assertThat(invert(""), Is.is(""));
        assertThat(invert("name"), Is.is("name"));
        assertThat(invert("first last"), Is.is("last, first"));
        assertThat(invert("      name     "), Is.is("name"));
        assertThat(invert("first      last"), Is.is("last, first"));
        assertThat(invert("Mr. first last"), Is.is("last, first"));
        assertThat(invert("Mrs. first last"), Is.is("last, first"));
        assertThat(invert("first last SR."), Is.is("last, first SR."));
    }

    private String invert(String name) {
        if (name == null || name.isEmpty())
            return "";
        else {
            List<String> names = splitNames(name);
            removeHonorific(names);
            if (names.size() == 1) {
                return names.get(0);
            }
            String postNominal =  "";
            if (names.size() == 3) {
                postNominal = names.get(2);
            }
            return String.format("%s, %s %s", names.get(1), names.get(0), postNominal).trim();

        }
    }

    private void removeHonorific(List<String> names) {
        if (names.size() > 1 && isHonoritic(names))
            names.remove(0);
    }

    private List<String> splitNames(String name) {
        return new ArrayList<>(Arrays.asList(name.trim().split("\\s+")));
    }

    private boolean isHonoritic(List<String> names) {
        return names.get(0).matches("Mr\\.|Mrs\\.");
    }
}
