package sample.algorithms.FourDot;

import sample.Pixel;
import sample.algorithms.DrawAlgorithm;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class FourDotAlgorithm implements DrawAlgorithm {
    protected Pixel pixel1;
    protected Pixel pixel2;
    protected Pixel pixel3;
    protected Pixel pixel4;

    @Override
    public Collection<Pixel> drawAndReset(Pixel pixel) {
        Set<Pixel> pixels = new HashSet<>();
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
    public Collection<Pixel> drawNoReset(Pixel pixel) {
        Set<Pixel> pixels = new HashSet<>();
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
    public Collection<Pixel> drawAll(Pixel... inputs) {
        Set<Pixel> pixels = new HashSet<>();
        for (Pixel pixel : inputs) {
            pixels.addAll(drawAndReset(pixel));
        }
        return pixels;
    }

    @Override
    public void clear() {
        pixel1 = pixel2 = pixel3 = pixel4 = null;
    }

    protected abstract void draw2(Collection<Pixel> pixels);

    protected abstract void draw3(Collection<Pixel> pixels);

    protected abstract void draw4(Collection<Pixel> pixels);
}
