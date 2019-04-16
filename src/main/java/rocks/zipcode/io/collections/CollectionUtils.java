package rocks.zipcode.io.collections;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionUtils {

    /**
     * @param collection - object to be converted to list
     * @param <E>        - type of collection
     * @return list with identical contents
     */
    public static <E> List<E> toList(Collection collection) {
        Object[] arr = new Object[collection.size()];
        int count = 0;
        for (Object item : collection) {
            arr[count] = item;
            count++;
        }

        return (List<E>) Arrays.asList(arr);
    }

    /**
     * @param nestedCollection - collection to be evaluated
     * @param collection       - collections to be sought within `nestedCollection`
     * @return true if `nestedCollection` contains a collection with contents identical to `collection`
     */
    public static Boolean contains(Collection<? extends Collection<?>> nestedCollection, Collection<?> collection) {
        Boolean flag = false;
        if (nestedCollection.contains(collection)) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    /**
     * @param collections - collections to be nested
     * @return a single collection containing each of the collections passed in as an argument
     */
    public static Collection<? extends Collection<?>> nest(Collection<?>... collections) {
        Collection<? extends Collection<?>> nestedCollection = Arrays.asList(
                collections);
        return nestedCollection;
    }

    /**
     * @param collections - collections to be combined
     * @return a single collection containing the aggregate contents of each collection passed in as an argument
     */
    public static Collection<?> flatten(Collection<?>... collections) {
//        Object[] arr = new Object[collections.length];
//        for (int i = 0; i < collections.length; i++) {
//            arr[i] = collections[i];
//        }
        Stream<Object> stream = Arrays.stream(collections)
                .flatMap(x -> x.stream());

        return Arrays.asList(stream.toArray());

    }
}
