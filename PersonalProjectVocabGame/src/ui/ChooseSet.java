package ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ChooseSet {

	public void start(Stage primaryStage) throws Exception {

		Label titleLabel = new Label(" Select your word set");
		titleLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));

		Button set1 = new Button("Set 1");
		set1.setStyle("-fx-font-size: 20pt;");
		Button set2 = new Button("Set 2");
		set2.setStyle("-fx-font-size: 20pt;");
		Button set3 = new Button("Set 3");
		set3.setStyle("-fx-font-size: 20pt;");
		Button set4 = new Button("Set 4");
		set4.setStyle("-fx-font-size: 20pt;");

		HBox title = new HBox();
		HBox body = new HBox();
		VBox all = new VBox();

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setHgap(25);
		grid.setVgap(25);
		grid.add(set1, 0, 0);
		grid.add(set2, 0, 1);
		grid.add(set3, 1, 0);
		grid.add(set4, 1, 1);

		title.getChildren().addAll(titleLabel);
		body.getChildren().addAll(grid);
		all.getChildren().addAll(title, body);

		Scene scene = new Scene(all, 300, 300);

		primaryStage.setTitle("Select Word Set");
		primaryStage.setScene(scene);
		primaryStage.show();

		set1.setOnAction(new EventHandler<ActionEvent>() {
			//UponClickinSet1 Fetch the words with setId = 1
			
			@Override
			public void handle(ActionEvent event) {
				primaryStage.close();
				try {
					new MultipleChoiceQuestionUI().start(new Stage());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}
}
