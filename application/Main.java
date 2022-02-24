package application;

import java.util.Locale;
import java.util.Scanner;

import entities.*;

public class Main {

	public static void main(String[] args) {

		// AulaIODefault();
		// AulaScope();
		// AulaDebug();
		// AulaBitWise();
		// AulaFunctions();
		// InTriangleData();
		ProductApp();
		// RectangleApp();
		// EmployeeApp();
		// StudentApp();
		// CalcApp();
		// aulaCotacaoDolar();

	}

	public static void aulaCotacaoDolar() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		double priceReais = 0;
		double amountReais = 0;
		System.out.println("Wellcome!!!!");

		System.out.print("Enter the dolar price: ");
		CurrencyConvert.dollarPrice = sc.nextDouble();

		System.out.print("How many dollars will be bought: ");
		amountReais = sc.nextDouble();

		// processing
		priceReais = amountReais * CurrencyConvert.dollarPrice;
		priceReais = priceReais + (priceReais * CurrencyConvert.percentage);

		System.out.printf("Amount to be paid in reais: %.2f%n", priceReais);
		sc.close();

	}

	public static void CalcApp() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Wellcome!!!!");

		System.out.print("Enter radius: ");
		double radius = sc.nextDouble();

		double c = CalculatorStaticMembers.circumference(radius); // teste de classe estatática
		double v = CalculatorStaticMembers.volume(radius);// teste de classe estatática

		System.out.printf("Circumference: %.2f%n", c);
		System.out.printf("Volume: %.2f%n", v);
		System.out.printf("PI Value: %.2f%n", CalculatorStaticMembers.PI);

		sc.close();
	}

	public static void StudentApp() {
		Student student = new Student();

		student.EnterGrades();
	}

	public static void EmployeeApp() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		String message;
		Employee emp = new Employee();
		System.out.println("Wellcome!!!!");

		System.out.println("Enter data of employee:");
		System.out.print("Name: ");
		emp.name = sc.next();
		System.out.print("Grass Salary: ");
		emp.grossSalary = sc.nextDouble();
		System.out.print("Tax of salary: ");
		emp.tax = sc.nextDouble();

		message = "Employee Name: " + emp.name + "\n" +
				"Gross Salary: $ " + String.format("%.2f", emp.grossSalary) +
				"\n\nWhitch percentage to increase salary?\n";

		System.out.println(message);

		System.out.print("Percentage (%): ");
		double perc = sc.nextDouble();
		emp.IncreaseSalary(perc);

		message = "Updating Data...\n" +
				"\nName employee: " + emp.name +
				"\nGross Salary: " + emp.grossSalary +
				"\nSalary (tax over gross salary): " + emp.NetSalary();

		System.out.println(message);
		sc.close();

	}

	public static void RectangleApp() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		String message;
		Rectangle r = new Rectangle();
		System.out.println("Wellcome!!!!");

		System.out.println("Enter measures of rectangle.");
		System.out.print("Width: ");
		r.width = sc.nextDouble();
		System.out.print("Height: ");
		r.height = sc.nextDouble();
		System.out.println("Calculating...\n");

		message = "Rectangle Data!\n" +
				"Area: " + String.format("%.2f", r.Area()) + "m²\n" +
				"Perimeter: " + String.format("%.2f", r.Perimeter()) + "m\n" +
				"Diagonal: " + String.format("%.2f", r.Diagonal()) + "m\n" +
				">>";
		System.out.println(message);

		sc.close();

	}

	public static void ProductApp() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		double price = 0;
		int opt = 0;
		int quantityToDel = 0;
		int quantity = 0;
		String name = "";
		Product product = new Product(name, price, quantity);

		System.out.println("Wellcome!!!!");

		do {
			System.out.print(
					"Select:\n1 - Insert Product.\n2 - Add product quantity.\n3 - Remove product quantity.\n4 - Update product price.\n5 - Search Produtc.\n0 - Exit.\n\nEnter: ");
			opt = sc.nextInt();

			switch (opt) {
				case 1:
					// 1 - Insert Product
					System.out.println("Enter product data.");
					System.out.print("Name: ");
					name = sc.next();
					product.setName(name);

					do {
						System.out.print("Price: ");
						price = sc.nextDouble();
						if (price <= 0) {
							System.out.println("Price not allowed! Try another one.");
						} else {
							product.setPrice(price);
						}
					} while (price <= 0);

					do {
						System.out.print("Quantity: ");
						quantity = sc.nextInt();
						if (quantity <= 0) {
							System.out.println("Quantity not allowed. Try another one.");
						} else {
							product.setQuantity(quantity);
						}
					} while (quantity <= 0);

					System.out.println(product);
					break;
				case 2:
					if (product.getName() != "") {
						// 2 - Add product quantity
						System.out.println(
								"Quantity now: " + product.getQuantity()
										+ "\nEnter the product quantity to add stock.");
						System.out.print("Quantity: ");
						quantity = product.getQuantity() + sc.nextInt();
						product.setQuantity(quantity);
						product.MessageCreator();
					} else {
						System.out.println("No product avaible!");
					}
					break;
				case 3:
					// 3 - Remove product quantity
					if (product.getQuantity() > 0) {
						System.out.println("Quantity now: " + product.getQuantity()
								+ "\nEnter the product quantity to remove from stock.");
						System.out.print("Quantity to remove: ");
						quantityToDel = sc.nextInt();

						if ((product.getQuantity() - quantityToDel) < 0) {
							System.out.println("Quantity is not enought to be decrease!");
						} else {
							quantity = product.getQuantity() - quantityToDel;
							product.setQuantity(quantity);
							product.MessageCreator();
						}
					} else {
						System.out.println("No product avaible!");
					}
					break;
				case 4:
					if (product.getName() != "") {
						// 4 - Update product price
						System.out.print("Price now: " + product.getPrice() + "\nEnter the product new price: ");
						price = sc.nextDouble();
						product.setPrice(price);
						product.MessageCreator();
					} else {
						System.out.println("No product avaible!");
					}
					break;
				case 5:
					if (product.getName() != "") {
						product.MessageCreator();
					} else {
						System.out.println("No product avaible!");
					}
					break;
				case 0:
					System.out.println("Exiting... OK! :)");
					break;

				default:
					// message error in case not from 1 to 5 opt
					System.out.println(
							"ERROR!\nTry another option!");
					break;
			}
		} while (opt != 0);

		sc.close();

	}

	public static void InTriangleData() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		/*
		 * 
		 * // **************TRIANGLES WITHOUT OBJ********** // Triangle X double xA, xB,
		 * xC;
		 * 
		 * // Triangle Y double yA, yB, yC;
		 * 
		 * System.out.println("Triangle Without Class!");
		 * System.out.println("Enter the measure of triangle X:");
		 * System.out.print("xA: "); xA = sc.nextDouble(); System.out.print("xB: "); xB
		 * = sc.nextDouble(); System.out.print("xC: "); xC = sc.nextDouble();
		 * System.out.println("Triangle X OK!"); System.out.println(" ");
		 * 
		 * System.out.println("Enter the measure of triangle Y:");
		 * System.out.print("yA: "); yA = sc.nextDouble(); System.out.print("yB: "); yB
		 * = sc.nextDouble(); System.out.print("yC: "); yC = sc.nextDouble();
		 * System.out.println("Triangle y OK!"); System.out.println(" ");
		 * 
		 * double pX = (xA + xB + xC) / 2.0; double areaX = Math.sqrt(pX * (pX - xA) *
		 * (pX - xB) * (pX - xC));
		 * 
		 * double pY = (yA + yB + yC) / 2.0; double areaY = Math.sqrt(pY * (pY - yA) *
		 * (pY - yB) * (pY - yC));
		 * 
		 * System.out.printf("Triangle X area: %.4f%n", areaX);
		 * System.out.printf("Triangle Y area: %.4f%n", areaY); System.out.println(" ");
		 * 
		 * if (areaX > areaY) System.out.println("Larger area: X"); else
		 * System.out.println("Larger area: Y");
		 * 
		 */

		// Triangle with Obj
		Triangle x, y;

		x = new Triangle();
		y = new Triangle();

		System.out.println("Triangle With Class!");

		// Triangle X
		System.out.println("Enter the measure of triangle X:");
		System.out.print("xA: ");
		x.a = sc.nextDouble();

		System.out.print("xB: ");
		x.b = sc.nextDouble();

		System.out.print("xC: ");
		x.c = sc.nextDouble();

		System.out.println("Triangle X OK!");
		System.out.println(" ");

		// Trinagle Y
		System.out.println("Enter the measure of triangle Y:");
		System.out.print("yA: ");
		y.a = sc.nextDouble();

		System.out.print("yB: ");
		y.b = sc.nextDouble();

		System.out.print("yC: ");
		y.c = sc.nextDouble();

		System.out.println("Triangle Y OK!");
		System.out.println(" ");

		// processing...
		double areaX = x.area();
		System.out.printf("Triangle X area: %.4f%n", areaX);

		double areaY = y.area();
		System.out.printf("Triangle Y area: %.4f%n", areaY);

		if (areaX > areaY)
			System.out.println("Larger area: X");
		else
			System.out.println("Larger area: Y");

		sc.close();
	}

	public static void AulaFunctions() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// in this test I'm using the static mode, so no need to be used obj
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int higher = AulaFunctions_max(a, b, c);
		AulaFunctions_showResult(higher);

		sc.close();
	}

	public static void AulaFunctions_showResult(int a) {
		System.out.println("The higher value is: " + a);
	}

	public static int AulaFunctions_max(int x, int y, int z) {
		int aux;

		if (x > y && x > z) {
			aux = x;
		} else if (y > z) {
			aux = y;
		} else {
			aux = z;
		}

		return aux;
	}

	public static void AulaBitWise() {
		int n1 = 89;
		int n2 = 60;

		System.out.println(n1 & n2);
		System.out.println(n1 | n2);
		System.out.println(n1 ^ n2);

		try (Scanner sc = new Scanner(System.in)) {
			int mask = 0b00100000; // 6th bit in this binary is false = 0
			int n = sc.nextInt();

			if ((n & mask) != 0) {
				System.out.println("6th bit is true!");
			} else {
				System.out.println("6th bit is false!");
			}
		}
	}

	public static void AulaDebug() {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// Data In
		double largura = sc.nextDouble();
		double comprimento = sc.nextDouble();
		double metroQuadrado = sc.nextDouble(); // crtl+shift+b to insert the toggle Break Point on the conde line or
												// double click

		// Process
		double area = largura * comprimento;
		double preco = area * metroQuadrado;

		// Data Out
		System.out.printf("AREA = %.2f%n", area);
		System.out.printf("PRECO = %.2f%n", preco);
		sc.close();
	}

	public static void AulaIODefault() {

		Locale.setDefault(Locale.US); // se liberada essa linha o formato fica com ponto e não com vírgula
		Scanner sc = new Scanner(System.in);

		// Leitura de um double
		/*
		 * double x; x = sc.nextDouble();
		 * 
		 * System.out.println("Você digitou: "+ x);
		 * System.out.printf("Você digitou: %.2f%n", x);
		 */

		// Leitura de um char
		/*
		 * char c = sc.next().charAt(0);// pega somente o primeiro caractere.
		 * System.out.println("Você digitou: "+ c);
		 */

		// **** varios dados na mesma linha
		/*
		 * String a; int b; double c;
		 * 
		 * a = sc.next(); b = sc.nextInt(); c = sc.nextDouble();
		 * 
		 * System.out.println("Dados digitados: "); System.out.println(a);
		 * System.out.println(b); System.out.println(c);
		 * 
		 */

		// ler linha até a quebra e linha pendente

		int x;
		String s1, s2, s3;

		x = sc.nextInt();
		sc.nextLine(); // esse nextline consome a quebra de linha pendente
		s1 = sc.nextLine();
		s2 = sc.nextLine();
		s3 = sc.nextLine();
		System.out.println("Dados digitados: ");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

		sc.close();
	}

	public static void AulaScope() {
		// double price; // The local variable price may not have been initialized

		double price = 400.00;

		if (price > 200.00) {
			double discount = price * 0.1; // discount cannot be resolved to a variable. It is out off scope!
		}
		// System.out.println(discount);

		double discount_2;
		if (price < 200.00) {
			discount_2 = price * 0.1;
		}
		// System.out.println(discount_2);// discount_2 can get any value if condition
		// is false because it is not
		// initialized!
	}
}
