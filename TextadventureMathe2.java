/**
 * Created by Markus Alpers on 20.10.2016.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Textadventure extends Application {

    private int aktuellerAbschnitt;
    private String[] abschnitte;
    private String[][] beschriftungen;
    private int[][] naechsterAbschnitt;
    private Text beschreibung;
    private Button button1;
    private Button button2;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Textadventure");

        int abenteuerlaenge = 10;
        aktuellerAbschnitt = 0;

        abschnitte = new String[abenteuerlaenge];
        beschriftungen = new String[abenteuerlaenge][2];
        naechsterAbschnitt = new int[abenteuerlaenge][2];

        // 0: Primzahlzwillinge
        abschnitte[0] = "Die Welt ist dem Untergang geweiht. Nur du kannst sie mit deinem außergewöhnlichen Mathe2-Wissen retten, indem du damit schnell die Weltformel aufstellst. /nWas besagt der Satz von Euklid?";
        beschriftungen[0][0] = "Es gibt unendlich viele Primzahlzwillinge.";
        naechsterAbschnitt[0][0] = 1;
        beschriftungen[0][1] = "Es gibt unendlich viele Primzahlen.";
        naechsterAbschnitt[0][1] = 2;

        // 1: Kleiner Satz von Fermat
        abschnitte[1] = "Es gibt unendlich viele Primzahlen./nWas bedeutet es, wenn du in Z/nZ herausbekommst: a^(n-1) = 1 (wenn a != 0)?";
        beschriftungen[1][0] = "n ist vielleicht eine Primzahl.";
        naechsterAbschnitt[1][0] = 2;
        beschriftungen[1][1] = "n ist eine Primzahl.";
        naechsterAbschnitt[1][1] = 0;

        // 2: Ankathete
        abschnitte[2] = "a^(n-1) = 1 (a != 0) bedeutet, dass n vielleicht eine Primzahl ist./nDie Ankathete eines rechtwinkligen Dreiecks berechnet man mit dem...";
        beschriftungen[2][0] = "Sinus.";
        naechsterAbschnitt[2][0] = 3;
        beschriftungen[2][1] = "Kosinus.";
        naechsterAbschnitt[2][1] = 4;

        // 3: Signum
        abschnitte[3] = "Die Ankathete eines rechtwinkligen Dreiecks berechnet man mit dem Kosinus./nWas bedeutet das \"Signum 1 einer Permutation\"?";
        beschriftungen[3][0] = "Die Permutation ist eine Transposition.";
        naechsterAbschnitt[3][0] = 5;
        beschriftungen[3][1] = "Die Permutation hat eine gerade Anzahl von Fehlständen.";
        naechsterAbschnitt[3][1] = 6;

        // 4: Wurzelziehen komplexe Zahl
        abschnitte[4] = "Wie ziehst du die Wurzel aus einer komplexen Zahl?";
        beschriftungen[4][0] = "Umrechnung in Polardarstellung, Wurzel aus dem Betrag ziehen, Winkel halbieren, Umrechnung in kartesische Darstellung";
        naechsterAbschnitt[4][0] = 9;
        beschriftungen[4][1] = "Umrechnung in Polardarstellung, Wurzel aus dem Winkel ziehen, Betrag halbieren, Umrechnung in kartesische Darstellung";
        naechsterAbschnitt[4][1] = 5;

        // 5: Körper
        abschnitte[5] = "Transpositionen haben immer das Signum -1 und somit eine ungerade Anzahl von Fehlständen./nSo ziehst du die Wurzel aus einer komplexen Zahl: Umrechnung in Polardarstellung, Wurzel aus dem Betrag ziehen, Winkel halbieren, Umrechnung in kartesische Darstellung./nEine skalare Multiplikation ergibt einen Vektor./nWas musst du in Körpern beachten?";
        beschriftungen[5][0] = "Der Fundamentalsatz der Algebra und das Klausurenlemma gelten nicht mehr.";
        naechsterAbschnitt[5][0] = 6;
        beschriftungen[5][1] = "Es gibt nur rein komplexe Lösungen für Gleichungen.";
        naechsterAbschnitt[5][1] = 8;

        // 6: Skalar
        abschnitte[6] = "Ein Skalar ist das Ergebnis von...";
        beschriftungen[6][0] = "einem Skalarprodukt.";
        naechsterAbschnitt[6][0] = 9;
        beschriftungen[6][1] = "einer skalaren Multiplikation.";
        naechsterAbschnitt[6][1] = 5;

        //
        abschnitte[7] = "Testeintrag...";
        beschriftungen[7][0] = "Neustart";
        naechsterAbschnitt[7][0] = 0;
        beschriftungen[7][1] = "Neustart";
        naechsterAbschnitt[7][1] = 2;

        // 8: Game Over
        abschnitte[8] = "Verloren. Du hast es nicht drauf und fällst durch Mathe2. Ach ja, und die Welt geht unter... Schade.";
        beschriftungen[8][0] = "Nochmal von vorne.";
        naechsterAbschnitt[8][0] = 0;
        beschriftungen[8][1] = "Nochmal von vorne.";
        naechsterAbschnitt[8][1] = 0;

        // 9: Ende
        abschnitte[9] = "Du hast es geschafft. Die Weltformel ist... terra(x) = 42. Die Welt ist gerettet!";
        beschriftungen[9][0] = "Nochmal von vorne.";
        naechsterAbschnitt[9][0] = 0;
        beschriftungen[9][1] = "Nochmal von vorne.";
        naechsterAbschnitt[9][1] = 0;

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 1200, 400);
        primaryStage.setScene(scene);

        Text scenetitle = new Text("Kleines Textadventure");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        beschreibung = new Text(abschnitte[aktuellerAbschnitt]);
        grid.add(beschreibung, 0, 1, 2, 2);

        button1 = new Button(beschriftungen[aktuellerAbschnitt][0]);
        grid.add(button1, 0, 3);
        grid.setHalignment(button1, HPos.RIGHT);

        button2 = new Button(beschriftungen[aktuellerAbschnitt][1]);
        grid.add(button2, 1, 3);
        grid.setHalignment(button2, HPos.LEFT);

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                aktuellerAbschnitt = naechsterAbschnitt[aktuellerAbschnitt][0];
                rewriteEntries(aktuellerAbschnitt);
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                aktuellerAbschnitt = naechsterAbschnitt[aktuellerAbschnitt][1];
                rewriteEntries(aktuellerAbschnitt);
            }
        });

        primaryStage.show();
    }

    private void rewriteEntries(int abschnnitt){
        beschreibung.setText(abschnitte[aktuellerAbschnitt]);
        button1.setText(beschriftungen[aktuellerAbschnitt][0]);
        button2.setText(beschriftungen[aktuellerAbschnitt][1]);
    }

    public static void main(String[] args) {
        launch(args);
    }

}

/**
 * Grundsätzlich nötig:
 * Textanzeige
 * Buttons für Auswahl der Antwort
 *
 * Texte aus Array von Abschnitten
 * Dazu Array mit Anzahl Buttons zum Abschnitt
 * Dazu Array mit Texten für jeden der Buttons
 */