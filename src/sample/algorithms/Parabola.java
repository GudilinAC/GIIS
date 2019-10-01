package sample.algorithms;

import sample.Pixel;
import sample.Settings;

import java.util.LinkedList;

import static sample.algorithms.Global.sign;

public class Parabola extends TwoDotsAlgorithm {

    @Override
    protected void draw(LinkedList<Pixel> pixels) {
        if (secondPixel.x == firstPixel.x && secondPixel.y == firstPixel.y) return;

        if (secondPixel.x == firstPixel.x) {
            int s = sign(secondPixel.y - firstPixel.y);
            for (int i = firstPixel.y; i < Settings.MAX_Y && i >= 0; i += s)
                pixels.add(new Pixel(firstPixel.x, i));
            return;
        }
        if (secondPixel.y == firstPixel.y) {
            for (int i = 0; i < Settings.MAX_X; i++)
                pixels.add(new Pixel(i, firstPixel.y));
            return;
        }

        double p = - Math.pow(secondPixel.x - firstPixel.x, 2) / (2 * (secondPixel.y - firstPixel.y));
        Pixel pixel45 = new Pixel(p, -p / 2);

        double e;
        int x;
        int y = 0;

        pixels.add(firstPixel);

        int sy = sign(p);
        for (x = 1; x < Math.abs(pixel45.x) && x < Settings.MAX_X; x++) {
            e = x * x + 2 * p * y;
            if (e > 1)
                y -= sy;

            pixels.add(new Pixel(firstPixel.x + x, firstPixel.y + y));
            pixels.add(new Pixel(firstPixel.x - x, firstPixel.y + y));
        }

        pixels.add(new Pixel(firstPixel.x + pixel45.x, firstPixel.y + pixel45.y));
        pixels.add(new Pixel(firstPixel.x - pixel45.x, firstPixel.y + pixel45.y));

        x = Math.abs(pixel45.x);
        for (y = pixel45.y - sy; Math.abs(y) < Settings.MAX_Y; y -= sy) {
            e = x * x + 2 * p * y;
            if (e < 0)
                x++;

            pixels.add(new Pixel(firstPixel.x + x, firstPixel.y + y));
            pixels.add(new Pixel(firstPixel.x - x, firstPixel.y + y));
        }
    }
}
