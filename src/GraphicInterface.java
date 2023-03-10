import java.util.Scanner;

public class GraphicInterface {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("A continuación ingresa un numero: ");
		int numero = scanner.nextInt();
		scanner.close();
		System.out.println("El numero ingresado es: " + numero);
	}
}
