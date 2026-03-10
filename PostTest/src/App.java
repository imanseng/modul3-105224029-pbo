import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        double saldoAwal = 5000000.0;
        int menu = 0;
        
        System.out.println("Simulasi Menu ATM");
        do {
            System.out.println("Menu:");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Setor Tunai");
            System.out.println("3. Tarik Tunai");
            System.out.println("4. Keluar");
            System.out.print("Pilihan (angka): ");
            menu = input.nextInt();
            if (menu == 4) {
                break;
            }
            switch (menu) {
                case 1:
                    System.out.println("Saldo saat ini: " + saldoAwal);
                    break;
                case 2:
                    System.out.print("Masukkan jumlah setoran: ");
                    double setoran = input.nextDouble();
                    saldoAwal += setoran;
                    System.out.println("Setoran berhasil. Saldo saat ini: " + saldoAwal);
                    break;
                case 3:
                    System.out.print("Masukkan jumlah penarikan: ");
                    double penarikan = input.nextDouble();
                    if (saldoAwal - penarikan >= 50000.0) {
                        saldoAwal -= penarikan;
                        System.out.println("Penarikan berhasil. Saldo saat ini: " + saldoAwal);
                    } else {
                        System.out.println("Penarikan gagal. Saldo minimal Rp. 50.000.");
                    }
                    break;
                default:
                    break;
            }
        } while (true);
        input.close();
    }
}
