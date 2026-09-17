/*
 * Class: CIST 2372 Java Programming II
 * Term: Fall 2026
 * Instructor: Chris Bishop
 * Description: Solution to Lab #2 - More Complex FX GUI
 * Author: Omar Sullivan
 */
package lab2;

import java.util.Optional;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Lab2 extends Application {

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #EAF2F8;");

        Label titleLabel = new Label("Student Information");

        titleLabel.setFont(
                Font.font("Arial", FontWeight.BOLD, 26)
        );

        titleLabel.setStyle("-fx-text-fill: #1F4E78;");

        root.setTop(titleLabel);
        BorderPane.setAlignment(titleLabel, Pos.CENTER);

        BorderPane.setMargin(
                titleLabel,
                new Insets(0, 0, 20, 0)
        );

        GridPane studentGrid = new GridPane();

        studentGrid.setAlignment(Pos.CENTER);
        studentGrid.setHgap(15);
        studentGrid.setVgap(15);
        studentGrid.setPadding(new Insets(20));

        studentGrid.setStyle(
                "-fx-background-color: white;"
                + "-fx-border-color: #2C3E50;"
                + "-fx-border-width: 2;"
                + "-fx-border-radius: 8;"
                + "-fx-background-radius: 8;"
        );

        Label idLabel = new Label("ID:");
        Label firstNameLabel = new Label("First Name:");
        Label lastNameLabel = new Label("Last Name:");
        Label emailLabel = new Label("Email:");
        Label gpaLabel = new Label("GPA:");

        String labelStyle
                = "-fx-font-size: 14px;"
                + "-fx-font-weight: bold;";

        idLabel.setStyle(labelStyle);
        firstNameLabel.setStyle(labelStyle);
        lastNameLabel.setStyle(labelStyle);
        emailLabel.setStyle(labelStyle);
        gpaLabel.setStyle(labelStyle);

        TextField idField = new TextField();
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField emailField = new TextField();
        TextField gpaField = new TextField();

        idField.setPromptText("Enter student ID");
        firstNameField.setPromptText("Enter first name");
        lastNameField.setPromptText("Enter last name");
        emailField.setPromptText("Enter email address");
        gpaField.setPromptText("Enter GPA");

        idField.setPrefWidth(280);
        firstNameField.setPrefWidth(280);
        lastNameField.setPrefWidth(280);
        emailField.setPrefWidth(280);
        gpaField.setPrefWidth(280);

        studentGrid.add(idLabel, 0, 0);
        studentGrid.add(idField, 1, 0);

        studentGrid.add(firstNameLabel, 0, 1);
        studentGrid.add(firstNameField, 1, 1);

        studentGrid.add(lastNameLabel, 0, 2);
        studentGrid.add(lastNameField, 1, 2);

        studentGrid.add(emailLabel, 0, 3);
        studentGrid.add(emailField, 1, 3);

        studentGrid.add(gpaLabel, 0, 4);
        studentGrid.add(gpaField, 1, 4);

        root.setCenter(studentGrid);

        Button findButton = new Button("Find");
        Button insertButton = new Button("Insert");
        Button deleteButton = new Button("Delete");
        Button updateButton = new Button("Update");
        Button exitButton = new Button("Exit");

        findButton.setPrefWidth(85);
        insertButton.setPrefWidth(85);
        deleteButton.setPrefWidth(85);
        updateButton.setPrefWidth(85);
        exitButton.setPrefWidth(85);

        String buttonStyle
                = "-fx-background-color: #1F4E78;"
                + "-fx-text-fill: white;"
                + "-fx-font-size: 13px;"
                + "-fx-font-weight: bold;"
                + "-fx-background-radius: 6;";

        findButton.setStyle(buttonStyle);
        insertButton.setStyle(buttonStyle);
        deleteButton.setStyle(buttonStyle);
        updateButton.setStyle(buttonStyle);

        exitButton.setStyle(
                "-fx-background-color: #B22222;"
                + "-fx-text-fill: white;"
                + "-fx-font-size: 13px;"
                + "-fx-font-weight: bold;"
                + "-fx-background-radius: 6;"
        );

        HBox buttonBox = new HBox(10);

        buttonBox.setAlignment(Pos.CENTER);

        buttonBox.getChildren().addAll(
                findButton,
                insertButton,
                deleteButton,
                updateButton,
                exitButton
        );

        root.setBottom(buttonBox);

        BorderPane.setMargin(
                buttonBox,
                new Insets(20, 0, 0, 0)
        );

        Scene scene = new Scene(root, 600, 420);

        primaryStage.setTitle("Student Information Form");
        primaryStage.setScene(scene);

        exitButton.setOnAction(event -> confirmExit(primaryStage));

        primaryStage.setOnCloseRequest(event -> {
            event.consume();
            confirmExit(primaryStage);
        });

        primaryStage.show();
    }

    private void confirmExit(Stage primaryStage) {

        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION);

        exitAlert.initOwner(primaryStage);
        exitAlert.setTitle("Exit Confirmation");
        exitAlert.setHeaderText("Are you sure you want to exit?");
        exitAlert.setContentText("Select Yes to close the application.");

        exitAlert.getButtonTypes().setAll(
                ButtonType.YES,
                ButtonType.NO
        );

        Optional<ButtonType> result = exitAlert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.YES) {
            primaryStage.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
