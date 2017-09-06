import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class NameInverterTest {
    @Test
    public void nameInverter() {
        assertThat(invert(null), Is.is(""));
        assertThat(invert(""), Is.is(""));
    }

    private String invert(String name) {
        return "";
    }
}
