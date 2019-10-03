package sample;

import sample.algorithms.AlgorithmFactory;
import sample.algorithms.AlgorithmFactory.Type;
import sample.algorithms.DrawAlgorithm;

import java.util.Iterator;
import java.util.LinkedList;

public class Controller {
    private DrawAlgorithm drawAlgorithm = AlgorithmFactory.getAlgorithm(null);

    public void newAlgorithm(Type type) {
        drawAlgorithm = AlgorithmFactory.getAlgorithm(type);
    }

    public LinkedList<Pixel> followMouse(Pixel pixel) {
        return drawAlgorithm.drawNoReset(pixel);
    }

    public Iterator<Pixel> click(Pixel pixel) {
        return drawAlgorithm.drawAndReset(pixel).iterator();
    }
}
