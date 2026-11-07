public class BensinPertalite extends BahanBakar implements Layanan, CetakStruk {
    private double subsidiPemerintah;

    public BensinPertalite(String kodeBBM, double hargaPerLiter, double stokLiter, double subsidiPemerintah) {
        super(kodeBBM, "Pertalite", hargaPerLiter, stokLiter);
        this.subsidiPemerintah = subsidiPemerintah;
    }

    @Override
    public void tampilkanDetail() {
        System.out.printf(" [%s] %-10s | Harga: Rp%,.0f/L | Subsidi: Rp%,.0f | Sisa Stok: %.1f L%n",
                getKodeBBM(), getNamaBBM(), getHargaPerLiter(), subsidiPemerintah, getStokLiter());
    }

    @Override
    public void isiBahanBakar(double liter) {
        System.out.println("\n>>> MEMPROSES PENGISIAN PERTALITE...");
        if (getStokLiter() >= liter) {
            kurangiStok(liter);
            double total = hitungTotalHarga(liter);
            System.out.printf(" [SUCCESS] Berhasil mengisi %.1f Liter Pertalite.%n", liter);
            cetak(liter, total);
        } else {
            System.out.printf(" [FAILED] Transaksi Gagal! Stok Pertalite kurang (Sisa: %.1f L, Diminta: %.1f L)%n",
                    getStokLiter(), liter);
        }
    }

    @Override
    public void cetak(double liter, double totalBayar) {
        System.out.println("=========================================");
        System.out.println("         STRUK RESMI SPBU PERTAMINA      ");
        System.out.println("            " + NAMA_SPBU);
        System.out.println("=========================================");
        System.out.println(" Produk       : Pertalite (Subsidi)");
        System.out.printf(" Jumlah Liter : %.1f Liter%n", liter);
        System.out.printf(" Total Bayar  : Rp%,.0f%n", totalBayar);
        System.out.printf(" Sisa Stok    : %.1f Liter%n", getStokLiter());
        System.out.println("-----------------------------------------");
        System.out.println("  Terima Kasih & Selamat Jalan!  ");
        System.out.println("=========================================");
    }
}
