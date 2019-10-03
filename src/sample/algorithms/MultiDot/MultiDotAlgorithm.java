package sample.algorithms.MultiDot;

import sample.Pixel;
import sample.algorithms.DrawAlgorithm;


import java.util.Arrays;
import java.util.LinkedList;

public abstract class MultiDotAlgorithm implements DrawAlgorithm {
    protected LinkedList<Pixel> inputs = new LinkedList<>();

    @Override
    public LinkedList<Pixel> drawAndReset(Pixel pixel) {
        inputs.add(pixel);
        LinkedList<Pixel> pixels = new LinkedList<>();
        if (inputs.size() < 2){
            pixels.add(pixel);
        } else {
            draw(pixels);
        }
        return pixels;
    }

    @Override
    public LinkedList<Pixel> drawNoReset(Pixel pixel) {
        inputs.add(pixel);
        LinkedList<Pixel> pixels = new LinkedList<>();
        if (inputs.size() < 2){
            pixels.add(pixel);
        } else {
            draw(pixels);
            inputs.removeLast();
        }
        return pixels;
    }

    @Override
    public LinkedList<Pixel> drawAll(Pixel... inputs) {
        this.inputs.addAll(Arrays.asList(inputs));
        LinkedList<Pixel> pixels = new LinkedList<>();
        draw(pixels);
        return pixels;
    }

    @Override
    public void clear(){
        inputs.clear();
    }

    protected abstract void draw(LinkedList<Pixel> pixels);
}
