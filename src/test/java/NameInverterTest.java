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
    }

    private String invert(String name) {
        if (name == null || name.isEmpty())
            return "";
        else {
            List<String> names = new ArrayList<>(Arrays.asList(name.trim().split("\\s+")));
            if (names.size() > 1&& names.get(0).equals("Mr."))
                names.remove(0);
            if (names.size() == 2)
                return String.format("%s, %s", names.get(1), names.get(0));
            else
                return names.get(0);
        }
    }
}
