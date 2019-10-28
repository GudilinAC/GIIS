package sample.algorithms.MultiDot;

import sample.Pixel;
import sample.algorithms.Matrix;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BSpline extends MultiDotAlgorithm {
    private Matrix randInts = new Matrix(new double[][]{
            {-1, 3, -3, 1},
            {3, -6, 3, 0},
            {-3, 0, 3, 0},
            {1, 4, 1, 0}
    });

    @Override
    protected void draw(Collection<Pixel> pixels) {
        switch (inputs.size()) {
            case 2:
                draw4(pixels, Arrays.asList(inputs.get(0), inputs.get(1), inputs.get(1), inputs.get(1)));
                break;
            case 3:
                draw4(pixels, Arrays.asList(inputs.get(0), inputs.get(1), inputs.get(2), inputs.get(2)));
                break;
            default:
                for (int i = 0; i < inputs.size() - 3; i++)
                    draw4(pixels, inputs.subList(i, i + 4));
                break;
        }
    }

    private void draw4(Collection<Pixel> pixels, List<Pixel> inputs) {
        Matrix initInts = new Matrix(new double[][]{
                {inputs.get(0).x, inputs.get(0).y},
                {inputs.get(1).x, inputs.get(1).y},
                {inputs.get(2).x, inputs.get(2).y},
                {inputs.get(3).x, inputs.get(3).y}
        });

        Matrix resInts = randInts.mult(initInts);

        for (double t = 0; t <= 1; t += 0.01) {
            Matrix input = new Matrix(new double[][]{{t * t * t, t * t, t, 1}});
            Matrix res = input.mult(resInts).mult(1. / 6);
            pixels.add(new Pixel(res.get(0, 0), res.get(0, 1)));
        }
    }
}
