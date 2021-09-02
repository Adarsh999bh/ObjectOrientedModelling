package oomd.empwagebuilder;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to employee wage builder..!\n\n" );
        Scanner sc_int=new Scanner(System.in);
        Scanner sc_string=new Scanner(System.in);
        System.out.println("Enter the no of Companies");
        int n=sc_int.nextInt();
        EmployeeWageBuilder[] cp=new EmployeeWageBuilder[n];
        for(int i=0;i<n;i++){
            System.out.print("Enter the company name : ");
            String compname=sc_string.nextLine();
            System.out.print("Enter the number of employees : ");
            int no_e=sc_int.nextInt();
            System.out.print("Enter max working hours per month : ");
            int mwh=sc_int.nextInt();
            System.out.print("Enter part-time hour : ");
            int pt=sc_int.nextInt();
            System.out.print("Enter full-time hour : ");
            int ft=sc_int.nextInt();
            System.out.print("Enter employee wage per hour : ");
            int wph=sc_int.nextInt();
            System.out.print("Enter the number of working days in month : ");
            int wds=sc_int.nextInt();
            cp[i]=new EmployeeWageBuilder(compname, mwh, pt, ft, wph, wds, no_e);
            cp[i].calculate();
        }
        sc_int.close();
        sc_string.close();
    }
}
