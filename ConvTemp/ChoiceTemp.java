package ConvTemp;

public enum ChoiceTemp {
    CELSIUS(1), KELVIN(2), FAHRENHEIT(3);
    private final int unit;

    private ChoiceTemp(int unit) {
        this.unit = unit;
    }

    public static ChoiceTemp getInd(int scale) {
        for (ChoiceTemp scaleName : values()) {
            if (scaleName.unit == scale) {
                return scaleName;
            }
        }
        System.err.println("Scale invalid: " + scale + "\nNew value of scale is CELSIUS");
        return ChoiceTemp.getInd(1);
    }
}
