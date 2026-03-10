import java.util.Scanner;

public class Latihan1 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan angka a: ");
        double a = input.nextInt();
        System.out.print("Masukkan angka b: ");
        double b = input.nextInt();
        System.out.print("Masukkan Operator Pilihan (+, -, *, /): ");
        char operator = input.next().charAt(0);

        switch (operator) {
            case '+':
                System.out.println("Hasil penjumlahan: " + (a + b));
                break;
            case '-':
                System.out.println("Hasil pengurangan: " + (a - b));
                break;
            case '*':
                System.out.println("Hasil perkalian: " + (a * b));
                break;
            case '/':
                if (b != 0) {
                    System.out.println("Hasil pembagian: " + (a / b));
                } else {
                    System.out.println("Error: Pembagian dengan nol tidak diizinkan.");
                }
                break;
            default:
                System.out.println("Operator tidak valid.");
        }
        input.close();
    }
}
