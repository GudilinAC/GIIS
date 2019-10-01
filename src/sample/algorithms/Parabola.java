package sample.algorithms;

import sample.Pixel;
import sample.Settings;

import java.util.LinkedList;

public class Parabola extends TwoDotsAlgorithm {

    @Override
    protected void draw(LinkedList<Pixel> pixels) {
        double p = - Math.pow(secondPixel.x - secondPixel.y, 2) / (2 * (secondPixel.y - firstPixel.y));
        Pixel pixel45 = new Pixel(p, -p / 2);

        double e;
        int x;
        int y = 0;

        pixels.add(firstPixel);

        for (x = 1; x < pixel45.x && x <= Settings.MAX_X; x++) {
            e = x * x + 2 * p * y;
            if (e > 1)
                y--;

            pixels.add(new Pixel(firstPixel.x + x, firstPixel.y + y));
            pixels.add(new Pixel(firstPixel.x - x, firstPixel.y + y));
        }

        pixels.add(new Pixel(firstPixel.x + pixel45.x, firstPixel.y + pixel45.y));
        pixels.add(new Pixel(firstPixel.x - pixel45.x, firstPixel.y + pixel45.y));

        x = pixel45.x;
        for (y = pixel45.y - 1; -y <= Settings.MAX_Y; y--) {
            e = x * x + 2 * p * y;
            if (e < 0)
                x++;

            pixels.add(new Pixel(firstPixel.x + x, firstPixel.y + y));
            pixels.add(new Pixel(firstPixel.x - x, firstPixel.y + y));
        }
    }
}
