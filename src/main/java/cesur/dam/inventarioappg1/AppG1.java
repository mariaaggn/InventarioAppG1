package cesur.dam.inventarioappg1;

import cesur.dam.inventarioappg1.data.DataBaseInitializer;
import cesur.dam.inventarioappg1.data.DataSourceFactory;
import cesur.dam.inventarioappg1.sceneManager.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class AppG1 extends Application {

    @Override
    public void start(Stage stage) {
        DataBaseInitializer.initialize(DataSourceFactory.getDataSource());
        DataBaseInitializer.loadData(DataSourceFactory.getDataSource());

        SceneManager.init(stage);
        stage.setTitle("Inventario App G1");
        SceneManager.goTo("login");
        stage.show();
    }
}