package com.example.cloudanalystt.ui;

import com.example.cloudanalystt.HelloApplication;
import com.example.cloudanalystt.RootObjectToSaveData;
import com.example.cloudanalystt.XMLWriter;
import com.example.cloudanalystt.utils.*;
import com.example.cloudanalystt.utils.utilsForSerializable.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.*;


public class MainConfigurationController {

    private ObservableList<PhysicalHWDetailsOfDC> listHWDetails = FXCollections.observableArrayList(new PhysicalHWDetailsOfDC(0, 204800, 100000000, 1000000, 4, 10000, "TIME_SHARED"));
    private final ObservableList<ServersDC> listServersDC = FXCollections.observableArrayList(new ServersDC("Сервер 1", "s1", 1, ""));

    @FXML
    AnchorPane paneConfigurationSimulation;
    @FXML
    Button buttonConfigureSimulation;
    @FXML
    Button buttonInternetCharacteristics;
    @FXML
    Button buttonRunSimulation;
    @FXML
    Button buttonExit;

    boolean isPressedContinue = false;

    private ObservableList<UserBases> originalListUserBases  = FXCollections.observableArrayList(new UserBases("UB1", 1, 60, 100, 3, 9, 1000, 100));
    private ObservableList<AppDeploymentConfiguration> originalListAppConf  = FXCollections.observableArrayList(new AppDeploymentConfiguration("DC1", 5, 10000, 512, 1000));
    private final ObservableList<PhysicalHWDetailsOfDC> originalListHwDetail= FXCollections.observableArrayList(new PhysicalHWDetailsOfDC(0, 204800, 100000000, 1000000, 4, 10000, "TIME_SHARED"));
    private final ObservableList<ServersDC> originalListServersDC = FXCollections.observableArrayList(new ServersDC("Сервер 1", "s1", 1, ""));
    private ObservableList<DataCentres> originalListDataCentres= FXCollections.observableArrayList(new DataCentres("DC1", 5, "x86", "Linux", "Xen", 0.1, 0.05, 0.1, 0.1, 1, FXCollections.observableArrayList(new PhysicalHWDetailsOfDC(0, 204800, 100000000, 1000000, 4, 10000, "TIME_SHARED")), FXCollections.observableArrayList(new ServersDC("Сервер 1", "s1", 1, ""))));
    private String originalValueSimDur = "60.0";
    private String originalSimDur = "минуты";
    private String originalBrokerPolicy = "Ближайший ЦОД";
    private String originalUsGroupingFactorInUB = "10";
    private String originalRequestGroupingFactorInDC = "10";
    private String originalExecutableInstructionLengthPrReq = "100";
    private String originalLBPolicy = "Циклический (Круговой) алгоритм";

    @FXML
    private Button buttonAddApplicationConfTable;
    @FXML
    private Button buttonAddTableUsers;
    @FXML
    private Button buttonRemoveApplicationConfTable;
    @FXML
    private Button buttonRemoveTableUsers;
    @FXML
    private ComboBox<String> comboboxBrokerPolicy;
    @FXML
    private ComboBox<String> comboboxSimulationDuration;
    @FXML
    private TextField valueSimDurText;
    @FXML
    private TableView<UserBases> tableUserBases = new TableView<>();
    @FXML
    private TableColumn<UserBases, String> nameColUs;
    @FXML
    private TableColumn<UserBases, String> regionColUs;
    @FXML
    private TableColumn<UserBases, String> requestsPrUsPrHrColUs;
    @FXML
    private TableColumn<UserBases, String> dataSzPrRqColUs;
    @FXML
    private TableColumn<UserBases, String> peakHrStartColUs;
    @FXML
    private TableColumn<UserBases, String> peakHrEndColUs;
    @FXML
    private TableColumn<UserBases, String> avgPkUsColUs;
    @FXML
    private TableColumn<UserBases, String> avgPkOffUsColUs;
    ObservableList<UserBases> listUserBases = FXCollections.observableArrayList(new UserBases("UB1", 1, 60, 100, 3, 9, 1000, 100));


    @FXML
    private TableView<AppDeploymentConfiguration> tableAppDeplConf = new TableView<>();
    @FXML
    private TableColumn<AppDeploymentConfiguration, String> dataCenterCol;
    @FXML
    private TableColumn<AppDeploymentConfiguration, String> virtualMachinesCol;
    @FXML
    private TableColumn<AppDeploymentConfiguration, String> imageSizeCol;
    @FXML
    private TableColumn<AppDeploymentConfiguration, String> memoryCol;
    @FXML
    private TableColumn<AppDeploymentConfiguration, String> bandwidth_col;
    ObservableList<AppDeploymentConfiguration> listAppConf = FXCollections.observableArrayList(new AppDeploymentConfiguration("DC1", 5, 10000, 512, 1000));


    //Data center configuration
    @FXML
    private TableView<DataCentres> tableDataCentres = new TableView<>();
    private  ObservableList<DataCentres> listDataCentres = FXCollections.observableArrayList(new DataCentres("DC1", 5, "x86", "Linux", "Xen", 0.1, 0.05, 0.1, 0.1, 1, listHWDetails, listServersDC));
    @FXML
    private TableColumn<DataCentres, String> nameOfDataCenterCol;
    @FXML
    private TableColumn<DataCentres, String> regionOfDataCenterCol;
    @FXML
    private TableColumn<DataCentres, String> archOfDataCenterCol;
    @FXML
    private TableColumn<DataCentres, String> OsOfDataCenterCol;
    @FXML
    private TableColumn<DataCentres, String> VmmOfDataCenterCol;
    @FXML
    private TableColumn<DataCentres, String> costPerVmOfDataCenterCol;
    @FXML
    private TableColumn<DataCentres, String> memoryCostOfDataCenterCol;
    @FXML
    private TableColumn<DataCentres, String> storageCostOfDataCenterCol;
    @FXML
    private TableColumn<DataCentres, String> dataTransferCostOfDataCenterCol;
    @FXML
    private TableColumn<DataCentres, String> physicalHwUnitsOfDataCenterCol;
    @FXML
    private Button buttonAddDataCentres;
    @FXML
    private Button buttonRemoveDataCentres;
    @FXML
    private AnchorPane windowPhysicalHWDetails;

