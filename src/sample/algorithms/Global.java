package sample.algorithms;

public class Global {
    public static int sign(double x) {
        return (x > 0) ? 1 : (x < 0) ? -1 : 0;
    }

    public static int sign(int x) {
        return Integer.compare(x, 0);
    }
}
