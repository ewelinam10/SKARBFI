package skarbfi;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SKARBFI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numerTasks;
        int numberRepeat=0;
        
        do{
        System.out.println("Podaj ilość zestawów danych od 1 do 50");
        numerTasks = sc.nextInt();
        numberRepeat++;
        if(numberRepeat>2) System.out.println("Czytać nie umiesz? Zaraz program zakończy działanie !");
        if(numberRepeat>4) System.exit(0);
        }while(!(numerTasks >= 1 && numerTasks<= 50));
        
            for (int j = 0; j < numerTasks; j++) {
                System.out.println("\n Podaj ilość wskazówek ");
                int numberHints = sc.nextInt();

                int a = 0, b = 0;
                int x = 0, y = 0;
                Map<Integer, Integer> map = new HashMap<>();
                Random generator = new Random();

                System.out.println("Mapa ruchów które doprowadzą Cię do skarbu : ");
                //GENEROWANIE LISTY RUCHÓW MAPY
                //GENEROWANIE WSPOLRZEDNYCH WYNIKOWYCH, OKRESLAJACYCH WSPOLRZEDNE SKARBU
                for (int i = 0; i < numberHints; i++) {
                    a = generator.nextInt(4); //przypisz a -wartość z zakresu <0-3>, wartość ta określa kierunki 0-N,1-S,2-W,3-E
                    b = generator.nextInt(10001); //przypisz b -wartość z zakresu <0-10000>, wartość ta określa liczbę kroków wykonanych w danym kierunku(czyli liczbe jednostek w układzie współrzędnym) 
                    switch (a) {
                        case 0:
                            y += b;
                        case 1:
                            y -= b;
                        case 2:
                            x -= b;
                        case 3:
                            x += b;
                    }
                    System.out.println("(" + a + "," + b + ")");
                }

                System.out.println("\n Współrzędne skarbu to: (" + x + "," + y + ")");
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

                System.out.println("\n Więc po co się meczyć jak możesz pójść na skróty ...");
                if (y == 0 && x != 0) {
                    System.out.println("Ruch który zapewni Ci dojście do skarbu to : (" + array2[0] + "," + array2[1] + ")");
                }
                if (y != 0 && x == 0) {
                    System.out.println("Ruch który zapewni Ci dojście do skarbu to : (" + array1[0] + "," + array1[1] + ")");
                }
                if (y == 0 && x == 0) {
                    System.out.println("Skarb znajduję się w studni!  ");
                }
                if (y != 0 && x != 0) {
                    System.out.println("Ruchy które zapewnią Ci dojście do skarbu to : ");
                    System.out.println("(" + array1[0] + "," + array1[1] + ")");
                    System.out.println("(" + array2[0] + "," + array2[1] + ")");
                }

            }
        }
       
    }


