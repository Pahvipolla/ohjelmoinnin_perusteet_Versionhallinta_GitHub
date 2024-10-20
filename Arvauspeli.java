import java.util.Scanner;

public class Arvauspeli {
    public static void main(String[] args) {
        String oikeaNimi = "Matti";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tervetuloa Arvauspeliin!");
        System.out.print("Arvaa nimi: ");
        String arvaus = scanner.nextLine();

        if (arvaus.equalsIgnoreCase(oikeaNimi)) {
            System.out.println("Onnittelut! Arvasit oikein.");
        } else {
            System.out.println("Väärä arvaus. Peli päättyy.");
        }

        scanner.close();
    }
}
