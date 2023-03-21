import java.util.HashMap;
import javax.swing.JOptionPane;

public class TestDivisas {
	public static String nombreDeApp = "Conversiones.com";
	
	public static HashMap<String, Double> divisas = new HashMap<>();

	public static void main(String[] args) {

		String opciones[] = { "Conversor de Monedas", "Conversor de Temperatura" };

		do {
		String opcionSeleccionada = (String) JOptionPane.showInputDialog(null, "Elige Conversor", nombreDeApp,
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		
			switch (opcionSeleccionada) {
			case "Conversor de Monedas":
				conversorDeMonedas();
				break;
			case "Conversor de Temperatura":
				conversorTemperatura();
				break;
			}
		}while(true);
	}

	public static void conversorDeMonedas() {
		//Declaramos las divisas
		String opciones[] = { "Peso - MXN", "Dollar - USD", "Euro - EUR", "Libra Esterlina -GBP", 
				"Yen Japones - JPY", "Won sul-coreano - KRW"};
		
		divisas.put(opciones[0], 1.00);
		divisas.put(opciones[1], 0.053);
		divisas.put(opciones[2], 0.050);
		divisas.put(opciones[3], 0.043);
		divisas.put(opciones[4], 6.98);
		divisas.put(opciones[5], 69.36);
		

		String monedaPrincipal = (String) JOptionPane.showInputDialog(null, "Elige tu moneda", nombreDeApp,
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		boolean error = false;
		double cantidadDinero = 0.0;
		do {
			error = false;
			try {
				cantidadDinero = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Ingresa la cantidad",
						nombreDeApp, JOptionPane.QUESTION_MESSAGE, null, null, null));
			} catch (NumberFormatException nfe) {
				error = true;
				JOptionPane.showMessageDialog(null, "Haz ingresado una cantidad inválida. Vuelve a intentarlo",
						nombreDeApp, JOptionPane.INFORMATION_MESSAGE, null);
			}
		} while (error);

		String monedaBuscada = (String) JOptionPane.showInputDialog(null, "¿A qué moneda haremos tu conversion?",
				nombreDeApp, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		double valorEquivalente = operacionConversion(monedaPrincipal, monedaBuscada, cantidadDinero);

		String mensaje = "El resultado es: " + String.format("%.2f", valorEquivalente);

		JOptionPane.showMessageDialog(null, mensaje, nombreDeApp, JOptionPane.INFORMATION_MESSAGE, null);
	}

	public static double operacionConversion(String monedaPrincipal, String monedaBuscada, double cantidadDinero) {
		return (cantidadDinero*divisas.get(monedaBuscada))/divisas.get(monedaPrincipal);
	}
	
	public static void conversorTemperatura() {
		String opciones[] = { "Celsius - °C", "Fahrenheit - °F", "Kelvin - K"};
		
		String escalaPrincipal = (String) JOptionPane.showInputDialog(null, "Elige la escala principal", nombreDeApp,
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		boolean error = false;
		double temperatura = 0.0;
		do {
			error = false;
			try {
				temperatura = Double.parseDouble((String) JOptionPane.showInputDialog(null, "Ingresa temperatura",
						nombreDeApp, JOptionPane.QUESTION_MESSAGE, null, null, null));
			} catch (NumberFormatException nfe) {
				error = true;
				JOptionPane.showMessageDialog(null, "Haz ingresado una cantidad inválida. Vuelve a intentarlo",
						nombreDeApp, JOptionPane.INFORMATION_MESSAGE, null);
			}
		} while (error);

		String escalaBuscada = (String) JOptionPane.showInputDialog(null, "¿A qué escala haremos tu conversion?",
				nombreDeApp, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		double valorEquivalente = conversionTemperatura(escalaPrincipal, escalaBuscada, temperatura);

		String mensaje = "La temperatura esquivalente es: " + String.format("%.2f", valorEquivalente);

		JOptionPane.showMessageDialog(null, mensaje, nombreDeApp, JOptionPane.INFORMATION_MESSAGE, null);
	}
	
	public static double conversionTemperatura(String escalaPrincipal, String escalaBuscada, double temperatura) {

		switch (escalaPrincipal) {

		case "Celsius - °C":
			switch (escalaBuscada) {
			case "Fahrenheit - °F":
				return ((9 * temperatura) / 5) + 32;
			case "Kelvin - K":
				return temperatura + 273.15;
			default:
				return temperatura;
			}

		case "Fahrenheit - °F":
			switch (escalaBuscada) {
			case "Celsius - °C":
				return (5 * (temperatura - 32)) / 9;
			case "Kelvin - K":
				return ((5 * (temperatura - 32)) / 9) + 273.15;
			default:
				return temperatura;
			}

		default:
			switch (escalaBuscada) {
			case "Celsius - °C":
				return temperatura - 273.15;
			case "Fahrenheit - °F":
				return ((9 * (temperatura - 273.15)) / 5) + 32;
			default:
				return temperatura;
			}
		}

	}

}
