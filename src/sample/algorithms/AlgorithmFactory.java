package sample.algorithms;

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
        Parabola
    }
}
