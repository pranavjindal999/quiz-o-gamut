/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Pranav
 */
public class ResultController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private Text t1;
    @FXML
    private Font x2;
    @FXML
    private Text t2;
    @FXML
    private Text t3;
    @FXML
    private Text t4;
    @FXML
    private Text t5;
    @FXML
    private Text t6;
    @FXML
    private Text t7;
    @FXML
    private Text t8;
    @FXML
    private Group defeat;
    @FXML
    private Font x3;
    @FXML
    private Text sc1;
    @FXML
    private Text sc2;
    @FXML
    private Text sc3;
    @FXML
    private Text sc4;
    @FXML
    private Text sc5;
    @FXML
    private Text sc6;
    @FXML
    private Text sc7;
    @FXML
    private Text sc8;
    @FXML
    private Group victory;
    @FXML
    private Group tie_group;
    @FXML
    private Group table;
    @FXML
    private Font x4;
    @FXML
    private Group wait_state;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            final Statement statement;
            statement = StartpageController.connection1.createStatement();
            ResultSet resultSet;

            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        ResultSet resultSet = statement.executeQuery("select * from start");
                        resultSet.next();
                        while (resultSet.getInt("value") != 9) {
                            resultSet = statement.executeQuery("select * from start");
                            resultSet.next();
                            TimeUnit.MILLISECONDS.sleep(100);
                        }

                        wait_state.setVisible(false);
                        table.setVisible(true);
                        resultSet = statement.executeQuery("select * from teams order by points desc");
                        resultSet.next();
                        t1.setText(resultSet.getString("name"));
                        sc1.setText(resultSet.getString("points"));
                        resultSet.next();
                        t2.setText(resultSet.getString("name"));
                        sc2.setText(resultSet.getString("points"));
                        resultSet.next();
                        t3.setText(resultSet.getString("name"));
                        sc3.setText(resultSet.getString("points"));
                        resultSet.next();
                        t4.setText(resultSet.getString("name"));
                        sc4.setText(resultSet.getString("points"));
                        resultSet.next();
                        t5.setText(resultSet.getString("name"));
                        sc5.setText(resultSet.getString("points"));
                        resultSet.next();
                        t6.setText(resultSet.getString("name"));
                        sc6.setText(resultSet.getString("points"));
                        resultSet.next();
                        t7.setText(resultSet.getString("name"));
                        sc7.setText(resultSet.getString("points"));
                        resultSet.next();
                        t8.setText(resultSet.getString("name"));
                        sc8.setText(resultSet.getString("points"));

                        if (QuizpageController.team.equalsIgnoreCase(t1.getText()) || QuizpageController.team.equalsIgnoreCase(t2.getText()) || QuizpageController.team.equalsIgnoreCase(t3.getText()) || QuizpageController.team.equalsIgnoreCase(t4.getText())) {
                            victory.setVisible(true);
                        } else {
                            defeat.setVisible(true);
                        }
                        if (sc4.getText().equals(sc5.getText()) || (sc4.getText().equals(sc5.getText()) && sc3.getText().equals(sc5.getText())) || (sc4.getText().equals(sc5.getText()) && sc6.getText().equals(sc5.getText()))) {
                            tie_group.setVisible(true);
                            victory.setVisible(false);
                            defeat.setVisible(false);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(ResultController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ResultController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            thread.start();
        } catch (SQLException ex) {
            Logger.getLogger(ResultController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
