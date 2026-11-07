public class BensinPertamaxTurbo extends BahanBakar implements Layanan, CetakStruk {
    private int oktan;

    public BensinPertamaxTurbo(String kodeBBM, double hargaPerLiter, double stokLiter, int oktan) {
        super(kodeBBM, "Pertamax Turbo", hargaPerLiter, stokLiter);
        this.oktan = oktan;
    }

    @Override
    public void tampilkanDetail() {
        System.out.printf(" [%s] %-14s (RON %d) | Harga: Rp%,.0f/L | Sisa Stok: %.1f L%n",
                getKodeBBM(), getNamaBBM(), oktan, getHargaPerLiter(), getStokLiter());
    }

    @Override
    public void isiBahanBakar(double liter) {
        System.out.println("\n>>> MEMPROSES PENGISIAN PERTAMAX TURBO...");
        if (getStokLiter() >= liter) {
            kurangiStok(liter);
            double total = hitungTotalHarga(liter);
            System.out.printf(" [SUCCESS] Berhasil mengisi %.1f Liter Pertamax Turbo.%n", liter);
            cetak(liter, total);
        } else {
            System.out.printf(" [FAILED] Transaksi Gagal! Stok Pertamax Turbo kurang (Sisa: %.1f L)%n", getStokLiter());
        }
    }

    @Override
    public void cetak(double liter, double totalBayar) {
        System.out.println("=========================================");
        System.out.println("         STRUK RESMI SPBU PERTAMINA      ");
        System.out.println("            " + NAMA_SPBU);
        System.out.println("=========================================");
        System.out.println(" Produk       : Pertamax Turbo (RON " + oktan + ")");
        System.out.printf(" Jumlah Liter : %.1f Liter%n", liter);
        System.out.printf(" Total Bayar  : Rp%,.0f%n", totalBayar);
        System.out.printf(" Sisa Stok    : %.1f Liter%n", getStokLiter());
        System.out.println("-----------------------------------------");
        System.out.println("  Terima Kasih & Selamat Jalan!  ");
        System.out.println("=========================================");
    }
}
