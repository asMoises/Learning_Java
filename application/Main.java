package application;

import java.security.DrbgParameters.NextBytes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.stream.Collectors;

import decomp.Department;
import decomp.HourContract;
import decomp.Worker;
import decomp_enum.WorkerLevel;
import entities.Account;
import entities.CalculatorStaticMembers;
import entities.CurrencyConvert;
import entities.Employee;
import entities.EmployeeListTest;
import entities.Orders;
import entities.OrdersStatus;
import entities.Product;
import entities.Rectangle;
import entities.Student;
import entities.Triangle;
import entities.VectorExerc;
import entities.VectorProducts;

public class Main {

	public static void main(String[] args) throws ParseException {

		// AulaIODefault();
		// AulaScope();
		// AulaDebug();
		// AulaBitWise();
		// AulaFunctions();
		// InTriangleData();
		// ProductApp();
		// RectangleApp();
		// EmployeeApp();
		// StudentApp();
		// CalcApp();
		// aulaCotacaoDolar();
		// BankAccount();
		// vectorEx01();
		// vectorEx02();
		// vectorExerc();
		// forEachTest();
		// ListTest();
		// EmployeeListExerc();
		// Matrix();
		// MatrixExerc();
		// DateTests();
		// CalendarTest();
		// EnumTests();

		DecompTests();

	}

	public static void DecompTests() throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();

		System.out.print("Enter worker data: \n");
		System.out.println("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Leve: ");
		String workeLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();

