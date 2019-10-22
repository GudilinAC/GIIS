package sample.algorithms.FourDot;

import sample.Pixel;
import sample.algorithms.Matrix;

import java.util.LinkedList;

public class Ermit extends FourDotAlgorithm {
    @Override
    protected void draw2(LinkedList<Pixel> pixels) {
        pixels.add(pixel1);
        pixels.add(pixel2);
    }

    @Override
    protected void draw3(LinkedList<Pixel> pixels) {
        pixels.add(pixel1);
        pixels.add(pixel2);
        pixels.add(pixel3);
    }

    private Matrix randInts = new Matrix(new double[][]{
            {2, -2, 1, 1},
            {-3, 3, -2, -1},
            {0, 0, 1, 0},
            {1, 0, 0, 0}
    });

    @Override
    protected void draw4(LinkedList<Pixel> pixels) {
        Matrix initInts = new Matrix(new double[][]{
                {pixel1.x, pixel1.y},
                {pixel4.x, pixel4.y},
                {pixel2.x - pixel1.x, pixel2.y - pixel1.y},
                {pixel4.x - pixel3.x, pixel4.y - pixel3.y}
        });

        Matrix resInts = randInts.mult(initInts);

        for (double t = 0; t <= 1; t += 0.001){
            Matrix input = new Matrix(new double[][]{{t*t*t, t*t, t, 1}});
            Matrix res = input.mult(resInts);
            pixels.add(new Pixel(res.get(0, 0), res.get(0, 1)));
        }
    }
}
