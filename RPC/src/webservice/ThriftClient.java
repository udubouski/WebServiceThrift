/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Font;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author vlad
 */
public class ThriftClient extends Application {
    
    private Scene scene;
    private GridPane mainPane;
    private GridPane upPane;
    private GridPane downPane;
    private Label startLabel;
    private TableView table;
    private TableColumn firstName;
    private TableColumn secondName;
    private TableColumn numberCourse;
    private TableColumn numberGroup;
    private Button addBtn;
    private Button changeBtn;
    private Button deleteBtn;
    private Button exitBtn;
    private HBox leftBox;
    
    @Override
    public void start(Stage primaryStage) {

        mainPane = new GridPane();
        upPane = new GridPane();
        downPane = new GridPane();
        leftBox = new HBox();
        startLabel = new Label("Information manual about students");
        startLabel.setFont(new Font("Arial", 30));
        GridPane.setHalignment(startLabel, HPos.CENTER);
        
        table = new TableView();
        firstName = new TableColumn("First Name");
        secondName = new TableColumn("Second Name");
        numberCourse = new TableColumn("Number Course");
        numberGroup = new TableColumn("Number Group");
        
        table.setEditable(false);
        table.getColumns().addAll(firstName, secondName, numberCourse, numberGroup);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        firstName.setMinWidth(150);
        secondName.setMinWidth(150);        
        numberCourse.setMinWidth(150);
        numberGroup.setMinWidth(150);
        
        addBtn = new Button("Добавить");
        changeBtn = new Button("Изменить");
        deleteBtn = new Button("Удалить");
        exitBtn = new Button("Выход");
        
        upPane.add(startLabel,0,0);
        upPane.add(table,0,1);
  
        leftBox.getChildren().addAll(addBtn, changeBtn,deleteBtn,exitBtn);
        downPane.add(leftBox,0,0);
        
        mainPane.add(upPane,0,0);
        mainPane.add(downPane,0,1);
        
        scene = new Scene(mainPane,600,450, Color.WHITE);
        
        primaryStage.setTitle("ThriftClient");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
