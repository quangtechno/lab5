
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class college_students extends students{
    double graduation_average_score;

    public college_students(double graduation_average_score, String student_number, String student_fullName, int total_credit, double average_score) {
        super(student_number, student_fullName, total_credit, average_score);
        this.graduation_average_score = graduation_average_score;
    }
    public college_students(){
        
    }
    @Override
    public void input() {
        super.input(); // 
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter graduation_average_score : ");
        double score=reader.nextDouble();
        setGraduation_average_score(score);
    }
    

    public double getGraduation_average_score() {
        return graduation_average_score;
    }

    public void setGraduation_average_score(double graduation_average_score) {
        this.graduation_average_score = graduation_average_score;
    }

    @Override
    boolean graduation() {
        if(this.getTotal_credit()>=100){
            if(this.getAverage_score()>=5){
                if(this.getGraduation_average_score()>=5){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString()+" college_students{" + "graduation_average_score=" + graduation_average_score + '}';
    }
    
}
