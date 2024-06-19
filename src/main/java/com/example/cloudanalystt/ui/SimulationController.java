package com.example.cloudanalystt.ui;


import com.example.cloudanalystt.utils.ServersResponseTime;
import com.example.cloudanalystt.utils.StateExcel;
import com.example.cloudanalystt.utils.StateExcelData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.dhatim.fastexcel.reader.Row;
import org.dhatim.fastexcel.reader.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class SimulationController {
    Map<String, List<StateExcelData>> userRowsMap = new TreeMap<>();
    //    List<List<String>> allRowsList = new ArrayList<>();
    Map<String, List<List<String>>> allRowsList = new TreeMap<>();

    @FXML
    private TableView<ServersResponseTime> tableServerResponseTime = new TableView<>();
    @FXML
    private TableColumn<ServersResponseTime, String> serverCol;
    @FXML
    private TableColumn<ServersResponseTime, String> minCol;
    @FXML
    private TableColumn<ServersResponseTime, String> maxCol;
    @FXML
    private TableColumn<ServersResponseTime, String> avgCol;

    private ObservableList<ServersResponseTime> listServerResponseTime = FXCollections.observableArrayList();


    @FXML
    private TableView<StateExcel> tableAllRequests = new TableView<>();
    @FXML
    private TableColumn<StateExcel, String> hostCol;
    @FXML
    private TableColumn<StateExcel, String> stateCol;
    @FXML
    private TableColumn<StateExcel, String> startTimeCol;
    @FXML
    private TableColumn<StateExcel, String> endTimeCol;
    @FXML
    private TableColumn<StateExcel, String> durationTimeCol;
    ObservableList<StateExcel> listAllRequests = FXCollections.observableArrayList();

    private ArrayList<Float> listUsersMetrics;
    @FXML
    private Label textMinValue;
    @FXML
    private Label textMaxValue;
    @FXML
    private Label textAvgValue;

    @FXML
    void initialize() {
        readFile();
        initTableRequests();
        getUserRequests();
        initTableServersResponse();
    }

    private void initTableServersResponse() {
        serverCol.setCellValueFactory(cellData -> cellData.getValue().serverProperty());
        maxCol.setCellValueFactory(cellData -> cellData.getValue().maxProperty());
        minCol.setCellValueFactory(cellData -> cellData.getValue().minProperty());
        avgCol.setCellValueFactory(cellData -> cellData.getValue().avgProperty());

        tableServerResponseTime.setItems(listServerResponseTime);

        Map<String, List<Float>> serverResponseTimes = new TreeMap<>();
        listAllRequests.forEach(request -> {
            String server = request.getHost().trim();
            if (!server.startsWith("u")) {
                serverResponseTimes.computeIfAbsent(server, k -> new ArrayList<>()).add(request.getDurationTime());
            }
        });
        System.out.println("Server response time statistics:");
        serverResponseTimes.forEach((server, responseTimes) -> {
            float minResponseTime = Collections.min(responseTimes);
            float maxResponseTime = Collections.max(responseTimes);
            float avgResponseTime = (float) responseTimes.stream().mapToDouble(Float::doubleValue).average().orElse(0.0);
            listServerResponseTime.add(new ServersResponseTime(server, minResponseTime, maxResponseTime, avgResponseTime));
            System.out.println("Server: " + server);
            System.out.println("Min response time: " + minResponseTime);
            System.out.println("Max response time: " + maxResponseTime);
            System.out.println("Avg response time: " + avgResponseTime);
//        listServerResponseTime.add(new ServersResponseTime(allRowsList.));
        });
    }

    private void initTableRequests() {
        hostCol.setCellValueFactory(cellData -> cellData.getValue().hostProperty());
        stateCol.setCellValueFactory(cellData -> cellData.getValue().stateProperty());
        startTimeCol.setCellValueFactory(cellData -> cellData.getValue().startTimeProperty());
        endTimeCol.setCellValueFactory(cellData -> cellData.getValue().endTimeProperty());
        durationTimeCol.setCellValueFactory(cellData -> cellData.getValue().durationTimeProperty());

        hostCol.setCellFactory(TextFieldTableCell.forTableColumn());
        stateCol.setCellFactory(TextFieldTableCell.forTableColumn());
        startTimeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        endTimeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        durationTimeCol.setCellFactory(TextFieldTableCell.forTableColumn());

        tableAllRequests.setItems(listAllRequests);

        allRowsList.forEach((server, rowsList) -> {
            for (int i = 0; i < rowsList.size(); i++) {
                if (i != rowsList.size() - 1) {
                    String state = rowsList.get(i).getLast();
                    if (!rowsList.get(i + 1).getLast().equals(state)) {
                        listAllRequests.add(new StateExcel(rowsList.get(i).get(1), rowsList.get(i).getLast(), Float.parseFloat(rowsList.get(i).get(3)), Float.parseFloat(rowsList.get(i + 1).get(3)), Float.parseFloat(rowsList.get(i + 1).get(3)) - Float.parseFloat(rowsList.get(i).get(3))));
                    }
                } else {
                    //TODO рассмотреть ситуацию когда последний элемент
                }
            }
        });

    }

    private void readFile() {
        Path path = Path.of("/home/hasan/IdeaProjects/CloudAnalystt/state111.xlsx");
        try (FileInputStream fis = new FileInputStream(path.toFile());
             ReadableWorkbook workbook = new ReadableWorkbook(fis)) {
            Sheet sheet = workbook.getFirstSheet();

            try (Stream<Row> rows = sheet.openStream()) {
                rows.forEach(row -> {
                    List<String> rowData = new ArrayList<>();
                    row.forEach(cell -> rowData.add(cell.getText()));
                    if (rowData.size() == 1) {
                        String[] splitData = rowData.getFirst().split(",");
                        rowData.clear();
                        rowData.addAll(Arrays.asList(splitData));
                    }
                    initListsRequests(rowData);
                });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initListsRequests(List<String> rowData) {
        String actor = rowData.get(1).trim();
        if (actor.startsWith("u")) { // фильтрация по условию
            String type = rowData.get(0).trim();
            String type1 = rowData.get(2).trim();
            float startTime = Float.parseFloat(rowData.get(3).trim());
            float endTime = Float.parseFloat(rowData.get(4).trim());
            float durationTime = Float.parseFloat(rowData.get(5).trim());
            int level = (int) Double.parseDouble(rowData.get(6).trim());
            String state = rowData.get(7).trim();
            StateExcelData data = new StateExcelData(type, actor, type1, startTime, endTime, durationTime, level, state);
            userRowsMap.computeIfAbsent(actor, k -> new ArrayList<>()).add(data);
        }
        if (actor.contains("u-")) {
            allRowsList.computeIfAbsent(actor, k -> new ArrayList<>()).add(new ArrayList<>(rowData));
        }
    }

    private void getUserRequests() {
        ArrayList<Float> listUsersTimeRequests = new ArrayList<>();
        userRowsMap.forEach((user, rowsList) -> {
            for (int i = 0; i < rowsList.size() - 1; i++) {
                StateExcelData data = rowsList.get(i);
                if (i < rowsList.size() - 3 && data.getState().equals("send") && rowsList.get(i + 1).getState().equals("execute") && rowsList.get(i + 2).getState().equals("receive") && rowsList.get(i + 3).getState().equals("execute")) {
                    float subtraction = rowsList.get(i + 3).getStartTime() - data.getStartTime();
//                    listUserRequests.add(new StateExcel(rowsList.get(i).getActor(), rowsList.get(i).getState(), rowsList.get(i).getStartTime(), rowsList.get(i + 1).getStartTime(), rowsList.get(i + 1).getStartTime() - rowsList.get(i).getStartTime()));
                    listUsersTimeRequests.add(subtraction);
                }
            }
        });
        listUsersMetrics = getMinMaxAvg(listUsersTimeRequests);
        textMinValue.setText(String.valueOf(listUsersMetrics.get(0)));
        textMaxValue.setText(String.valueOf(listUsersMetrics.get(1)));
        textAvgValue.setText(String.valueOf(listUsersMetrics.get(2)));
    }

    private ArrayList<Float> getMinMaxAvg(ArrayList<Float> list) {
        float min = 0, max = 0, avg = 0, sum = 0;
        ArrayList<Float> listMetrics = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                min = list.get(i);
                max = list.get(i);
            }
            if (list.get(i) < min) {
                min = list.get(i);
            } else if (list.get(i) > max) {
                max = list.get(i);
            }
            sum += list.get(i);
        }
        listMetrics.add(min);
        listMetrics.add(max);
        listMetrics.add(sum / list.size());
        return listMetrics;
    }
}
