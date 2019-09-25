package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class View {
    private Controller controller = new Controller();

    private boolean debug = false;

    @FXML private WritableImage image;
    private PixelWriter writer;

    @FXML private void initialize(){
        writer = image.getPixelWriter();
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
        int dx = pixel.x * 9 + 1;
        int dy = pixel.y * 9 + 1;

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++){
               writer.setColor(dx + i, dy + j, pixel.color);
            }
    }

    public void clear(ActionEvent e) {
        for (int i = 0; i < 505; i++)
            for (int j = 0; j < 505; j++)
                writer.setColor(i, j, Color.WHITE);
        drawGrid();
        //TODO reset controller
    }

    public void debug(ActionEvent e) {
        debug = !debug;
    }

    public void next(ActionEvent e) {
    }

    public void cda(ActionEvent e) {
    }

    public void bresenhem(ActionEvent e) {
    }

    public void vu(ActionEvent e) {
    }

    public void click(MouseEvent e) {
        controller.click(new Pixel((int)e.getX(), (int)e.getY()));
    }
}