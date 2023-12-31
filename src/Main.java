import Entities.Department;
import Entities.HourContract;
import Entities.Worker;
import Entities.enums.WorkerLevel;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");

        System.out.print("Enter departament's name: ");
        String department = scanner.nextLine();
        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String workerName = scanner.nextLine();
        System.out.print("Level: ");
        String workerLevel = scanner.nextLine();
        System.out.print("Base salary: ");
        double workerBaseSalary = scanner.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, new Department(department));

        System.out.print("How many contracts for this worker? ");
        int contractQuantities = scanner.nextInt();

        for (int i = 0; i < contractQuantities; i++){

            System.out.println();
            System.out.println("Enter contract #" + (i + 1) + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(scanner.next());
            System.out.print("Value per hour: ");
            double valuePerHour = scanner.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = scanner.nextInt();

            HourContract contract = new HourContract(contractDate, valuePerHour, hours);

            worker.addContract(contract);

        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        Date incomePeriod = sdf2.parse(scanner.next());

        System.out.println("Name " + worker.getName());
        System.out.println("Department " + worker.getDepartment().getName());
        System.out.println("Income "+ worker.income(incomePeriod.getYear(), (incomePeriod.getMonth() + 1)));
        scanner.close();
        }
    }
