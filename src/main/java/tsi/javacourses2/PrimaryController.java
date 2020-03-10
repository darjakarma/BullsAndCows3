package tsi.javacourses2;

import java.io.IOException;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;

public class PrimaryController {
    private static List<Integer> myNumbers;
    private int count;
    public Spinner<Integer> num1;
    public Spinner<Integer> num2;
    public Spinner<Integer> num3;
    public Spinner<Integer> num4;
    public TableView<Turn> turnsTable;



    public static void  initialize() { //это готовый метод для загаданного 4х значного рандомного числа.
        Set<Integer> tmp = new LinkedHashSet<>();
        Random rand = new Random();
        while (tmp.size() < 4) {
            int i = rand.nextInt(10); // rand: 3 4 3 3 4 4 4 3 3 3 ... 9 ... 7. Тоесть Set проверяет на уникальность значения
          //   set: 3 4 9 7
            tmp.add(i);
        }
         myNumbers = List.copyOf(tmp);
        System.out.println(myNumbers);
    }



    public void doTurn() { //этот метод возникает при нажатии на кнопку Go
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
