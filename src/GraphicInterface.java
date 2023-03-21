import java.util.Scanner;

public class GraphicInterface {
	public static void main(String[] args) {
		int opcionPrincipal;

		System.out.println("1. Convertidor de monedas");
		System.out.println("2. Convertidor de temperatura");
		System.out.print(((char) 10) + "Selecciona el tipo de convertidor: ");

		Scanner scanner = new Scanner(System.in);

		opcionPrincipal = Integer.parseInt(scanner.nextLine());

		switch (opcionPrincipal) {
		case 1:
			int opcionMoneda;
			double cantidadInicial;
			//double cantidadEquivalente;
			System.out.println("1. Peso Mexicano -> Dollar");
			System.out.println("2. Peso Mexicano -> Euro");

			System.out.print("Selecciona opcion: ");

			opcionMoneda = Integer.parseInt(scanner.nextLine());
			System.out.print("Ingresa la cantidad inicial: ");
			cantidadInicial = Double.parseDouble(scanner.nextLine());

			switch (opcionMoneda) {
			case 1:
				System.out.println("Cantidad inicial: " + cantidadInicial);
				System.out.println("Cantidad en dolares: " + cantidadInicial * 20);
				break;
			case 2:
				System.out.println("Cantidad inicial: " + cantidadInicial);
				System.out.println("Cantidad en dolares: " + cantidadInicial * 23);
				break;
			}

		case 2:
			System.out.println("Haz seleccionado la segunda opcion");
			break;
		default:
			break;

		}
		scanner.close();
	}
}
