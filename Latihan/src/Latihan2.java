import java.util.Scanner;

public class Latihan2{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int PIN = 1234, i = 1;

        System.out.print("Masukkan PIN: ");
        int inputPIN = input.nextInt();

        while (i < 4) {
            if (inputPIN == PIN) {
                System.out.println("PIN Benar");
                break;
            }
            if (i == 3) {
                System.out.println("Akun diblokir");
                break;
            }
            i++;
            System.out.println("PIN Salah");
            System.out.print("Masukkan PIN: ");
            inputPIN = input.nextInt();
        }
        input.close();
    }
}