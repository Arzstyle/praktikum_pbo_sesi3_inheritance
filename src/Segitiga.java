public final class Segitiga {
    double alas; 
    double tinggi;
    double sisiA;
    double sisiB;
    double sisiC;

    boolean isHeron = false;

    // Segitiga Siku-siku
    public Segitiga(double alas, double tinggi) {
        if (alas <= 0 || tinggi <= 0) {
            throw new IllegalArgumentException("Nilai alas dan tinggi harus lebih besar dari 0.");
        }
        this.alas = alas;
        this.tinggi = tinggi;
        this.isHeron = false;
    }

    // Segitiga Lancip dan Segitiga Tumpul
    public Segitiga(double a, double b, double angle, char type) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Sisi harus positif.");
        }
        if (angle <= 0 || angle >= 180) {
            throw new IllegalArgumentException("Nilai sudut harus lebih besar dari 0 dan kurang dari 180.");
        }

        double angleRad = Math.toRadians(angle);
        double c = Math.sqrt(a * a + b * b - 2 * a * b * Math.cos(angleRad));

        if (c <= 0 || !isValidTriangle(a, b, c)) {
            throw new IllegalArgumentException("Sisi tidak membentuk segitiga.");
        }

        this.sisiA = a;
        this.sisiB = b;
        this.sisiC = c;
        this.isHeron = true;

        if (type == 'L' && angle >= 90) {
            throw new IllegalArgumentException("Sudut harus kurang dari 90° untuk Segitiga Lancip.");
        } else if (type == 'T' && angle <= 90) {
            throw new IllegalArgumentException("Sudut harus lebih dari 90° untuk Segitiga Tumpul.");
        }
    }

    public double luas() {
        if (isHeron) {
            double s = (sisiA + sisiB + sisiC) / 2;
            return Math.sqrt(s * (s - sisiA) * (s - sisiB) * (s - sisiC));
        } else {
            return 0.5 * alas * tinggi;
        }
    }

    public double keliling() {
        if (isHeron) {
            return sisiA + sisiB + sisiC;
        } else {
            double sisiMiring = Math.sqrt(alas * alas + tinggi * tinggi);
            return alas + tinggi + sisiMiring;
        }
    }

    boolean isValidTriangle(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a) && (a > 0) && (b > 0) && (c > 0);
    }
}
