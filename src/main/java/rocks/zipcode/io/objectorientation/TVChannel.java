package rocks.zipcode.io.objectorientation;

import java.util.Arrays;
import java.util.function.Predicate;

public enum TVChannel {
    MSN(0,"MSN"),
    CNN(1,"CNN"),
    FOX(2,"FOX"),
    AE(3,"AE"),
    MTV(4,"MTV"),
    BET(5,"BET"),
    HBO(6,"HBO"),
    NBC(7,"NBC"),
    CBS(8,"CBS");

    private int channelNumber;
    private String channelName;

    TVChannel(int number, String name) {
        this.channelNumber = number;
        this.channelName = name;
    }

    /**
     * @param ordinal; ordinal of the expected enumeration
     * @return enumeration with respective ordinal
     */
    public static TVChannel getByOrdinal(Integer ordinal) {
        TVChannel[] arr =  TVChannel.values();
        return arr[ordinal];
    }

    /**
     * @param name; name of the expected enumeration
     * @return enumeration with respective name
     */
    public static TVChannel getByName(String name) {

        return find(channel -> name.equals(channel.name()));
    }

    /**
     * @param predicate - clause to evaluate
     * @return the first channel which is applicable to the `predicate`
     */
    private static TVChannel find(Predicate<TVChannel> predicate) {
        return Arrays
                .stream(TVChannel.values())
                .filter(predicate)
                .findFirst()
                .get();
    }
}
