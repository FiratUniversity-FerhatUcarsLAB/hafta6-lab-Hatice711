/**
* Ad Soyad : Hatice KIRMIZIGÜL
* Öğrenci No : 250541102
* Proje : Öğrenci Not Değerlendirme Sistemi
* Tarih : 25.11.2025
*/   


import java.util.Scanner;

public class  OgrenciNot {

    public static double calculateAverage(int vize_notu, int final_notu, int odev_notu) {
        double ortalama = vize_notu * 0.3 + final_notu * 0.4 + odev_notu * 0.3;

        return ortalama;
    }
    public static boolean isPassingGrade(double ortalama) {

        if (ortalama >= 50) {
            return true;
        } else {
            return false;
        }
    }

       public static char getLetterGrade(double ortalama){
       char harf_notu;
        if(ortalama >= 90 && ortalama <= 100){
            harf_notu = 'A';
        }else if(ortalama >= 80 && ortalama <= 90){
            harf_notu = 'B';
        }else if(ortalama >= 70 && ortalama <= 80){
            harf_notu = 'C';
        }else if(ortalama >= 60 && ortalama <= 70){
            harf_notu = 'D';
        }else{ // 60dan küçük ise
            harf_notu = 'F';
        }
        return harf_notu;
    }


        public static boolean isHonorList(double ortalama, int vize_notu, int final_notu, int odev_notu){
            if(ortalama >= 85 && vize_notu <= 70 && final_notu <= 70 && odev_notu >= 70){
                return true;
            }else{
                return false;
            }
        }

        public static boolean hasRetakeRight(double ortalama){
            if(ortalama >= 40 && ortalama < 50){
                return true;
            }//tekrar if içine girmediği için else yazmamıza gerek yok
                return false;
        }


            public static void main(String[] args){

        Scanner ınput = new Scanner(System.in);

        System.out.print("Vize notunuzu giriniz : ");
        int vize_notu, final_notu, odev_notu;
        vize_notu = ınput.nextInt();

        System.out.print("Final Notunuzu  girin :");
        final_notu = ınput.nextInt();

        System.out.print("Ödev Notunuzu girin :");
        odev_notu = ınput.nextInt();


        System.out.println("=== OGRENCİ NOT RAPORU ===");
        System.out.println("Vize notu :"+vize_notu);
        System.out.println("Final notu :"+final_notu);
        System.out.println("Ödev notu :"+odev_notu);
        System.out.println("==============================");

        double ortalama = calculateAverage(vize_notu, final_notu, odev_notu);

        System.out.println("Ortalama : "+ortalama);
        System.out.println("Harf Notu :"+ getLetterGrade(ortalama));
        if(isPassingGrade(ortalama)) {
            System.out.println("Durum : GEÇTİ");
        }else {
            System.out.println("Durum : KALDI");
        }

        System.out.println("Onur Listesi :"+(isHonorList(ortalama, vize_notu, final_notu, odev_notu)
                 ? "EVET" : "HAYIR"));

        System.out.println("Bütünleme :"+ (hasRetakeRight(ortalama) ? "VAR" : "YOK"));

        ınput.close();

        }
    }


