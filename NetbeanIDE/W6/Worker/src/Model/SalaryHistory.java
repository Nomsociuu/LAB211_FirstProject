
package Model;
public class SalaryHistory extends Worker implements Comparable<SalaryHistory>{
    private String status;
    private String Date;

    public SalaryHistory() {
        super();
    }

    public SalaryHistory(String id, String name, int age, double salary, String workLocation,String status, String Date) {
        super(id, name, age, salary, workLocation);
        this.status = status;
        this.Date = Date;
    }
    
    public void display(){
        System.out.printf("%-10s %-20s %-10d %-20.1f %-20s %-10s\n",id,name,age,salary,status,Date);
    }

    @Override
    public int compareTo(SalaryHistory o) {
        return this.id.compareToIgnoreCase(o.id);
    }
    
}
