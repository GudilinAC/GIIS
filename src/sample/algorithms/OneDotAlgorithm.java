package sample.algorithms;

import sample.Pixel;

import java.util.LinkedList;

public abstract class OneDotAlgorithm implements DrawAlgorithm{
    protected Pixel pixel = null;
    protected final double p;

    public OneDotAlgorithm(double p){
        this.p = p;
    }

    @Override
    public LinkedList<Pixel> drawAndReset(Pixel pixel) {

        LinkedList<Pixel> pixels = new LinkedList<>();
        this.pixel = pixel;
        draw(pixels);
        return pixels;
    }

    @Override
    public LinkedList<Pixel> drawNoReset(Pixel pixel) {
        return new LinkedList<>();
    }

    protected abstract void draw(LinkedList<Pixel> pixels);
}
