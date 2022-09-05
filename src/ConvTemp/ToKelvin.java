package ConvTemp;

public class ToKelvin {
    public float convert(float temp, ChoiceTemp scale) {
        float result;
        if(scale == ChoiceTemp.FAHRENHEIT) {
            result = (float) ((temp - 32) * 5/9 + 273.15);
            System.out.printf("%.2f ºF ---> %.2f ºK\n", temp, result);
        } else if (scale == ChoiceTemp.CELSIUS) {
            result = (float) (temp + 273.15);
            System.out.printf("%.2f ºC ---> %.2f ºK\n", temp, result);
        } else {
            result = temp;
            System.out.printf("%.2f ºK ---> %.2f ºK\n", temp, result);
        }
        return result;
    }
}
