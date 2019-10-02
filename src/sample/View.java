package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import sample.algorithms.AlgorthmFactory.Type;

import java.util.Iterator;
import java.util.LinkedList;

public class View {
    private Controller controller = new Controller();

    private Color[][] grid = new Color[Settings.MAX_X][Settings.MAX_Y];

    private void setSell(int x, int y, Color color){
        if (x >= Settings.MAX_X || y >= Settings.MAX_Y || x < 0 || y < 0)
            return;
        grid[x][y] = color;
    }

    private Color getSell(int x, int y){
        if (x >= Settings.MAX_X || y >= Settings.MAX_Y || x < 0 || y < 0)
            return Color.WHITE;
        return grid[x][y];
    }

    private boolean debug = false;
    private Iterator<Pixel> iterator;

    @FXML
    private Canvas canvas;
    private GraphicsContext context;

    private final Image clear = new Image("clear.png");

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

    @FXML
    private void initialize() {
        context = canvas.getGraphicsContext2D();
        loadClear();
    }

    private LinkedList<Pixel> tempList = null;

    private void draw(Pixel pixel, Color color){
        int dx = pixel.x * 9 + 1;
        int dy = pixel.y * 9 + 1;

        context.setFill(color);
        context.fillRect(dx, dy, 8 ,8);
    }

    private void drawPixel(Pixel pixel, Color color) {
        if (pixel.x >= Settings.MAX_X || pixel.y >= Settings.MAX_Y || pixel.x < 0 || pixel.y < 0)
            return;
        setSell(pixel.x, pixel.y, color);
        draw(pixel, color);
    }

    private void drawTemp(Pixel pixel){
        if (pixel.x >= Settings.MAX_X || pixel.y >= Settings.MAX_Y || pixel.x < 0 || pixel.y < 0)
            return;
        draw(pixel, pixel.color);
    }

    private void drawPixel(Pixel pixel) {
        drawPixel(pixel, pixel.color);
    }

    private void loadClear() {
        for (int x = 0; x < Settings.MAX_X; x++)
            for (int y = 0; y < Settings.MAX_Y; y++)
                setSell(x,y,Color.WHITE);
        context.drawImage(clear, 0, 0);
    }

    public void debug(ActionEvent e) {
        debug = !debug;
    }

    public void next(ActionEvent e) {
        if (debug && iterator != null && iterator.hasNext())
            drawPixel(iterator.next());
    }

    public void cda(ActionEvent e) {
        controller.newAlgorithm(Type.Cda);
    }

    public void bresenhem(ActionEvent e) {
        controller.newAlgorithm(Type.Bresenhem);
    }

    public void vu(ActionEvent e) {
        controller.newAlgorithm(Type.Vu);
    }

    public void clear(ActionEvent e) {
        controller.newAlgorithm(null);
        clearTemp();
        loadClear();
    }

    private void clearTemp(){
        if (tempList != null)
            tempList.forEach(p -> draw(p, getSell(p.x, p.y)));
        tempList = null;
    }

    public void circle(ActionEvent e) {

    }

    public void ellipse(ActionEvent e) {

    }

    public void parabola(ActionEvent e) {
        controller.newAlgorithm(Type.Parabola);
    }

    public void click(MouseEvent e) {
        clearTemp();
        int x = ((int) (e.getX() + 1)) / 9;
        int y = ((int) (e.getY() + 1)) / 9;
        iterator = controller.click(new Pixel(x, y));
        if (!debug)
            iterator.forEachRemaining(this::drawPixel);
        else if (iterator.hasNext())
            drawPixel(iterator.next());
    }



    public void mouseMove(MouseEvent e) {
        int x = ((int) (e.getX() + 1)) / 9;
        int y = ((int) (e.getY() + 1)) / 9;
        clearTemp();
        tempList = controller.followMouse(new Pixel(x, y));
        tempList.forEach(this::drawTemp);
    }
}