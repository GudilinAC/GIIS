package sample.algorithms;

import sample.Pixel;

import java.util.LinkedList;

public class Bresenhem extends TwoDotsAlgorithm {
    @Override
    protected void draw(LinkedList<Pixel> pixels) {
        int x = firstPixel.x;
        int y = firstPixel.y;
        int dx = secondPixel.x - firstPixel.x;
        int dy = secondPixel.y - firstPixel.y;
        int sx = Global.sign(dx);
        int sy = Global.sign(dy);
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
        } else {
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
        }//0-0, 11-5, брезенхем на бумаге
    }
}
