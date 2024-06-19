package com.example.cloudanalystt.ui;

import com.example.cloudanalystt.utils.ServersDC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ServersDcController {
    @FXML
    private TableView<ServersDC> tableServersDC = new TableView<>();
    @FXML
    private TableColumn<ServersDC, String> nameCol;
    @FXML
    private TableColumn<ServersDC, String> prefixCol;
    @FXML
    private TableColumn<ServersDC, String> countCol;
    @FXML
    private Button buttonAddServer;
    @FXML
    private Button buttonDeleteServer;
    @FXML
    private Button buttonUpdateServer;
    @FXML
    private Button buttonSaveServer;

    @FXML
    private AnchorPane windowAdvanced;
    @FXML
    private AnchorPane windowAdd;
    private ObservableList<ServersDC> listServers = FXCollections.observableArrayList(new ServersDC("Cloud Broker", "cb",  1, " "), new ServersDC("Load Balancer", "lb",  1, " "),new ServersDC("WEB Server", "web",  1, " "), new ServersDC("App Server", "app",  1, " "), new ServersDC("DataBase server", "db",  1, " "));

    @FXML
    private TextField textPrefixAdd;
    @FXML
    private TextArea textCodeAdd;
    @FXML
    private Button buttonSaveAdd;
    @FXML
    private Button buttonCancelAdd;


    private enum actions {UPDATE, ADD}

    private String action;
    private int index;

    public ServersDcController (){}

    @FXML
    void initialize() {
       initViews(getListServers());
    }

    private void initViews(ObservableList<ServersDC> listServersDC) {
        textCodeAdd.setWrapText(true);
        textCodeAdd.setMaxWidth(350);
        nameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        prefixCol.setCellValueFactory(cellData -> cellData.getValue().prefixProperty());
        countCol.setCellValueFactory(cellData -> cellData.getValue().countProperty());

        prefixCol.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item);
                    setGraphic(null);
                }
            }
        });
        countCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());


        countCol.setOnEditCommit(event -> {
            ServersDC serversDC = event.getRowValue();
            serversDC.setCount(Integer.parseInt(event.getNewValue()));
        });
        nameCol.setOnEditCommit(event -> {
            ServersDC serversDC = event.getRowValue();
            serversDC.setName(event.getNewValue());
        });
        tableServersDC.setItems(listServersDC);

        buttonAddServer.setOnAction(event -> {
            windowAdvanced.setVisible(false);
            windowAdd.setVisible(true);
            action = String.valueOf(actions.ADD);
            textPrefixAdd.setText("");
            textCodeAdd.setText("");
        });
        buttonUpdateServer.setOnAction(event -> {
            if (tableServersDC.getSelectionModel().getSelectedItem() != null) {
                windowAdvanced.setVisible(false);
                windowAdd.setVisible(true);
                action = String.valueOf(actions.UPDATE);
                index = tableServersDC.getSelectionModel().getSelectedIndex();
                textPrefixAdd.setText(listServersDC.get(index).getPrefix());
                textCodeAdd.setText(listServersDC.get(index).getCode());

            } else {
                alertError("Пожалуйста, выберите сервер!");
            }
        });
        buttonDeleteServer.setOnAction(event -> {
            listServersDC.remove(tableServersDC.getSelectionModel().getSelectedIndex());
            tableServersDC.refresh();
        });
        buttonSaveServer.setOnAction(actionEvent -> {
            onCloseWindow();
        });
        buttonSaveAdd.setOnAction(event -> {
            if (!textPrefixAdd.getText().isEmpty()) {
                if (action.equals(String.valueOf(actions.ADD))) {
                    listServersDC.add(new ServersDC("", textPrefixAdd.getText(), 1, textCodeAdd.getText()));
                } else if (action.equals(String.valueOf(actions.UPDATE))) {
                    listServersDC.get(index).setPrefix(textPrefixAdd.getText());
                    listServersDC.get(index).setCode(textCodeAdd.getText());
                }
                windowAdd.setVisible(false);
                windowAdvanced.setVisible(true);
                action = "";
                tableServersDC.refresh();
            } else {
                alertError("Пожалуйста, введите префикс!");
            }

        });

        buttonCancelAdd.setOnAction(event -> {
            windowAdd.setVisible(false);
            windowAdvanced.setVisible(true);
        });
    }

    @FXML
    void onCloseWindow() {
        System.out.println( "OnClose" + getListServers());
        Stage stage = (Stage) buttonSaveServer.getScene().getWindow();
        stage.close();
    }
    public ObservableList<ServersDC> getListServers() {
        tableServersDC.refresh();
        return listServers;

    }

    public void setListServers(ObservableList<ServersDC> listServers) {
        this.listServers = listServers;
        initViews(listServers);
    }

    public void alertError(String contentText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

}