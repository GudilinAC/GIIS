package sample.algorithms;

public class Matrix {
    private final int length;
    private final int height;
    private final double[][] matrix;

    public Matrix(int height, int length) {
        this.length = length;
        this.height = height;
        matrix = new double[height][length];
    }

    public Matrix(double[][] mat) {
        this.height = mat.length;
        this.length = mat[0].length;
        matrix = new double[height][length];

        for (int i = 0; i < height; i++)
            System.arraycopy(mat[i], 0, this.matrix[i], 0, length);

    }

    public void set(int i, int j, double n) {
        matrix[i][j] = n;
    }

    public double get(int i, int j) {
        return matrix[i][j];
    }

    public Matrix plus(double n) {
        Matrix res = new Matrix(height, length);
        for (int i = 0; i < height; i++)
            for (int j = 0; j < length; j++)
                res.matrix[i][j] = this.matrix[i][j] + n;
        return res;
    }

    public Matrix plus(Matrix mat) {
        if (this.length != mat.length || this.height != mat.height)
            return null;

        Matrix res = new Matrix(height, length);
        for (int i = 0; i < height; i++)
            for (int j = 0; j < length; j++)
                res.matrix[i][j] = this.matrix[i][j] + mat.matrix[i][j];
        return res;
    }

    public Matrix minus() {
        Matrix res = new Matrix(height, length);
        for (int i = 0; i < height; i++)
            for (int j = 0; j < length; j++)
                res.matrix[i][j] = -this.matrix[i][j];
        return res;
    }

    public Matrix mult(double n) {
        Matrix res = new Matrix(height, length);
        for (int i = 0; i < height; i++)
            for (int j = 0; j < length; j++)
                res.matrix[i][j] = this.matrix[i][j] * n;
        return res;
    }

    public Matrix mult(Matrix mat) {
        if (this.length != mat.height)
            return null;

        Matrix res = new Matrix(this.height, mat.length);
        for (int i = 0; i < this.height; i++)
            for (int j = 0; j < mat.length; j++) {
                double n = 0;
                for (int k = 0; k < this.length; k++)
                    n += this.matrix[i][k] * mat.matrix[k][j];
                res.matrix[i][j] = n;
            }

        return res;
    }
}
