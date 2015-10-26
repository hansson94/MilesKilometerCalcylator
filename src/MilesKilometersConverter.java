

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MilesKilometersConverter extends Application {

	@Override
	public void start(Stage window) throws Exception {
		// TODO Auto-generated method stub
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(5, 5, 5, 5));
		pane.setVgap(5);
		pane.setHgap(5);

		Text miles, kilo;
		TextField milesTF, kiloTF;

		miles = new Text("Miles :");
		GridPane.setConstraints(miles, 0, 0);

		kiloTF = new TextField();
		// kiloTF.setPromptText("Kilometers");
		GridPane.setConstraints(kiloTF, 1, 1);

		kilo = new Text("Kilometers :");
		GridPane.setConstraints(kilo, 0, 1);

		milesTF = new TextField();
		// milesTF.setPromptText("Miles");
		GridPane.setConstraints(milesTF, 1, 0);

		milesTF.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if (event.getCode() == KeyCode.ENTER) {
					String milesS = milesTF.getText();
					Float milesTF = Float.parseFloat(milesS);
					Float resultF = milesTF / 1.609344f ;
					String resultS = Float.toString(resultF);
					kiloTF.setText(resultS);

				}

			}
		});

		kiloTF.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				// TODO Auto-generated method stub
				if (event.getCode() == KeyCode.ENTER) {
					String kiloS = kiloTF.getText();
					Float kiloTF = Float.parseFloat(kiloS);
					Float resultF = 1.609344f * kiloTF;
					String resultS = Float.toString(resultF);
					milesTF.setText(resultS);

				}

			}
		});

		pane.getChildren().addAll(miles, kilo, milesTF, kiloTF);

		Scene scene = new Scene(pane, 220, 64);
		window.setScene(scene);
		window.setTitle("Converter");
		window.show();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
