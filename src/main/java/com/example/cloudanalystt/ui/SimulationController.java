package com.example.cloudanalystt.ui;


//import com.example.cloudanalystt.utils.ExcelExporter;

import com.example.cloudanalystt.utils.ServersResponseTime;
import com.example.cloudanalystt.utils.StateExcel;
import com.example.cloudanalystt.utils.StateExcelData;
import com.example.cloudanalystt.utils.TextExporter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.dhatim.fastexcel.reader.Row;
import org.dhatim.fastexcel.reader.Sheet;

import java.io.File;
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
    @FXML
    private Button buttonExport;
    ObservableList<StateExcel> listAllRequests = FXCollections.observableArrayList();

    private ArrayList<Double> listUsersMetrics;
    @FXML
    private Label textMinValue;
    @FXML
    private Label textMaxValue;
    @FXML
    private Label textAvgValue;

    @FXML
    private Label textFactSimDur;

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

        Map<String, List<Double>> serverResponseTimes = new TreeMap<>();
        /*listAllRequests.forEach(request -> {
            String server = request.getServer().trim();
            if ( server.contains("u-") && !server.startsWith("db")
                    && !server.startsWith("cb") && !server.startsWith("lb")) {
                serverResponseTimes.computeIfAbsent(server, k -> new ArrayList<>()).add(request.getDurationTime());
            }
        });*/
        for (int i = 0; i < listAllRequests.size(); i++) {
            String server = listAllRequests.get(i).getServer().trim();
            if (server.contains("u-") && !server.startsWith("db")
                    && !server.startsWith("cb") && !server.startsWith("lb")) {
                if (i < listAllRequests.size() - 3 && listAllRequests.get(i).getState().trim().equals("send")
                        && listAllRequests.get(i + 1).getState().trim().equals("execute") && listAllRequests.get(i + 2).getState().trim().equals("receive")
                        && listAllRequests.get(i + 3).getState().trim().equals("execute")) {
                    serverResponseTimes.computeIfAbsent(server, k -> new ArrayList<>()).add(listAllRequests.get(i + 3).getStartTime() - listAllRequests.get(i).getStartTime());
                }
            }
        }
        System.out.println("Server response time statistics:");
        serverResponseTimes.forEach((server, responseTimes) -> {
            double minResponseTime = Collections.min(responseTimes);
            double maxResponseTime = Collections.max(responseTimes);
            double avgResponseTime = responseTimes.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
            listServerResponseTime.add(new ServersResponseTime(server,  minResponseTime, maxResponseTime, avgResponseTime));
            System.out.println("Server: " + server);
            System.out.println("Min response time: " + minResponseTime);
            System.out.println("Max response time: " + maxResponseTime);
            System.out.println("Avg response time: " + avgResponseTime);
//        listServerResponseTime.add(new ServersResponseTime(allRowsList.));
        });
    }

    private void initTableRequests() {
        hostCol.setCellValueFactory(cellData -> cellData.getValue().serverProperty());
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

        buttonExport.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Сохранить файл");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT Files", "*.txt"));

            // Отображение диалогового окна
            File file = fileChooser.showSaveDialog(new Stage());
            if (file != null) {
                String filePath = file.getPath();
                if (!filePath.toLowerCase().endsWith(".txt")) {
                    // Если расширения нет, добавляем его
                    filePath += ".txt";
                    file = new File(filePath);
                }
                // Экспорт данных в текстовый файл
                TextExporter.exportToTextFile(listAllRequests, file.getAbsolutePath());
                System.out.println("Данные экспортированы в текстовый файл: " + file.getAbsolutePath());
            } else {
                System.out.println("Сохранение файла отменено.");
            }
        });

