package searchfilter;

import exceptions.StringInputException;
import utils.DataUtils;

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

    public void setAgeValues(String minValue, String maxValue) throws StringInputException {
        this.setMinAgeValue(minValue);
        this.setMaxAgeValue(maxValue);
    }

    private void setMinAgeValue(String value) throws StringInputException {
        if (!DataUtils.isInputEmpty(value)
                && DataUtils.isInputIntegerValid(value)) {
            this.setMinAgeValue(Integer.parseInt(value));
        } else if (DataUtils.isInputEmpty(value)) {
            this.setMinAgeValue(0);
        } else {
            throw new StringInputException("Le nombre entré est invalide : veuillez entrer un entier");
        }
    }

    private void setMaxAgeValue(String value) throws StringInputException {
        if (!DataUtils.isInputEmpty(value)
                && DataUtils.isInputIntegerValid(value)) {
            this.setMaxAgeValue(Integer.parseInt(value));
        } else if (DataUtils.isInputEmpty(value)) {
            this.setMaxAgeValue(99);
        } else {
            throw new StringInputException("Le nombre entré est invalide : veuillez entrer un entier");
        }
    }

    public void setGradeValues(String minValue, String maxValue) throws StringInputException {
        this.setMinGradeValue(minValue);
        this.setMaxGradeValue(maxValue);
    }

    private void setMinGradeValue(String value) throws StringInputException {
        if (!DataUtils.isInputEmpty(value)
                && DataUtils.isInputFloatValid(value)) {
            this.setMinGradeValue(Float.parseFloat(value));
        } else if (DataUtils.isInputEmpty(value)) {
            this.setMinGradeValue(0);
        } else {
            throw new StringInputException("Le nombre entré est invalide : veuillez entrer un nombre entier ou décimal");
        }
    }

    private void setMaxGradeValue(String value) throws StringInputException {
        if (!DataUtils.isInputEmpty(value)
                && DataUtils.isInputFloatValid(value)) {
            this.setMaxGradeValue(Float.parseFloat(value));
        } else if (DataUtils.isInputEmpty(value)) {
            this.setMaxGradeValue(20);
        } else {
            throw new StringInputException("Le nombre entré est invalide : veuillez entrer un nombre entier ou décimal");
        }
    }


}
