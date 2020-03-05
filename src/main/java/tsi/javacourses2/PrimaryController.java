package tsi.javacourses2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;

public class PrimaryController {

    private int count;
    public Spinner<Integer> num1;
    public Spinner<Integer> num2;
    public Spinner<Integer> num3;
    public Spinner<Integer> num4;
    public TableView<Turn> turnsTable;

    public void doTurn() {
        count++;
        int n1 = num1.getValue();
        int n2 = num2.getValue();
        int n3 = num3.getValue();
        int n4 = num4.getValue();

        var turn = new Turn();
        turn.setNr(count);
        turn.setGuess("" + n1 + n2 + n3 + n4);

        turnsTable.getItems().add(0,turn);// 0 - для того чтобв табличке сортировалось по новому -Go-

        System.out.printf("TURN %d %d %d %d %n", n1, n2, n3, n4);
    }
}
