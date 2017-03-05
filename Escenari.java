package Ex2_SoldatsColors;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Escenari extends Application {

	int punts = 0;
	int escapats = 0;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage theStage) {

		ArrayList<Soldat> llistat = new ArrayList<Soldat>();

		theStage.setTitle("Caza al robot");
		Group root = new Group();
		Scene theScene = new Scene(root);
		theStage.setScene(theScene);
		Canvas canvas = new Canvas(600, 600);
		root.getChildren().add(canvas);

		GraphicsContext gc = canvas.getGraphicsContext2D();

		// Al presionar S o X

		// CLICAR POINTS

		/*theScene.setOnMouseClicked(

				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {

						for (int i = 0; i < llistat.size(); i++) {

							if (event.getSceneX() > llistat.get(i).getPosx()
									&& event.getSceneX() < (llistat.get(i).getPosx() + llistat.get(i).getWidth())
									&& event.getSceneY() > llistat.get(i).getPosy()
									&& event.getSceneY() < (llistat.get(i).getPosy() + llistat.get(i).getWidth())) {

								if (llistat.get(i).isColor()) {

									punts++;
								}

								else
									punts--;

								llistat.get(i).removeImage();
								llistat.remove(i);
							}

						}

					}

				}

		);*/
		
		
		/*
		 * SET ON MOUSE CLICKED IMPLEMENTED WITH LAMBDA EXPRESSION.
		 */
			
		
		theScene.setOnMouseClicked(event -> {
			
			for (int i = 0; i < llistat.size(); i++) {

				if (event.getSceneX() > llistat.get(i).getPosx()
						&& event.getSceneX() < (llistat.get(i).getPosx() + llistat.get(i).getWidth())
						&& event.getSceneY() > llistat.get(i).getPosy()
						&& event.getSceneY() < (llistat.get(i).getPosy() + llistat.get(i).getWidth())) {

					if (llistat.get(i).isColor()) {

						punts++;
					}

				else
						punts--;

					llistat.get(i).removeImage();
					llistat.remove(i);
				}

			}
		});

		// Inicialitzacio imatges

		int quantitat = (int) (Math.random() * 50) + 1;

		for (int i = 0; i < quantitat; i++) {

			Soldat s1 = new Soldat();
			s1.init();
			llistat.add(s1);
		}

		new AnimationTimer() {

			@Override
			public void handle(long now) {

				for (int i = 0; i < llistat.size(); i++) {

					llistat.get(i).imageMovement();

					// System.out.println(canvas.);

					if (llistat.get(i).isCostat()) {

						if (llistat.get(i).getPosx() > theScene.getWidth() + 50) {

							if (llistat.get(i).isColor()) {
								escapats++;
								llistat.get(i).removeImage();
								llistat.remove(i);
							}
						}
					}

					else if (!llistat.get(i).isCostat()) {

						if (llistat.get(i).getPosx() < (theScene.getWidth() - theScene.getWidth()) - 100) {

							if (llistat.get(i).isColor()) {
								escapats++;
								llistat.get(i).removeImage();
								llistat.remove(i);
							}

						}
					}

				}

				// background image clears canvas
				gc.clearRect(0, 0, 600, 600);

				for (int i = 0; i < llistat.size(); i++) {

					llistat.get(i).render(gc);

				}

				String pointsText = "Punts: " + punts;
				gc.fillText(pointsText, 30, 36);
				gc.strokeText(pointsText, 30, 36);

				String escapes = "Escapats: " + escapats;
				gc.fillText(escapes, 100, 36);
				gc.strokeText(escapes, 100, 36);
			}

		}.start();

		theStage.show();

	}
}
