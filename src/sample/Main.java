package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Random;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Mandelbrot set");

        Group root = new Group();

        for (int x = 0; x < 1200; x++) {
            for (int y = 0; y < 800; y++) {
                Complex z0 = new Complex(0, 0);
                Complex c = new Complex(x / 400.0 - 2, 1 - y / 400.0);

                if (isBounded(iterate(z0, c))) {
                    drawPoint(x, y, root);
                }
            }
        }

        primaryStage.setScene(new Scene(root, 1200, 800));
        primaryStage.show();
    }


    public void drawPoint(int x, int y, Group root) {
        int max = 255;
        int min = 0;
        int range = max - min + 1;


        Line line = new Line(x, y, x, y);
        line.setStroke(Color.rgb((int)(Math.random() * range) + min,(int)(Math.random() * range) + min,(int)(Math.random() * range) + min));
        root.getChildren().add(line);
    }

    public Complex iterate(Complex z0, Complex c) {
        Complex zn = z0;

        for (int i = 0; i < 20; i++) {
            zn.square().add(c);
        }

        return zn;
    }

    public boolean isBounded(Complex zn) {
        return zn.module() < 2;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
