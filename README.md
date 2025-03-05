# 📚 OOP Practicum: Bangun Datar (Shapes) Implementation Guide

## 📑 Daftar Isi
- [1. Konsep OOP dalam Implementasi](#1-konsep-oop-dalam-implementasi-)
- [2. Penjelasan Kode](#2-penjelasan-kode-)
  - [2.1. BangunDatar.java](#21-bangundatarjava-)
  - [2.2. BujurSangkar.java](#22-bujursangkarjava-)
  - [2.3. PersegiPanjang.java](#23-persegipanjangjava-)
  - [2.4. Segitiga.java](#24-segitigajava-)
- [3. Referensi](#3-referensi-)

---

## 1. Konsep OOP dalam Implementasi 🧩
Implementasi ini menggunakan 4 prinsip OOP:
1. **Encapsulation**: Variabel seperti `sisi`, `panjang`, dan `tinggi` dienkapsulasi dalam kelas.
2. **Inheritance**: `BujurSangkar` dan `PersegiPanjang` mewarisi `BangunDatar`.
3. **Polymorphism**: Override method `luas()` dan `keliling()` di setiap subclass.
4. **Abstraction**: Kelas `BangunDatar` bertindak sebagai template umum.

[🔙 Kembali ke Daftar Isi](#-daftar-isi)

---

## 2. Penjelasan Kode 💻

### 2.1. BangunDatar.java 🟦
#### Struktur Utama
- **Fungsi**: Kelas abstrak untuk menghitung luas dan keliling bangun datar.
- **Variabel**:
  - `luas` dan `keliling`: Menyimpan hasil perhitungan.
- **Method**:
  - `luas()` dan `keliling()`: Mengembalikan nilai luas/keliling (di-override di subclass).
 
```java
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
```


#### Implementasi Main
- **Alur Program**:
  1. Menampilkan menu pilihan bangun datar.
  2. Menerima input pengguna menggunakan `Scanner`.
  3. Membuat objek sesuai pilihan:
     - `BujurSangkar` untuk persegi.
     - `PersegiPanjang` untuk persegi panjang.
     - `Segitiga` dengan logika khusus untuk 3 tipe segitiga.

[🔙 Kembali ke Daftar Isi](#-daftar-isi)

---

### 2.2. BujurSangkar.java 🟨
#### Fitur Khusus
- **Validasi Input**: Memastikan `sisi` > 0 dengan `IllegalArgumentException`.
- **Override Method**:
  ```java
  @Override
  public double luas() { return sisi * sisi; }
  ```
  ```java
  @Override
  public double keliling() { return 4 * sisi; }
  ```
- **Constructor**:
  ```java
  public BujurSangkar(double sisi) {
    if (sisi <= 0) throw new IllegalArgumentException("...");
    this.sisi = sisi;
  }
  ```

[🔙 Kembali ke Daftar Isi](#-daftar-isi)

---

### 2.3. PersegiPanjang.java 🟧
#### Perbedaan dengan BujurSangkar
- **Parameter Ganda**: Menerima `panjang` dan `lebar`.
- **Validasi Ganda**:
  ```java
  if (panjang <= 0 || lebar <= 0) {
    throw new IllegalArgumentException("...");
  }
  ```
- **Rumus Keliling**:
  ```java
  @Override
  public double keliling() { return 2 * (panjang + lebar); }
  ```

[🔙 Kembali ke Daftar Isi](#-daftar-isi)

---

### 2.4. Segitiga.java 📐
#### Konstruktor Fleksibel
1. **Segitiga Siku-Siku**:
   ```java
   public Segitiga(double alas, double tinggi) { ... }
   ```
   - Menggunakan rumus `0.5 * alas * tinggi`.

2. **Segitiga Lancip/Tumpul**:
   ```java
   public Segitiga(double a, double b, double angle, char type) { ... }
   ```
   - Menghitung sisi ke-3 dengan **Hukum Cosinus**.
   - Validasi sudut sesuai tipe (`L` untuk lancip, `T` untuk tumpul).

#### Metode Khusus
- **Luas dengan Heron**:
  ```java
  double s = (sisiA + sisiB + sisiC) / 2;
  return Math.sqrt(s * (s - sisiA) * (s - sisiB) * (s - sisiC));
  ```
- **Validasi Segitiga**:
  ```java
  boolean isValidTriangle(double a, double b, double c) { ... }
  ```

[🔙 Kembali ke Daftar Isi](#-daftar-isi)

---

## 3. Referensi 📖
- [Java Documentation](https://docs.oracle.com/en/java/)
- [OOP Concepts in Java](https://www.geeksforgeeks.org/object-oriented-programming-oops-concept-in-java/)
- [Heron's Formula](https://en.wikipedia.org/wiki/Heron%27s_formula)

[🔙 Kembali ke Daftar Isi](#-daftar-isi)
