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

public class MultipleChoiceQuestionUI extends Application {

	private String question = "question";
	private String answerInput1 = "answer";
	private String answerInput2 = "answer";
	private String answerInput3 = "answer";
	private String answerInput4 = "answer";
	
	public void clickButton(Button button, Stage primaryStage) {
		button.setOnAction(new EventHandler<ActionEvent>() {
			//Upon click, check if the word id is same as synonym id
			
			@Override
			public void handle(ActionEvent event) {
				primaryStage.close();
				try {
					new QuestionResult().start(new Stage());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	public void start(Stage primaryStage) throws Exception {

		Label titleLabel = new Label("Select a synonym to the word below");
		titleLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
		Label questionLabel = new Label(question);
		questionLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		questionLabel.setStyle("-fx-border-color: black;");
		questionLabel.setMaxWidth(250);

		Button answer1 = new Button(answerInput1);
		answer1.setStyle("-fx-font-size: 15pt;");
		answer1.setMaxWidth(200);
		Button answer2 = new Button(answerInput2);
		answer2.setStyle("-fx-font-size: 15pt;");
		answer2.setMaxWidth(200);
		Button answer3 = new Button(answerInput3);
		answer3.setStyle("-fx-font-size: 15pt;");
		answer3.setMaxWidth(200);
		Button answer4 = new Button(answerInput4);
		answer4.setStyle("-fx-font-size: 15pt;");
		answer4.setMaxWidth(200);

		HBox title = new HBox();
		VBox body = new VBox();
		VBox all = new VBox();

		title.getChildren().addAll(titleLabel);
		body.getChildren().addAll(questionLabel, answer1, answer2, answer3, answer4);

		all.getChildren().addAll(title, body);

		Scene scene = new Scene(all, 300, 300);

		primaryStage.setTitle("Select Word Set");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		clickButton(answer1,primaryStage);
		clickButton(answer2,primaryStage);
		clickButton(answer3,primaryStage);
		clickButton(answer4,primaryStage);

	}

}
