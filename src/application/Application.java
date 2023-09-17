package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entites.Department;
import entites.HourContract;
import entites.Worker;
import entities.enums.WorkerLevel;

public class Application {

	public static void main( String[] args ) throws ParseException {
		
		Locale.setDefault( Locale.US );
		Scanner sc = new Scanner( System.in );
		
		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
		
		
		
		System.out.print( "Enter department's name: " );
		String nameDepartment = sc.nextLine();
		
		
		System.out.print( "\nEnter Worker data:" );
		System.out.print( "\nName: " );
		String name = sc.nextLine();
		
		System.out.print( "Level: " );
		String workLevel = sc.nextLine();
		
		System.out.print("Base salary: ");
		double salary = sc.nextDouble();
		
		Worker worke = new Worker( name, WorkerLevel.valueOf( workLevel ), salary, new Department( nameDepartment ) );
		
		
		System.out.print( "\nHow many contracts to this worker: " );
		int num = sc.nextInt();
		
		for( int i = 0; i < num; i++) {
			
			System.out.printf( "\nEnter contract #%s data:%n",i+1 );
			
			System.out.print( "Date (DD/MM/YYYY): " );
			Date date = sdf.parse( sc.next() );
			
			System.out.print( "Value per hour: " );
			double valuePerHour = sc.nextDouble();
			
			System.out.print( "Duration (hours): " );
			int hours = sc.nextInt();
			
			HourContract contract = new HourContract( date, valuePerHour, hours );
			worke.addContract( contract );
		}
		
		
		System.out.println();
		
		System.out.print( "Enter month and year to calculate income (MM/YYYY): " );
		String dateIncome = sc.next();
		
		
		int year = Integer.parseInt( dateIncome.substring( 3 ) );
		int month = Integer.parseInt( dateIncome.substring( 0, 2 ) );
		
		System.out.print( "Name: "+worke.getName() );
		System.out.print( "\nDepartment: "+worke.getDepartment().getName() );
		System.out.print( "\nIncome for "+dateIncome+": "+String.format( "%.2f", worke.income( year, month ) ) );
		
		
		sc.close();

	}

}
