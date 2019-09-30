package sample;

import javafx.scene.paint.Color;

public class Pixel {
    public final int x;
    public final int y;
    public final Color color;

    public Pixel(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Pixel(int x, int y){
        this(x, y, Color.BLACK);
    }

    public Pixel(double x, double y, Color color){
        this((int) (x), (int) (y), color);
    }

    public Pixel(double x, double y){
        this(x, y, Color.BLACK);
    }
}
