
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class question3 {

    public static void main(String[] args) {
         DAO dao=new DAO();
        Scanner reader = new Scanner(System.in);
        Vector<students> university = dao.ReadUniversityObject();
       Vector<students> college = dao.ReadCollegeObject();
       
//        university.add(inputUniversity_students());
//        university.add(inputCollege_students());
//        Iterator iter=university.iterator();
//        while(iter.hasNext()){
//            System.out.println(iter.next().toString());
//        }
        
//         students[] arr=(students[]) university.toArray(new students[university.size()]);

//        if(dao.saveUniversityObject(university)){
//            System.out.println("saved");
//        }else{
//            System.out.println("error");
//        }
//for(int i=0;i<university.size();i++){
//    System.out.println(university.get(i).toString());
//}
//List<students> temp=dao.ReadUniversityObject();
//    for(int i=0;i<temp.size();i++){
//        System.out.println(temp.get(i).toString());
//    }
        int menu;
        do {
            System.out.print("1. Add a new college student.\n"
                    + "2. Add a new university student.\n"
                    + "3. Remove a student from the list with the student code entered from the keyboard.\n"
                    + "4. Print student list.\n"
                    + "5. Print the list of students eligible for graduation and indicate the number of eligible\n"
                    + "students.\n"
                    + "6. Sort the student list ascending by Student type (College, university) and student code\n"
                    + "7. Find student list by student's full name (Contains).\n"
                    + "8. Exit\n Enter the menu_number : ");
            menu = reader.nextInt();
            switch (menu) {
                case 1:
                    college.add(inputCollege_students());
                    dao.saveCollegeObject(college);
                    break;
                case 2:
                    university.add(inputUniversity_students());
                    dao.saveUniversityObject(university);
                    break;
                case 3:
                    System.out.println("Enter the student code : ");
                    String code = reader.next();
                    if(!removeStudent(code, university)){
                        if(removeStudent(code, college)){
                             dao.saveCollegeObject(college);
                        }
                    }else{
                         dao.saveUniversityObject(university);
                    }
                    
                    break;
                case 4:
                    print(university);
                    print(college);
                    break;
                case 5:
                    checkGraduation(university);
                    checkGraduation(college);
                    break;
                case 6:
                    sort(university);
                    dao.saveUniversityObject(university);
                    sort(college);
                    dao.saveCollegeObject(college);
                    break;
                case 7:
                    System.out.println("Enter the name/char : ");
                    String name=reader.next();
                    findName(university, name);
                case 8:
                    System.out.println("exit");
                    break;
                default:
                    System.out.println("wrong input");
            }
        } while (menu != 8);
    }

    public static university_students inputUniversity_students() {
        university_students temp = new university_students();
        temp.input();
        return temp;
    }
public static void findName(Vector<students> vec,String name){
      for (int i = 0; i < vec.size(); i++) {
            students temp = vec.get(i);
            if (temp.getStudent_fullName().contains(name)) {
            System.out.println(temp.toString());
            }
        }
}
    public static void sort(Vector<students> vec){
        Comparator<students> com = new Comparator<students>() {
            @Override
            public int compare(students o1, students o2) {
                if (o1.getClass().equals(o2.getClass())) {
                    return o1.getStudent_number().compareTo(o2.getStudent_number());
                }
                return o1.getClass().getName().compareTo(o2.getClass().getName());
            }
        };
        vec.sort(com);
    }

    public static college_students inputCollege_students() {
        college_students temp = new college_students();
        temp.input();
        return temp;
    }

    public static void print(Vector<students> vec) {
        Iterator iter = vec.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public static boolean removeStudent(String student_code, Vector<students> vec) {
        for (int i = 0; i < vec.size(); i++) {
            students temp = vec.get(i);
            if (temp.getStudent_number().equalsIgnoreCase(student_code)) {
                System.out.println("delete : " + temp.toString());
                vec.remove(temp);
                return true;
            }
        }
        return false;
    }

    public static void checkGraduation(Vector<students> vec) {
        for (int i = 0; i < vec.size(); i++) {
            students temp = vec.get(i);
            if (temp.graduation()) {
                System.out.println(temp.toString());
            }
        }
    }
}
