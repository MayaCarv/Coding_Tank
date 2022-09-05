package ConvTemp;

public class ToFahrenheit {
    public float convert(float temp, ChoiceTemp scale) {
        float result;
        if(scale == ChoiceTemp.CELSIUS) {
            result = (float) (temp * 9.0 / 5 + 32);
            System.out.printf("%.2f ºC ---> %.2f ºF\n", temp, result);
        } else if (scale == ChoiceTemp.KELVIN) {
            result = (float) ((temp - 273.15) * 1.8 + 32);
            System.out.printf("%.2f ºK ---> %.2f ºF\n", temp, result);
        } else {
            result = temp;
            System.out.printf("%.2f ºF ---> %.2f ºF\n", temp, result);
        }
        return result;
    }
}