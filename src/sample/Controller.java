package sample;

import sample.algorithms.AlgorthmFactory;
import sample.algorithms.AlgorthmFactory.Type;
import sample.algorithms.DrawAlgorithm;

import java.util.Iterator;
import java.util.LinkedList;

public class Controller {
    private DrawAlgorithm drawAlgorithm = AlgorthmFactory.getAlgorithm(null);

    public void newAlgorithm(Type type, Object... params){
        drawAlgorithm = AlgorthmFactory.getAlgorithm(type, params);
    }

    public LinkedList<Pixel> followMouse(Pixel pixel) {
        return drawAlgorithm.drawNoReset(pixel);
    }

    public Iterator<Pixel> click(Pixel pixel){
        return drawAlgorithm.drawAndReset(pixel).iterator();
    }
}
