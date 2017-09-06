import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameInverterTest {
    @Test
    public void nameInverter()
    {
        assertThat(invert(null), Is.is(""));
    }

    private String invert(String name) {
        return null;
    }
}
