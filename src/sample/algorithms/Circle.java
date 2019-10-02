package sample.algorithms;

import javafx.scene.paint.Color;
import sample.Pixel;

import java.util.ArrayList;
import java.util.LinkedList;

public class Circle extends TwoDotsAlgorithm{

    @Override
    protected void draw(LinkedList<Pixel> pixels) {
        int R2 = (int)(Math.pow(secondPixel.x - firstPixel.x, 2) + Math.pow(secondPixel.y - firstPixel.y, 2));
        double R = Math.pow(R2, 0.5);

        Pixel pixel45 = new Pixel(Math.pow(R2 / 2., 0.5) + 0.5 , Math.pow(R2 / 2., 0.5) + 0.5);
        ArrayList<Pixel> segment = new ArrayList<>(pixel45.x * 2);

        int e;
        int x = (int)(R + 0.5);
        int y;

        for (y = 0; y <= pixel45.y; y++) {
            e = x * x + y * y - R2;
            if (e > 0)
                x --;

            segment.add(new Pixel(x, y));
        }

        for (int i = segment.size() - 2; i > 0; i--) {
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