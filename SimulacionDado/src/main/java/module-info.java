module com.yazidsistems.app.simulaciondado {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.yazidsistems.app.simulaciondado to javafx.fxml;
    // Permite acceder a la subcarpeta del controlador
    opens com.yazidsistems.app.simulaciondado.controller to javafx.fxml;

    exports com.yazidsistems.app.simulaciondado;
}
