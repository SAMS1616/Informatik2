 /** 
2  * Created by Markus Alpers on 20.10.2016. 
3  */ 
4 
 
5 import javafx.application.Application; 
6 import javafx.event.ActionEvent; 
7 import javafx.event.EventHandler; 
8 import javafx.geometry.HPos; 
9 import javafx.geometry.Pos; 
10 import javafx.geometry.Insets; 
11 import javafx.scene.Scene; 
12 import javafx.scene.control.Button; 
13 import javafx.scene.layout.GridPane; 
14 import javafx.scene.text.Font; 
15 import javafx.scene.text.FontWeight; 
16 import javafx.scene.text.Text; 
17 import javafx.stage.Stage; 
18 
 
19 public class Textadventure extends Application { 
20 
 
21     private int aktuellerAbschnitt; 
22     private String[] abschnitte; 
23     private String[][] beschriftungen; 
24     private int[][] naechsterAbschnitt; 
25     private Text beschreibung; 
26     private Button button1; 
27     private Button button2; 
28 
 
29     @Override 
30     public void start(Stage primaryStage) { 
31         primaryStage.setTitle("Textadventure"); 
32 
 
33         int abenteuerlaenge = 10; 
34         aktuellerAbschnitt = 0; 
35 
 
36         abschnitte = new String[abenteuerlaenge]; 
37         beschriftungen = new String[abenteuerlaenge][2]; 
38         naechsterAbschnitt = new int[abenteuerlaenge][2]; 
39 
 
40         // 0: Startpunkt 
41         abschnitte[0] = "Du erwachst. Es ist kalt und du hast einen Kater. Es riecht ein wenig muffig."; 
42         beschriftungen[0][0] = "Du siehst dich um."; 
43         naechsterAbschnitt[0][0] = 1; 
44         beschriftungen[0][1] = "Du stehst auf."; 
45         naechsterAbschnitt[0][1] = 2; 
46 
 
47         // 1: Umsehen nach erfwachen 
48         abschnitte[1] = "Ich glaub, du stehst im Wald... nein, vielmehr liegst du im Wald. Muss eine üble Party gewesen sein."; 
49         beschriftungen[1][0] = "Du stehst auf."; 
50         naechsterAbschnitt[1][0] = 2; 
51         beschriftungen[1][1] = "Du schläfst lieber nochmal ne Runde."; 
52         naechsterAbschnitt[1][1] = 0; 
53 
 
54         // 2: Aufstehen 
55         abschnitte[2] = "Schwankend kommst du auf die Füße. Der nächste Wald von deiner WG aus liegt in nördlicher Richtung. Wie war das doch noch?"; 
56         beschriftungen[2][0] = "An Bäumen wächst das Moos auf der Südseite, denn Moos wächst im Sonnenlicht."; 
57         naechsterAbschnitt[2][0] = 3; 
58         beschriftungen[2][1] = "Quatsch, es ist genau umgekehrt."; 
59         naechsterAbschnitt[2][1] = 4; 
60 
 
61         // 3: Nach Norden 
62         abschnitte[3] = "So soll es sein... Du schwankst durch einen unbekannten Wald in eine Richtung, die du für Süden hältst."; 
63         beschriftungen[3][0] = "Du bleibst bei deiner Entscheidung und gehst immer weiter in die Richtung."; 
64         naechsterAbschnitt[3][0] = 5; 
65         beschriftungen[3][1] = "Du bist dir nicht sicher und drehst nochmal um."; 
66         naechsterAbschnitt[3][1] = 6; 
67 
 
68         // 4: Nach Süden 
69         abschnitte[4] = "So soll es sein... Du schwankst durch einen unbekannten Wald in eine Richtung, die du für Süden hältst."; 
70         beschriftungen[4][0] = "Du bleibst bei deiner Entscheidung und gehst immer weiter in die Richtung."; 
71         naechsterAbschnitt[4][0] = 9; 
72         beschriftungen[4][1] = "Du bist dir nicht sicher und drehst nochmal um."; 
73         naechsterAbschnitt[4][1] = 5; 
74 
 
75         // 5: Weiter nach Norden 
76         abschnitte[5] = "Und du gehst ... und gehst ... und gehst..."; 
77         beschriftungen[5][0] = "und drehst dann irgendwann um, weils so weit doch nicht sein kann."; 
78         naechsterAbschnitt[5][0] = 6; 
79         beschriftungen[5][1] = "und gehst immer weiter."; 
80         naechsterAbschnitt[5][1] = 8; 
81 
 
82         // 6: Doch nach Süden 
83         abschnitte[6] = "Du kommst an der Stelle vorbei, an der du aufgewacht bist."; 
84         beschriftungen[6][0] = "Weiter geht's."; 
85         naechsterAbschnitt[6][0] = 9; 
86         beschriftungen[6][1] = "Nein, doch lieber umdrehen."; 
87         naechsterAbschnitt[6][1] = 5; 
88 
 
89         // 
90         abschnitte[7] = "Testeintrag..."; 
91         beschriftungen[7][0] = "Neustart"; 
92         naechsterAbschnitt[7][0] = 0; 
93         beschriftungen[7][1] = "Neustart"; 
94         naechsterAbschnitt[7][1] = 2; 
95 
 
96         // 8: Game Over 
97         abschnitte[8] = "Du hast dich hoffnungslos verirrt."; 
98         beschriftungen[8][0] = "Nochmal von vorne."; 
99         naechsterAbschnitt[8][0] = 0; 
100         beschriftungen[8][1] = "Nochmal von vorne."; 
101         naechsterAbschnitt[8][1] = 0; 
102 
 
103         // 9: Ende 
104         abschnitte[9] = "Nach fünf Minuten brichst du durch die Hecke auf das Gelände deines Wohnheims. Dann mal ran an Statistik 1 - Und mögest du alle Hoffnung verlieren."; 
105         beschriftungen[9][0] = "Nochmal von vorne."; 
106         naechsterAbschnitt[9][0] = 0; 
107         beschriftungen[9][1] = "Nochmal von vorne."; 
108         naechsterAbschnitt[9][1] = 0; 
109 
 
110         GridPane grid = new GridPane(); 
111         grid.setAlignment(Pos.CENTER); 
112         grid.setHgap(10); 
113         grid.setVgap(10); 
114         grid.setPadding(new Insets(25, 25, 25, 25)); 
115 
 
116         Scene scene = new Scene(grid, 1200, 400); 
117         primaryStage.setScene(scene); 
118 
 
119         Text scenetitle = new Text("Kleines Textadventure"); 
120         scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20)); 
121         grid.add(scenetitle, 0, 0, 2, 1); 
122 
 
