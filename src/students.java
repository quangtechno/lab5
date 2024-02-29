
import java.awt.Font;
import java.io.Serializable;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public abstract class students implements Serializable{

    
 private String student_number;
    private String student_fullName;
    private int total_credit;
    private double average_score;
    public students(String student_number, String student_fullName, int total_credit, double average_score) {
        this.student_number = student_number;
        this.student_fullName = student_fullName;
        this.total_credit = total_credit;
        this.average_score = average_score;
    }
   public students(){
       
   }
    
    abstract boolean graduation();
    
    public void input() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter student_number : ");
        setStudent_number(reader.next());
        System.out.println("Enter student_fullName : ");
        String first=reader.next();
        String fullname=reader.nextLine();
        fullname=first+fullname;
        setStudent_fullName(fullname);
        System.out.println("Enter student_credit : ");
        setTotal_credit(reader.nextInt());
        System.out.println("Enter student_average_score : ");
        setAverage_score(reader.nextDouble());
    }
    
    public String getStudent_number() {
        return student_number;
    }
    
    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }
    
    public String getStudent_fullName() {
        return student_fullName;
    }
    
    public void setStudent_fullName(String student_fullName) {
        this.student_fullName = student_fullName;
    }
    
    public int getTotal_credit() {
        return total_credit;
    }
    
    public void setTotal_credit(int total_credit) {
        this.total_credit = total_credit;
    }
    
    public double getAverage_score() {
        return average_score;
    }
    
    public void setAverage_score(double average_score) {
        this.average_score = average_score;
    }

    @Override
    public String toString() {
        return "students{ student_number=" + student_number + ", student_fullName=" + student_fullName + ", total_credit=" + total_credit + ", average_score=" + average_score + '}';
    }
    
}
