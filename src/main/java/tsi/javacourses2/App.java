package tsi.javacourses2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;


    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("BullsAndCows");
        scene = new Scene(loadFXML("primary"));//говорим размер какой показать
        stage.setScene(scene);//что конкретно показать - окошко
        stage.show();//покажись
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));//мы читаем файл primary з resources!
        return fxmlLoader.load();
    }

   // private class Random {
     //   Random rand = new Random();
       // int randNum =
    // }

    public static void main(String[] args) {
        launch();
    }
}