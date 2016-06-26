/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Pranav
 */
public class QuizpageController implements Initializable {

    @FXML
    private ProgressBar timebar;
    @FXML
    private Text question;
    @FXML
    private Button op1;
    @FXML
    private Font x1;
    @FXML
    private Button op2;
    @FXML
    private Button op3;
    @FXML
    private Button op4;
    @FXML
    private Font x2;
    @FXML
    private Text qno;
    @FXML
    private Button skip_button;
    @FXML
    private Text score;
    Statement statement;
    ResultSet resultSet = null;
    String current_ans;
    Integer curr_score;
    Integer totalno;
    static String team;
    Animation animation;

    public QuizpageController() {
        try {
            this.statement = StartpageController.connection1.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(QuizpageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        curr_score = 0;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            animation = new Transition() {
                {
                    setCycleDuration(Duration.millis(20000));
                    setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent t) {
                            skip_button.fire();
                        }
                    });
                }

                @Override
                protected void interpolate(double d) {
                    timebar.setProgress(d);
                    ColorAdjust colorAdjust = new ColorAdjust();
                    colorAdjust.setHue(-.4 + d * (12.0 / 10));
                    timebar.effectProperty().setValue(colorAdjust);
                }
            };
            
            resultSet = statement.executeQuery("select count(*) from ques");
            resultSet.next();
            totalno = resultSet.getInt("count(*)");
            resultSet.close();
            resultSet = statement.executeQuery("select * from ques");
            next();
        } catch (SQLException ex) {
            Logger.getLogger(QuizpageController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void timer_reset() {
        animation.playFromStart();
    }

    private void next() {
        try {
            resultSet.next();
            try {
                if (resultSet.isAfterLast()) {
                    statement.execute("update teams set points=" + curr_score + " where name='" + team + "'");
                    statement.execute("update start set value=value+1");
                    try {
                        Parent temParent;
                        temParent = (Parent) FXMLLoader.load(getClass().getResource("result.fxml"));
                        quiz.Quiz.scene.setRoot(temParent);
                    } catch (IOException ex) {
                        Logger.getLogger(StartpageController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    return;
                }
            } catch (SQLException ex) {
            }

            try {
                timer_reset();
                question.setText(resultSet.getString("q"));
                op1.setText(resultSet.getString("a"));
                op2.setText(resultSet.getString("b"));
                op3.setText(resultSet.getString("c"));
                op4.setText(resultSet.getString("d"));
                current_ans = resultSet.getString("r");
                qno.setText(resultSet.getString("qid"));
            } catch (SQLException ex) {
                Logger.getLogger(QuizpageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuizpageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void update_score(Integer passedscore) {
        score.setText(passedscore.toString());
    }

    @FXML
    private void a_action(ActionEvent event) {
        if ("a".equals(current_ans)) {
            curr_score += 11 + (int) ((1 - timebar.getProgress()) * 10);

        } else {
            curr_score -= 3;
        }
        update_score(curr_score);
        next();
    }

    @FXML
    private void b_action(ActionEvent event) {
        if (current_ans.equals("b")) {
            curr_score += 11 + (int) ((1 - timebar.getProgress()) * 10);
        } else {
            curr_score -= 3;
        }
        update_score(curr_score);
        next();
    }

    @FXML
    private void c_action(ActionEvent event) {
        if (current_ans.equals("c")) {
            curr_score += 11 + (int) ((1 - timebar.getProgress()) * 10);
        } else {
            curr_score -= 3;
        }
        update_score(curr_score);
        next();
    }

    @FXML
    private void d_action(ActionEvent event) {
        if (current_ans.equals("d")) {
            curr_score += 11 + (int) ((1 - timebar.getProgress()) * 10);
        } else {
            curr_score -= 3;
        }
        update_score(curr_score);
        next();
    }

    @FXML
    private void skip(ActionEvent event) {
        next();
    }
}
