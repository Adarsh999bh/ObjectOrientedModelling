package oomd.empwagebuilder;

public class EmployeeWageBuilder {
    class Employee{

        Employee(){
            employee_working_status_for_the_day=0;
            monthly_overtime=0;
            overtime_wage=0;
            total_hours_worked_in_month=0;
            total_wage_per_month=0;
        }
        public int employee_working_status_for_the_day;//absent 0 part-time 1 full-time 2
        public int monthly_overtime,overtime_wage;
        public int total_hours_worked_in_month;
        public int total_wage_per_month;
        public void employeeDetails(){
            System.out.println("total hours worked in month : "+total_hours_worked_in_month);
            System.out.println("total wage per month : "+total_wage_per_month);
            System.out.println("Monthly overtime : "+this.monthly_overtime);
            System.out.println("Monthly overtime wage : "+this.overtime_wage);
        }
        public void setStatus(int employee_working_status_for_the_day){
            this.employee_working_status_for_the_day=employee_working_status_for_the_day;
        }
        public void printStatus(int emp_no,int day){
            if(this.employee_working_status_for_the_day==0){
                System.out.println("Employee "+emp_no+" is Absent on day "+day);
            }
            else if(this.employee_working_status_for_the_day==1){
                System.out.println("Employee "+emp_no+" is present (part-time) on day "+day);
            }
            else{
                System.out.println("Employee "+emp_no+" is present (full-time) on day "+day);
            }
        }
    }
    //end of Employee class

    //basic(fixed) attributes
    public String compName;
    public int max_working_hours_per_month,part_time_hour,full_time_hour,employee_wage_per_hour,no_working_days_per_month;
    //calculating(changing) attributes
    public int cost_for_comp_part_emp,cost_for_comp_full_emp,no_of_emp;
    public Employee[] ep;

    //constructor
    EmployeeWageBuilder(String compName,int max_working_hours_per_month,int part_time_hour,int full_time_hour,int employee_wage_per_hour,int no_working_days_per_month,int no_of_emp){
        this.compName=compName;
        this.max_working_hours_per_month=max_working_hours_per_month;
        this.part_time_hour=part_time_hour;
        this.full_time_hour=full_time_hour;
        this.employee_wage_per_hour=employee_wage_per_hour;
        this.no_of_emp=no_of_emp;
        this.no_working_days_per_month=no_working_days_per_month;
        this.ep=new Employee[this.no_of_emp];
        for(int i=0;i<this.no_of_emp;i++){
            this.ep[i]=new Employee();
        }
        this.cost_for_comp_full_emp=0;
        this.cost_for_comp_part_emp=0;
    }

    //company details printing
    public void displayCompDetails(){
        System.out.println("Company name : "+this.compName);
        System.out.println("Max working hours per month : "+this.max_working_hours_per_month);
        System.out.println("Part-time hour : "+this.part_time_hour);
        System.out.println("Full-time hour : "+this.full_time_hour);
        System.out.println("Employye wage per hour : "+this.employee_wage_per_hour);
        System.out.println("Number of working days in a month : "+this.no_working_days_per_month);
        System.out.println("total cost for company on part-time employee is "+this.cost_for_comp_part_emp);
        System.out.println("total cost for company on full-time employee is "+this.cost_for_comp_full_emp);
    }
    public void calculate(){
        for(int j=0;j<this.no_working_days_per_month;j++){
            for (int i=0;i<this.no_of_emp;i++){
                int status=(int) (Math.floor(Math.random()*10)%3);
                if(status==0){
                    //System.out.println("Employee "+(i+1)+" is Absent on day "+j);
                    this.ep[i].setStatus(status);
                    this.ep[i].printStatus(i+1, j+1);
                }
                else if (status==1){
                    // System.out.println("Employee "+(i+1)+" is Present (Part-time) on day "+j);
                    // pt_wage+=80;
                    // ep_wage[i]+=80;
                    this.ep[i].setStatus(status);
                    this.ep[i].printStatus(i+1, j+1);
                    if(this.ep[i].total_hours_worked_in_month<=this.max_working_hours_per_month){
                        int rem=this.ep[i].total_hours_worked_in_month + this.part_time_hour - this.max_working_hours_per_month;
                        if(rem<=0){
                            this.ep[i].total_hours_worked_in_month+=this.part_time_hour;
                            this.ep[i].total_wage_per_month+=this.part_time_hour*this.employee_wage_per_hour;
                            this.cost_for_comp_part_emp+=this.part_time_hour*this.employee_wage_per_hour;
                        }
                        else{
                            this.ep[i].total_hours_worked_in_month+=this.part_time_hour-rem;
                            this.ep[i].total_wage_per_month=this.max_working_hours_per_month*this.employee_wage_per_hour;
                            this.ep[i].monthly_overtime+=rem;
                            this.ep[i].overtime_wage+=rem*this.employee_wage_per_hour;
                            this.cost_for_comp_part_emp+=this.part_time_hour*this.employee_wage_per_hour;
                        }
                    }
                }
                else{
                    // System.out.println("Employee "+(i+1)+" is Present (Full-time) on day "+j);
                    // ft_wage+=160;
                    // ep_wage[i]=160;
                    this.ep[i].setStatus(status);
                    this.ep[i].printStatus(i+1, j+1);
                    if(this.ep[i].total_hours_worked_in_month<=this.max_working_hours_per_month){
                        int rem=this.ep[i].total_hours_worked_in_month + this.full_time_hour - this.max_working_hours_per_month;
                        if(rem<=0){
                            this.ep[i].total_hours_worked_in_month+=this.full_time_hour;
                            this.ep[i].total_wage_per_month+=this.full_time_hour+this.employee_wage_per_hour;
                            this.cost_for_comp_full_emp+=this.full_time_hour*this.employee_wage_per_hour;
                        }
                        else{
                            this.ep[i].total_hours_worked_in_month+=this.full_time_hour-rem;
                            this.ep[i].total_wage_per_month=this.max_working_hours_per_month*this.employee_wage_per_hour;
                            this.ep[i].monthly_overtime+=rem;
                            this.ep[i].overtime_wage+=rem*this.employee_wage_per_hour;
                            this.cost_for_comp_full_emp+=this.full_time_hour*this.employee_wage_per_hour;
                        }
                    }
                }
            }
        }
        for(int i=0;i<this.no_of_emp;i++){
            System.out.println("Employee "+(i+1));
            this.ep[i].employeeDetails();
        }
        displayCompDetails();
    }
    
}
