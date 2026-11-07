public class BioSolar extends BahanBakar implements Layanan, CetakStruk {
    private String tipeMesin;

    public BioSolar(String kodeBBM, double hargaPerLiter, double stokLiter, String tipeMesin) {
        super(kodeBBM, "Bio Solar", hargaPerLiter, stokLiter);
        this.tipeMesin = tipeMesin;
    }

    @Override
    public void tampilkanDetail() {
        System.out.printf(" [%s] %-10s (%s) | Harga: Rp%,.0f/L | Sisa Stok: %.1f L%n",
                getKodeBBM(), getNamaBBM(), tipeMesin, getHargaPerLiter(), getStokLiter());
    }

    @Override
    public void isiBahanBakar(double liter) {
        System.out.println("\n>>> MEMPROSES PENGISIAN BIO SOLAR...");
        if (getStokLiter() >= liter) {
            kurangiStok(liter);
            double total = hitungTotalHarga(liter);
            System.out.printf(" [SUCCESS] Berhasil mengisi %.1f Liter Bio Solar.%n", liter);
            cetak(liter, total);
        } else {
            System.out.printf(" [FAILED] Transaksi Gagal! Stok Bio Solar kurang (Sisa: %.1f L)%n", getStokLiter());
        }
    }

    @Override
    public void cetak(double liter, double totalBayar) {
        System.out.println("=========================================");
        System.out.println("         STRUK RESMI SPBU PERTAMINA      ");
        System.out.println("            " + NAMA_SPBU);
        System.out.println("=========================================");
        System.out.println(" Produk       : Bio Solar (" + tipeMesin + ")");
        System.out.printf(" Jumlah Liter : %.1f Liter%n", liter);
        System.out.printf(" Total Bayar  : Rp%,.0f%n", totalBayar);
        System.out.printf(" Sisa Stok    : %.1f Liter%n", getStokLiter());
        System.out.println("-----------------------------------------");
        System.out.println("  Terima Kasih & Selamat Jalan!  ");
        System.out.println("=========================================");
    }
}