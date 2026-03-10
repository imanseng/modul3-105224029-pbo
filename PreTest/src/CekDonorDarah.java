import java.util.Scanner;

// Iman Dwi Satrio (105224029)
// PreTest Modul 3

public class CekDonorDarah {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Program Seleksi Donor Darah");
        System.out.print("Masukkan Usia: ");
        int usia = input.nextInt();
        System.out.print("Masukkan Berat Badan (kg): ");
        double beratBadan = input.nextDouble();
        System.out.print("Masukkan Kadar Hemoglobin: ");
        double kadarHemoglobin = input.nextDouble();

        if (usia >= 17 && usia <= 60) {
            if (beratBadan >= 45.0) {
                if (kadarHemoglobin >= 11.0 && kadarHemoglobin <= 17.0) {
                    System.out.println("Anda boleh donor darah.");
                } else {
                    System.out.println("Anda ditolak karena kadar Hemoglobin tidak memenuhi syarat.");
                }
            } else {
                System.out.println("Anda ditolak karena berat badan minimal harus 45 kg.");
            }
        } else {
            System.out.println("Anda ditolak karena usia harus di rentang 17 hingga 60 tahun.");
        }
        input.close();
    }
}
