package sample.algorithms;

import sample.Pixel;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Bresenhem implements DrawAlgorithm {
    private Pixel firstPixel = null;

    @Override
    public Iterator<Pixel> dot(Pixel pixel) {
        if (firstPixel == null){
            firstPixel = pixel;
            LinkedList<Pixel> pixels = new LinkedList<>();
            pixels.add(pixel);
            return pixels.iterator();
        }

        LinkedList<Pixel> pixels = new LinkedList<>();

        int x = firstPixel.x;
        int y = firstPixel.y;
        int dx = pixel.x - firstPixel.x;
        int dy = pixel.y - firstPixel.y;
        int sx = (dx > 0) ? (1) : (-1);
        int sy = (dy > 0) ? (1) : (-1);
        dx = Math.abs(dx);
        dy = Math.abs(dy);

        if (dx > dy) {
            int e = 2 * dy - dx;

            for (int i = 0; i < dx; i++) {
                if (e >= 0) {
                    y += sy;
                    e -= 2 * dx;
                }
                x += sx;
                e += 2 * dy;
                pixels.add(new Pixel(x, y));
            }
        }
        else {
            int e = 2 * dx - dy;

            for (int i = 0; i < dy; i++) {
                if (e >= 0) {
                    x += sx;
                    e -= 2 * dy;
                }
                y += sy;
                e += 2 * dx;
                pixels.add(new Pixel(x, y));
            }
        }//TODO remove duplicate code

        firstPixel = null;
        return pixels.iterator();
    }
}
