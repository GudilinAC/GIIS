package sample.algorithms.TwoDot;

import javafx.scene.paint.Color;
import sample.Pixel;

import java.util.ArrayList;
import java.util.LinkedList;

public class Circle extends TwoDotsAlgorithm {

    @Override
    protected void draw(LinkedList<Pixel> pixels) {
        int R2 = (int) (Math.pow(secondPixel.x - firstPixel.x, 2) + Math.pow(secondPixel.y - firstPixel.y, 2));

        Pixel pixel45 = new Pixel(Math.pow(R2 / 2., 0.5) + 0.5, Math.pow(R2 / 2., 0.5) + 0.5);
        ArrayList<Pixel> segment = new ArrayList<>(pixel45.x * 2);

        int x = (int) (Math.pow(R2, 0.5) + 0.5);
        int y = 0;
        int e = (int)(2 - 2 * Math.pow(R2, 0.5));

        segment.add(new Pixel(x, y));

        for (; y <= pixel45.y; y++) {
            e += 2 * y + 1;

            if (e > 0) {
                x--;
                e += -2 * x + 1;
            }

            segment.add(new Pixel(x, y));
        }

        for (int i = segment.size() - 1; i > 0; i--) {
            Pixel p = segment.get(i);
            //noinspection SuspiciousNameCombination
            segment.add(new Pixel(p.y, p.x));
        }

        segment.forEach(p -> pixels.add(new Pixel(firstPixel.x + p.x, firstPixel.y + p.y)));
        segment.forEach(p -> pixels.add(new Pixel(firstPixel.x - p.y, firstPixel.y + p.x)));
        segment.forEach(p -> pixels.add(new Pixel(firstPixel.x - p.x, firstPixel.y - p.y)));
        segment.forEach(p -> pixels.add(new Pixel(firstPixel.x + p.y, firstPixel.y - p.x)));
    }
}
