package sample.controller;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLCalculatorController implements Initializable {


    Float data = 0f;
    int operation = -1;

    @FXML
    private Label displayCalc;

    @FXML
    private Button one;

    @FXML
    private Button two;

    @FXML
    private Button three;

    @FXML
    private Button four;

    @FXML
    private Button five;

    @FXML
    private Button six;

    @FXML
    private Button seven;

    @FXML
    private Button eight;

    @FXML
    private Button nine;

    @FXML
    private Button zero;

    @FXML
    private Button clear;

    @FXML
    private Button equals;

    @FXML
    private Button plus;

    @FXML
    private Button minus;

    @FXML
    private Button multi;

    @FXML
    private Button div;


    @FXML
    void handleOneButtonAction(ActionEvent event) {
        if(event.getSource() == one){
            displayCalc.setText(displayCalc.getText()+"1");
        }else if(event.getSource() == two){
            displayCalc.setText(displayCalc.getText()+"2");
        }else if(event.getSource() == three){
            displayCalc.setText(displayCalc.getText()+"3");
        }else if(event.getSource() == four){
            displayCalc.setText(displayCalc.getText()+"4");
        }else if(event.getSource() == five){
            displayCalc.setText(displayCalc.getText()+"5");
        }else if(event.getSource() == six){
            displayCalc.setText(displayCalc.getText()+"6");
        }else if(event.getSource() == seven){
            displayCalc.setText(displayCalc.getText()+"7");
        }else if(event.getSource() == eight){
            displayCalc.setText(displayCalc.getText()+"8");
        }else if(event.getSource() == nine){
            displayCalc.setText(displayCalc.getText()+"9");
        }else if(event.getSource() == zero){
            displayCalc.setText(displayCalc.getText()+"0");
        }else if(event.getSource() == clear){
            displayCalc.setText("");
        }else if(event.getSource() == plus){
            data = Float.parseFloat(displayCalc.getText());
            operation = 1;
            displayCalc.setText("");
        }else if(event.getSource() == minus){
            data = Float.parseFloat(displayCalc.getText());
            operation = 2;
            displayCalc.setText("");
        }else if(event.getSource() == multi){
            data = Float.parseFloat(displayCalc.getText());
            operation = 3;
            displayCalc.setText("");
        }else if(event.getSource() == div){
            data = Float.parseFloat(displayCalc.getText());
            operation = 4;
            displayCalc.setText("");
        }else if(event.getSource() == equals){
            Float secondData = Float.parseFloat(displayCalc.getText());
            switch (operation){

                case 1:
                        int ans = (int) Math.round(data + secondData);
                        displayCalc.setText(String.valueOf(ans));
                        if(ans == 9){
                            animationCircle();
                        }
                        break;
                case 2:
                        ans = (int) Math.round(data - secondData);
                        displayCalc.setText(String.valueOf(ans));
                        if(ans == 9){
                            animationCircle();
                        }
                        break;
                case 3:
                        ans = (int) Math.round(data * secondData);
                        displayCalc.setText(String.valueOf(ans));
                        if(ans == 9){
                            animationCircle();
                        }
                        break;
                case 4:
                        Float ansF = 0f;
                        try {
                            ansF = data / secondData;
                        }catch (Exception ex){
                            displayCalc.setText("Error");
                        }
                        displayCalc.setText(String.valueOf(ansF));
                        if(ansF == 9.0){
                            animationCircle();
                        }
                        break;

            }
        }
    }

    private void animationCircle() {
        Circle cir = new Circle();
        cir.setFill(Color.GREEN);
        cir.setRadius(40);
        cir.setLayoutX(50);
        cir.setLayoutY(50);

        Circle cir2 = new Circle();
        cir2.setFill(Color.RED);
        cir2.setRadius(40);
        cir2.setLayoutX(450);
        cir2.setLayoutY(50);

        //green circle
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(2));
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.setToX(400);
        transition.setToY(400);

        ScaleTransition scaleTransition = new ScaleTransition();
        scaleTransition.setToX(0.5);
        scaleTransition.setToY(0.5);

        //red circle
        TranslateTransition transition2 = new TranslateTransition();
        transition2.setDuration(Duration.seconds(1));
        transition2.setCycleCount(TranslateTransition.INDEFINITE);
        transition2.setToX(-400);
        transition2.setToY(350);

        ScaleTransition scaleTransition2 = new ScaleTransition();
        scaleTransition2.setToX(1.2);
        scaleTransition2.setToY(1.2);

        transition.setNode(cir);
        scaleTransition.setNode(cir);
        transition.setAutoReverse(true);
        scaleTransition.setAutoReverse(true);
        transition.play();
        scaleTransition.play();

        transition2.setNode(cir2);
        scaleTransition2.setNode(cir2);
        transition2.setAutoReverse(true);
        scaleTransition2.setAutoReverse(true);
        transition2.play();
        scaleTransition2.play();


        Label label = new Label("Hire me!");
        label.setFont(new Font("Arial",30));
        AnchorPane.setLeftAnchor(label,10.0);
        AnchorPane.setRightAnchor(label,10.0);
        label.setAlignment(Pos.CENTER);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), label);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setCycleCount(Animation.INDEFINITE);
        fadeTransition.play();


        AnchorPane secondaryLayout = new AnchorPane();
        secondaryLayout.getChildren().add(cir);
        secondaryLayout.getChildren().add(cir2);
        secondaryLayout.getChildren().add(label);

        Scene secondScene = new Scene(secondaryLayout, 500, 500);

        Stage newWindow = new Stage();
        newWindow.setTitle("Animation");
        newWindow.setScene(secondScene);

        newWindow.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
