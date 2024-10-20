import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Henkilo-luokka
class Henkilo {
    private String nimi;
    private String titteli;
    private String yksikko;

    public Henkilo(String nimi, String titteli, String yksikko) {
        this.nimi = nimi;
        this.titteli = titteli;
        this.yksikko = yksikko;
    }

    public String getNimi() {
        return nimi;
    }

    public String getTitteli() {
        return titteli;
    }

    public String getYksikko() {
        return yksikko;
    }

    @Override
    public String toString() {
        return nimi + ", " + titteli + ", " + yksikko;
    }
}

// HenkiloLista-luokka
class HenkiloLista {
    public static List<Henkilo> luoHenkiloLista() {
        List<Henkilo> henkilot = new ArrayList<>();

        henkilot.add(new Henkilo("Pertti Puusaari", "Rehtori-toimitusjohtaja", "Ylin johto ja kehittäminen"));
        henkilot.add(new Henkilo("Heidi Ahokallio-Leppälä", "Vararehtori", "Ylin johto ja kehittäminen"));
        henkilot.add(new Henkilo("Jari Jussila", "Tutkijayliopettaja", "HAMK Design Factory"));
        henkilot.add(new Henkilo("Mari Kamaja", "Kehitysjohtaja", "Ylin johto ja kehittäminen"));
        henkilot.add(new Henkilo("Marianne Kukko", "Yksikön johtaja", "Ammatillinen opettajakorkeakoulu"));
        henkilot.add(new Henkilo("Martti Majuri", "Tutkimusyksikön johtaja", "HAMK Edu"));
        henkilot.add(new Henkilo("Lassi Martikainen", "Yksikön johtaja", "Liiketalouden, muotoilun ja tekniikan yksikkö"));
        henkilot.add(new Henkilo("Johanna Närhi", "Talous- ja hallintojohtaja", "Ylin johto ja kehittäminen"));
        henkilot.add(new Henkilo("Anna Olkinuora", "Yksikön johtaja", "Sosiaali- ja terveysalan yksikkö"));
        henkilot.add(new Henkilo("Annukka Pakarinen", "Tutkimusjohtaja", "HAMK Bio"));
        henkilot.add(new Henkilo("Jukka Pulkkinen", "Tutkimusyksikön johtaja", "HAMK Smart"));
        henkilot.add(new Henkilo("Mona-Anitta Riihimäki", "Yksikön johtaja", "Bio- ja luonnonvara-alan yksikkö"));
        henkilot.add(new Henkilo("Merja Salminen", "Yksikön johtaja", "Sosiaali- ja terveysalan yksikkö"));
        henkilot.add(new Henkilo("Tuomas Salonen", "Kiinteistökehitysjohtaja", "Ylin johto ja kehittäminen"));
        henkilot.add(new Henkilo("Anne-Maarit Selinummi", "Johtava digipalvelupäällikkö", "Digipalvelut"));
        henkilot.add(new Henkilo("Jaana Malmisuo", "Lehtori", "Terveysala"));
        henkilot.add(new Henkilo("Senja Sakko", "Julkaisuasiantuntija", "Kirjasto- ja tietopalvelut"));
        henkilot.add(new Henkilo("Henriikka Mastokangas", "Puheenjohtaja", "HAMKO"));

        return henkilot;
    }
}

// Arvauspeli-luokka
public class Arvauspeli {
    public static void main(String[] args) {
        List<Henkilo> henkilot = HenkiloLista.luoHenkiloLista();
        if (henkilot.isEmpty()) {
            System.out.println("Henkilölistassa ei ole yhtään henkilöä.");
            return;
        }

        // Valitaan satunnaisesti yksi henkilö
        Random random = new Random();
        Henkilo oikeaHenkilo = henkilot.get(random.nextInt(henkilot.size()));
        String oikeaNimi = oikeaHenkilo.getNimi();

        Scanner scanner = new Scanner(System.in);
        int yritykset = 0;
        String arvaus = "";
        int vihjeTaso = 1;

        System.out.println("Tervetuloa Arvauspeliin!");
        System.out.println("");
        System.out.println("Pelissä on tarkoitus arvata kuka HAMK:in johtoryhmän jäsen on kyseessä.");
        System.out.println("Arvaa nimi tai kirjoita 'loppu' lopettaaksesi pelin.");

        while (true) {
            System.out.print("Arvaa nimi: ");
            arvaus = scanner.nextLine().trim();
            yritykset++;

            if (arvaus.equalsIgnoreCase(oikeaNimi)) {
                System.out.println("Onnittelut! Arvasit oikein.");
                break;
            } else if (arvaus.equalsIgnoreCase("loppu")) {
                System.out.println("Peli lopetettu.");
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
                }
            }
        }

        // Pelin lopetus
        System.out.println("Arvauskertoja: " + yritykset);
        System.out.println("");
        System.out.println("Oikea henkilö oli siis:");
        System.out.println("");
        System.out.println("Henkilö: " + oikeaHenkilo.getNimi());
        System.out.println("Titteli: " + oikeaHenkilo.getTitteli());
        System.out.println("Yksikkö: " + oikeaHenkilo.getYksikko());
        scanner.close();
    }
}