		// instance of Worker
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workeLevel), baseSalary,
				new Department(departmentName));

		System.out.print("Enter the quantity of contracts: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Entre contract #" + (i + 1) + " data: ");
			System.out.print("Date (DD/MM/YYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.println("Enter value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();

			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);

		}

		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYY): ");
		String monthAndYear = sc.next();

		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));

		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

		sc.close();

	}

	public static void EnumTests() {

		Orders order = new Orders(1080, new Date(), OrdersStatus.PENDING_PAYMENT);

		System.out.println(order);

	}

	public static void CalendarTest() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss"); // format the date
		Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z")); // insert a date to date instance d

		System.out.println(sdf.format(d));

		// using calendar to manipulate date data
		Calendar cal = Calendar.getInstance(); // create an instance of Calendar

		cal.setTime(d); // insert the actual date in the cal instance
		cal.add(Calendar.HOUR_OF_DAY, 4); // sum 4 hours

		// insert the manipulated date in the d instance
		d = cal.getTime(); // get the time plus 4 hours
		System.out.println(sdf.format(d));

		// getting the minutes from a date: "2018-06-25T15:42:07Z"
		int minute = cal.get(Calendar.MINUTE);
		System.out.println("The minute: " + minute);

		int month = 1 + cal.get(Calendar.MONTH); // remember, month starts on 0, it's necessray to add 1 (January is 0)
		System.out.println("Month: " + month);

	}

	public static void DateTests() throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));

		Date x1 = new Date();
		Date x2 = new Date(System.currentTimeMillis());
		Date x3 = new Date(0L);
		Date x4 = new Date(1000L * 60L * 60L * 5L);

		Date y1 = sdf1.parse("25/06/2018");
		Date y2 = sdf2.parse("25/06/2018 15:42:07");
		Date y3 = Date.from(Instant.parse("2018-06-25T15:42:07Z"));

		System.out.println("--------------------------------------");
		System.out.println("x1: " + x1);
		System.out.println("x2: " + x2);
		System.out.println("x3: " + x3);
		System.out.println("x4: " + x4);
		System.out.println("y1: " + y1);
		System.out.println("y2: " + y2);
		System.out.println("y3: " + y3);

		System.out.println("--------------------------------------");
		System.out.println("x1: " + sdf3.format(x1));
		System.out.println("x2: " + sdf3.format(x2));
		System.out.println("x3: " + sdf3.format(x3));
		System.out.println("x4: " + sdf3.format(x4));
		System.out.println("y1: " + sdf3.format(y1));
		System.out.println("y2: " + sdf3.format(y2));
		System.out.println("y3: " + sdf3.format(y3));

	}

	public static void MatrixExerc() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the dimension of line 'M': ");
		int m = sc.nextInt();
		System.out.print("Enter the dimension of column 'N': ");
		int n = sc.nextInt();

		int[][] mat = new int[m][n]; // instance a new mat at heap memory

		System.out.println("Enter all the data of Matrix: ");
		for (int i = 0; i < m; i++) { // rum the lines
			for (int j = 0; j < n; j++) {// rum the columns
				mat[i][j] = sc.nextInt();
			}
		}

		System.out.println("All data in the matrix [m] [n]");
		for (int i = 0; i < mat.length; i++) { // rum the lines
			for (int j = 0; j < mat[i].length; j++) {// rum the columns
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

		int askNumber;
		do {
			System.out.println("\nEnter the number to be find: ");
			askNumber = sc.nextInt();

			for (int i = 0; i < mat.length; i++) { // rum the columns
				for (int j = 0; j < mat[i].length; j++) {// rum the lines

					if (askNumber == mat[i][j]) { // askNumber found!

						System.out.println("Position: mat[" + i + "][" + j + "]");
						if (j > 0) {
							System.out.println("Its left: " + mat[i][j - 1]);
						}
						if (i > 0) {
							System.out.println("Its up: " + mat[i - 1][j]);
						}
						if (j < mat[i].length - 1) {
							System.out.println("Its right: " + mat[i][j + 1]);
						}
						if (i < mat.length - 1) {
							System.out.println("Its down: " + mat[i + 1][j]);
						}

					}
				}
			}
		} while (askNumber >= 0);
		System.out.println("End!");

		sc.close();
	}

	public static void Matrix() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the dimension of Matrix: ");
		int n = sc.nextInt();

		int[][] mat = new int[n][n]; // instance a new mat at heap memory

		System.out.println("Enter all the data of Matrix (separated by space): ");
		for (int i = 0; i < mat.length; i++) { // rum the lines
			for (int j = 0; j < mat.length; j++) {// rum the columns
				mat[i][j] = sc.nextInt();
			}

		}

		// Main diagonal
		System.out.println("Main diagonal:");
		for (int i = 0; i < mat.length; i++) { // main diagonal
			System.out.print(mat[i][i] + " ");
		}
		System.out.println();

		// Negative numbers on the Matrix
		int count = 0;
		for (int i = 0; i < mat.length; i++) { // rum the lines
			for (int j = 0; j < mat.length; j++) {// rum the columns
				if (mat[i][j] < 0) {
					count++;
				}
			}
		}
		System.out.println("Negative number: " + count);
		sc.close();
	}

	public static void EmployeeListExerc() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<EmployeeListTest> list = new ArrayList<>();

		System.out.print("How many employees will be registred? "); // tamanho da lista!
		int n = sc.nextInt();

		// Insert employee at list
		for (int i = 0; i < n; i++) {
			System.out.println("\nEmployee #" + (i + 1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();

			// check if id already exist
			while (hasId(list, id)) {
				System.out.println("ID already taken! Try again");
				id = sc.nextInt();
			}

			System.out.print("Employee: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();

			EmployeeListTest emp = new EmployeeListTest(id, name, salary);

			list.add(emp);
		}

		// ask for percentage to increase
		System.out.print("Enter the employee id that will have salary increase: ");
		int idSalary = sc.nextInt();

		EmployeeListTest e = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);

		if (e == null) {
			System.out.println("ID not found!");
		} else {
			System.out.println("Enter the percentage: ");
			double p = sc.nextDouble();
			e.increaseSalary(p);
		}

		// show entire list
		System.out.println("\nList of employee:");
		for (EmployeeListTest x : list) {
			System.out.println(x);
		}

		sc.close();
	}

	public static boolean hasId(List<EmployeeListTest> list, int id) {
		EmployeeListTest emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

		return emp != null; // This is a conditional structure that returns true "if" emp is different of
							// null!
	}

	public static Integer position(List<EmployeeListTest> list, int id) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}

	public static void ListTest() {
		List<String> list = new ArrayList<>();
		System.out.println("*Lista original*");
		list.add("Maria");
		list.add("Alex");
		list.add("Bob");
		list.add("Anna");

		for (String x : list) {
			System.out.println(x);
		}
		System.out.println("\n*Insere Marco*");

		list.add(2, "Marco");
		for (String x : list) {
			System.out.println(x);
		}
		System.out.println("\n*Tamanho da lista*");
		System.out.println(list.size());
		System.out.println("\n*Exclui Anna*");
		list.remove("Anna");
		for (String x : list) {
			System.out.println(x);
		}
		System.out.println("\n*Remove o elemento de posição 1*");
		list.remove(1);
		for (String x : list) {
			System.out.println(x);
		}
		System.out.println("\n*Remove todo elemento M na posição [0]*");
		list.removeIf(x -> x.charAt(0) == 'M'); // predicado: remove todo x, tval que x[0] seja == 'M'
		for (String x : list) {
			System.out.println(x);
		}
		System.out.println("\n*Index of*");
		list.add("Alex");
		list.add("Anna");

		for (String x : list) {
			System.out.println(x);
		}
		System.out.println("Index of Bob: " + list.indexOf("Bob")); // quando não encontra, retorna -1

		System.out.println("\n*Fiter of*");

		List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList()); // pega alista
																											// atual,
																											// converte
																											// pra
																											// stream,
																											// filtra e
																											// devolve
																											// no tipo
																											// list
		for (String x : result) {
			System.out.println(x);
		}

		System.out.println("\n*Finding element*");

		String name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse("Não achei!"); // pesquia
																										// elemento em
																										// um lista e se
																										// não achar,
																										// retonra null
		System.out.println(name);
	}

	public static void forEachTest() {
		String[] vect = new String[] { "Maria", "Bob", "Alex" };

		for (int i = 0; i < vect.length; i++) {
			System.out.println(vect[i]);
		}

		System.out.println("-------------------------");

		for (String obj : vect) { // para cada objeto ou elemento contindo no vect faça:
			System.out.println(obj);
		}
	}

	public static void vectorExerc() {
		Scanner sc = new Scanner(System.in);
		VectorExerc[] vect = new VectorExerc[10];

		System.out.print("How many rooms will be rented? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Rent #" + i + ":");
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Room: ");
			int room = sc.nextInt();
			vect[room] = new VectorExerc(name, email); // a posição do vetro não era i, e sim room! esse foi o meu erro
														// no exercício!
		}
		System.out.println();
		System.out.println("Busy rooms:");
		for (int i = 0; i < 10; i++) {
			if (vect[i] != null) {
				System.out.println(i + ": " + vect[i]);
			}
		}
		sc.close();
	}

	public static void vectorEx02() {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the value: ");
		int n = sc.nextInt();

		VectorProducts[] vect = new VectorProducts[n];

		System.out.println("Enter the products data");
		for (int i = 0; i < vect.length; i++) {
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.println("Price: ");
			double price = sc.nextDouble();
			vect[i] = new VectorProducts(name, price);
		}

		double sum = 0;

		for (int i = 0; i < vect.length; i++) {
			sum += vect[i].getPrice();
		}

		double avg = sum / vect.length;
		System.out.printf("Average price: %.2f%n", avg);

		sc.close();

	}

	public static void vectorEx01() {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the value: ");
		int n = sc.nextInt();

		double[] vector = new double[n];

		for (int i = 0; i < n; i++) {

			System.out.print("Position[" + i + "] = ");
			vector[i] = sc.nextDouble();
		}

		double sum = 0;

		for (int i = 0; i < n; i++) {
			sum += vector[i];
		}

		double avg = sum / n;
		System.out.printf("Average: %.2f%n", avg);

		sc.close();

	}

	public static void BankAccount() {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Account acc;

		System.out.println("Wellcome!!\n\nEnter account number: ");
		int number = sc.nextInt();

		System.out.print("Enter account holder: ");
		sc.nextLine();
		String holder = sc.nextLine();

		System.out.print("Is there an initial deposit? (y/n):");
		char response = sc.next().charAt(0); // pega o caracter da posição do vetor

		if (response == 'y') {
			System.out.print("Enter initial deposit value:");
			double initialDeposit = sc.nextDouble();
			acc = new Account(holder, number, initialDeposit);
		} else {
			acc = new Account(holder, number);
		}

		System.out.println("\n" + acc);
		System.out.print("\nEnter a deposit value:");
		double depValue = sc.nextDouble();
		acc.deposit(depValue);
		System.out.println("Update account data: \n" + acc);

		System.out.print("\nEnter a withdraw value:");
		double withdrawValue = sc.nextDouble();
		acc.withdraw(withdrawValue);
		System.out.println("Update account data: \n" + acc);

		sc.close();

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

		message = "Employee Name: " + emp.name + "\n" + "Gross Salary: $ " + String.format("%.2f", emp.grossSalary)
				+ "\n\nWhitch percentage to increase salary?\n";

		System.out.println(message);

		System.out.print("Percentage (%): ");
		double perc = sc.nextDouble();
		emp.IncreaseSalary(perc);

		message = "Updating Data...\n" + "\nName employee: " + emp.name + "\nGross Salary: " + emp.grossSalary
				+ "\nSalary (tax over gross salary): " + emp.NetSalary();

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

		message = "Rectangle Data!\n" + "Area: " + String.format("%.2f", r.Area()) + "m²\n" + "Perimeter: "
				+ String.format("%.2f", r.Perimeter()) + "m\n" + "Diagonal: " + String.format("%.2f", r.Diagonal())
				+ "m\n" + ">>";
		System.out.println(message);

		sc.close();

	}

	public static void ProductApp() {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		double price = 0;
		int opt = 0;
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
						product.AddProducts(quantity);
					}
				} while (quantity <= 0);

				System.out.println(product);
				break;
			case 2:
				if (product.getName() != "") {
					// 2 - Add product quantity
					System.out.println(
							"Quantity now: " + product.getQuantity() + "\nEnter the product quantity to add stock.");
					System.out.print("Quantity: ");
					quantity = sc.nextInt();
					product.AddProducts(quantity);
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
					quantity = sc.nextInt();

					if ((product.getQuantity() - quantity) < 0) {
						System.out.println("Quantity is not enought to be decrease!");
					} else {
						product.RemoveProduct(quantity);
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
				System.out.println("ERROR!\nTry another option!");
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
