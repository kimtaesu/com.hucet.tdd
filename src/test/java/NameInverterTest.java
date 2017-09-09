import com.google.common.base.Joiner;
import javafx.beans.binding.ObjectBinding;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.assertThat;

public class NameInverterTest {
    @Test
    public void nameInverter() {
        assertThat(invert(null), is(""));
        assertThat(invert(""), is(""));
        assertThat(invert("name"), is("name"));
        assertThat(invert("first last"), is("last, first"));
        assertThat(invert("      name     "), is("name"));
        assertThat(invert("first      last"), is("last, first"));
        assertThat(invert("Mr. first last"), is("last, first"));
        assertThat(invert("Mrs. first last"), is("last, first"));
        assertThat(invert("first last SR."), is("last, first SR."));
        assertThat(invert("first last BS. Phd."), is("last, first BS. Phd."));
        assertThat(invert("    Rober Martin 11 esq."), is("Martin, Rober 11 esq."));
    }

    private String invert(String name) {
        if (name == null || name.isEmpty())
            return "";
        else {
            List<String> names = splitNames(name);
            removeHonorific(names);
            return formatName(names);
        }
    }

    private String formatName(List<String> names) {
        if (names.size() == 1) {
            return names.get(0);
        }
        String postNominal = getPostNominal(names);
        return String.format("%s, %s %s", names.get(1), names.get(0), postNominal).trim();
    }

    private String getPostNominal(List<String> names) {
        String postNominal = "";
        List<String> postNominals = new ArrayList<>();
        if (names.size() > 2) {
            postNominals = names.subList(2, names.size());
        }
        postNominal = Joiner.on(" ").join(postNominals);
        return postNominal;
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
