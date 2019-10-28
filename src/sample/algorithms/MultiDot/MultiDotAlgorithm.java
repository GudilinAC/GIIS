package sample.algorithms.MultiDot;

import sample.Pixel;
import sample.algorithms.DrawAlgorithm;

import java.util.*;

public abstract class MultiDotAlgorithm implements DrawAlgorithm {
    protected List<Pixel> inputs = new LinkedList<>();

    @Override
    public Collection<Pixel> drawAndReset(Pixel pixel) {
        inputs.add(pixel);
        Set<Pixel> pixels = new HashSet<>();
        if (inputs.size() < 1) {
            pixels.add(pixel);
        } else {
            draw(pixels);
        }
        return pixels;
    }

    @Override
    public Collection<Pixel> drawNoReset(Pixel pixel) {
        Set<Pixel> pixels = new HashSet<>();
        if (inputs.size() > 1) {
            inputs.add(pixel);
            draw(pixels);
            inputs.remove(inputs.size() - 1);
        }
        return pixels;
    }

    @Override
    public Collection<Pixel> drawAll(Pixel... inputs) {
        this.inputs.addAll(Arrays.asList(inputs));
        Set<Pixel> pixels = new HashSet<>();
        draw(pixels);
        return pixels;
    }

    @Override
    public void clear() {
        inputs.clear();
    }

    protected abstract void draw(Collection<Pixel> pixels);
}
