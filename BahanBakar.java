public abstract class BahanBakar {
    public static final String NAMA_SPBU = "SPBU Pertamina 34-53101";
    private final String kodeBBM;

    private String namaBBM;
    private double hargaPerLiter;
    private double stokLiter;

    public BahanBakar(String kodeBBM, String namaBBM, double hargaPerLiter) {
        this(kodeBBM, namaBBM, hargaPerLiter, 100.0);
    }

    public BahanBakar(String kodeBBM, String namaBBM, double hargaPerLiter, double stokLiter) {
        this.kodeBBM = kodeBBM;
        this.namaBBM = namaBBM;
        this.hargaPerLiter = hargaPerLiter;
        this.stokLiter = stokLiter;
    }

    public abstract void tampilkanDetail();

    public void kurangiStok(double jumlah) {
        this.stokLiter -= jumlah;
    }

    public double hitungTotalHarga(double liter) {
        return liter * this.hargaPerLiter;
    }

    public String getKodeBBM() { return kodeBBM; }
    public String getNamaBBM() { return namaBBM; }
    public void setNamaBBM(String namaBBM) { this.namaBBM = namaBBM; }
    public double getHargaPerLiter() { return hargaPerLiter; }
    public void setHargaPerLiter(double hargaPerLiter) { this.hargaPerLiter = hargaPerLiter; }
    public double getStokLiter() { return stokLiter; }
    public void setStokLiter(double stokLiter) { this.stokLiter = stokLiter; }
}
