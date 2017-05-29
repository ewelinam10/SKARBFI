package skarbfi;

import java.util.*;
import java.lang.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
 
class MAIN
{
	public static void main (String[] args) throws java.lang.Exception
	{
		     Scanner sc = new Scanner(System.in);
        int numerTasks;
        int numberRepeat=0;
 
        List<String> lista = new ArrayList<String>();
        //System.out.println("Podaj ilość zestawów danych od 1 do 50");
        numerTasks = sc.nextInt();
 
 
            for (int j = 0; j < numerTasks; j++) {
                //System.out.println("\n Podaj ilość wskazówek ");
                int numberHints = sc.nextInt();
 
                int a = 0, b = 0;
                int x = 0, y = 0;
 
 
             //   System.out.println("Mapa ruchów które doprowadzą Cię do skarbu : ");
                //GENEROWANIE LISTY RUCHÓW MAPY
                //GENEROWANIE WSPOLRZEDNYCH WYNIKOWYCH, OKRESLAJACYCH WSPOLRZEDNE SKARBU
                for (int i = 0; i < numberHints; i++) {
                    a=sc.nextInt();
                    b=sc.nextInt();
                    //przypisz a -wartość z zakresu <0-3>, wartość ta określa kierunki 0-N,1-S,2-W,3-E
                    //przypisz b -wartość z zakresu <0-10000>, wartość ta określa liczbę kroków wykonanych w danym kierunku(czyli liczbe jednostek w układzie współrzędnym) 
                    switch (a) {
                        case 0:
                            y += b;
                            break;
                        case 1:
                            y -= b;
                            break;
                        case 2:
                            x -= b;
                            break;
                        case 3:
                            x += b;
                            break;
                    }
 
 
                }
 
 
 
                //GENEROWANIE MAX. DWOCH RUCHOW KTORE ZAPEWNIA KROTSZE DOJSCIE DO SKARBU
                int[] array1 = new int[2]; //tablica przechowująca pierwszy ruch
                int[] array2 = new int[2]; //tablica przechowująca ewentualny drugi ruch
                if (y != 0) {
                    array1[1] = y; // drugiemu elementowi przypisujemy ilosc przesuniec (kroków)
                    if (y >= 0) {
                        array1[0] = 0; // a pierwszemu wartość 0 czyli N ( przesunięcie na północ)
                    } else {
                        array1[0] = 1; // w przeciwnym razie (jesli y jest ujemne) przypisz 1 czyli S , przesunięcia na południe
                    }
                }
                if (x != 0) {
                    array2[1] = x; //drugiemu elementowi przypisujemy ilosc przesuniec (kroków)
                    if (x >= 0) {
                        array2[0] = 3; // a pierwszemu wartosc 3 czyli E (przesuniecie na wschód)
                    } else {
                        array2[0] = 2; // w przeciwnym razie jeśli x jest ujemne 
                    }
                }
 
 
 
              //  System.out.println("\n Więc po co się meczyć jak możesz pójść na skróty ...");
                if (y == 0 && x != 0) {
                    System.out.println( array2[0] + " " + array2[1] );
                   lista.add( array2[0] + " " + array2[1]);
                }
                if (y != 0 && x == 0) {
                    lista.add( array1[0] + " " + array1[1] );
                }
                if (y == 0 && x == 0) {
                    lista.add("studnia  ");
                }
                if (y != 0 && x != 0) {
                 //   System.out.println("Ruchy które zapewnią Ci dojście do skarbu to : ");
                    lista.add ( array1[0] + " " + array1[1] );
                    lista.add(array2[0] + " " + array2[1] );
                }
 
                System.out.println("");
            }
            for (String e : lista) {
            System.out.println(e);
                }
 
 
 
	}
}