import java.util.Scanner;

public class BangunDatar {
    double luas;
    double keliling;

    public double luas() {
        return luas;
    }

    public double keliling() {
        return keliling;
    }

    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("Silahkan Pilih Bangun Datar yang Ingin Anda Hitung:");
        System.out.println("1. Bujur Sangkar");
        System.out.println("2. Persegi Panjang");
        System.out.println("3. Segitiga");
        System.out.println("=====================================");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Silahkan Mengisikan Pilihan: ");
            int pilihan = scanner.nextInt();

            if (pilihan == 1) {
                System.out.print("Masukkan panjang sisi: ");
                double sisi = scanner.nextDouble();
                BujurSangkar bs = new BujurSangkar(sisi);
                System.out.println("Luas: " + bs.luas());
                System.out.println("Keliling: " + bs.keliling());

            } else if (pilihan == 2) {
                System.out.print("Masukkan panjang: ");
                double panjang = scanner.nextDouble();
                System.out.print("Masukkan lebar: ");
                double lebar = scanner.nextDouble();
                PersegiPanjang pp = new PersegiPanjang(panjang, lebar);
                System.out.println("Luas: " + pp.luas());
                System.out.println("Keliling: " + pp.keliling());

            } else if (pilihan == 3) {
                System.out.println("Pilih Tipe Segitiga:");
                System.out.println("1. Segitiga Siku-siku (alas & tinggi)");
                System.out.println("2. Segitiga Lancip");
                System.out.println("3. Segitiga Tumpul");
                System.out.print("Masukkan tipe segitiga: ");
                int tipeSegitiga = scanner.nextInt();

                Segitiga segitiga = null;

                if (tipeSegitiga == 1) {
                    System.out.print("Masukkan alas: ");
                    double alas = scanner.nextDouble();
                    System.out.print("Masukkan tinggi: ");
                    double tinggi = scanner.nextDouble();
                    segitiga = new Segitiga(alas, tinggi);

                } else if (tipeSegitiga == 2 || tipeSegitiga == 3) {
                    System.out.print("Masukkan sisi A: ");
                    double sisiA = scanner.nextDouble();
                    System.out.print("Masukkan sisi B: ");
                    double sisiB = scanner.nextDouble();
                    System.out.print("Masukkan sudut di antara A dan B (derajat): "); // Jika memilih segitiga tumpul maka input derajat harus > 90 derajat & jika memilih segitiga lancip maka input derajat harus < 90 derajat
                    double sudut = scanner.nextDouble();
                    segitiga = new Segitiga(sisiA, sisiB, sudut, tipeSegitiga == 2 ? 'L' : 'T');

                } else {
                    System.out.println("Pilihan tipe segitiga tidak valid!");
                }

                if (segitiga != null) {
                    System.out.println("Luas: " + segitiga.luas());
                    System.out.println("Keliling: " + segitiga.keliling());
                }

            } else {
                System.out.println("Pilihan tidak tersedia");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
