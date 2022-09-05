package test01;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import test02.JDBConnect;

//public class Toroku extends Application {
public class Toroku extends Stage{
	private Button okbtn;
	private Label[] labels;
	private TextField[] texts;
	private VBox root ;
	private HBox [] hboxs;
	public  Toroku(Stage primaryStage) {
		super();

//	@Override
//	public void start(Stage primaryStage) {
		try {
			root = new VBox();
			okbtn=new Button("登録");
			labels = new Label[6];
			labels[0] = new Label("shihon_id");
			labels[1] = new Label("shohin_mei");
			labels[2] = new Label("shohin_bunrui");
			labels[3] = new Label("hanbai_tanka");
			labels[4] = new Label("shiire_tanka");
			labels[5] = new Label("torokubi");
			texts = new TextField[6];
			texts[0] = new TextField();
			texts[1] = new TextField();
			texts[2] = new TextField();
			texts[3] = new TextField();
			texts[4] = new TextField();
			texts[5] = new TextField();
			hboxs = new HBox[6];
			hboxs[0] = new HBox();
			hboxs[1] = new HBox();
			hboxs[2] = new HBox();
			hboxs[3] = new HBox();
			hboxs[4] = new HBox();
			hboxs[5] = new HBox();
			hboxs[0].getChildren().addAll(labels[0],texts[0]);
			hboxs[1].getChildren().addAll(labels[1],texts[1]);
			hboxs[2].getChildren().addAll(labels[2],texts[2]);
			hboxs[3].getChildren().addAll(labels[3],texts[3]);
			hboxs[4].getChildren().addAll(labels[4],texts[4]);
			hboxs[5].getChildren().addAll(labels[5],texts[5]);
			root.getChildren().add(okbtn);
			root.getChildren().addAll(hboxs);
			okbtn.setAlignment(Pos.CENTER);
			okbtn.setOnAction(e->{
//				System.out.println("ボタンが押された");
				JDBConnect con = new JDBConnect();
				con.insertdata(texts[0].getText(),texts[1].getText(),texts[2].getText()
						,Integer.parseInt(texts[3].getText()),Integer.parseInt(texts[4].getText())
						,texts[5].getText());

				con.close();
			});
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("登録");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//		launch(args);
//	}
}
