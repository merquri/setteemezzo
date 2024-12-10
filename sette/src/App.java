import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Dichiariamo lo scanner
        Scanner sc = new Scanner(System.in);

        // Dichiariamo il random
        Random r = new Random();

        // Dichiariamo le variabili
        double carta, punteggio;
        boolean risposta;
        String seme;

        // Dichiaro array e lo popolo
        String[] semi = { "denari", "bastoni", "coppe", "spade" };

        // inizializziamo le variabili
        risposta = true;
        punteggio = 0;

        // Ciclo while che controlla il risultato e se vuole giocare ancora
        while (risposta) {

            // Creiamo un numero casuale da 1 a 10
            carta = r.nextInt(10) + 1;

            // Creiamo un seme casuale
            seme = semi[r.nextInt(4)];

            // Esponiamo il risultato della carta
            System.out.println("La carta estratta è: " + carta + " di " + seme);

            // Se maggiore o uguale a 8 punteggio 0.5
            if (carta >= 8) {
                carta = 0.5;
            }

            // Sommo i punti
            punteggio = punteggio + carta;
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
