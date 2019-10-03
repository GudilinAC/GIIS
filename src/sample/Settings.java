package sample;

public class Settings {
    public static int MAX_X = 100;
    public static int MAX_Y = 100;

    public static void scale(boolean scale) {
        if (scale) {
            MAX_X = 100;
            MAX_Y = 100;
        } else {
            MAX_X = 901;
            MAX_Y = 901;
        }
    }
}
