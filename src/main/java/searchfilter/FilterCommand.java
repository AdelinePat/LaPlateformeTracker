package searchfilter;

import exceptions.StringInputException;
import utils.DataUtils;
import static exceptions.ExceptionMessage.INVALID_INPUT_FLOAT;
import static exceptions.ExceptionMessage.INVALID_INPUT_INTEGER;

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
    private boolean isMaxAgeGreaterThanMinAge() {
        return this.minAgeValue <= this.maxAgeValue;
    }

    private boolean isMaxGradeGreaterThanMinGrade() {
        return this.minGradeValue <= this.maxGradeValue;
    }

    public void setAgeValues(String minValue, String maxValue) throws StringInputException {
        this.setMinAgeValue(minValue);
        this.setMaxAgeValue(maxValue);
        if (!this.isMaxAgeGreaterThanMinAge()) {
            this.minAgeValue = this.maxAgeValue;
            this.maxAgeValue = Integer.parseInt(minValue);
        }
    }
    private void setMinAgeValue(String value) throws StringInputException {
        if (!DataUtils.isInputEmpty(value)
                && DataUtils.isInputIntegerValid(value)) {
            this.minAgeValue = Integer.parseInt(value);
        } else if (DataUtils.isInputEmpty(value)) {
            this.minAgeValue = 0;
//            this.setMinAgeValue(0);
        } else {
            throw new StringInputException(INVALID_INPUT_INTEGER.getMessage());
        }
    }

    private void setMaxAgeValue(String value) throws StringInputException {
        if (!DataUtils.isInputEmpty(value)
                && DataUtils.isInputIntegerValid(value)) {
            this.maxAgeValue = Integer.parseInt(value);
        } else if (DataUtils.isInputEmpty(value)) {
            this.maxAgeValue = 99;
//            this.setMaxAgeValue(99);
        } else {
            throw new StringInputException(INVALID_INPUT_INTEGER.getMessage());
        }
    }

    public void setGradeValues(String minValue, String maxValue) throws StringInputException {
        this.setMinGradeValue(minValue);
        this.setMaxGradeValue(maxValue);
        if (!this.isMaxGradeGreaterThanMinGrade()) {
            this.minGradeValue = this.maxGradeValue;
            this.maxGradeValue = Float.parseFloat(minValue);
        }
    }

    private void setMinGradeValue(String value) throws StringInputException {
        if (!DataUtils.isInputEmpty(value)
                && DataUtils.isInputFloatValid(value)) {
            this.minGradeValue = Float.parseFloat(value);
        } else if (DataUtils.isInputEmpty(value)) {
            this.minGradeValue = 0;
        } else {
            throw new StringInputException(INVALID_INPUT_FLOAT.getMessage());
        }
    }

    private void setMaxGradeValue(String value) throws StringInputException {
        if (!DataUtils.isInputEmpty(value)
                && DataUtils.isInputFloatValid(value)) {

            this.maxGradeValue = Float.parseFloat(value);
        } else if (DataUtils.isInputEmpty(value)) {
            this.maxGradeValue = 20;
        } else {
            throw new StringInputException(INVALID_INPUT_FLOAT.getMessage());
        }
    }
}
