package com.example.cloudanalystt;

import com.example.cloudanalystt.ui.ServersDcController;
import com.example.cloudanalystt.utils.ServersDC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.ListViewMatchers.hasItems;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;

public class Tests extends ApplicationTest {/*
    private ServersDcController controller;
    private ObservableList<ServersDC> servers;

    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/cloudanalystt/servers-dc.fxml"));
        Parent root = loader.load();
        controller = loader.getController();

        stage.setScene(new Scene(root));
        stage.show();
    }

    //-------------------------------Unit tests------------------------------------------
    // Тестирование классов моделей
    @Test
    public void testGettersAndSetters() {
        ServersDC server = new ServersDC("Server1", "s1", 1, "code1");
        assertEquals("Server1", server.getName());
        assertEquals("s1", server.getPrefix());
        assertEquals(1, server.getCount());
        assertEquals("code1", server.getCode());

        server.setName("Server2");
        server.setPrefix("s2");
        server.setCount(2);
        server.setCode("code2");

        assertEquals("Server2", server.getName());
        assertEquals("s2", server.getPrefix());
        assertEquals(2, server.getCount());
        assertEquals("code2", server.getCode());

    }

    //Тестирование логики контроллеров
    @Test
    public void testGetListServers() {
        ObservableList<ServersDC> servers = FXCollections.observableArrayList(
                new ServersDC("Server1", "s1", 1, "code1")
        );
        controller.setListServers(servers);
        assertEquals(1, controller.getListServers().size());
        assertEquals("Server1", controller.getListServers().get(0).getName());
    }

    // ---------------------------------Интеграционные тесты-------------------------------
    //Тестирование взаимодействия между контроллерами и моделями
    @Test
    public void testAddServer() {
        controller.getListServers().add(new ServersDC("Server2", "s2", 2, "code2"));
        assertEquals(2, controller.getListServers().size());
        assertEquals("Server2", controller.getListServers().get(1).getName());
    }

    @Test
    public void testUpdateServer() {
        ServersDC server = controller.getListServers().get(0);
        server.setName("UpdatedServer");
        controller.getListServers().removeFirst();
        controller.getListServers().addFirst(server);
        assertEquals("UpdatedServer", controller.getListServers().get(0).getName());
    }

    @Test
    public void testDeleteServer() {
        controller.getListServers().removeFirst();
        assertEquals(0, controller.getListServers().size());
    }

    //--------------------------------UI тесты---------------------------------------
    //Тестирование пользовательского интерфейса с использованием TestFX
    @Test
    public void testAddServerUI() {

        clickOn("#buttonAddServer");
        clickOn("#textPrefixAdd").write("s2");
        clickOn("#textCodeAdd").write("code2");
        clickOn("#buttonSaveAdd");

        verifyThat("#tableServersDC", hasItems(2));
    }

    @Test
    public void testUpdateServerUI() {
        clickOn("#tableServersDC").type(KeyCode.DOWN);
        clickOn("#buttonUpdateServer");
        clickOn("#textPrefixAdd").eraseText(2).write("s3");
        clickOn("#buttonSaveAdd");

        verifyThat("#tableServersDC", hasItems(1)); // assuming only one item is updated
        verifyThat("#tableServersDC", hasText("s3"));
    }

    @Test
    public void testDeleteServerUI() {
        // Убедитесь, что таблица инициализирована и содержит данные
        ObservableList<ServersDC> servers = FXCollections.observableArrayList(
                new ServersDC("Server1", "s1", 1, "code1")
        );
        controller.setListServers(servers);

        // Убедитесь, что данные добавлены в таблицу
        verifyThat("#tableServersDC", hasItems(1));
        clickOn("#tableServersDC").type(KeyCode.UP);
        clickOn("#buttonDeleteServer");

        verifyThat("#tableServersDC", hasItems(0)); // assuming only one item was present
    }*/
}