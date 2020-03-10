package tsi.javacourses2;

import java.io.IOException;
import java.util.*;

import javafx.beans.binding.Bindings;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;

public class PrimaryController {
    private List<Integer> myNumbers;
    public Button goButton; //
    private int count;
    public Spinner<Integer> num1;
    public Spinner<Integer> num2;
    public Spinner<Integer> num3;
    public Spinner<Integer> num4;
    public TableView<Turn> turnsTable;


    public void initialize() {
        generateRandom();

        goButton.disableProperty().bind(
                Bindings.createBooleanBinding(// теперь, в табличке цифры обязательно должны быть разные иначе кнопка Go - не работает!!!!
                        () -> {
                            Set<Integer> tmp = new HashSet<Integer>();
                            tmp.add(num1.getValue());
                            tmp.add(num2.getValue());
                            tmp.add(num3.getValue());
                            tmp.add(num4.getValue());
                            return tmp.size() < 4; // так можно установить максимальное значение
                        },

                        num1.valueProperty(),
                        num2.valueProperty(),
                        num3.valueProperty(),
                        num4.valueProperty()
                )
        );
    }


    public void generateRandom() { //это готовый метод для загаданного 4х значного рандомного числа.
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


    public void doTurn() throws IOException { //этот метод возникает при нажатии на кнопку Go
        count++;
        int n1 = num1.getValue();
        int n2 = num2.getValue();
        int n3 = num3.getValue();
        int n4 = num4.getValue();

        List<Integer> userNumbers = List.of(n1, n2, n3, n4);

        var turn = new Turn();

        turn.setNr(count);
        turn.setGuess("" + n1 + n2 + n3 + n4);
        updateBullsAndCows(turn, userNumbers);

        turnsTable.getItems().add(0, turn);// 0 - для того чтобв табличке сортировалось по новому -Go-

        System.out.printf("TURN %d %d %d %d %n", n1, n2, n3, n4);

        if (turn.getBulls() == 4) {
            App.setRoot("secondary");
        }
    }

    private void updateBullsAndCows(Turn turn, List<Integer> userNumbers) {
        int cows = 0;
        int bulls = 0;
        for (int y = 0; y < 4; y++) {//random - т.е. загадное компом число коровы строчки
            for (int x = 0; x < 4; x++) {// юзер - т.е. написаное юзером предположение столбики
                int un = userNumbers.get(x); // equels метод только для чисел
                int mn = myNumbers.get(y);
                if (un == mn) {
                    if (x == y) {
                        bulls++;
                    } else {
                        cows++;
                    }
                }
            }
        }
        turn.setCows(cows);
        turn.setBulls(bulls);
    }



    private int calculateBulls(List<Integer> userNumbers) { //боксинг и анбоксинг - когда в Интеджере можно прописать и числа - int - а не объект
        int bulls = 0;
        for (int i = 0; i < 4; i++) {
            int un = userNumbers.get(i); //equels метод только для чисел
            int mn = myNumbers.get(i);
            if (un == mn) {
                bulls++;
            }
        }
        return bulls;
        // myNumbers.get(0); индексы 1 2 3 4
        // userNumbers.get(0);
//            if (i.equals("")) {
//                return true;
//            } else if (usernu.equals("n")) {
//                return false;
    }
}
//   if (x != y && un == mn) {//так выявлять совпадение индексов (инбекс - x y)
//     cows++;