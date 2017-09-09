import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NameInverterTest {

    private NameInverter nameInvertor = new NameInverter();

    @Test
    public void nameInverter() {
        assertThat(nameInvertor.invert(null), is(""));
        assertThat(nameInvertor.invert(""), is(""));
        assertThat(nameInvertor.invert("name"), is("name"));
        assertThat(nameInvertor.invert("first last"), is("last, first"));
        assertThat(nameInvertor.invert("      name     "), is("name"));
        assertThat(nameInvertor.invert("first      last"), is("last, first"));
        assertThat(nameInvertor.invert("Mr. first last"), is("last, first"));
        assertThat(nameInvertor.invert("Mrs. first last"), is("last, first"));
        assertThat(nameInvertor.invert("first last SR."), is("last, first SR."));
        assertThat(nameInvertor.invert("first last BS. Phd."), is("last, first BS. Phd."));
        assertThat(nameInvertor.invert("    Rober Martin 11 esq."), is("Martin, Rober 11 esq."));
    }

}
