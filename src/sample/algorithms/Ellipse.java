package sample.algorithms;

import sample.Pixel;

import java.util.LinkedList;

public class Ellipse extends TwoDotsAlgorithm {
    @Override
    protected void draw(LinkedList<Pixel> pixels) {
        int dx = Math.abs(secondPixel.x - firstPixel.x);
        int dy = Math.abs(secondPixel.y - firstPixel.y);

        if (dx == 0) {
            for (int i = -dy; i <= dy; i++)
                pixels.add(new Pixel(firstPixel.x, firstPixel.y + i));
            return;
        }
        if (dy == 0) {
            for (int i = -dx; i <= dx; i++)
                pixels.add(new Pixel(firstPixel.x + i, firstPixel.y));
            return;
        }

        int a2 = 2 * dx * dx;
        int b2 = 2 * dy * dy;

        LinkedList<Pixel> segment = new LinkedList<>();

        double e = a2 + b2 - 2 * a2 * Math.pow(b2, 0.5);
        int x = 0;
        int y = (int) (Math.pow(b2, 0.5) + 0.5);

        segment.add(new Pixel(x, y));
        while (y >= 0) {
            if (e < 0) {
                x++;
                e += b2 * (2 * x + 1);
                if ((2 * (e + a2 * y) - 1) > 0) {
                    y--;
                    e += a2 * (1 - 2 * y);
                }
            } else if (e > 0) {
                y--;
                e += a2 * (1 - 2 * y);
                if ((2 * (e - b2 * x) - 1) <= 0) {
                    x++;
                    e += b2 * (2 * x + 1);
                }
            } else {
                x++;
                y--;
                e += b2 * (2 * x + 1) + a2 * (1 - 2 * y);
            }

            segment.add(new Pixel(x, y));
        }

        segment.forEach(p -> pixels.add(new Pixel(firstPixel.x + p.x, firstPixel.y + p.y)));
        segment.forEach(p -> pixels.add(new Pixel(firstPixel.x - p.x, firstPixel.y + p.y)));
        segment.forEach(p -> pixels.add(new Pixel(firstPixel.x - p.x, firstPixel.y - p.y)));
        segment.forEach(p -> pixels.add(new Pixel(firstPixel.x + p.x, firstPixel.y - p.y)));

    }
}
