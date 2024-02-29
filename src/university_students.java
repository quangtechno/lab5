
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
public class university_students extends students implements Serializable{

    String thesis_name;
    double thesis_score;
    public university_students(String thesis_name, double thesis_score, String student_number, String student_fullName, int total_credit, double average_score) {
        super(student_number, student_fullName, total_credit, average_score);
        this.thesis_name = thesis_name;
        this.thesis_score = thesis_score;
    }
    public university_students(){
        
    }
    
    @Override
    boolean graduation() {
        if(this.getTotal_credit()>=150){
            if(this.getAverage_score()>=5){
                if(this.thesis_score>=5){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void input() {
        super.input(); 
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter thesis_name : ");
        String first=reader.next();
        String name=reader.nextLine();
        name+=first+name;
        setThesis_name(name);
        System.out.println("Enter thesis_Average_score");
        setAverage_score(reader.nextDouble());
    }

    public String getThesis_name() {
        return thesis_name;
    }

    public void setThesis_name(String thesis_name) {
        this.thesis_name = thesis_name;
    }

    public double getThesis_score() {
        return thesis_score;
    }

    public void setThesis_score(double thesis_score) {
        this.thesis_score = thesis_score;
    }

    @Override
    public String toString() {
        return super.toString()+" university_students{" + "thesis_name=" + thesis_name + ", thesis_score=" + thesis_score + '}';
    }
  
}
