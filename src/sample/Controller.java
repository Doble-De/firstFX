package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    int empate =0;
    int pj = 1;
    boolean jugar = false;
    boolean jugarvsc = false;
    boolean maquina = false;
    String mododejuego = "pvp";
    String jugadorX ="";
    String jugadorO ="";

    @FXML
    private Button buno;
    @FXML
    private Button bdos;
    @FXML
    private Button btres;
    @FXML
    private Button bcuatro;
    @FXML
    private Button bcinco;
    @FXML
    private Button bseis;
    @FXML
    private Button bsiete;
    @FXML
    private Button bocho;
    @FXML
    private Button bnueve;
    @FXML
    private TextArea pjX;
    @FXML
    private TextArea pjO;
    @FXML
    private Text turnode;
    @FXML
    private ListView<String> res;
    ObservableList<String> resultados = FXCollections.observableArrayList();

    @FXML
    public void tipodePartida(ActionEvent event){
        RadioButton radioButton = (RadioButton) event.getSource();
        mododejuego = radioButton.getId();
    }

    @FXML
    public void movimiento (ActionEvent event){

        if (jugar) {
            Button b = (Button) event.getSource();

            if (b.getText().equals(" ")) {
                if (pj == 1) {
                    b.setText("X");
                    pj++;
                    ganador();
                } else{
                    b.setText("O");
                    pj--;
                    ganador();
                }

            }

        }
        if (jugarvsc){
            Timeline twoSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    jugadacpu();
                    ganador();

                }
            }));
            twoSecondsWonder.play();
        }
    }


    @FXML
    public void start (ActionEvent event){

        jugadorX = pjX.getText();
        jugadorO = pjO.getText();
        buno.setText(" ");
        bdos.setText(" ");
        btres.setText(" ");
        bcuatro.setText(" ");
        bcinco.setText(" ");
        bseis.setText(" ");
        bsiete.setText(" ");
        bocho.setText(" ");
        bnueve.setText(" ");
        empate = 0;
        pj = (int) (Math.random() * 1)+1;


        switch (mododejuego){
            case "pvp":
                jugar = true;
                break;

            case "pvc":
                jugar = true;
                jugarvsc = true;
                break;
            case "cvc":
                jugarvsc = true;
                cpualone();
                break;
        }


    }

    public void ganador(){
        empate++;

        if (buno.getText().equals("X") && bdos.getText().equals("X") && btres.getText().equals("X")
                || buno.getText().equals("O") && bdos.getText().equals("O") && btres.getText().equals("O") ){
            Alert ganador = new Alert(Alert.AlertType.INFORMATION);
            ganador.setTitle("¡Hay un ganador!");
            ganador.setHeaderText("Enhorabuena el jugador "+ buno.getText()+" ha ganado");
            if (buno.getText().equals("X")) {
                ganador.setContentText("Gana "+jugadorX+ " vs "+jugadorO+" Pierde");
                resultados.add("Gana "+jugadorX+ " X vs O "+jugadorO+" Pierde");
                res.setItems(resultados);
            }else {
                ganador.setContentText("Gana "+jugadorO+ " vs "+jugadorX+" Pierde");
                resultados.add("Gana "+jugadorO+ " O vs X "+jugadorX+" Pierde");
                res.setItems(resultados);
            }
            ganador.initStyle(StageStyle.UTILITY);
            ganador.show();
            jugar = false;
            jugarvsc =false;
            turnode.setText(" ");
            empate = 0;
        }

        else if (buno.getText().equals("X") && bcuatro.getText().equals("X") && bsiete.getText().equals("X")
                || buno.getText().equals("O") && bcuatro.getText().equals("O") && bsiete.getText().equals("O") ){
            Alert ganador = new Alert(Alert.AlertType.INFORMATION);
            ganador.setTitle("¡Hay un ganador!");
            ganador.setHeaderText("Enhorabuena el jugador "+ buno.getText()+" ha ganado");
            if (buno.getText().equals("X")) {
                ganador.setContentText("Gana "+jugadorX+ " vs "+jugadorO+" Pierde");
                resultados.add("Gana "+jugadorX+ " X vs O "+jugadorO+" Pierde");
                res.setItems(resultados);
            }else {
                ganador.setContentText("Gana "+jugadorO+ " vs "+jugadorX+" Pierde");
                resultados.add("Gana "+jugadorO+ " O vs X "+jugadorX+" Pierde");
                res.setItems(resultados);
            }
            ganador.initStyle(StageStyle.UTILITY);
            ganador.show();
            jugar = false;
            jugarvsc =false;
            turnode.setText(" ");
            empate = 0;

        }

        else if (buno.getText().equals("X") && bcinco.getText().equals("X") && bnueve.getText().equals("X")
                || buno.getText().equals("O") && bcinco.getText().equals("O") && bnueve.getText().equals("O") ){
            Alert ganador = new Alert(Alert.AlertType.INFORMATION);
            ganador.setTitle("¡Hay un ganador!");
            ganador.setHeaderText("Enhorabuena el jugador "+ buno.getText()+" ha ganado");
            if (buno.getText().equals("X")) {
                ganador.setContentText("Gana "+jugadorX+ " vs "+jugadorO+" Pierde");
                resultados.add("Gana "+jugadorX+ " X vs O "+jugadorO+" Pierde");
                res.setItems(resultados);
            }else {
                ganador.setContentText("Gana "+jugadorO+ " vs "+jugadorX+" Pierde");
                resultados.add("Gana "+jugadorO+ " O vs X "+jugadorX+" Pierde");
                res.setItems(resultados);
            }
            ganador.initStyle(StageStyle.UTILITY);
            ganador.show();
            jugar = false;
            jugarvsc =false;
            turnode.setText(" ");
            empate = 0;
        }

        else if (bdos.getText().equals("X") && bcinco.getText().equals("X") && bocho.getText().equals("X")
                || bdos.getText().equals("O") && bcinco.getText().equals("O") && bocho.getText().equals("O") ){
            Alert ganador = new Alert(Alert.AlertType.INFORMATION);
            ganador.setTitle("¡Hay un ganador!");
            ganador.setHeaderText("Enhorabuena el jugador "+ buno.getText()+" ha ganado");
            if (bdos.getText().equals("X")) {
                ganador.setContentText("Gana "+jugadorX+ " vs "+jugadorO+" Pierde");
                resultados.add("Gana "+jugadorX+ " X vs O "+jugadorO+" Pierde");
                res.setItems(resultados);
            }else {
                ganador.setContentText("Gana "+jugadorO+ " vs "+jugadorX+" Pierde");
                resultados.add("Gana "+jugadorO+ " O vs X "+jugadorX+" Pierde");
                res.setItems(resultados);
            }
            ganador.initStyle(StageStyle.UTILITY);
            ganador.show();
            jugar = false;
            jugarvsc =false;
            turnode.setText(" ");
            empate = 0;
        }

        else if (btres.getText().equals("X") && bseis.getText().equals("X") && bnueve.getText().equals("X")
                || btres.getText().equals("O") && bseis.getText().equals("O") && bnueve.getText().equals("O") ){
            Alert ganador = new Alert(Alert.AlertType.INFORMATION);
            ganador.setTitle("¡Hay un ganador!");
            ganador.setHeaderText("Enhorabuena el jugador "+ buno.getText()+" ha ganado");
            if (btres.getText().equals("X")) {
                ganador.setContentText("Gana "+jugadorX+ " vs "+jugadorO+" Pierde");
                resultados.add("Gana "+jugadorX+ " X vs O "+jugadorO+" Pierde");
                res.setItems(resultados);
            }else {
                ganador.setContentText("Gana "+jugadorO+ " vs "+jugadorX+" Pierde");
                resultados.add("Gana "+jugadorO+ " O vs X "+jugadorX+" Pierde");
                res.setItems(resultados);
            }
            ganador.initStyle(StageStyle.UTILITY);
            ganador.show();
            jugar = false;
            jugarvsc =false;
            turnode.setText(" ");
            empate = 0;
        }

        else if (bcuatro.getText().equals("X") && bcinco.getText().equals("X") && bseis.getText().equals("X")
                || bcuatro.getText().equals("O") && bcinco.getText().equals("O") && bseis.getText().equals("O") ){
            Alert ganador = new Alert(Alert.AlertType.INFORMATION);
            ganador.setTitle("¡Hay un ganador!");
            ganador.setHeaderText("Enhorabuena el jugador "+ buno.getText()+" ha ganado");
            if (bcuatro.getText().equals("X")) {
                ganador.setContentText("Gana "+jugadorX+ " vs "+jugadorO+" Pierde");
                resultados.add("Gana "+jugadorX+ " X vs O "+jugadorO+" Pierde");
                res.setItems(resultados);
            }else {
                ganador.setContentText("Gana "+jugadorO+ " vs "+jugadorX+" Pierde");
                resultados.add("Gana "+jugadorO+ " O vs X "+jugadorX+" Pierde");
                res.setItems(resultados);
            }
            ganador.initStyle(StageStyle.UTILITY);
            ganador.show();
            jugar = false;
            jugarvsc =false;
            turnode.setText(" ");
            empate = 0;
        }
        else if (btres.getText().equals("X") && bcinco.getText().equals("X") && bsiete.getText().equals("X")
                || btres.getText().equals("O") && bcinco.getText().equals("O") && bsiete.getText().equals("O") ){
            Alert ganador = new Alert(Alert.AlertType.INFORMATION);
            ganador.setTitle("¡Hay un ganador!");
            ganador.setHeaderText("Enhorabuena el jugador "+ buno.getText()+" ha ganado");
            if (bcuatro.getText().equals("X")) {
                ganador.setContentText("Gana "+jugadorX+ " vs "+jugadorO+" Pierde");
                resultados.add("Gana "+jugadorX+ " X vs O "+jugadorO+" Pierde");
                res.setItems(resultados);
            }else {
                ganador.setContentText("Gana "+jugadorO+ " vs "+jugadorX+" Pierde");
                resultados.add("Gana "+jugadorO+ " O vs X "+jugadorX+" Pierde");
                res.setItems(resultados);
            }
            ganador.initStyle(StageStyle.UTILITY);
            ganador.show();
            jugar = false;
            jugarvsc =false;
            turnode.setText(" ");
            empate = 0;
        }

        else if (bsiete.getText().equals("X") && bocho.getText().equals("X") && bnueve.getText().equals("X")
                || bsiete.getText().equals("O") && bocho.getText().equals("O") && bnueve.getText().equals("O") ){
            Alert ganador = new Alert(Alert.AlertType.INFORMATION);
            ganador.setTitle("¡Hay un ganador!");
            ganador.setHeaderText("Enhorabuena el jugador "+ buno.getText()+" ha ganado");
            if (bsiete.getText().equals("X")) {
                ganador.setContentText("Gana "+jugadorX+ " vs "+jugadorO+" Pierde");
                resultados.add("Gana "+jugadorX+ " X vs O "+jugadorO+" Pierde");
                res.setItems(resultados);
            }else {
                ganador.setContentText("Gana "+jugadorO+ " vs "+jugadorX+" Pierde");
                resultados.add("Gana "+jugadorO+ " O vs X "+jugadorX+" Pierde");
                res.setItems(resultados);
            }
            ganador.initStyle(StageStyle.UTILITY);
            ganador.show();
            jugar = false;
            jugarvsc =false;
            turnode.setText(" ");
            empate = 0;
        }

        else if(empate == 9){
            Alert ganador = new Alert(Alert.AlertType.INFORMATION);
            ganador.setTitle("¡Hay un Empate!");
            ganador.setHeaderText("Habeis Empatado");
            ganador.initStyle(StageStyle.UTILITY);
            ganador.show();
            resultados.add("Empate "+jugadorX+ " X vs O "+jugadorO+" Empate");
            res.setItems(resultados);
            jugar = false;
            jugarvsc =false;
            turnode.setText(" ");
        }
    }

    public void jugadacpu() {
        int opcion = 0;
        boolean movido = false;
        while (!movido) {
            opcion = (int) (Math.random() * 8);
            switch (opcion) {
                case 0:
                    if (buno.getText().equals(" ")) {
                        if (pj == 1) {
                            buno.setText("X");
                            pj++;
                            movido = true;
                        } else {
                            buno.setText("O");
                            pj--;
                            movido = true;
                        }
                    }
                    break;
                case 1:
                    if (bdos.getText().equals(" ")) {
                        if (pj == 1) {
                            bdos.setText("X");
                            pj++;
                            movido = true;
                        } else {
                            bdos.setText("O");
                            pj--;
                            movido = true;
                        }
                    }
                    break;
                case 2:
                    if (btres.getText().equals(" ")) {
                        if (pj == 1) {
                            btres.setText("X");
                            pj++;
                            movido = true;
                        } else {
                            btres.setText("O");
                            pj--;
                            movido = true;
                        }
                    }
                    break;
                case 3:
                    if (bcuatro.getText().equals(" ")) {
                        if (pj == 1) {
                            bcuatro.setText("X");
                            pj++;
                            movido = true;
                        } else {
                            bcuatro.setText("O");
                            pj--;
                            movido = true;
                        }
                    }
                    break;
                case 4:
                    if (bcinco.getText().equals(" ")) {
                        if (pj == 1) {
                            bcinco.setText("X");
                            pj++;
                            movido = true;
                        } else {
                            bcinco.setText("O");
                            pj--;
                            movido = true;
                        }
                    }
                    break;
                case 5:
                    if (bseis.getText().equals(" ")) {
                        if (pj == 1) {
                            bseis.setText("X");
                            pj++;
                            movido = true;
                        } else {
                            bseis.setText("O");
                            pj--;
                            movido = true;
                        }
                    }
                    break;
                case 6:
                    if (bsiete.getText().equals(" ")) {
                        if (pj == 1) {
                            bsiete.setText("X");
                            pj++;
                            movido = true;
                        } else {
                            bsiete.setText("O");
                            pj--;
                            movido = true;
                        }
                    }
                    break;
                case 7:
                    if (bocho.getText().equals(" ")) {
                        if (pj == 1) {
                            bocho.setText("X");
                            pj++;
                            movido = true;
                        } else {
                            bocho.setText("O");
                            pj--;
                            movido = true;
                        }
                    }
                    break;
                case 8:
                    if (bnueve.getText().equals(" ")) {
                        if (pj == 1) {
                            bnueve.setText("X");
                            pj++;
                            movido = true;
                        } else {
                            bnueve.setText("O");
                            pj--;
                            movido = true;
                        }
                    }
                    break;
            }
        }
    }

    public void cpualone() {
        if (jugarvsc) {
            Timeline twoSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler <ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    jugadacpu();
                    ganador();

                }
            }));
            twoSecondsWonder.play();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}