package ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Label titleLabel = new Label(" Welcome to Vocabulary Game! \n Press start to select a word set");
		titleLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));

		Button start = new Button("Start");
		start.setStyle("-fx-font-size: 20pt;");

		BorderPane border = new BorderPane();
		border.setPadding(new Insets(10, 20, 10, 20));
		border.setCenter(start);

		VBox title = new VBox();
		title.getChildren().addAll(titleLabel, border);

		Scene scene = new Scene(title, 400, 400);

		primaryStage.setTitle("Select Word Set");
		primaryStage.setScene(scene);
		primaryStage.show();

		start.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.close();
				try {
					new ChooseSet().start(new Stage());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}
}
