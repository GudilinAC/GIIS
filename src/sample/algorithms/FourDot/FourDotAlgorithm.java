package sample.algorithms.FourDot;

import sample.Pixel;
import sample.algorithms.DrawAlgorithm;

import java.util.LinkedList;

public abstract class FourDotAlgorithm implements DrawAlgorithm {
    protected Pixel pixel1;
    protected Pixel pixel2;
    protected Pixel pixel3;
    protected Pixel pixel4;

    @Override
    public LinkedList<Pixel> drawAndReset(Pixel pixel) {
        LinkedList<Pixel> pixels = new LinkedList<>();
        if (pixel1 == null) {
            pixel1 = pixel;
            pixels.add(pixel);
        } else if (pixel2 == null) {
            pixel2 = pixel;
            draw2(pixels);
        } else if (pixel3 == null) {
            pixel3 = pixel;
            draw3(pixels);
        } else if (pixel4 == null) {
            pixel4 = pixel;
            draw4(pixels);
            clear();
        }
        return pixels;
    }

    @Override
    public LinkedList<Pixel> drawNoReset(Pixel pixel) {
        LinkedList<Pixel> pixels = new LinkedList<>();
        if (pixel1 == null) {
            pixel1 = pixel;
            pixels.add(pixel);
            pixel1 = null;
        } else if (pixel2 == null) {
            pixel2 = pixel;
            draw2(pixels);
            pixel2 = null;
        } else if (pixel3 == null) {
            pixel3 = pixel;
            draw3(pixels);
            pixel3 = null;
        } else {
            pixel4 = pixel;
            draw4(pixels);
            pixel4 = null;
        }
        return pixels;
    }

    @Override
    public LinkedList<Pixel> drawAll(Pixel... inputs) {
        LinkedList<Pixel> pixels = new LinkedList<>();
        for (Pixel pixel : inputs) {
            pixels.addAll(drawAndReset(pixel));
        }
        return pixels;
    }

    @Override
    public void clear() {
        pixel1 = pixel2 = pixel3 = pixel4 = null;
    }

    protected abstract void draw2(LinkedList<Pixel> pixels);

    protected abstract void draw3(LinkedList<Pixel> pixels);

    protected abstract void draw4(LinkedList<Pixel> pixels);
}
