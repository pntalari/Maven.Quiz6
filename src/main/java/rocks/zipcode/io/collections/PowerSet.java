package rocks.zipcode.io.collections;

import java.util.*;

/**
 * @author leon on 10/01/2019.
 */
public class PowerSet<TypeOfSet> {
    protected Set<TypeOfSet> originalSet;

    public PowerSet(TypeOfSet[] originalSet) {

        this.originalSet = new HashSet<>(Arrays.asList(originalSet));
    }

    /**
     * @return the powerset of `originalSet`
     */
    public Set<Set<TypeOfSet>> permute() {

        Set<Set<TypeOfSet>> sets = new LinkedHashSet<>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<>());
            return sets;
        }
        List<TypeOfSet> list = new ArrayList<>(originalSet);
        TypeOfSet head = list.get(0);
        Set<TypeOfSet> rest = new LinkedHashSet<>(list.subList(1, list.size()));
        this.originalSet = rest;
        for (Iterable<TypeOfSet> set : permute()) {
            Set<TypeOfSet> newSet = new LinkedHashSet<>();
            newSet.add(head);
            newSet.addAll((Collection<? extends TypeOfSet>) set);
            sets.add(newSet);
            sets.add((Set<TypeOfSet>) set);
        }
        return sets;
    }

    /**
     * @return `originalSet`
     */
    public Set<TypeOfSet> getOriginalSet() {

        return originalSet;
    }
}
