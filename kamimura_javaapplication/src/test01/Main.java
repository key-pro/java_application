package test01;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import test02.JDBConnect;

public class Main extends Application {
	private Button okbtn;
	private Button rkbtn;
	private Button trbtn;
	private TextField text ;
	private ArrayList<String[]>datas;
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox();
			okbtn=new Button("データー検索");
			text = new TextField();
			rkbtn = new Button("データー登録");
			trbtn = new Button("データー更新");
			HBox main = new HBox();
			main.getChildren().addAll(okbtn,rkbtn,trbtn);
			root.getChildren().addAll(main,text);
			okbtn.setAlignment(Pos.CENTER);
			okbtn.setOnAction(e->{
				System.out.println("一覧表");
				JDBConnect con = new JDBConnect();
				String shohin_mei = text.getText();

				datas = con.getDatas(shohin_mei);
				for(String[]data:datas) {
					Label[] labels = new Label[6];

					labels[0] = new Label(data[0]);
					labels[1] = new Label(data[1]);
					labels[2] = new Label(data[2]);
					labels[3] = new Label(data[3]);
					labels[4] = new Label(data[4]);
					labels[5] = new Label(data[5]);
					HBox hbox = new HBox();
					hbox.getChildren().addAll(labels);
					root.getChildren().add(hbox);
				}
//				con.testPrint();

				con.close();
			});
			rkbtn.setOnAction(e->{
				Toroku toroku = new Toroku(primaryStage);
			});
			trbtn.setOnAction(e->{
				Henko henko = new Henko(primaryStage);
			});
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("java_postgresql管理メニュー");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
