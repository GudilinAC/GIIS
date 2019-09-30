package sample.algorithms;

import sample.Pixel;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class OneDotAlgorithm implements DrawAlgorithm{
    protected Pixel pixel = null;
    protected final double p;

    public OneDotAlgorithm(double p){
        this.p = p;
    }

    @Override
    public Iterator<Pixel> dot(Pixel pixel) {

        LinkedList<Pixel> pixels = new LinkedList<>();
        this.pixel = pixel;
        draw(pixels);
        return pixels.iterator();
    }

    protected abstract void draw(LinkedList<Pixel> pixels);
}
