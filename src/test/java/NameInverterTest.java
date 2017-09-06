import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class NameInverterTest {
    @Test
    public void nameInverter() {
        assertThat(invert(null), Is.is(""));
        assertThat(invert(""), Is.is(""));
        assertThat(invert("name"), Is.is("name"));
    }

    private String invert(String name) {
        if (name == null || name.isEmpty())
            return "";
        else
            return name;
    }
}
