package sample.algorithms.TwoDot;

import sample.Pixel;
import sample.Settings;

import java.util.Collection;

import static sample.algorithms.Global.sign;

public class Parabola extends TwoDotsAlgorithm {

    @Override
    protected void draw(Collection<Pixel> pixels) {
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

        double p = -Math.pow(secondPixel.x - firstPixel.x, 2) / (2 * (secondPixel.y - firstPixel.y));

        int x = 0;
        int y = 0;

        pixels.add(firstPixel);

        int sy = sign(p);
        double e = -sy * 2 * p;

        while (x < Math.abs(p) && x < Settings.MAX_X) {
            x++;
            e += 2 * x + 1;

            if (e > 0) {
                y -= sy;
                e -= sy * 2 * p;
            }

            pixels.add(new Pixel(firstPixel.x + x, firstPixel.y + y));
            pixels.add(new Pixel(firstPixel.x - x, firstPixel.y + y));
        }

        while (Math.abs(y) < Settings.MAX_Y) {
            y -= sy;
            e -= sy * 2 * p;

            if (e < 0) {
                x++;
                e += 2 * x + 1;
            }

            pixels.add(new Pixel(firstPixel.x + x, firstPixel.y + y));
            pixels.add(new Pixel(firstPixel.x - x, firstPixel.y + y));
        }
    }
}
