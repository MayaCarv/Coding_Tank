package ConvTemp;

public class ToCelsius {

    public float convert(float temp, ChoiceTemp scale) {
        float result;
        if(scale == ChoiceTemp.FAHRENHEIT) {
           result = (float) ((temp - 32) / 1.8);
            System.out.printf("%.2f ºF ---> %.2f ºC\n", temp, result);
        } else if (scale == ChoiceTemp.KELVIN) {
            result = (float) (temp - 273.15);
            System.out.printf("%.2f ºK ---> %.2f ºC\n", temp, result);
        } else {
            result = temp;
            System.out.printf("%.2f ºC ---> %.2f ºC\n", temp, result);
        }
        return result;
    }
}
