package searchfilter;

public class FilterCommand {
    private FilterType type;
    private String searchString;
    private int minAgeValue;
    private int maxAgeValue;
    private float minGradeValue;
    private float maxGradeValue;

    public void setType(FilterType type) {
        this.type = type;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public void setMinAgeValue(int minAgeValue) {
        this.minAgeValue = minAgeValue;
    }

    public void setMaxAgeValue(int maxAgeValue) {
        this.maxAgeValue = maxAgeValue;
    }

    public void setMinGradeValue(float minGradeValue) {
        this.minGradeValue = minGradeValue;
    }

    public void setMaxGradeValue(float maxGradeValue) {
        this.maxGradeValue = maxGradeValue;
    }

    public FilterType getType() {
        return type;
    }

    public String getSearchString() {
        return searchString;
    }

    public int getMinAgeValue() {
        return minAgeValue;
    }

    public int getMaxAgeValue() {
        return maxAgeValue;
    }

    public float getMinGradeValue() {
        return minGradeValue;
    }

    public float getMaxGradeValue() {
        return maxGradeValue;
    }
}
