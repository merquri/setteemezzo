import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        Random r=new Random();

        double carta, punteggio;
        boolean risposta;

        risposta=true;
        punteggio=0;

        while (risposta) { carta= r.nextInt(10)+1;
            System.out.println("La carta estratta è: " +carta);

            if (carta>=8) {
                carta=0.5;   
            }

            punteggio=punteggio+carta;
            System.out.println("Il tuo punteggio è : "+punteggio);

            if (punteggio>7.5) {
                System.out.println("Hai sballato!");
                risposta=false;
            } else if (punteggio==7.5) {
                System.out.println("Hai vinto!");
                risposta=false;
            } else          
            { System.out.println("Vuoi estrarre un'altra carta?");
            risposta= sc.nextBoolean(); }
            
        }

        sc.close();



    }
}
