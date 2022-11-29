package Labs_O.Lab_5.task4;

import java.util.Comparator;

public class TagCounterComparator implements Comparator<TagCounter> {
    @Override
    public int compare(TagCounter o1, TagCounter o2) {
        return o1.Value.compareTo(o2.Value);
    }
}
