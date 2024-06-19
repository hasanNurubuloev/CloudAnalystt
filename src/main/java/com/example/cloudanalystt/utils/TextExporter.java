package com.example.cloudanalystt.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TextExporter {
    public static void exportToTextFile(List<StateExcel> data, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            // Запись заголовков
            writer.write(String.format("%-20s%-20s%-20s%-20s%-20s%n", "Server", "State", "Start Time", "End Time", "Response Time"));

            // Запись данных
            for (StateExcel record : data) {
                writer.write(String.format("%-20s%-20s%-20.2f%-20.2f%-20.2f%n",
                        record.getServer(),
                        record.getState(),
                        record.getStartTime(),
                        record.getEndTime(),
                        record.getDurationTime()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}