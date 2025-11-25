import java.util.Scanner;

public class SinemaBileti {
    public static boolean isWeekend(int gun){
        return gun == 6 || gun == 7;
    }

    public static boolean isMatinee(int saat){
        if(saat < 12){
            return true;
        }else{
            return false;
        }
    }

    public static double calculateBasePrice(int gun, int saat){

        boolean haftasonu = isWeekend(gun);
        boolean matinee = isMatinee(saat);
        if(!haftasonu && matinee) return 45;
        if(!haftasonu && !matinee) return 65;
        if(haftasonu && matinee) return 55;
        return 85;
    }

    public static double calculateDiscount(int yas, int meslek, int gun){

        if(yas >= 65) return 0.30;
        if (yas < 12) return 0.25;

     switch(meslek){
         case 1:
             if (gun >= 1 && gun <=4) return 0.20;
             else return 0.15;
         case 2:
             if (gun == 3 ) return 0.35;
             break;

          default:
              break;
     }
     return 0;
    }

    public static double getFormatExtra(int filmTuru){
        switch (filmTuru){
            case 1: return 0;
            case 2: return 25;
            case 3: return 35;
            case 4: return 50;
            default: return 0;
        }
    }

    public static double calculateFinalPrice(int gun, int saat, int yas, int meslek, int filmTuru){

        double base = calculateBasePrice(gun,saat);
        double discountRate = calculateDiscount(yas, meslek, gun);
        double discountAmount = base * discountRate;

        double discountPrice = base - discountAmount;
        double extra = getFormatExtra(filmTuru);

        return  discountPrice + extra;
    }

    public static void generateTicketInfo(int gun, int saat, int yas, int meslek, int filmTuru){

        String[] gunler = {"", "Pazartesi", "Salı", "Çarşamba", "Perşembe","Cuma", "Cumartesi", "Pazar"};

        String filmFormat = switch (filmTuru) {
            case 1 -> "2D";
            case 2 -> "3D";
            case 3 -> "IMAX";
            case 4 -> "4DX";
            default -> "Bilinmiyor";
        };

        double base = calculateBasePrice(gun, saat);
        double discountRate = calculateDiscount(yas, meslek, gun);
        double discountAmount = base * discountRate;

        double finalPrice = calculateFinalPrice(gun, saat,yas,meslek,filmTuru);

        System.out.println("\n===== SİNEMA BİLETİ =====");
        System.out.println("Gun: " + gunler[gun]);
        System.out.println("Saat: " + saat +":00");
        System.out.println("Yas: " + yas);
        System.out.println("Film Türü: " + filmFormat);
        System.out.println("------------------------------");
        System.out.println("Temel Fiyat: " + base + "TL");
        System.out.println("İndirim: - " + discountAmount + "TL");
        System.out.println("Format Ekstra: +" + getFormatExtra(filmTuru) + "TL");
        System.out.println("------------------------------");
        System.out.println("Toplam Fiyat: " + finalPrice + "TL");
        System.out.println("==========================\n");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Gun (1=Pzt ... 7=Paz): ");
        int gun  = input.nextInt();

        System.out.print("Saat (7-24): ");
        int saat = input.nextInt();

        System.out.print("Yasınız: ");
        int yas = input.nextInt();

        System.out.print("Meslek (1=Öğrenci, 2=Öğretmen, 3=Diğer): ");
        int meslek = input.nextInt();

        System.out.print("Film Türü (1=2D, 2=3D, 3=IMAX, 4=4DX):");
        int filmTuru = input.nextInt();

        generateTicketInfo(gun, saat, yas, meslek, filmTuru);

        input.close();
    }
}
