package sample.algorithms;

import sample.algorithms.MultiDot.BSpline;
import sample.algorithms.FourDot.Bezier;
import sample.algorithms.FourDot.Ermit;
import sample.algorithms.TwoDot.*;

public class AlgorithmFactory {
    public static DrawAlgorithm getAlgorithm(Type type) {
        if (type == null) return new Empty();
        switch (type) {
            case Cda:
                return new Cda();
            case Bresenhem:
                return new Bresenhem();
            case Vu:
                return new Vu();
            case Circle:
                return new Circle();
            case Ellipse:
                return new Ellipse();
            case Parabola:
                return new Parabola();
            case Ermit:
                return new Ermit();
            case Bezier:
                return new Bezier();
            case BSpline:
                return new BSpline();
            default:
                return null;
        }
    }

    public enum Type {
        Cda,
        Bresenhem,
        Vu,
        Circle,
        Ellipse,
        Parabola,
        Ermit,
        Bezier,
        BSpline
    }
}
