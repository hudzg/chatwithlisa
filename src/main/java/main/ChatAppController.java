package main;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatAppController implements Initializable {
    @FXML
    private ScrollPane chatPane;
    @FXML
    private TextField textField;
    @FXML
    private VBox vBox;

    public void clickSendButton() {
        String text = textField.getText();
        if(text.isEmpty()) return;
        addMyMessage(text);
        addOtherMessage("I love you");
        textField.setText("");
    }

    private void addOtherMessage(String text){
        Label label = new Label(text);
        label.setFont(new Font(18));
        label.setWrapText(true);
        label.setMaxWidth(200);
        label.setMinWidth(200);
        label.setAlignment(Pos.CENTER_LEFT);
        label.setTextFill(Paint.valueOf("#FFFFFF"));
        AnchorPane anchorPane = new AnchorPane(label);
        anchorPane.setStyle("-fx-border-radius: 0 8 8 8;" +
                "-fx-background-radius: 0 8 8 8;" +
                "-fx-background-color: #EC407A;");
        anchorPane.setPrefWidth(200);
        anchorPane.setMaxWidth(200);
        AnchorPane anchorPane1 = new AnchorPane(anchorPane);
        vBox.getChildren().add(anchorPane1);
        chatPane.setContent(vBox);
    }

    private void addMyMessage(String text) {
        Label label = new Label(text);
        label.setFont(new Font(18));
        label.setWrapText(true);
        label.setMaxWidth(200);
        label.setMinWidth(200);
        label.setAlignment(Pos.CENTER_RIGHT);
        label.setTextFill(Paint.valueOf("#FFFFFF"));
        AnchorPane anchorPane = new AnchorPane(label);
        anchorPane.setStyle("-fx-border-radius: 8 0 8 8;" +
                "-fx-background-radius: 8 0 8 8;" +
                "-fx-background-color: #AB47BC;");
        anchorPane.setPrefWidth(200);
        anchorPane.setMaxWidth(200);
        anchorPane.setLayoutX(125);
        AnchorPane anchorPane1 = new AnchorPane(anchorPane);
        vBox.getChildren().add(anchorPane1);
        chatPane.setContent(vBox);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vBox.heightProperty().addListener((ChangeListener) (observable, oldvalue, newValue) -> chatPane.setVvalue((Double)newValue ));
        vBox.setSpacing(8);
    }
}