123         beschreibung = new Text(abschnitte[aktuellerAbschnitt]); 
124         grid.add(beschreibung, 0, 1, 2, 2); 
125 
 
126         button1 = new Button(beschriftungen[aktuellerAbschnitt][0]); 
127         grid.add(button1, 0, 3); 
128         grid.setHalignment(button1, HPos.RIGHT); 
129 
 
130         button2 = new Button(beschriftungen[aktuellerAbschnitt][1]); 
131         grid.add(button2, 1, 3); 
132         grid.setHalignment(button2, HPos.LEFT); 
133 
 
134         button1.setOnAction(new EventHandler<ActionEvent>() { 
135             @Override 
136             public void handle(ActionEvent e) { 
137                 aktuellerAbschnitt = naechsterAbschnitt[aktuellerAbschnitt][0]; 
138                 rewriteEntries(aktuellerAbschnitt); 
139             } 
140         }); 
141 
 
142         button2.setOnAction(new EventHandler<ActionEvent>() { 
143             @Override 
144             public void handle(ActionEvent e) { 
145                 aktuellerAbschnitt = naechsterAbschnitt[aktuellerAbschnitt][1]; 
146                 rewriteEntries(aktuellerAbschnitt); 
147             } 
148         }); 
149 
 
150         primaryStage.show(); 
151     } 
152 
 
153     private void rewriteEntries(int abschnnitt){ 
154         beschreibung.setText(abschnitte[aktuellerAbschnitt]); 
155         button1.setText(beschriftungen[aktuellerAbschnitt][0]); 
156         button2.setText(beschriftungen[aktuellerAbschnitt][1]); 
157     } 
158 
 
159     public static void main(String[] args) { 
160         launch(args); 
161     } 
162 
 
163 } 
164 
 
165 /** 
166  * Grundsätzlich nötig: 
167  * Textanzeige 
168  * Buttons für Auswahl der Antwort 
169  * 
170  * Texte aus Array von Abschnitten 
171  * Dazu Array mit Anzahl Buttons zum Abschnitt 
172  * Dazu Array mit Texten für jeden der Buttons 
173  */ 

