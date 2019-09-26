package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.PixelWriter;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import sample.algorithms.AlgorthmFactory.Type;

import java.util.Iterator;

public class View {
    private Controller controller = new Controller();

    private boolean debug = false;
    private Iterator<Pixel> iterator;

    @FXML private Canvas canvas;
    private PixelWriter writer;

    @FXML private void initialize(){
        writer = canvas.getGraphicsContext2D().getPixelWriter();
        drawGrid();
    }

    private void drawGrid(){
        for (int i = 0; i < 56; i++)
            for (int j = 0; j < 56; j++)
                for (int k = 0; k < 505; k++){
                    writer.setColor(i * 9, k, Color.GREY);
                    writer.setColor(k, j * 9, Color.GREY);
                }

        for (int i = 0; i < 505; i++){
            writer.setColor(504, i, Color.GREY);
            writer.setColor(i, 504, Color.GREY);
        }
    }

    private void drawPixel(Pixel pixel){
        if (pixel.x > 55 || pixel.y > 55)
            return;

        int dx = pixel.x * 9 + 1;
        int dy = pixel.y * 9 + 1;

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
               writer.setColor(dx + i, dy + j, pixel.color);
    }

    public void clear(ActionEvent e) {
      controller.newAlgorithm(null);
      canvas.getGraphicsContext2D().clearRect(0, 0, 505, 505);
      drawGrid();
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

    public void click(MouseEvent e) {
        int XX = (int)e.getX();
        int YY = (int)e.getY();

        int x = ((int) (e.getX() + 1)) / 9;
        int y = ((int) (e.getY() + 1)) / 9;
        iterator = controller.click(new Pixel(x, y));
        if (!debug)
            iterator.forEachRemaining(this::drawPixel);
    }
}