//        allRowsList.forEach((server, rowsList) -> {
//            for (int i = 0; i < rowsList.size(); i++) {
//                if (i != rowsList.size() - 1) {
//                    String state = rowsList.get(i).getLast();
//                    if (!rowsList.get(i + 1).getLast().equals(state)) {
//                        listAllRequests.add(new StateExcel(rowsList.get(i).get(1), rowsList.get(i).getLast(),
//                                Float.parseFloat(rowsList.get(i).get(3)), Float.parseFloat(rowsList.get(i + 1).get(3)),
//                                Float.parseFloat(rowsList.get(i + 1).get(3)) - Float.parseFloat(rowsList.get(i).get(3))));
//                    }
//                } else {
//                    //TODO рассмотреть ситуацию когда последний элемент
//                }
//            }
//        });


        List<String> sortedKeys = new ArrayList<>(allRowsList.keySet());
        sortedKeys.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                boolean s1ContainsU = s1.contains("u-");
                boolean s2ContainsU = s2.contains("u-");
                boolean s1StartsWithU = s1.startsWith("u");
                boolean s2StartsWithU = s2.startsWith("u");

                if (!s1ContainsU && !s2ContainsU) {
                    return s1.compareTo(s2);
                } else if (!s1ContainsU) {
                    return -1;
                } else if (!s2ContainsU) {
                    return 1;
                } else if (s1StartsWithU && s2StartsWithU) {
                    return s1.compareTo(s2);
                } else if (s1StartsWithU) {
                    return -1;
                } else if (s2StartsWithU) {
                    return 1;
                } else {
                    String[] parts1 = s1.split("u-");
                    String[] parts2 = s2.split("u-");
                    if (parts1.length > 1 && parts2.length > 1) {
                        int num1 = Integer.parseInt(parts1[1].split("\\.")[0]);
                        int num2 = Integer.parseInt(parts2[1].split("\\.")[0]);
                        int result = Integer.compare(num1, num2);
                        if (result != 0) {
                            return result;
                        }
                    }
                    return s1.compareTo(s2);
                }
            }
        });

        // Перенос отсортированных данных в новый Map
        Map<String, List<List<String>>> sortedAllRowsMap = new LinkedHashMap<>();
        for (String key : sortedKeys) {
            sortedAllRowsMap.put(key, allRowsList.get(key));
        }

        // Заполнение listAllRequests
        sortedAllRowsMap.forEach((server, rowsList) -> {
            for (int i = 0; i < rowsList.size(); i++) {
                if (i != rowsList.size() - 1) {
//                    String state = rowsList.get(i).getLast();
//                    if (!rowsList.get(i + 1).getLast().equals(state)) {
                    String serverName = rowsList.get(i).get(1);
                    if (serverName.contains(".")) {
                        serverName = serverName.substring(0, serverName.indexOf('.'));
                    }
                    listAllRequests.add(new StateExcel(serverName.trim(), rowsList.get(i).getLast(),
                            Double.parseDouble(rowsList.get(i).get(3)), Double.parseDouble(rowsList.get(i + 1).get(3)),
                            Double.parseDouble(rowsList.get(i + 1).get(3)) - Double.parseDouble(rowsList.get(i).get(3))));
//                    }
                } else {
                    //TODO рассмотреть ситуацию когда последний элемент
                }
            }
        });
        allRowsList.forEach((key, stateExcelList) -> {
            stateExcelList.forEach(stateExcel -> {
                if (stateExcel.get(1).trim().equals("cloudBroker-1") && !Objects.equals(stateExcel.getLast().trim(), "sleep")) {
                    textFactSimDur.setText(String.valueOf(stateExcel.get(4)));
                }
            });
        });
    }

    private void readFile() {
        Path path = Path.of("/home/hasan/IdeaProjects/CloudAnalystt/state1.xlsx");
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
            double startTime = Float.parseFloat(rowData.get(3).trim());
            double endTime = Float.parseFloat(rowData.get(4).trim());
            double durationTime = Float.parseFloat(rowData.get(5).trim());
            int level = (int) Double.parseDouble(rowData.get(6).trim());
            String state = rowData.get(7).trim();
            StateExcelData data = new StateExcelData(type, actor, type1, startTime, endTime, durationTime, level, state);
            userRowsMap.computeIfAbsent(actor, k -> new ArrayList<>()).add(data);
        }
//        if (actor.contains("u-")) {
        allRowsList.computeIfAbsent(actor, k -> new ArrayList<>()).add(new ArrayList<>(rowData));
//        }
    }

    private void getUserRequests() {
        ArrayList<Double> listUsersTimeRequests = new ArrayList<>();
        userRowsMap.forEach((user, rowsList) -> {
            for (int i = 0; i < rowsList.size() - 1; i++) {
                StateExcelData data = rowsList.get(i);
                if (i < rowsList.size() - 3 && data.getState().equals("send") && rowsList.get(i + 1).getState().equals("execute") && rowsList.get(i + 2).getState().equals("receive") && rowsList.get(i + 3).getState().equals("execute")) {
                    double subtraction = rowsList.get(i + 3).getStartTime() - data.getStartTime();
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

    private ArrayList<Double> getMinMaxAvg(ArrayList<Double> list) {
        double min = 0, max = 0, avg = 0, sum = 0;
        ArrayList<Double> listMetrics = new ArrayList<>();
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
