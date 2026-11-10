package cesur.dam.inventarioappg1.controllers;

import cesur.dam.inventarioappg1.data.DataSourceFactory;
import cesur.dam.inventarioappg1.data.EquipoJdbcDAO;
import cesur.dam.inventarioappg1.models.Equipo;
import cesur.dam.inventarioappg1.sceneManager.SceneManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML private TableView<Equipo> table;
    @FXML private TableColumn<Equipo, String> cId;
    @FXML private TableColumn<Equipo, String> cName;
    @FXML private TableColumn<Equipo, String> cCategory;
    @FXML private TableColumn<Equipo, String> cAvailability;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cId.setCellValueFactory(row -> new SimpleStringProperty(String.valueOf(row.getValue().getId())));
        cName.setCellValueFactory(row -> new SimpleStringProperty(row.getValue().getNombre()));
        cCategory.setCellValueFactory(row -> new SimpleStringProperty(String.valueOf(row.getValue().getCategoria()).toUpperCase()));
        cAvailability.setCellValueFactory(row -> new SimpleStringProperty(row.getValue().getDisponible() ? "disponible" : "no disponible"));
        // TODO: cargar datos desde el DAO
    }

    @FXML
    public void newRecord(ActionEvent e) {
        SceneManager.goTo("create");
    }

    @FXML
    public void logout(ActionEvent e) {
        SceneManager.goTo("login");
    }
    private final EquipoJdbcDAO dao = new EquipoJdbcDAO(DataSourceFactory.getDataSource());
}
