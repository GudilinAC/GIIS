package sample.algorithms;

import sample.Pixel;
import sample.Settings;

import java.util.LinkedList;

public class Parabola extends OneDotAlgorithm {
    public Parabola(double p) {
        super(p);
    }

    private Pixel pixel45;

    @Override
    protected void draw(LinkedList<Pixel> pixels) {
        pixel45 = new Pixel(p, - p/2);

        double e = 0;
        double x = 0;
        double y = 0;

        pixels.add(pixel);

        for (x = 1; x < pixel45.x && x < Settings.MAX_X; x++) {
            if (e >= 0) {
                y--;
                e--;
            }
            e += x*x + 2 * p * y;

            pixels.add(new Pixel(pixel.x + x, pixel.y + y));
            pixels.add(new Pixel(pixel.x - x, pixel.y + y));
        }

        pixels.add(new Pixel(pixel.x + pixel45.x, pixel.y + pixel45.y));
        pixels.add(new Pixel(pixel.x - pixel45.x, pixel.y + pixel45.y));

        x = pixel45.x;
        e = 0;
        for (y = pixel45.y; y < Settings.MAX_Y; y--){
            if (e >= 0) {
                x++;
                e--;
            }
            e += x*x + 2 * p * y;

            pixels.add(new Pixel(pixel.x + x, pixel.y + y));
            pixels.add(new Pixel(pixel.x - x, pixel.y + y));
        }
    }
}
