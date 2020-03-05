module tsi.javacourses2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens tsi.javacourses2 to javafx.fxml;
    exports tsi.javacourses2;
}