package sample.algorithms;

public class AlgorthmFactory {
    public enum Type {
        Cda,
        Bresenhem,
        Vu,
        Parabola
    }

    public static DrawAlgorithm getAlgorithm(Type type, Object... params) {
        if (type == null) return new Empty();
        switch (type) {
            case Cda:
                return new Cda();
            case Bresenhem:
                return new Bresenhem();
            case Vu:
                return new Vu();
            case Parabola:
                return new Parabola((double)params[0]);
            default:
                return null;
        }
    }
}
