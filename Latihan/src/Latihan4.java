import java.util.Scanner;

public class Latihan4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nilai ujian akhir: ");
        int nilai = input.nextInt();
        System.out.print("Masukkan persentase kehadiran (contoh: 80.4): ");
        double persentase = input.nextDouble();
        String hasil = (nilai >= 75 && persentase > 80.0) ? "Lulus" : "Tidak Lulus";
        System.out.println(hasil);
        input.close();}
}
