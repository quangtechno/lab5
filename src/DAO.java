
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ADMIN
 */
public class DAO {

    public DAO() {
    }

    public boolean saveUniversityObject (Vector<students> vec) {
        try {
            File f = new File("University.dat");
            FileOutputStream outstream = new FileOutputStream(f);
            ObjectOutputStream obj = new ObjectOutputStream(outstream);
            obj.writeObject( vec);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        } catch (IOException ex) { 
            System.out.println(ex.getMessage());
        }
        return true;

    }
     public boolean saveCollegeObject (Vector<students> vec) {
        try {
            File f = new File("College.dat");
            FileOutputStream outstream = new FileOutputStream(f);
            ObjectOutputStream obj = new ObjectOutputStream(outstream);
            obj.writeObject( vec);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        } catch (IOException ex) { 
            System.out.println(ex.getMessage());
        }
        return true;

    }
      public Vector<students> ReadCollegeObject() {
    Vector<students> temp=new Vector<>();
        try {
            File f = new File("College.dat");
            FileInputStream instream = new FileInputStream(f);
            ObjectInputStream obj = new ObjectInputStream(instream);
            temp = (Vector<students>) obj.readObject();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return temp;
    }

    public Vector<students> ReadUniversityObject() {
    Vector<students> temp=new Vector<>();
        try {
            File f = new File("University.dat");
            FileInputStream instream = new FileInputStream(f);
            ObjectInputStream obj = new ObjectInputStream(instream);
            temp =   (Vector<students>) obj.readObject();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return temp;
    }
}
