module com.mycompany.guiexample1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires postgresql;

    opens grp7.semproject.Presentation to javafx.fxml;
    exports grp7.semproject.Presentation;
}