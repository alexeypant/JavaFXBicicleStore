package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Bicycle Store");
//        primaryStage.setScene(new Scene(root, 300, 275));

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Select models");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridPane.add(sceneTitle, 0, 0, 2, 1);


        Label userName = new Label("UKRAINA");
        gridPane.add(userName, 0, 1);

        TextField numberOfUkraina = new TextField();
        gridPane.add(numberOfUkraina, 1,1);


        Label pw = new Label("ORLENOK:");
        gridPane.add(pw, 0, 2);

        TextField numberOfOrlenok = new TextField();
        gridPane.add(numberOfOrlenok, 1, 2);

//        gridPane.setGridLinesVisible(true);

        Button button = new Button("Validate order");
        HBox hbButton = new HBox(10);
        hbButton.setAlignment(Pos.BOTTOM_RIGHT);
        hbButton.getChildren().add(button);
        gridPane.add(hbButton, 1, 4);

        final Text actiontarget = new Text();
        gridPane.add(actiontarget,1,6);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    BikeOrder.validateOrder("UKRAINA", Integer.parseInt(numberOfUkraina.getText()));
                } catch (TooManyBikesException e) {

                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText(e.getMessage());
                }
            }
        });

        Scene scene = new Scene(gridPane, 300, 275);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
