package test01;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import test02.JDBConnect;

//public class Henko extends Application {
public class Henko extends Stage {
	private Button okbtn;
	private Button rkbtn;
	private Button debtn;
	private Label[] labels;
	private TextField[] texts;
	private VBox root ;
	private HBox [] hboxs;
	private TextField text ;
	private String[] data;
	public Henko(Stage primaryStage) {


//	@Override
//	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox();
			okbtn = new Button("検索");
			rkbtn = new Button("更新");
			debtn = new Button("削除");
			text = new TextField();
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


			HBox top = new HBox();
			top.getChildren().addAll(okbtn,text,rkbtn,debtn);
			root.getChildren().addAll(top);
			root.getChildren().addAll(hboxs);
			//検索ボタンが押された
			okbtn.setOnAction(e->{
//				System.out.println("ボタンが押された");
				JDBConnect con = new JDBConnect();
				String shohin_id = text.getText();

				data = con.getData(shohin_id);

					Label[] labels = new Label[6];
					texts[0].setText(data[0]);
					texts[1].setText(data[1]);
					texts[2].setText(data[2]);
					texts[3].setText(data[3]);
					texts[4].setText(data[4]);
					texts[5].setText(data[5]);

					texts[0].setEditable(false);

//				con.testPrint();

				con.close();
			});
			//更新ボタン用
			rkbtn.setOnAction(e->{
				System.out.println("更新ボタンが押された");
				JDBConnect con = new JDBConnect();
				con.updata(texts[0].getText(),texts[1].getText(),texts[2].getText()
						,Integer.parseInt(texts[3].getText()),Integer.parseInt(texts[4].getText())
						,texts[5].getText());

				con.close();
			});

			//削除ボタン
		     debtn.setOnAction(e->{
				System.out.println("削除ボタンが押された");
				JDBConnect con = new JDBConnect();
				con.deletedata(texts[0].getText());

				con.close();
			});
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setTitle("更新");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//		launch(args);
//	}
}
