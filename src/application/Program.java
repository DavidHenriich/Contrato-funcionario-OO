package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento: ");
		String department = sc.nextLine();
		System.out.println("\nEntre com as informa��es do Trabalhador:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Sal�rio base: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(department));
		
		System.out.print("Quantos contratos para este trabalhador? ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("\nEntre com o contrato #" + i);
			System.out.print("Data (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Dura��o (horas): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		 System.out.print("\nEntre com o m�s e ano para calcular o salario: (MM/YYYY): ");
		 String monthAndYear = sc.next();
		 int month = Integer.parseInt(monthAndYear.substring(0, 2));
		 int year = Integer.parseInt(monthAndYear.substring(3));
		 System.out.println("\nName: " + worker.getName());
		 System.out.println("Departamento: " + worker.getDepartment().getName());
		 System.out.println("Salario em " + monthAndYear + ": " + String.format("%.2f",worker.income(year, month)));
		 
		 
		sc.close();
	}

}
