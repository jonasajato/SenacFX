package senac.senacfx.controller;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import senac.senacfx.application.Main;
import senac.senacfx.db.DbException;
import senac.senacfx.gui.listeners.DataChangeListener;
import senac.senacfx.gui.util.Alerts;
import senac.senacfx.gui.util.Utils;
import senac.senacfx.model.entities.Fabric;
import senac.senacfx.model.services.DepartmentService;
import senac.senacfx.model.services.FabricService;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class TransportListController implements Initializable, DataChangeListener {
    //ao inves de implementar um service = new SellerService(), ficaria acoplamento forte
    //e seria obrigado a instanciar a classe
    private FabricService service;

    @FXML
    private TableView<Fabric> tableViewFabric;

    @FXML
    private TableColumn<Fabric, Integer> tableColumnId;

    @FXML
    private TableColumn<Fabric, String> tableColumnName;

    @FXML
    private TableColumn<Fabric, String> tableColumnEmail;

    @FXML
    private TableColumn<Fabric, Date> tableColumnBirthDate;

    @FXML
    private TableColumn<Fabric, Double> tableColumnBaseSalary;

    @FXML
    private TableColumn<Fabric, Fabric> tableColumnEDIT;

    @FXML
    private TableColumn<Fabric, Fabric> tableColumnREMOVE;

    @FXML
    private Button btNew;

    private ObservableList<Fabric> obsList;

//    @FXML
//    public void onBtNewAction(ActionEvent event){
//        Stage parentStage = Utils.currentStage(event);
//        Fabric obj = new Fabric();
//        createDialogForm(obj, "/gui/FabricForm.fxml", parentStage);
//    }

    //feito isso usando um set, para injetar dependencia, boa pratica
    //injecao de dependendencia manual, sem framework pra isso
    public void setFabricService(FabricService service){
        this.service = service;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeNodes();

    }

    private void initializeNodes() {
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableColumnBirthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        Utils.formatTableColumnDate(tableColumnBirthDate, "dd/MM/yyyy");
        tableColumnBaseSalary.setCellValueFactory(new PropertyValueFactory<>("baseSalary"));
        Utils.formatTableColumnDouble(tableColumnBaseSalary, 2);


        Stage stage = (Stage) Main.getMainScene().getWindow();
        tableViewFabric.prefHeightProperty().bind(stage.heightProperty());

    }

//    public void updateTableView(){
//        if (service == null){
//            throw new IllegalStateException("Service is null!");
//        }
//        List<Fabric> list = service.findAll();
//        obsList = FXCollections.observableArrayList(list);
//        tableViewFabric.setItems(obsList);
//        initEditButtons();
//        initRemoveButtons();
//    }

//    private void createDialogForm(Fabric obj, String absoluteName, Stage parentStage){
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
//            Pane pane = loader.load();
//
//            FabricFormController controller = loader.getController();
//            controller.setFabric(obj);
//            controller.setServices(new FabricService(), new DepartmentService());
//            controller.loadAssociatedObjects();
//            controller.subscribeDataChangeListener(this);
//            controller.updateFormData();
//
//            Stage dialogStage = new Stage();
//            dialogStage.setTitle("Enter seller data");
//            dialogStage.setScene(new Scene(pane));
//            dialogStage.setResizable(false);
//            dialogStage.initOwner(parentStage);
//            dialogStage.initModality(Modality.WINDOW_MODAL);
//            dialogStage.showAndWait();
//
//        } catch (IOException e){
//            e.printStackTrace();
//            Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
//        }
//    }

//    @Override
//    public void onDataChanged() {
//        updateTableView();
//    }

    private void initEditButtons() {
        tableColumnEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tableColumnEDIT.setCellFactory(param -> {
            return new TableCell<Fabric, Fabric>() {
                private final Button button = new Button("Editar");
                //            @Override
                //            protected void updateItem(Fabric obj, boolean empty) {
                //                super.updateItem(obj, empty);
                //                if (obj == null) {
                //                    setGraphic(null);
                //                    return;
                //                }
                //                setGraphic(button);
                //                button.setOnAction(
                //                        event -> createDialogForm(
                //                                obj, "/gui/FabricForm.fxml",Utils.currentStage(event)));
                            };
                        });
                    }

                private void initRemoveButtons() {
                    tableColumnREMOVE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
                    tableColumnREMOVE.setCellFactory(param -> new TableCell<Fabric, Fabric>() {
                        private final Button button = new Button("Remover");

                        @Override
                        protected void updateItem(Fabric obj, boolean empty) {
                            super.updateItem(obj, empty);
                            if (obj == null) {
                                setGraphic(null);
                                return;
                            }
                            setGraphic(button);
                            button.setOnAction(event -> removeEntity(obj));
                        }
                    });
                }

                private void removeEntity(Fabric obj) {
                    Optional<ButtonType> result = Alerts.showConfirmation("Confirmation", "Confirma que quer deletar?");

                    if (result.get() == ButtonType.OK) {
                        if (service == null) {
                            throw new IllegalStateException("Service estava null");
                        }
                        try {
                            service.remove(obj);
                            //                updateTableView();
                        } catch (DbException e) {
                            Alerts.showAlert("Error removing object", null, e.getMessage(), Alert.AlertType.ERROR);
                        }
                    }
                }

                public void setDepartmentService(TransportFormController transportFormController) {
                }


    @Override
    public void onDataChanged() {

    }
}