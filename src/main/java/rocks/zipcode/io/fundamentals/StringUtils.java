package rocks.zipcode.io.fundamentals;


import java.awt.print.Pageable;
import java.util.*;

/**
 * @author leon on 10/01/2019.
 */
public class StringUtils {
    /**
     * @param string - string to be evaluated
     * @return collection containing all permutations of casing of this string
     */
    public static Collection<String> getAllCasings(String string) {
        // get length of string
        // get range of length
        // get power-set of range
        // for every set in power-set
        // uppercase indices of string using set
        StringBuilder builder = new StringBuilder();
        builder.append(string);

        for (int j = 0; j < string.length() ; j++) {
            for (int i = 0; i < string.length(); i++) {
                builder.append(",");
                builder.append(upperCaseIndices(string, i));
            }
        }
        System.out.println(builder.toString());

        return Collections.singleton(builder.toString());
    }

    /**
     * @param string  - string to be evaluated
     * @param indices - indices to be evaluated
     * @return near-identical string whose characters at specified indices are capitalized
     */
    public static String upperCaseIndices(String string, Integer... indices) {
        StringBuilder builder = new StringBuilder();
        List<Integer> index = Arrays.asList(indices);
        for (int i = 0; i < string.length(); i++) {
            if (index.contains(i)) {
                builder.append(Character.toUpperCase(string.charAt(i)));
            } else {
                builder.append(string.charAt(i));
            }

        }
        return builder.toString();
    }


    /**
     * @param stringToBeManipulated - string to be evaluated
     * @param valueToBeInserted     - value to insert into string
     * @param index                 - string-index at which to insert value into string
     * @return near-identical string with `valueToBeInserted` inserted at `index`
     */
    public static String insertAtIndex(String stringToBeManipulated, String valueToBeInserted, Integer index) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < stringToBeManipulated.length(); i++) {
            if (i == index) {
                builder.append(valueToBeInserted);
                builder.append(stringToBeManipulated.charAt(i));
            } else {
                builder.append(stringToBeManipulated.charAt(i));
            }
        }

        return builder.toString();
    }

    /**
     * @param stringToBeManipulated - string to be evaluated
     * @param replacementValue      - value to insert at `index`
     * @param index                 - position of string to be manipulated
     * @return near-identical string with character at `index` replaced with `replacementValue`
     */
    public static String replaceAtIndex(String stringToBeManipulated, Character replacementValue, Integer index) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < stringToBeManipulated.length(); i++) {
            if (i == index) {
                builder.append(replacementValue);
            } else {
                builder.append(stringToBeManipulated.charAt(i));
            }
        }

        return builder.toString();
    }
}
