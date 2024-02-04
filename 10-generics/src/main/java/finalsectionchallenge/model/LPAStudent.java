package finalsectionchallenge.model;

import finalsectionchallenge.util.QueryItem;

public class LPAStudent extends Student implements QueryItem {
    private double percentComplete;

    public LPAStudent() {
        this.percentComplete = random.nextDouble(0, 100.001);
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        if (fieldName.equalsIgnoreCase("percentComplete")) {
            return percentComplete <= Double.parseDouble(value);
        }
        return super.matchFieldValue(fieldName, value);
    }
}
