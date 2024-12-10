
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        // Dichiariamo lo scanner
        Scanner sc = new Scanner(System.in);

        // Dichiariamo il random
        Random r = new Random();

        // Dichiariamo le variabili
        double punteggio;
        boolean risposta=true, uscita=true;
        String seme;
        int i, carta;

        // Dichiaro array e lo popolo
        String[] semi = {"denari", "bastoni", "coppe", "spade"};
        boolean[] carteUscite = new boolean[40];

        // inizializziamo le variabili
        punteggio = 0;

        // Ciclo while che controlla il risultato e se vuole giocare ancora
        while (risposta) {

            // Creiamo un numero casuale da 1 a 10
            carta = r.nextInt(10) + 1;

            // Creiamo un seme casuale
            seme = semi[r.nextInt(4)];

            // Controllo carta uscita
            while(uscita){
                i=0;
                switch(seme){
                    case "denari":
                        i=carta-1;
                        if(carteUscite[i]==true){
                            carta = r.nextInt(10) + 1;
                            seme = semi[r.nextInt(4)];
                        }else{
                            carteUscite[i]=true;
                            uscita=false;
                        }
                        break;
                    case "bastoni":
                    i=9+carta;
                    if(carteUscite[i]==true){
                        carta = r.nextInt(10) + 1;
                        seme = semi[r.nextInt(4)];
                    }else{
                        carteUscite[i]=true;
                        uscita=false;
                    }
                    break;
                    case "coppe":
                    i=19+carta;
                    if(carteUscite[i]==true){
                        carta = r.nextInt(10) + 1;
                        seme = semi[r.nextInt(4)];
                    }else{
                        carteUscite[i]=true;
                        uscita=false;
                    }
                    break;
                    case "spade":
                    i=29+carta;
                    if(carteUscite[i]==true){
                        carta = r.nextInt(10) + 1;
                        seme = semi[r.nextInt(4)];
                    }else{
                        carteUscite[i]=true;
                        uscita=false;
                    }
                    break;
                }
            }
            uscita=true;

            // Esponiamo il risultato della carta
            System.out.println("La carta estratta è: " + carta + " di " + seme);

            // Se maggiore o uguale a 8 punteggio 0.5
            if (carta >= 8) {
                punteggio += 0.5;
            }else{
                punteggio+=carta;
            }
            System.out.println("Il tuo punteggio è : " + punteggio);

            // Controllo il risultato
            if (punteggio > 7.5) {
                System.out.println("Hai sballato!");
                risposta = false;
            } else if (punteggio == 7.5) {
                System.out.println("Hai vinto!");
                risposta = false;
            } else {
                System.out.println("Vuoi estrarre un'altra carta?");
                risposta = sc.nextBoolean();
            }
            
        }

        sc.close();

    }
}
