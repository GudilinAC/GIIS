package sample.algorithms;

public class AlgorthmFactory {
    public enum Type {
        Cda,
        Bresenhem,
        Vu
    }

    public static DrawAlgorithm getAlgorithm(Type type) {
        if (type == null) return new Empty();
        switch (type) {
            case Cda:
                return new Cda();
            case Bresenhem:
                return new Bresenhem();
            case Vu:
                return new Vu();
            default:
                return null;
        }
    }
}