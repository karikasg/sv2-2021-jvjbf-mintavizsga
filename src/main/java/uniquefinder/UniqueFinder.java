package uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {
    public List<Character> getUniqueChars(String text) {
        List<Character> result = new ArrayList<>();

        if (text == null) {
            throw new IllegalArgumentException("Text is null.");
        }

        for (int i = 0; i < text.length(); i++) {
            if (!result.contains(text.charAt(i))) {
                result.add(text.charAt(i));
            }
        }

        return result;
    }
}
