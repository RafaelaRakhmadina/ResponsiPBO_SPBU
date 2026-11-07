public class Main {
    public static void main(String[] args) {
        System.out.println("=========================================================");
        System.out.println("    DASHBOARD MONITORING " + BahanBakar.NAMA_SPBU);
        System.out.println("=========================================================");

        BensinPertalite pertalite = new BensinPertalite("PTL01", 10000, 30.0, 1000);
        BensinPertamax pertamax = new BensinPertamax("PTX01", 12950, 40.0, 92);
        BensinPertamaxTurbo turbo = new BensinPertamaxTurbo("TUR01", 14400, 25.0, 98);
        BioSolar solar = new BioSolar("SOL01", 6800, 100.0, "Diesel");

        System.out.println("\n--- STATUS STOK AWAL BBM ---");
        pertalite.tampilkanDetail();
        pertamax.tampilkanDetail();
        turbo.tampilkanDetail();
        solar.tampilkanDetail();

        System.out.println("\n=========================================================");
        System.out.println("               SIMULASI TRANSAKSI SPBU                   ");
        System.out.println("=========================================================");

        Layanan transaksi1 = pertalite;
        Layanan transaksi2 = pertamax;
        Layanan transaksi3 = pertalite;

        transaksi1.isiBahanBakar(20.0);
        transaksi2.isiBahanBakar(15.0);

        // Pengujian Logika Percabangan (Stok sisa 10L, minta 25L -> GAGAL)
        transaksi3.isiBahanBakar(25.0);

        System.out.println("\n=========================================================");
        System.out.println("               SIMULASI SELESAI                          ");
        System.out.println("=========================================================");
    }
}