    //PhysicalHWDetails
    @FXML
    private TableView<PhysicalHWDetailsOfDC> tablePhysicalHWDetailsOfDC = new TableView<>();
    @FXML
    private TableColumn<PhysicalHWDetailsOfDC, String> idHwDetailsCol;
    @FXML
    private TableColumn<PhysicalHWDetailsOfDC, String> memoryHwDetailsCol;
    @FXML
    private TableColumn<PhysicalHWDetailsOfDC, String> storageHwDetailsCol;
    @FXML
    private TableColumn<PhysicalHWDetailsOfDC, String> availableBandwidthHwDetailsCol;
    @FXML
    private TableColumn<PhysicalHWDetailsOfDC, String> numOfProcessorHwDetailsCol;
    @FXML
    private TableColumn<PhysicalHWDetailsOfDC, String> speedOfProcessorHwDetailsCol;
    @FXML
    private TableColumn<PhysicalHWDetailsOfDC, String> VMPolicyHwDetailsCol;
    @FXML
    private Button buttonAddHwDetail;
    @FXML
    private Button buttonCopyHwDetail;
    @FXML
    private Button buttonRemoveHwDetail;
    @FXML
    private Button buttonServersDCHwDetail;

    //Advanced
    @FXML
    private ComboBox<String> comboBoxLBPolicy;
    @FXML
    private TextField textUsGroupingFactorInUB;
    @FXML
    private TextField textRequestGroupingFactorInDC;
    @FXML
    private TextField textExecutableInstructionLengthPrReq;

    //Main buttons
    @FXML
    private Button buttonSaveConfiguration;
    @FXML
    private Button buttonLoadConfiguration;
    @FXML
    private Button buttonDoneConfiguration;
    @FXML
    private Button buttonCancelConfiguration;

