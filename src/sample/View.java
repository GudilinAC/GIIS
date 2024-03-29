package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import sample.algorithms.AlgorithmFactory.Type;

import java.util.Collection;
import java.util.Iterator;

public class View {
    private final Image clear = new Image("clear.png");
    private Controller controller = new Controller();
    private Color[][] grid = new Color[Settings.MAX_X][Settings.MAX_Y];
    private boolean debug = false;
    private Iterator<Pixel> iterator;
    @FXML
    private Canvas canvas;
    private GraphicsContext context;
    private PixelWriter writer;
    private Collection<Pixel> tempList = null;
    private boolean scale = true;

//    private void drawGrid() {
//        for (int i = 0; i < Settings.MAX_X; i++)
//            for (int j = 0; j < Settings.MAX_Y; j++){
//                for (int k = 0; k < Settings.MAX_X * 9 + 1; k++)
//                    writer.setColor(i * 9, k, Color.GREY);
//                for (int k = 0; k < Settings.MAX_Y * 9 + 1; k++)
//                    writer.setColor(k, j * 9, Color.GREY);
//                }
//
//        for (int i = 0; i < Settings.MAX_X * 9 + 1; i++)
//            writer.setColor(i, Settings.MAX_Y * 9, Color.GREY);
//        for (int i = 0; i < Settings.MAX_Y * 9 + 1; i++)
//            writer.setColor(Settings.MAX_X * 9, i, Color.GREY);
//
//        WritableImage writableImage = new WritableImage(901, 901);
//        canvas.snapshot(null, writableImage);
//        RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
//        try {
//            ImageIO.write(renderedImage, "png", new File("clear.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private void setSell(int x, int y, Color color) {
        if (x >= Settings.MAX_X || y >= Settings.MAX_Y || x < 0 || y < 0)
            return;
        grid[x][y] = color;
    }

    private Color getSell(int x, int y) {
        if (x >= Settings.MAX_X || y >= Settings.MAX_Y || x < 0 || y < 0)
            return Color.WHITE;
        return grid[x][y];
    }

    @FXML
    private void initialize() {
        context = canvas.getGraphicsContext2D();
        writer = context.getPixelWriter();
        loadClear();
    }

    private void draw(Pixel pixel, Color color) {
        if (scale) {
            int dx = pixel.x * 9 + 1;
            int dy = pixel.y * 9 + 1;

            context.setFill(color);
            context.fillRect(dx, dy, 8, 8);
        } else
            writer.setColor(pixel.x, pixel.y, color);
    }

    private boolean isOutOfLimits(Pixel pixel) {
        return pixel.x < 0 || pixel.y < 0 || pixel.x >= Settings.MAX_X || pixel.y >= Settings.MAX_Y;
    }

    private void drawPixel(Pixel pixel, Color color) {
        if (isOutOfLimits(pixel))
            return;
        setSell(pixel.x, pixel.y, color);
        draw(pixel, color);
    }

    private void drawTemp(Pixel pixel) {
        if (isOutOfLimits(pixel))
            return;
        draw(pixel, pixel.color);
    }

    private void drawPixel(Pixel pixel) {
        drawPixel(pixel, pixel.color);
    }

    private void loadClear() {
        grid = new Color[Settings.MAX_X][Settings.MAX_Y];
        for (int x = 0; x < Settings.MAX_X; x++)
            for (int y = 0; y < Settings.MAX_Y; y++)
                setSell(x, y, Color.WHITE);
        if (scale)
            context.drawImage(clear, 0, 0);
        else {
            context.setFill(Color.WHITE);
            context.fillRect(0, 0, Settings.MAX_X, Settings.MAX_Y);
        }
    }

    public void debug(ActionEvent e) {
        debug = !debug;
    }

    public void next(ActionEvent e) {
        if (debug && iterator != null && iterator.hasNext())
            drawPixel(iterator.next());
    }

    public void scale(ActionEvent e) {
        scale = !scale;
        Settings.scale(scale);
        loadClear();
    }

    public void cda(ActionEvent e) {
        newAlgorithm(Type.Cda);
    }

    public void bresenhem(ActionEvent e) {
        newAlgorithm(Type.Bresenhem);
    }

    public void vu(ActionEvent e) {
        newAlgorithm(Type.Vu);
    }

    public void clear(ActionEvent e) {
        controller.newAlgorithm(null);
        clearTemp();
        loadClear();
    }

    private void clearTemp() {
        if (tempList != null)
            tempList.forEach(p -> draw(p, getSell(p.x, p.y)));
        tempList = null;
    }

    public void circle(ActionEvent e) {
        newAlgorithm(Type.Circle);
    }

    public void ellipse(ActionEvent e) {
        newAlgorithm(Type.Ellipse);
    }

    public void parabola(ActionEvent e) {
        newAlgorithm(Type.Parabola);
    }

    public void ermit(ActionEvent e) {
        newAlgorithm(Type.Ermit);
    }

    public void bezier(ActionEvent e) {
        newAlgorithm(Type.Bezier);
    }

    public void bspline(ActionEvent e) {
        newAlgorithm(Type.BSpline);
    }

    private void newAlgorithm(Type type){
        tempList = null;
        controller.newAlgorithm(type);
    }

    private Pixel getPixel(MouseEvent e) {
        int x, y;
        if (scale) {
            x = ((int) (e.getX() + 1)) / 9;
            y = ((int) (e.getY() + 1)) / 9;
        } else {
            x = (int) e.getX();
            y = (int) e.getY();
        }
        return new Pixel(x, y);
    }

    public void click(MouseEvent e) {
        clearTemp();
        iterator = controller.click(getPixel(e));
        if (!debug)
            iterator.forEachRemaining(this::drawPixel);
    }


    public void mouseMove(MouseEvent e) {
        clearTemp();
        tempList = controller.followMouse(getPixel(e));
        tempList.forEach(this::drawTemp);
    }
}