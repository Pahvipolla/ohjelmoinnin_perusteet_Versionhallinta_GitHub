import java.util.Scanner;

public class Arvauspeli {
    public static void main(String[] args) {
        String oikeaNimi = "Matti"; // Voit muuttaa nimeä haluamaksesi
        Scanner scanner = new Scanner(System.in);
        int yritykset = 0;
        String arvaus = "";
        int vihjeTaso = 1;

        System.out.println("Tervetuloa Arvauspeliin!");
        System.out.println("Arvaa nimi tai kirjoita 'loppu' lopettaaksesi pelin.");

        while (true) {
            System.out.print("Arvaa nimi: ");
            arvaus = scanner.nextLine();
            yritykset++;

            if (arvaus.equalsIgnoreCase(oikeaNimi)) {
                System.out.println("Onnittelut! Arvasit oikein.");
                break;
            } else if (arvaus.equalsIgnoreCase("loppu")) {
                System.out.println("Peli lopetettu. Oikea nimi oli: " + oikeaNimi);
                yritykset--;
                break;
            } else {
                System.out.println("Väärä arvaus. Yritä uudelleen.");
                
                if (vihjeTaso <= oikeaNimi.length()) {
                    String vihje = oikeaNimi.substring(0, vihjeTaso);
                    int remainingLetters = oikeaNimi.length() - vihjeTaso;
                    
                    StringBuilder pisteet = new StringBuilder();
                    for (int i = 0; i < remainingLetters; i++) {
                        pisteet.append(".");
                    }
                    
                    System.out.println("Vihje: " + vihje + pisteet.toString());
                    vihjeTaso++;
                    
                    // Tarkistetaan, onko koko nimi annettu vihjeenä
                    if (vihjeTaso > oikeaNimi.length()) {
                        System.out.println("Koko nimi annettiin vihjeenä, mutta et onnistunut kirjoittamaan sitä oikein. Peli lopetetaan.");
                        break;
                    }
                } else {
                    // Tämä kohta on turvaverkko, jos vihjeTaso ylittää nimen pituuden
                    System.out.println("Vihjeitä ei enää ole saatavilla.");
                }
            }
        }

        System.out.println("Arvauskertoja: " + yritykset);
        scanner.close();
    }
}