    @FXML
    void initialize() {
        parentButtons();
        //MainConfiguration
        initComboBoxes();
        initUserTable();
        initAppDeploymentConfTable();
        //DataCenterConfiguration
        initDataCenterTable();
        initMainButtons();

      //  saveOriginalData();
    }
    private void parentButtons(){
        buttonConfigureSimulation.setOnAction(event ->{
            paneConfigurationSimulation.setVisible(true);
            if(isPressedContinue) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("continue.ser"))) {
                    deserialize((RootObjectToSaveData) ois.readObject());
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                isPressedContinue = false;
            }
        });
        buttonExit.setOnAction(event ->{
            Platform.exit();
        });
        buttonRunSimulation.setOnAction(event -> {

        });
        buttonInternetCharacteristics.setOnAction(event -> {

        });
    }

    private void initComboBoxes() {
        ObservableList<String> itemsSimDur = FXCollections.observableArrayList("минуты", "часы", "дни");
        comboboxSimulationDuration.setItems(itemsSimDur);
        comboboxSimulationDuration.setValue("минуты");

        ObservableList<String> itemsBrokPolicy = FXCollections.observableArrayList("Ближайший ЦОД", "Оптимизированное время запроса", "Динамическое распознавание");
        comboboxBrokerPolicy.setItems(itemsBrokPolicy);
        comboboxBrokerPolicy.setValue("Ближайший ЦОД");

        ObservableList<String> itemsLBPolicy = FXCollections.observableArrayList("Циклический (Круговой) алгоритм", "Балансировка нагрузки c равным распределением", "Регулируемый алгоритм балансировки");
        comboBoxLBPolicy.setItems(itemsLBPolicy);
        comboBoxLBPolicy.setValue("Циклический (Круговой) алгоритм");
    }

    private void initUserTable() {
        nameColUs.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        regionColUs.setCellValueFactory(cellData -> cellData.getValue().regionProperty());
        requestsPrUsPrHrColUs.setCellValueFactory(cellData -> cellData.getValue().requestsPrUsPrHrProperty());
        dataSzPrRqColUs.setCellValueFactory(cellData -> cellData.getValue().dataSzPrRqProperty());
        peakHrStartColUs.setCellValueFactory(cellData -> cellData.getValue().peakHrStartProperty());
        peakHrEndColUs.setCellValueFactory(cellData -> cellData.getValue().peakHrEndProperty());
        avgPkUsColUs.setCellValueFactory(cellData -> cellData.getValue().avgPkUsrsProperty());
        avgPkOffUsColUs.setCellValueFactory(cellData -> cellData.getValue().avgPkOffUsrsProperty());

        nameColUs.setCellFactory(TextFieldTableCell.forTableColumn());
        ObservableList<String> countryOptions = FXCollections.observableArrayList("0", "1", "2", "3", "4", "5");
        regionColUs.setCellFactory(ComboBoxTableCell.forTableColumn(countryOptions));
        requestsPrUsPrHrColUs.setCellFactory(TextFieldTableCell.forTableColumn());
        dataSzPrRqColUs.setCellFactory(TextFieldTableCell.forTableColumn());
        peakHrStartColUs.setCellFactory(TextFieldTableCell.forTableColumn());
        peakHrEndColUs.setCellFactory(TextFieldTableCell.forTableColumn());
        avgPkUsColUs.setCellFactory(TextFieldTableCell.forTableColumn());
        avgPkUsColUs.setCellFactory(TextFieldTableCell.forTableColumn());

        nameColUs.setOnEditCommit(event -> {
            UserBases userBases = event.getRowValue();
            userBases.setName(event.getNewValue());
        });
        regionColUs.setOnEditCommit(event -> {
            UserBases userBases = event.getRowValue();
            userBases.setRegion(Integer.parseInt(event.getNewValue()));
        });
        requestsPrUsPrHrColUs.setOnEditCommit(event -> {
            UserBases userBases = event.getRowValue();
            userBases.setRequestsPrUsPrHr(Integer.parseInt(event.getNewValue()));
        });
        dataSzPrRqColUs.setOnEditCommit(event -> {
            UserBases userBases = event.getRowValue();
            userBases.setDataSzPrRq(Integer.parseInt(event.getNewValue()));
        });
        peakHrStartColUs.setOnEditCommit(event -> {
            UserBases userBases = event.getRowValue();
            userBases.setPeakHrStart(Integer.parseInt(event.getNewValue()));
        });
        peakHrEndColUs.setOnEditCommit(event -> {
            UserBases userBases = event.getRowValue();
            userBases.setPeakHrEnd(Integer.parseInt(event.getNewValue()));
        });
        avgPkUsColUs.setOnEditCommit(event -> {
            UserBases userBases = event.getRowValue();
            userBases.setAvgPkUsrs(Integer.parseInt(event.getNewValue()));
        });
        avgPkOffUsColUs.setOnEditCommit(event -> {
            UserBases userBases = event.getRowValue();
            userBases.setAvgPkOffUsrs(Integer.parseInt(event.getNewValue()));
        });

        tableUserBases.setItems(listUserBases);

        buttonAddTableUsers.setOnAction(event -> {
            int countDataUsers = listUserBases.size() + 1;
            listUserBases.add(new UserBases("UB" + countDataUsers, 1, 60, 100, 3, 9, 1000, 100));
        });
        buttonRemoveTableUsers.setOnAction(event -> listUserBases.remove(tableUserBases.getSelectionModel().getSelectedIndex()));
    }

    private void initAppDeploymentConfTable() {
        dataCenterCol.setCellValueFactory(cellData -> cellData.getValue().dataCenterProperty());
        virtualMachinesCol.setCellValueFactory(cellData -> cellData.getValue().virtualMachinesProperty());
        imageSizeCol.setCellValueFactory(cellData -> cellData.getValue().imageSizeProperty());
        memoryCol.setCellValueFactory(cellData -> cellData.getValue().memoryProperty());
        bandwidth_col.setCellValueFactory(cellData -> cellData.getValue().bandwidthProperty());

        updateDataCenterNames();
        virtualMachinesCol.setCellFactory(TextFieldTableCell.forTableColumn());
        imageSizeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        memoryCol.setCellFactory(TextFieldTableCell.forTableColumn());
        bandwidth_col.setCellFactory(TextFieldTableCell.forTableColumn());

        dataCenterCol.setOnEditCommit(event -> {
            AppDeploymentConfiguration appDeploymentConfTable = event.getRowValue();
            String newValue = event.getNewValue();

            if (newValue == null || newValue.isEmpty() || isNameExists(newValue, appDeploymentConfTable)) {
                alertError("Пожалуйста, введите уникальное название!");
                appDeploymentConfTable.setDataCenter("");
                tableAppDeplConf.refresh();
            } else {
                appDeploymentConfTable.setDataCenter(newValue);
            }
            tableDataCentres.refresh(); // Обновляем таблицу для отображения текущего значения
        });
        virtualMachinesCol.setOnEditCommit(event -> {
            AppDeploymentConfiguration appDeploymentConfTable = event.getRowValue();
            appDeploymentConfTable.setVirtualMachines(Integer.parseInt(event.getNewValue()));
        });
        imageSizeCol.setOnEditCommit(event -> {
            AppDeploymentConfiguration appDeploymentConfTable = event.getRowValue();
            appDeploymentConfTable.setImageSize(Integer.parseInt(event.getNewValue()));
        });
        memoryCol.setOnEditCommit(event -> {
            AppDeploymentConfiguration appDeploymentConfTable = event.getRowValue();
            appDeploymentConfTable.setMemory(Integer.parseInt(event.getNewValue()));
        });
        bandwidth_col.setOnEditCommit(event -> {
            AppDeploymentConfiguration appDeploymentConfTable = event.getRowValue();
            appDeploymentConfTable.setBandwidth(Integer.parseInt(event.getNewValue()));
        });

        tableAppDeplConf.setItems(listAppConf);

        buttonAddApplicationConfTable.setOnAction(event -> {
            if (listAppConf.getLast().getDataCenter().isEmpty()) {
                alertError("Пожалуйста, завершите текущее заполнение, выбрав центр обработки данных");
                return;
            }
            if (listAppConf.size() == listDataCentres.size()) {
                alertError("Все доступные центры обработки данных уже распределены. Создайте новые ЦОД перед тем как создать новый элемент");
                tableAppDeplConf.refresh();
            } else {
                listAppConf.add(new AppDeploymentConfiguration("", 5, 10000, 512, 1000));
            }
            updateDataCenterNames();
        });
        buttonRemoveApplicationConfTable.setOnAction(event -> listAppConf.remove(tableAppDeplConf.getSelectionModel().getSelectedIndex()));
    }

    private boolean isNameExists(String newValue, AppDeploymentConfiguration currentRow) {
        for (AppDeploymentConfiguration appConf : listAppConf) {
            if (appConf != currentRow && newValue.equals(appConf.getDataCenter())) {
                return true;
            }
        }
        return false;
    }

    private ObservableList<String> updateDataCenterNames() {
        ObservableList<String> dataCenterNames = FXCollections.observableArrayList();
        for (DataCentres dataCentre : listDataCentres) {
            dataCenterNames.add(dataCentre.getName());
        }
        dataCenterCol.setCellFactory(ComboBoxTableCell.forTableColumn(dataCenterNames));
        return dataCenterNames;
    }

    private void initDataCenterTable() {
        nameOfDataCenterCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        regionOfDataCenterCol.setCellValueFactory(cellData -> cellData.getValue().regionProperty());
        archOfDataCenterCol.setCellValueFactory(cellData -> cellData.getValue().archProperty());
        OsOfDataCenterCol.setCellValueFactory(cellData -> cellData.getValue().OSProperty());
        VmmOfDataCenterCol.setCellValueFactory(cellData -> cellData.getValue().VMMProperty());
        costPerVmOfDataCenterCol.setCellValueFactory(cellData -> cellData.getValue().costPerVmProperty());
        memoryCostOfDataCenterCol.setCellValueFactory(cellData -> cellData.getValue().memoryCostProperty());
        storageCostOfDataCenterCol.setCellValueFactory(cellData -> cellData.getValue().storageCostProperty());
        dataTransferCostOfDataCenterCol.setCellValueFactory(cellData -> cellData.getValue().dataTransferCostProperty());
        physicalHwUnitsOfDataCenterCol.setCellValueFactory(cellData -> cellData.getValue().physicalHWUnitsProperty());

        nameOfDataCenterCol.setCellFactory(TextFieldTableCell.forTableColumn());
        regionOfDataCenterCol.setCellFactory(ComboBoxTableCell.forTableColumn(FXCollections.observableArrayList("0", "1", "2", "3", "4", "5")));
        archOfDataCenterCol.setCellFactory(ComboBoxTableCell.forTableColumn(FXCollections.observableArrayList("x86", "x64")));
        OsOfDataCenterCol.setCellFactory(ComboBoxTableCell.forTableColumn(FXCollections.observableArrayList("Linux", "Windows", "MacOS")));
        VmmOfDataCenterCol.setCellFactory(ComboBoxTableCell.forTableColumn(FXCollections.observableArrayList("Xen")));
        costPerVmOfDataCenterCol.setCellFactory(TextFieldTableCell.forTableColumn());
        memoryCostOfDataCenterCol.setCellFactory(TextFieldTableCell.forTableColumn());
        storageCostOfDataCenterCol.setCellFactory(TextFieldTableCell.forTableColumn());
        dataTransferCostOfDataCenterCol.setCellFactory(TextFieldTableCell.forTableColumn());
        physicalHwUnitsOfDataCenterCol.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item);
                }
            }
        });
        nameOfDataCenterCol.setOnEditCommit(event -> {
            boolean flag = false;
            DataCentres dataCentres = event.getRowValue();
            for (DataCentres listDataCentre : listDataCentres) {
                if (Objects.equals(dataCentres.getName(), listDataCentre.getName())) {
                    flag = true;
                }
            }
            if (!flag) {
                dataCentres.setName(event.getNewValue());
            } else {
                alertError("Пожалуйста, введите уникальное название!");
                tableDataCentres.refresh();
            }
        });
        regionOfDataCenterCol.setOnEditCommit(event -> {
            DataCentres dataCentres = event.getRowValue();
            dataCentres.setRegion(Integer.parseInt(event.getNewValue()));
        });
        archOfDataCenterCol.setOnEditCommit(event -> {
            DataCentres dataCentres = event.getRowValue();
            dataCentres.setArch(event.getNewValue());
        });
        OsOfDataCenterCol.setOnEditCommit(event -> {
            DataCentres dataCentres = event.getRowValue();
            dataCentres.setOS(event.getNewValue());
        });
        VmmOfDataCenterCol.setOnEditCommit(event -> {
            DataCentres dataCentres = event.getRowValue();
            dataCentres.setVMM(event.getNewValue());
        });
        costPerVmOfDataCenterCol.setOnEditCommit(event -> {
            DataCentres dataCentres = event.getRowValue();
            dataCentres.setCostPerVm(Integer.parseInt(event.getNewValue()));
        });
        memoryCostOfDataCenterCol.setOnEditCommit(event -> {
            DataCentres dataCentres = event.getRowValue();
            dataCentres.setMemoryCost(Integer.parseInt(event.getNewValue()));
        });
        storageCostOfDataCenterCol.setOnEditCommit(event -> {
            DataCentres dataCentres = event.getRowValue();
            dataCentres.setStorageCost(Integer.parseInt(event.getNewValue()));
        });
        dataTransferCostOfDataCenterCol.setOnEditCommit(event -> {
            DataCentres dataCentres = event.getRowValue();
            dataCentres.setDataTransferCost(Integer.parseInt(event.getNewValue()));
        });

        tableDataCentres.setItems(listDataCentres);

        buttonAddDataCentres.setOnAction(event -> {
            int countDataUsers = listDataCentres.size() + 1;
            listDataCentres.add(new DataCentres("DC" + countDataUsers, 5, "x86", "Linux", "Xen", 0.1, 0.05, 0.1, 0.1, 1, FXCollections.observableArrayList(new PhysicalHWDetailsOfDC(0, 204800, 100000000, 1000000, 4, 10000, "TIME_SHARED")), FXCollections.observableArrayList(new ServersDC("Сервер 1", "s1", 1, ""))));
            updateDataCenterNames();
            tableDataCentres.getSelectionModel().clearSelection();
            windowPhysicalHWDetails.setVisible(false);
        });
        buttonRemoveDataCentres.setOnAction(event -> {
            listDataCentres.remove(tableDataCentres.getSelectionModel().getSelectedIndex());
            tableDataCentres.getSelectionModel().clearSelection();
            windowPhysicalHWDetails.setVisible(false);
            updateDataCenterNames();
            for (AppDeploymentConfiguration appConf : listAppConf) {
                if (!updateDataCenterNames().contains(appConf.getDataCenter())) {
                    listAppConf.remove(appConf);
                }
            }
            tableDataCentres.refresh();
        });
        tableDataCentres.setOnMouseClicked(event -> {
            DataCentres selectedDataCenter = tableDataCentres.getSelectionModel().getSelectedItem();
            if (selectedDataCenter != null) {
                initPhysicalHWDetailsTable(selectedDataCenter.getListHwDetailsOfDCS());
                windowPhysicalHWDetails.setVisible(true);
            } else {
                windowPhysicalHWDetails.setVisible(false);
            }
        });
        tableDataCentres.refresh();
    }

    private void initPhysicalHWDetailsTable(ObservableList<PhysicalHWDetailsOfDC> listDetails) {
        idHwDetailsCol.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        memoryHwDetailsCol.setCellValueFactory(cellData -> cellData.getValue().memoryProperty());
        storageHwDetailsCol.setCellValueFactory(cellData -> cellData.getValue().storageProperty());
        availableBandwidthHwDetailsCol.setCellValueFactory(cellData -> cellData.getValue().availableBandwidthProperty());
        numOfProcessorHwDetailsCol.setCellValueFactory(cellData -> cellData.getValue().numOfProcessorsProperty());
        speedOfProcessorHwDetailsCol.setCellValueFactory(cellData -> cellData.getValue().processorSpeedProperty());
        VMPolicyHwDetailsCol.setCellValueFactory(cellData -> cellData.getValue().VMPolicyProperty());

        idHwDetailsCol.setCellFactory(TextFieldTableCell.forTableColumn());
        memoryHwDetailsCol.setCellFactory(TextFieldTableCell.forTableColumn());
        storageHwDetailsCol.setCellFactory(TextFieldTableCell.forTableColumn());
        availableBandwidthHwDetailsCol.setCellFactory(TextFieldTableCell.forTableColumn());
        numOfProcessorHwDetailsCol.setCellFactory(TextFieldTableCell.forTableColumn());
        speedOfProcessorHwDetailsCol.setCellFactory(TextFieldTableCell.forTableColumn());
        VMPolicyHwDetailsCol.setCellFactory(column -> new TableCell<>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item);
                }
            }
        });
        idHwDetailsCol.setOnEditCommit(event -> {
            boolean flag = false;
            PhysicalHWDetailsOfDC hwDetailsOfDC = event.getRowValue();
            for (PhysicalHWDetailsOfDC listHwDetailsOfDC : listDetails) {
                if (Objects.equals(hwDetailsOfDC.getId(), listHwDetailsOfDC.getId())) {
                    flag = true;
                }
            }
            if (!flag) {
                hwDetailsOfDC.setId(Integer.parseInt(event.getNewValue()));
            } else {
                alertError("Пожалуйста, введите уникальный ID!");
                tablePhysicalHWDetailsOfDC.refresh();
            }
        });
        memoryHwDetailsCol.setOnEditCommit(event -> {
            PhysicalHWDetailsOfDC detailsOfDC = event.getRowValue();
            detailsOfDC.setMemory(Integer.parseInt(event.getNewValue()));
        });
        storageHwDetailsCol.setOnEditCommit(event -> {
            PhysicalHWDetailsOfDC detailsOfDC = event.getRowValue();
            detailsOfDC.setStorage(Integer.parseInt(event.getNewValue()));
        });
        availableBandwidthHwDetailsCol.setOnEditCommit(event -> {
            PhysicalHWDetailsOfDC detailsOfDC = event.getRowValue();
            detailsOfDC.setAvailableBandwidth(Integer.parseInt(event.getNewValue()));
        });
        numOfProcessorHwDetailsCol.setOnEditCommit(event -> {
            PhysicalHWDetailsOfDC detailsOfDC = event.getRowValue();
            detailsOfDC.setNumOfProcessors(Integer.parseInt(event.getNewValue()));
        });
        speedOfProcessorHwDetailsCol.setOnEditCommit(event -> {
            PhysicalHWDetailsOfDC detailsOfDC = event.getRowValue();
            detailsOfDC.setProcessorSpeed(Integer.parseInt(event.getNewValue()));
        });

        tablePhysicalHWDetailsOfDC.setItems(listDetails);

        buttonAddHwDetail.setOnAction(event -> {
            int countDataUsers = listDetails.size();
            listDetails.add(new PhysicalHWDetailsOfDC(countDataUsers, 204800, 100000000, 1000000, 4, 10000, "TIME_SHARED"));
            tablePhysicalHWDetailsOfDC.getSelectionModel().clearSelection();
            tableDataCentres.getSelectionModel().getSelectedItem().setPhysicalHWUnits(listDetails.size());
        });
        buttonRemoveHwDetail.setOnAction(event -> {
            int selectedIndex = tablePhysicalHWDetailsOfDC.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                listDetails.remove(selectedIndex);
                tablePhysicalHWDetailsOfDC.getSelectionModel().clearSelection();
                tableDataCentres.getSelectionModel().getSelectedItem().setPhysicalHWUnits(listDetails.size());
            } else {
                alertError("Выберите элемент для удаления");
            }
        });
        buttonCopyHwDetail.setOnAction(event -> {
            if (tablePhysicalHWDetailsOfDC.getSelectionModel().getSelectedItem() != null) {
                Spinner<Integer> spinner = new Spinner<>(1, 100, 1);

                Dialog<Integer> dialog = new Dialog<>();
                dialog.setTitle("Количество копий");
                dialog.setHeaderText(null);
                dialog.setContentText("Введите количество копий:");

                Label contentLabel = new Label("Выберите количество копий:");

                VBox vbox = new VBox(10);
                vbox.getChildren().addAll(contentLabel, spinner);
                vbox.setPadding(new Insets(20));
                DialogPane dialogPane = dialog.getDialogPane();
                dialogPane.setPrefWidth(280);
                dialogPane.setPrefHeight(50);

                dialogPane.setContent(vbox);

                ButtonType okButtonType = new ButtonType("Подтвердить", ButtonBar.ButtonData.OK_DONE);
                ButtonType cancelButtonType = new ButtonType("Отменить", ButtonBar.ButtonData.CANCEL_CLOSE);

                dialogPane.getButtonTypes().addAll(okButtonType, cancelButtonType);

                dialog.setResultConverter(buttonType -> {
                    if (buttonType == okButtonType) {
                        // Возвращаем выбранное значение спиннера
                        return spinner.getValue();
                    }
                    return null; // Возвращаем null при нажатии на кнопку Cancel
                });
                Optional<Integer> result = dialog.showAndWait();
                result.ifPresent(copies -> {
                    PhysicalHWDetailsOfDC selectedRow = tablePhysicalHWDetailsOfDC.getSelectionModel().getSelectedItem();
                    for (int i = 0; i < copies; i++) {
                        int size = listDetails.size();
                        System.out.println(i);
                        PhysicalHWDetailsOfDC newDetailsOfDC = new PhysicalHWDetailsOfDC(size, selectedRow.getMemory(), selectedRow.getStorage(), selectedRow.getAvailableBandwidth(), selectedRow.getNumOfProcessors(), selectedRow.getProcessorSpeed(), selectedRow.getVMPolicy());
                        listDetails.add(newDetailsOfDC);
                    }
                    tableDataCentres.getSelectionModel().getSelectedItem().setPhysicalHWUnits(listDetails.size());
                });
            } else {
                alertError("Пожалуйста, выберите машину для копирования!");
            }
        });
        buttonServersDCHwDetail.setOnAction(event1 -> {
            try {
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("servers-dc.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);

                ServersDcController serversDcController = fxmlLoader.getController();
                serversDcController.setListServers(listDataCentres.get(tableDataCentres.getSelectionModel().getSelectedIndex()).getListServersDC());
                stage.setTitle("Серверы ЦОД");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();

                ObservableList<ServersDC> updatedServersList = serversDcController.getListServers();
                listDataCentres.get(tableDataCentres.getSelectionModel().getSelectedIndex()).setListServersDC(updatedServersList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    private void initMainButtons() {
        buttonSaveConfiguration.setOnAction(event -> {
            if (Integer.parseInt(textUsGroupingFactorInUB.getText()) < Integer.parseInt(textRequestGroupingFactorInDC.getText())) {
                alertError("Коэффициент группировки пользователей в базах пользователей не может быть меньше, чем коэффициент группировки запросов в ЦОД");
                return;
            }
            try {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Выберите место сохранения файла");
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("SIM files (*.sim)", "*.sim"));

                File file = fileChooser.showSaveDialog(new Stage());
                if (file != null) {
                    String filePath = file.getPath();
                    if (!filePath.toLowerCase().endsWith(".sim")) {
                        // Если расширения нет, добавляем его
                        filePath += ".sim";
                        file = new File(filePath);
                    }
                    try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filePath)))) {
                        encoder.writeObject(serialize());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            new XMLWriter().saveToXML(listUserBases, listAppConf);
        });
        buttonLoadConfiguration.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Выберите файл для загрузки");
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("SIM файлы (*.sim)", "*.sim");
            fileChooser.getExtensionFilters().add(extFilter);

            File file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {
                try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)))) {
                    Object object = decoder.readObject();
                    if (object instanceof RootObjectToSaveData) {
                        deserialize((RootObjectToSaveData) object);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                System.err.println("Неверный тип объекта");
            }
        });
        buttonDoneConfiguration.setOnAction(event -> {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("continue.ser"))) {
                oos.writeObject(serialize());
                saveOriginalData();
            } catch (IOException e) {
                e.printStackTrace();
            }
            isPressedContinue = true;
            paneConfigurationSimulation.setVisible(false);
        });
        buttonCancelConfiguration.setOnAction(event -> {
            paneConfigurationSimulation.setVisible(false);
            windowPhysicalHWDetails.setVisible(false);

            listUserBases = FXCollections.observableArrayList();
            for (UserBases ub : originalListUserBases) {
                listUserBases.add(ub.copy());
            }

            listAppConf = FXCollections.observableArrayList();
            for (AppDeploymentConfiguration adc : originalListAppConf) {
                listAppConf.add(adc.copy());
            }

            listHWDetails = FXCollections.observableArrayList();
            for (PhysicalHWDetailsOfDC hw : originalListHwDetail) {
                listHWDetails.add(hw.copy());
            }

            listDataCentres = FXCollections.observableArrayList();
            for (DataCentres dc : originalListDataCentres) {
                DataCentres dcCopy = dc.copy(dc.getListHwDetailsOfDCS(), dc.getListServersDC());
                ObservableList<PhysicalHWDetailsOfDC> copiedHwDetails = FXCollections.observableArrayList();
                for (PhysicalHWDetailsOfDC hw : dc.getListHwDetailsOfDCS()) {
                    copiedHwDetails.add(hw.copy());
                }
                ObservableList<ServersDC> copiedServersDC = FXCollections.observableArrayList();
                for (ServersDC server : dc.getListServersDC()) {
                    copiedServersDC.add(server.copy());
                }
                dcCopy.setListHwDetailsOfDCS(copiedHwDetails);
                dcCopy.setListServersDC(copiedServersDC);
                listDataCentres.add(dcCopy);
            }

            tableUserBases.setItems(listUserBases);
            tableAppDeplConf.setItems(listAppConf);
            tableDataCentres.setItems(listDataCentres);
            tablePhysicalHWDetailsOfDC.setItems(listHWDetails);

            valueSimDurText.setText(originalValueSimDur);
            comboboxSimulationDuration.setValue(originalSimDur);
            comboboxBrokerPolicy.setValue(originalBrokerPolicy);
            textUsGroupingFactorInUB.setText(originalUsGroupingFactorInUB);
            textRequestGroupingFactorInDC.setText(originalRequestGroupingFactorInDC);
            textExecutableInstructionLengthPrReq.setText(originalExecutableInstructionLengthPrReq);
            comboBoxLBPolicy.setValue(originalLBPolicy);
        });
    }

    private void saveOriginalData() {
        originalListUserBases = FXCollections.observableArrayList(listUserBases);
        originalListAppConf = FXCollections.observableArrayList(listAppConf);
        originalListDataCentres = FXCollections.observableArrayList(listDataCentres);
        originalValueSimDur = valueSimDurText.getText();
        originalSimDur = comboboxSimulationDuration.getValue();
        originalBrokerPolicy = comboboxBrokerPolicy.getValue();
        originalUsGroupingFactorInUB = textUsGroupingFactorInUB.getText();
        originalRequestGroupingFactorInDC = textRequestGroupingFactorInDC.getText();
        originalExecutableInstructionLengthPrReq = "100";
        originalLBPolicy = comboBoxLBPolicy.getValue();
    }
    private void alertError(String contentText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

        public RootObjectToSaveData serialize() {
            RootObjectToSaveData save = new RootObjectToSaveData();
            SerializableList<UserBaseData> listUsBs = new SerializableList<>();
            for (int i = 0; i < listUserBases.size(); i++) {
                listUsBs.add(new UserBaseData(listUserBases.get(i).getName(), listUserBases.get(i).getRegion(), listUserBases.get(i).getRequestsPrUsPrHr(), listUserBases.get(i).getDataSzPrRq(), listUserBases.get(i).getPeakHrStart(), listUserBases.get(i).getPeakHrEnd(), listUserBases.get(i).getAvgPkUsrs(), listUserBases.get(i).getAvgPkOffUsrs()));
            }
            SerializableList<AppDeploymentConfigurationData> listApCon = new SerializableList<>();
            for (int i = 0; i < listAppConf.size(); i++) {
                listApCon.add(new AppDeploymentConfigurationData(listAppConf.get(i).getDataCenter(), listAppConf.get(i).getVirtualMachines(), listAppConf.get(i).getImageSize(), listAppConf.get(i).getMemory(), listAppConf.get(i).getBandwidth()));
            }
            SerializableList<DataCentresData> listDC = new SerializableList<>();
            for (int i = 0; i < listDataCentres.size(); i++) {
                SerializableList<PhysicalHWDetailsOfDCData> listDetails = new SerializableList<>();
                SerializableList<ServersDCData> listServerDC = new SerializableList<>();
                for (int j = 0; j < listDataCentres.get(i).getListHwDetailsOfDCS().size(); j++) {
                    listDetails.add(new PhysicalHWDetailsOfDCData(listDataCentres.get(i).getListHwDetailsOfDCS().get(j).getId(), listDataCentres.get(i).getListHwDetailsOfDCS().get(j).getMemory(), listDataCentres.get(i).getListHwDetailsOfDCS().get(j).getStorage(), listDataCentres.get(i).getListHwDetailsOfDCS().get(j).getAvailableBandwidth(), listDataCentres.get(i).getListHwDetailsOfDCS().get(j).getNumOfProcessors(), listDataCentres.get(i).getListHwDetailsOfDCS().get(j).getProcessorSpeed(), listDataCentres.get(i).getListHwDetailsOfDCS().get(j).getVMPolicy()));
                }
                for (int j = 0; j < listDataCentres.get(i).getListServersDC().size(); j++) {
                    listServerDC.add(new ServersDCData(listDataCentres.get(i).getListServersDC().get(j).getName(), listDataCentres.get(i).getListServersDC().get(j).getPrefix(), listDataCentres.get(i).getListServersDC().get(j).getCount(), listDataCentres.get(i).getListServersDC().get(j).getCode()));
                }
                listDC.add(new DataCentresData(listDataCentres.get(i).getName(), listDataCentres.get(i).getRegion(), listDataCentres.get(i).getArch(), listDataCentres.get(i).getOS(), listDataCentres.get(i).getVMM(), listDataCentres.get(i).getCostPerVm(), listDataCentres.get(i).getMemoryCost(), listDataCentres.get(i).getStorageCost(), listDataCentres.get(i).getDataTransferCost(), listDataCentres.get(i).getPhysicalHWUnits(), listDetails, listServerDC));
            }
            save.setAdvancedData(new AdvancedData(Integer.parseInt(textUsGroupingFactorInUB.getText()), Integer.parseInt(textRequestGroupingFactorInDC.getText()), Integer.parseInt(textExecutableInstructionLengthPrReq.getText()), comboBoxLBPolicy.getValue()));

            save.setSimulationDuration(comboboxSimulationDuration.getValue());
            save.setValueSimulationDuration(Double.parseDouble(valueSimDurText.getText()));
            save.setServiceBrokerPolicy(comboboxBrokerPolicy.getValue());

            save.setListUserBases(listUsBs);
            save.setListAppDeploymentConf(listApCon);
            save.setListDataCentres(listDC);
            return save;
        }

    private void deserialize(RootObjectToSaveData loadedData) {
        listDataCentres.clear();
        listAppConf.clear();
        listUserBases.clear();

        for (int i = 0; i < loadedData.getListUserBases().size(); i++) {
            listUserBases.add(new UserBases(loadedData.getListUserBases().get(i).getName(), loadedData.getListUserBases().get(i).getRegion(), loadedData.getListUserBases().get(i).getRequsetsPrUsPrHr(), loadedData.getListUserBases().get(i).getDataSzPrRq(), loadedData.getListUserBases().get(i).getPeakHrStart(), loadedData.getListUserBases().get(i).getPeakHrEnd(), loadedData.getListUserBases().get(i).getAvgPkUsrs(), loadedData.getListUserBases().get(i).getAvgPkOffUsrs()));
        }
        for (int i = 0; i < loadedData.getListAppDeploymentConf().size(); i++) {
            listAppConf.add(new AppDeploymentConfiguration(loadedData.getListAppDeploymentConf().get(i).getDataCenter(), loadedData.getListAppDeploymentConf().get(i).getVirtualMachines(), loadedData.getListAppDeploymentConf().get(i).getImageSize(), loadedData.getListAppDeploymentConf().get(i).getMemory(), loadedData.getListAppDeploymentConf().get(i).getBandwidth()));
        }
        for (int i = 0; i < loadedData.getListDataCentres().size(); i++) {
            ObservableList<PhysicalHWDetailsOfDC> listDetails = FXCollections.observableArrayList();
            ObservableList<ServersDC> listServersDc = FXCollections.observableArrayList();
            ArrayList<PhysicalHWDetailsOfDCData> listLoadedDetails = loadedData.getListDataCentres().get(i).getListHwDetailsOfDCS();
            ArrayList<ServersDCData> listLoadedServersDC = loadedData.getListDataCentres().get(i).getListServersDC();
            for (int j = 0; j < loadedData.getListDataCentres().get(i).getListHwDetailsOfDCS().size(); j++) {
                listDetails.add(new PhysicalHWDetailsOfDC(listLoadedDetails.get(j).getId(), listLoadedDetails.get(j).getMemory(), listLoadedDetails.get(j).getStorage(), listLoadedDetails.get(j).getAvailableBandwidth(), listLoadedDetails.get(j).getNumOfProcessors(), listLoadedDetails.get(j).getProcessorSpeed(), listLoadedDetails.get(j).getVMPolicy()));
            }
            for (int j = 0; j < loadedData.getListDataCentres().get(i).getListServersDC().size(); j++) {
                listServersDc.add(new ServersDC(listLoadedServersDC.get(j).getName(), listLoadedServersDC.get(j).getPrefix(), listLoadedServersDC.get(j).getCount(), listLoadedServersDC.get(j).getCode()));
            }

            List<DataCentresData> list = loadedData.getListDataCentres();
            listDataCentres.add(new DataCentres(list.get(i).getName(), list.get(i).getRegion(), list.get(i).getArch(), list.get(i).getOS(),
                    list.get(i).getVMM(), list.get(i).getCostPerVm(), list.get(i).getMemoryCost(), list.get(i).getStorageCost(),
                    list.get(i).getDataTransferCost(), list.get(i).getPhysicalHWUnits(), listDetails, listServersDc));
        }
        AdvancedData advancedData = loadedData.getAdvancedData();
        textExecutableInstructionLengthPrReq.setText(String.valueOf(advancedData.getExecutableInstructionLengthPrReq()));
        textUsGroupingFactorInUB.setText(String.valueOf(advancedData.getUsGroupingFactorInUB()));
        textRequestGroupingFactorInDC.setText(String.valueOf(advancedData.getRequestGroupingFactorInDC()));
        comboBoxLBPolicy.setValue(advancedData.getLBPolicy());

        valueSimDurText.setText(String.valueOf(loadedData.getValueSimulationDuration()));
        comboboxSimulationDuration.setValue(String.valueOf(loadedData.getSimulationDuration()));
        comboboxBrokerPolicy.setValue(String.valueOf(loadedData.getServiceBrokerPolicy()));

        tableDataCentres.refresh();
        tableAppDeplConf.refresh();
        tableUserBases.refresh();
    }


    //----------------------------------INTERNET CHARACTERISTICS------------------------------------------------------
}