package sample.algorithms;

import sample.Pixel;

import java.util.LinkedList;

public class Ellipse extends TwoDotsAlgorithm {
    @Override
    protected void draw(LinkedList<Pixel> pixels) {

        int dx = Math.abs(secondPixel.x - firstPixel.x);
        int dy = Math.abs(secondPixel.y - firstPixel.y);

        if (dx == 0) {
            for (int i = - dy; i <= dy; i++)
                pixels.add(new Pixel(firstPixel.x, firstPixel.y + i));
            return;
        }
        if (dy == 0) {
            for (int i = - dx; i <= dx; i++)
                pixels.add(new Pixel(firstPixel.x + i, firstPixel.y));
            return;
        }

        int a2 = 2 * dx * dx;
        int b2 = 2 * dy * dy;

        Pixel pixel45 = new Pixel(
                (a2 / Math.pow(b2 + a2, 0.5)) + 0.5,
                (b2 / Math.pow(b2 + a2, 0.5)) + 0.5
        );

        LinkedList<Pixel> segment = new LinkedList<>();

        double e;
        int x = (int) (Math.pow(a2, 0.5) + 0.5);
        int y;

        for (y = 0; y <= pixel45.y; y++) {
            e = (double) (x * x) / a2 + (double) (y * y) / b2 - 1;
            if (e > 0)
                x--;
            if (x < 0) break;
            segment.add(new Pixel(x, y));
        }

        for (; x >= 0; x--) {
            e = (double) (x * x) / a2 + (double) (y * y) / b2 - 1;
            if (e < 0)
                y++;

            segment.add(new Pixel(x, y));
        }

        segment.forEach(p -> pixels.add(new Pixel(firstPixel.x + p.x, firstPixel.y + p.y)));
        segment.forEach(p -> pixels.add(new Pixel(firstPixel.x - p.x, firstPixel.y + p.y)));
        segment.forEach(p -> pixels.add(new Pixel(firstPixel.x - p.x, firstPixel.y - p.y)));
        segment.forEach(p -> pixels.add(new Pixel(firstPixel.x + p.x, firstPixel.y - p.y)));

    }
}
