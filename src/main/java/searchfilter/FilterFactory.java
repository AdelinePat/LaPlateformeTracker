package searchfilter;

public class FilterFactory {
    static public ISearchFilter createFilter(FilterType type) {
        return switch (type) {
            case NOFILTER -> new NoFilter();
            case FIRSTNAME, LASTNAME -> new NameFilter();
            case AVERAGE, AGE -> new RangeFilter();
        };
    }
}
