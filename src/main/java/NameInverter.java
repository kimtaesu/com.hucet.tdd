import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NameInverter {


    private String formatMultiElementName(List<String> names) {
        String postNominal = "";
        if (names.size() > 2)
            postNominal = getPostNominal(names);
        return String.format("%s, %s %s", names.get(1), names.get(0), postNominal).trim();
    }

    private String getPostNominal(List<String> names) {
        List<String> postNominals = names.subList(2, names.size());
        return Joiner.on(" ").join(postNominals);
    }

    private boolean isHonoritic(List<String> names) {
        return names.get(0).matches("Mr\\.|Mrs\\.");
    }

    public String invert(String name) {
        if (name == null || name.isEmpty())
            return "";
        else
            return formatName(removeHonorific(splitNames(name)));
    }

    private String formatName(List<String> names) {
        if (names.size() == 1) {
            return names.get(0);
        }
        return formatMultiElementName(names);
    }

    private List<String> removeHonorific(List<String> names) {
        if (names.size() > 1 && isHonoritic(names))
            names.remove(0);
        return names;
    }

    private List<String> splitNames(String name) {
        return new ArrayList<>(Arrays.asList(name.trim().split("\\s+")));
    }
}
