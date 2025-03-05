public class BujurSangkar extends BangunDatar {
    double sisi;

    public BujurSangkar( double sisi){
         if (sisi <= 0) {
              throw new IllegalArgumentException("Nilai sisi harus lebih dari 0");
         }
         this.sisi = sisi;
    }
    @Override
    public double luas(){
         return sisi * sisi;
    }
    @Override
    public double keliling(){
         return 4 * sisi;
    }
}