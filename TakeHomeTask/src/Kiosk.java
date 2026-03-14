import java.util.Scanner;

// Nama : Iman Dwi Satrio
// NIM : 105224029
// Take Home Task Modul 3

public class Kiosk {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Inisialisasi Stok dan Harga
        int stokTiketVIP = 5, stokTiketFestival = 25, stokTiketTribune = 35;
        int hargaTiketVIP = 1500000, hargaTiketFestival = 800000, hargaTiketTribune = 500000;
        boolean mesinAktif = true;

        while (mesinAktif) {
            // Tampilan Menu Utama
            System.out.println("-- KIOSK SOUNDFEST 2026 --");
            System.out.println("Sisa Stok Tiket:");
            System.out.println("[1] VIP      : Rp " + hargaTiketVIP + " (Stok: " + stokTiketVIP + ")");
            System.out.println("[2] Festival : Rp " + hargaTiketFestival + " (Stok: " + stokTiketFestival + ")");
            System.out.println("[3] Tribune  : Rp " + hargaTiketTribune + " (Stok: " + stokTiketTribune + ")");
            System.out.println("[4] Matikan Mesin");

            System.out.print("Pilih Menu: ");
            int menuPilihan = input.nextInt();

            // Variabel temporer
            int stokTiket = 0, hargaTiket = 0, syaratUsia = 0;
            String namaKategori = "";
            boolean pilihanValid = true;

            switch (menuPilihan) {
                case 1: // Pilihan VIP
                    stokTiket = stokTiketVIP;
                    hargaTiket = hargaTiketVIP;
                    syaratUsia = 18;
                    namaKategori = "VIP";
                    break;
                case 2: // Pilihan Festival
                    stokTiket = stokTiketFestival;
                    hargaTiket = hargaTiketFestival;
                    syaratUsia = 15;
                    namaKategori = "Festival";
                    break;
                case 3: // Pilihan Tribune
                    stokTiket = stokTiketTribune;
                    hargaTiket = hargaTiketTribune;
                    syaratUsia = 0;
                    namaKategori = "Tribune";
                    break;
                case 4: // Pilihan Matikan Mesin
                    System.out.println("Mesin dimatikan!");
                    mesinAktif = false;
                    pilihanValid = false;
                    break;
                default: // Pilihan tidak valid (validasi pilihan)
                    System.out.println("Pilihan tidak tersedia.");
                    pilihanValid = false;
                    break;
            }

            // Jika pilihan tidak valid atau mematikan mesin, lewati proses pembelian
            if (pilihanValid == false) {
                continue;
            }

            System.out.print("Masukkan jumlah tiket yang ingin dibeli: ");
            int jumlahBeli = input.nextInt();

            // Cek Persediaan
            if (jumlahBeli > stokTiket) {
                System.out.println("ERROR: Stok tidak cukup! (Sisa stok " + namaKategori + ": " + stokTiket + ")");
                continue;
            }

            int berhasilBeli = 0;
            boolean statusBatal = false;

            // Verifikasi Usia satu per satu
            for (int i = 1; i <= jumlahBeli; i++) {
                int usia;
                while (true) {
                    System.out.print("Masukkan usia untuk Tiket ke-" + i + " (Ketik -1 untuk batal): ");
                    usia = input.nextInt();

                    if (usia == -1) {
                        System.out.println("Sinyal 'Batal Darurat' diterima. Pesanan dihentikan.");
                        statusBatal = true;
                        break;
                    }

                    if (usia <= 0 || usia > 120) {
                        System.out.println("Usia tidak logis. Silakan masukkan kembali.");
                    } else {
                        break;
                    }
                }

                if (statusBatal == true) {
                    break;
                }

                if (usia >= syaratUsia) {
                    System.out.println("Tiket ke-" + i + " Berhasil diverifikasi.");
                    berhasilBeli++;
                } else {
                    System.out.println("Tiket ke-" + i + " Gagal. Usia minimal " + syaratUsia + " tahun.");
                }
            }

            // Finalisasi Transaksi
            if (!statusBatal && berhasilBeli > 0) {
                int totalTagihan = berhasilBeli * hargaTiket;
                System.out.println("-- NOTA PEMBAYARAN --");
                System.out.println("Kategori      : " + namaKategori);
                System.out.println("Tiket Berhasil: " + berhasilBeli);
                System.out.println("Total Tagihan : Rp " + totalTagihan);
                
                // Update Stok
                switch (menuPilihan) {
                    case 1:
                        stokTiketVIP -= berhasilBeli;
                        break;
                    case 2:
                        stokTiketFestival -= berhasilBeli;
                        break;
                    case 3:
                        stokTiketTribune -= berhasilBeli;
                        break;
                    default:
                        break;
                }
            } else if (!statusBatal) {
                System.out.println("Tidak ada tiket yang diproses.");
            }
        }
        input.close();
    }
}
