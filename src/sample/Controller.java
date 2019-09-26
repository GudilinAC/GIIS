package sample;

import sample.algorithms.AlgorthmFactory;
import sample.algorithms.AlgorthmFactory.Type;
import sample.algorithms.DrawAlgorithm;

import java.util.Iterator;

public class Controller {
    private DrawAlgorithm drawAlgorithm = AlgorthmFactory.getAlgorithm(null);

    public void newAlgorithm(Type type){
        drawAlgorithm = AlgorthmFactory.getAlgorithm(type);
    }

    public Iterator<Pixel> click(Pixel pixel){
        return drawAlgorithm.dot(pixel);
    }
}
