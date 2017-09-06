import org.hamcrest.core.Is;
import org.junit.Test;

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
    }

    private String invert(String name) {
        if (name == null || name.isEmpty())
            return "";
        else {
            String[] names = name.trim().split("\\s+");
            if (names.length == 2)
                return String.format("%s, %s", names[1], names[0]);
            else
                return names[0];
        }
    }
}
