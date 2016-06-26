/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.lang.Thread.*;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Pranav
 */
public class StartpageController implements Initializable {

    @FXML
    private TextField textbox;
    @FXML
    private Button submit_button;
    @FXML
    private Font x1;
    @FXML
    private Group submitted_group;
    static Connection connection1;
    static Statement statement;
    @FXML
    private Button db_tester;
    @FXML
    private Font x2;
    @FXML
    private Group start_timer;
    @FXML
    private Text second;
    @FXML
    private AnchorPane mainAnchorPane;
    @FXML
    private Group team_name_entry;
    @FXML
    private Text enter_team_name;
    @FXML
    private Font x3;
    @FXML
    private Text team_name_label;
    @FXML
    private Font x4;
    @FXML
    private Text welcome_simple;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            //todo
            connection1 = null;
            connection1 = DriverManager.getConnection("JDBC:mysql://192.168.1.2:3306/quiz", "root", "q1q1q1q1");
            statement = connection1.createStatement();
            team_name_label.setVisible(false);
            welcome_simple.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(StartpageController.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @FXML
    private void submitAction(ActionEvent event) {

        submitted_group.visibleProperty().set(true);
        team_name_entry.setVisible(false);
        welcome_simple.setVisible(true);
        team_name_label.setVisible(true);
        team_name_label.setText(textbox.getText());
        team_name_label.setLayoutX(683-team_name_label.getLayoutBounds().getWidth()/2);
        try {
            statement.execute("insert into teams (name) values('" + textbox.getText() + "')");
            QuizpageController.team=textbox.getText();
        } catch (SQLException ex) {
            Logger.getLogger(StartpageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Thread thread = new Thread() {
            @Override
            public void run() {
                db_tester.fire();
            }
        };
        thread.start();
    }

    @FXML
    private void db_tester_action(ActionEvent event) {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                ResultSet resultset = statement.executeQuery("select * from start");
                resultset.next();
                int test = resultset.getInt("value");
                if (test == 1) {
                    start_timer.setVisible(true);
                    welcome_simple.setVisible(false);
                    team_name_label.setVisible(false);
                    submitted_group.setVisible(false);
                    for (Integer i = 5; i > 0; i--) {
                        second.textProperty().set("0" + i.toString());
                        TimeUnit.SECONDS.sleep(1);
                    }
                    try {
                     Parent temParent;
                     temParent = (Parent) FXMLLoader.load(getClass().getResource("quizpage.fxml"));
                     quiz.Quiz.scene.setRoot(temParent);
                     } catch (IOException ex) {
                     Logger.getLogger(StartpageController.class.getName()).log(Level.SEVERE, null, ex);
                     }
                    break;
                }
            } catch (SQLException | InterruptedException ex) {
                Logger.getLogger(StartpageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

     

    @FXML
    private void key_pressed(KeyEvent event) {
        if(event.getCode().equals(KeyCode.ENTER))
        {
            submit_button.fire();
        }
    }
}
