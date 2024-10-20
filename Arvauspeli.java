import java.util.Scanner;

public class Arvauspeli {
    public static void main(String[] args) {
        String oikeaNimi = "Matti";
        Scanner scanner = new Scanner(System.in);
        int yritykset = 0;
        String arvaus = "";

        System.out.println("Tervetuloa Arvauspeliin!");
        System.out.println("Arvaa nimi tai kirjoita 'loppu' lopettaaksesi pelin.");

        while (!arvaus.equalsIgnoreCase(oikeaNimi)) {
            System.out.print("Arvaa nimi: ");
            arvaus = scanner.nextLine();
            yritykset++;

            if (arvaus.equalsIgnoreCase(oikeaNimi)) {
                System.out.println("Onnittelut! Arvasit oikein.");
            } else if (arvaus.equalsIgnoreCase("loppu")) {
                System.out.println("Peli lopetettu. Oikea nimi oli: " + oikeaNimi);
                yritykset--;
                break;
            } else {
                System.out.println("Väärä arvaus. Yritä uudelleen.");
            }
        }

        System.out.println("Arvauskertoja: " + yritykset);
        scanner.close();
    }
}
