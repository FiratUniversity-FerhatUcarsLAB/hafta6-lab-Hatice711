/**
* Ad Soayad : Hatice KIRMIZIGÜL
* Öğrenci No : 250541102
* Proje : Akıllı Restoran Sipariş Sistemi
* Tarih : 25.11.2025    
*/    


import java.util.Scanner;

public class RestoranSiparis {
    public static double getMainDishPrice(int secim) {
        switch(secim) {
            case 1: return 85; // Izgara Tavuk
            case 2: return 120; // Adana Kebap
            case 3: return 110; // Levrek
            case 4: return 65; // Mantı
            default: return 0;
        }
    }

    public static double getAppetizerPrice(int secim) {
        switch(secim) {
            case 1: return 25; // Çorba
            case 2: return 45; // Humus
            case 3: return 55; // Sigara Böreği
            default: return 0;
        }
    }

    public static double getDrinkPrice(int secim) {
        switch(secim) {
            case 1: return 15; // Kola
            case 2: return 12; // Ayran
            case 3: return 35; // Taze Meyve Suyu
            case 4: return 25; // Limonata
            default: return 0;
        }
    }

    public static double getDessertPrice(int secim) {
        switch(secim) {
            case 1: return 65; // Künefe
            case 2: return 55; // Baklava
            case 3: return 35; // Sütlaç
            default: return 0;
        }
    }

    public static boolean isComboOrder(boolean ana, boolean icecek, boolean tatli){
        return(ana && icecek && tatli);
    }

    public static boolean isHappyHour(int saat) {
            return saat >= 14 && saat <= 17;
    }

    public static double calculateDiscount(double araToplam, boolean combo, boolean ogrenci, int saat, int gun, double icecekFiyatı){

        double toplamIndirim = 0;

        if(combo){
            toplamIndirim += araToplam * 0.15;
        }

        if(isHappyHour(saat)){
            toplamIndirim += saat * 0.20;
        }

        boolean haftaIci = (gun >= 1 && gun <= 5);

        if (ogrenci && haftaIci){
            toplamIndirim += (araToplam - toplamIndirim) * 0.10;
        }

        return(toplamIndirim);
    }

    public static double calculateServiseTip(double tutar){
        return tutar * 0.10;
    }

    // ====================================
    //                 MAIN
    // ====================================
    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);

        // --- Menüler ---
        System.out.println("=== ANA YEMEKLER ===");
        System.out.println("1: Izgara Tavuk - 85 TL");
        System.out.println("2: Adana Kebap - 120 TL");
        System.out.println("3: Levrek - 110 TL");
        System.out.println("4: Mantı - 65 TL");
        System.out.print("Seçiminiz (0=Yok): ");
        int anaSecim = input.nextInt();

        System.out.println("\n=== BAŞLANGIÇLAR ===");
        System.out.println("1: Çorba - 25 TL");
        System.out.println("2: Humus - 45 TL");
        System.out.println("3: Sigara Böreği - 55 TL");
        System.out.print("Seçiminiz (0=Yok): ");
        int baseSecim = input.nextInt();

        System.out.println("\n=== İÇECEKLER ===");
        System.out.println("1: Kola - 15 TL");
        System.out.println("2: Ayran - 12 TL");
        System.out.println("3: Taze Meyve Suyu - 35 TL");
        System.out.println("4: Limonata - 25 TL");
        System.out.print("Seçiminiz (0=Yok): ");
        int icecekSecim = input.nextInt();

        System.out.println("\n=== TATLILAR ===");
        System.out.println("1: Künefe - 65 TL");
        System.out.println("2: Baklava - 55 TL");
        System.out.println("3: Sütlaç - 35 TL");
        System.out.print("Seçiminiz (0=Yok): ");
        int tatliSecim = input.nextInt();

        // Saat Bilgisi
        System.out.print("\nSaat (7-24): ");
        int saat = input.nextInt();

        // Öğrenci Sorusu
        System.out.print("Öğrenci misiniz? (E/H): ");
        String cevap = input.next();

        boolean ogrenci;
        if (cevap.equalsIgnoreCase("E")) {
            ogrenci = true;
        } else {
            ogrenci = false;
        }

        // Gün Bilgisi
        System.out.print("Hangi gün? (1=Pzt ... 7=Paz): ");
        int gun = input.nextInt();

        // --- FİYAT HESAPLAMALARI ---
        double anaFiyat = getMainDishPrice(anaSecim);
        double basFiyat = getAppetizerPrice(baseSecim);
        double icecekFiyat = getDrinkPrice(icecekSecim);
        double tatliFiyat = getDessertPrice(tatliSecim);

        double araToplam = anaFiyat + basFiyat + icecekFiyat + tatliFiyat;

        boolean combo = isComboOrder(anaFiyat > 0, icecekFiyat > 0, tatliFiyat > 0);

        double toplamIndirim = calculateDiscount(araToplam, combo, ogrenci, saat, gun, icecekFiyat);

        double odenecekTutar = araToplam - toplamIndirim;

        double bahsis = calculateServiseTip(odenecekTutar);

        // ---FİŞ ÇIKTISI ---
        System.out.println("\n====== FİŞ ======");
        System.out.println("Ara Toplam: " + araToplam + "TL");
        System.out.println("Toplam İndirim: - " + toplamIndirim + "TL");
        System.out.println("Ödenecek Tutar: " + odenecekTutar + "TL");
        System.out.println("Bahşiş Önerisi (%10): " + bahsis + "TL");
        System.out.print("============");

        input.close();
    }
}
