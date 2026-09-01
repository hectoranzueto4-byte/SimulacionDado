package com.yazidsistems.app.simulaciondado.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import java.util.Random;

public class MainController {

    @FXML
    private Pane panelDado;

    @FXML
    private Button btnLanzar;

    private final Random random = new Random();

    @FXML
    protected void onLanzarDadoClick() {
        // Deshabilitamos el botón para evitar doble clic durante la animación
        btnLanzar.setDisable(true);

        int destellosTotales = 12;
        Duration velocidad = Duration.millis(70);

        Timeline animacion = new Timeline(new KeyFrame(velocidad, event -> {
            int numeroTemporal = random.nextInt(6) + 1;
            dibujarPuntos(numeroTemporal);
        }));

        animacion.setCycleCount(destellosTotales);

        animacion.setOnFinished(event -> {
            int resultadoFinal = random.nextInt(6) + 1;
            dibujarPuntos(resultadoFinal);
            btnLanzar.setDisable(false); // Reactivamos el botón al terminar
        });

        animacion.play();
    }

    // Método encargado de posicionar matemáticamente los puntos negros en el cuadrado
    private void dibujarPuntos(int numero) {
        panelDado.getChildren().clear(); // Borra los puntos del tiro anterior

        int radio = 10; // Tamaño del punto
        Color colorPunto = Color.BLACK;

        // Definimos las posiciones clave dentro del cuadrado de 120x120
        // Margen izquierdo/superior = 30, Centro = 60, Margen derecho/inferior = 90
        if (numero == 1 || numero == 3 || numero == 5) {
            panelDado.getChildren().add(new Circle(60, 60, radio, colorPunto)); // Punto centro
        }
        if (numero > 1) {
            panelDado.getChildren().add(new Circle(30, 30, radio, colorPunto)); // Superior izquierdo
            panelDado.getChildren().add(new Circle(90, 90, radio, colorPunto)); // Inferior derecho
        }
        if (numero > 3) {
            panelDado.getChildren().add(new Circle(90, 30, radio, colorPunto)); // Superior derecho
            panelDado.getChildren().add(new Circle(30, 90, radio, colorPunto)); // Inferior izquierdo
        }
        if (numero == 6) {
            panelDado.getChildren().add(new Circle(30, 60, radio, colorPunto)); // Centro izquierdo
            panelDado.getChildren().add(new Circle(90, 60, radio, colorPunto)); // Centro derecho
        }
    }
}
