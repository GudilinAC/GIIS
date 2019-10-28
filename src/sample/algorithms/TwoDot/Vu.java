package sample.algorithms.TwoDot;

import javafx.scene.paint.Color;
import sample.Pixel;

import java.util.Collection;

import static sample.algorithms.Global.sign;

public class Vu extends TwoDotsAlgorithm {
    @Override
    protected void draw(Collection<Pixel> pixels) {
        int x = firstPixel.x;
        int y = firstPixel.y;
        double dx = secondPixel.x - firstPixel.x;
        double dy = secondPixel.y - firstPixel.y;
        int sx = sign(dx);
        int sy = sign(dy);
        dx = Math.abs(dx);
        dy = Math.abs(dy);
        double intensity;

        if (dx == 0) {
            for (int i = 1; i <= dy; i++)
                pixels.add(new Pixel(firstPixel.x, firstPixel.y + sy * i));
            return;
        }
        if (dy == 0) {
            for (int i = 1; i <= dx; i++)
                pixels.add(new Pixel(firstPixel.x + sx * i, firstPixel.y));
            return;
        }

        if (dx > dy) {
            y += sy;
            double secondaryY;
            double e = dy / dx - 0.5;

            for (int i = 0; i < dx - 1; i++) {
                x += sx;

                if (e >= 0.5) {
                    secondaryY = y;
                    y += sy;
                    e--;
                } else secondaryY = y - sy;
                e += dy / dx;

                intensity = Math.max(Math.min(e, 1.0), 0.0);
                pixels.add(new Pixel(x, y, Color.gray(1 - intensity)));
                pixels.add(new Pixel(x, secondaryY, Color.gray(intensity)));
            }
        } else {
            x += sx;
            double secondaryX;
            double e = dx / dy - 0.5;

            for (int i = 0; i < dy - 1; i++) {
                y += sy;

                if (e >= 0.5) {
                    secondaryX = x;
                    x += sx;
                    e--;
                } else secondaryX = x - sx;
                e += dx / dy;

                intensity = Math.max(Math.min(e, 1.0), 0.0);
                pixels.add(new Pixel(x, y, Color.gray(1 - intensity)));
                pixels.add(new Pixel(secondaryX, y, Color.gray(intensity)));
            }
        }

        pixels.add(new Pixel(secondPixel.x, secondPixel.y));
    }
}
