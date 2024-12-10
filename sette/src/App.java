
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        // Dichiariamo lo scanner
        Scanner sc = new Scanner(System.in);

        // Dichiariamo il random
        Random r = new Random();

        // Dichiariamo le variabili
        double punteggio,punteggioBanco=0;
        boolean risposta=true, uscita=true;
        String seme,semeBanco;
        int i, carta,puntata,budget,cartaBanco;
        budget=100;

        
        do {
            System.out.println("Inserisci la puntata: ");
            puntata= sc.nextInt();
        if (puntata>budget || budget==0) {
            System.out.println("Sei iper povero, ricarica i soldi");
    
        } else if (puntata<=0) {
            System.out.println("Scommessa non valida");
        }
        else
        System.out.println("Hai giocato: " + puntata + " Euro");
        } while (puntata> budget || budget==0 || puntata<=0);





        // Dichiaro array e lo popolo
        String[] semi = {"denari", "bastoni", "coppe", "spade"};
        boolean[] carteUscite = new boolean[40];
        boolean[] carteUsciteBanco = new boolean[40];

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
            if (carta >= 8) {
                punteggio += 0.5;
            }else{
                punteggio+=carta;
            }
            System.out.println("Il tuo punteggio è : " + punteggio);
            System.out.println("Vuoi estrarre un'altra carta?");
            risposta = sc.nextBoolean();
            

            
            // Se maggiore o uguale a 8 punteggi
            
        
            if (punteggio > 7.5) {
                System.out.println("Hai sballato!");
                budget= budget-puntata;
                risposta = false;
            } 
        

        }

        while (risposta) {

            cartaBanco= r.nextInt(10) + 1;
            semeBanco = semi[r.nextInt(4)];

            while(uscita){
                i=0;
                switch(semeBanco){
                    case "denari":
                        i=cartaBanco-1;
                        if(carteUsciteBanco[i]==true){
                            cartaBanco = r.nextInt(10) + 1;
                            semeBanco = semi[r.nextInt(4)];
                        }else{
                            carteUsciteBanco[i]=true;
                            uscita=false;
                        }
                        break;
                    case "bastoni":
                    i=9+cartaBanco;
                    if(carteUsciteBanco[i]==true){
                        cartaBanco = r.nextInt(10) + 1;
                        semeBanco = semi[r.nextInt(4)];
                    }else{
                        carteUsciteBanco[i]=true;
                        uscita=false;
                    }
                    break;
                    case "coppe":
                    i=19+cartaBanco;
                    if(carteUsciteBanco[i]==true){
                        cartaBanco = r.nextInt(10) + 1;
                        semeBanco = semi[r.nextInt(4)];
                    }else{
                        carteUsciteBanco[i]=true;
                        uscita=false;
                    }
                    break;
                    case "spade":
                    i=29+cartaBanco;
                    if(carteUsciteBanco[i]==true){
                        cartaBanco = r.nextInt(10) + 1;
                        semeBanco = semi[r.nextInt(4)];
                    }else{
                        carteUsciteBanco[i]=true;
                        uscita=false;
                    }
                    break;
                }
            }
            uscita=true;



            System.out.println("La carta estratta dal banco è: " + cartaBanco + " di " + semeBanco);

            if (cartaBanco >= 8) {
                punteggioBanco += 0.5;
            }else{
                punteggioBanco+=cartaBanco;
            }
            
            System.out.println("Il punteggio del Banco è : " + punteggioBanco);





        }

        if (punteggio > 7.5) {
            System.out.println("Hai sballato!");
            budget= budget-puntata;
            risposta = false;
        } 
        
        else if(punteggio == 7.5 || punteggioBanco>7.5) {
            System.out.println("L'utente ha vinto!");
            budget= budget+puntata;
            
            risposta = false;
        } else if (punteggio==punteggioBanco) {
            System.out.println("Il banco ha vinto!");
            budget= budget-puntata;
            risposta = false;
        }
        else {
            System.out.println("Budget rimanente = " + budget);
            System.out.println("Vuoi estrarre un'altra carta?");
            risposta = sc.nextBoolean();
        } 

        sc.close();

    }
}
