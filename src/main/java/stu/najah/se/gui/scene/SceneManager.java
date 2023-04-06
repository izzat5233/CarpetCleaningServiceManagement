package stu.najah.se.gui.scene;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import stu.najah.se.gui.Controller;

import java.io.IOException;

/**
 * This is the JavaFX application launcher.
 * It's a manager class for all scenes of the primary stage.
 * The logic screen shows up when the application launches.
 * All FXML files & Stylesheets resource files must be in this class's directory
 */
public class SceneManager extends Application {

    /**
     * The primary stage
     */
    private Stage stage;

    private Scene loginScene;
    private Controller loginController;

    private Scene mainScene;
    private Controller mainController;

    /**
     * A reference to the singleton manager object
     */
    private static SceneManager instance;

    /**
     * Must be called after createInstance() has been called
     *
     * @return reference to the singleton object
     */
    static SceneManager getInstance() {
        return instance;
    }

    /**
     * Launches the application.
     * Blocks control flow of the thread until the application closes.
     * To call it from another class use:
     * Platform.startup(() -> new SceneManager().start(new Stage()))
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        SceneManager.instance = this;
        instance.stage = primaryStage;
        instance.buildStage();
        instance.buildLoginScene();
        instance.buildMainScene();
        instance.setLoginScene();
    }

    /**
     * Switches the scene of the application to the login scene.
     * if the login scene is already displayed nothing happens.
     */
    void setLoginScene() {
        if (stage.getScene() != loginScene) {
            stage.setScene(loginScene);
            stage.centerOnScreen();
            mainController.reset();
        }
    }

    /**
     * Switches the scene of the application to the main scene.
     * if the main scene is already displayed nothing happens.
     */
    void setMainScene() {
        if (stage.getScene() != mainScene) {
            stage.setScene(mainScene);
            stage.centerOnScreen();
            loginController.reset();
        }
    }

    private void buildStage() {
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Carpet Cleaning Service Management");
        stage.show();
    }

    private void buildLoginScene() throws IOException {
        var loader = new FXMLLoader(getClass().getResource("control/login.control"));
        loginScene = new Scene(loader.load());
        loginController = loader.getController();
        loginScene.getStylesheets().add(
                String.valueOf(getClass().getResource("style/main.css")));
    }

    private void buildMainScene() throws IOException {
        var loader = new FXMLLoader(getClass().getResource("control/main.control"));
        mainScene = new Scene(loader.load());
        mainController = loader.getController();
        mainScene.getStylesheets().add(
                String.valueOf(getClass().getResource("style/main.css")));
    }

}
