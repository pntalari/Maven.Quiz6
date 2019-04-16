package rocks.zipcode.io.fundamentals;

import java.util.ArrayList;
import java.util.List;

public class BasicStringUtils {
    /**
     * @param chars - characters used to instantiate a new string object
     * @return new String which wraps the arguments passed in
     */
    public static String getString(char[] chars) {
        StringBuilder builder = new StringBuilder();
        for (char c : chars
        ) {
            builder.append(c);
        }
        return builder.toString();
    }

    /**
     * @param chars - characters used to instantiate a new string object
     * @return new String which wraps the arguments passed in
     */
    public static String getString(Character[] chars) {
        StringBuilder builder = new StringBuilder();
        for (Character c : chars) {
            builder.append(c);
        }
        return builder.toString();
    }

    /**
     * @param string - string to be manipulated
     * @return identical string with lowercase and uppercase vowels removed
     */
    public static String removeAllVowels(String string) {
        String regex = "[aeiouAEIOU]";
        String retStr = string.replaceAll(regex, "");
        return retStr;
    }

    /**
     * @param string             - string to be manipulated
     * @param charactersToRemove - characters to be removed from string
     * @return
     */
    public static String removeSpecifiedCharacters(String string, String charactersToRemove) {
        List<Character> remove = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i <charactersToRemove.length() ; i++) {
            remove.add(charactersToRemove.charAt(i));
        }

        for (int i = 0; i <string.length() ; i++) {
            if(!remove.contains(string.charAt(i))){
                builder.append(string.charAt(i));
            }
        }

        return builder.toString();
    }
}
