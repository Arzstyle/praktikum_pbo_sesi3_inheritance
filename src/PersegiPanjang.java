public class PersegiPanjang extends BangunDatar{
    double panjang;
    double lebar;

    public PersegiPanjang(double panjang, double lebar){
         if( panjang <= 0 || lebar <= 0) {
              throw new IllegalArgumentException("Nilai panjang dan lebar harus lebih besar dari 0.");
         }
         this.panjang = panjang;
         this.lebar = lebar;
    }
    @Override
    public double luas(){
         return panjang * lebar;
    }
    @Override
    public double keliling(){
         return 2 * (panjang + lebar);
    }
}