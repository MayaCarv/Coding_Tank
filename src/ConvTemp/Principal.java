package ConvTemp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        initialize();
        ToFahrenheit resultF = new ToFahrenheit();
        ToCelsius resultC = new ToCelsius();
        ToKelvin resultK = new ToKelvin();

        int num = getNum();
        float[] temp = new float[num];
        float[] tempConv = new float[num];
        ChoiceTemp scaleIn = getScale("input");
        ChoiceTemp scaleOut = getScale("output");
        for (int i = 0; i < num; i++) {
            temp[i] = getTemp(i);
        }
        System.out.println("\nThe values obtained are:");
        for (int i = 0; i < num; i++) {
            if (scaleOut == ChoiceTemp.KELVIN) {
                tempConv[i] = resultK.convert(temp[i], scaleIn);
            } else if (scaleOut == ChoiceTemp.FAHRENHEIT) {
                tempConv[i] = resultF.convert(temp[i], scaleIn);
            } else if (scaleOut == ChoiceTemp.CELSIUS) {
                tempConv[i] = resultC.convert(temp[i], scaleIn);
            }
        }
        mediaTemp(temp, num, scaleIn, "input");
        mediaTemp(tempConv, num, scaleOut, "output");
        System.out.println("");
    }

    private static void initialize() {

        System.out.println("\n*** Welcome to the temperature conversion program ***\n");
    }

    private static int getNum() {
        try {
            int num;
            Scanner input = new Scanner(System.in);
            System.out.println("Enter how many temperature you want to convert:");
            num = input.nextInt();
            if(num < 1)
            {
                System.err.println("Invalid quantity!!!");
                return getNum();
            }
            return num;
        } catch (InputMismatchException e) {
            System.err.println("\nPlease enter a number!!");
            return getNum();
        }
    }

    private static float getTemp(int i) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the " + (i + 1) + "º value you want to convert:");
            return input.nextFloat();
        } catch (InputMismatchException e) {
            System.err.println("\nPlease enter a number!!");
            return getTemp(i);
        }
    }

    private static ChoiceTemp getScale(String io) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter the temperature unit of %s:\n", io);
        System.out.println("____________________");
        System.out.println("| 1 for CELSIUS    |");
        System.out.println("| 2 for KELVIN     |");
        System.out.println("| 3 for FAHRENHEIT |");
        System.out.println("____________________");
        try {
            int scale = input.nextInt();
            ChoiceTemp scaleName = ChoiceTemp.getInd(scale);
            System.out.println("The chosen temperature unit of " + io + " is " + scaleName + "\n");
            return scaleName;
        } catch (InputMismatchException e) {
            System.err.println("\nPlease enter a number!!");
            return getScale(io);
        }
    }

    private static void mediaTemp(float[] temp, int tam, ChoiceTemp scale, String io) {
        float mediaTemp = 0;
        for (float temps : temp) {
            mediaTemp += temps;
        }
        mediaTemp /= tam;
        if (scale == ChoiceTemp.CELSIUS) {
            System.out.printf("\nThe average %s temperature is: %.2fºC", io, mediaTemp);
        }
        if (scale == ChoiceTemp.KELVIN) {
            System.out.printf("\nThe average %s temperature is: %.2fºK", io, mediaTemp);
        }
        if (scale == ChoiceTemp.FAHRENHEIT) {
            System.out.printf("\nThe average %s temperature is: %.2fºF", io, mediaTemp);
        }
    }
}