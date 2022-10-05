/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdb;

import java.sql.SQLException;
import java.util.ArrayList;
import utilities.DatabaseDriver;
import utilities.DatabaseHandler;

/**
 *
 * @author Zucrem
 */
public class StudentMain {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        String driver = "org.apache.derby.jdbc.ClientDriver";
        String url = "jdbc:derby://localhost:1527/student";
        String user = "app";
        String passwd = "app";
        DatabaseDriver dbDriver = new DatabaseDriver(driver, url, user, passwd);
        DatabaseHandler dbHandler = new DatabaseHandler(dbDriver);
        Student std1 = new Student(1, "John", 4.00);
        Student std2 = new Student(2, "Marry", 2.5);
        StudentDB.insertStudent(dbHandler, std1);
        StudentDB.insertStudent(dbHandler, std2);
        ArrayList<Student> listStudent = StudentDB.findAllStudent(dbHandler);
        if (listStudent != null)
            for (int i = 0;i < listStudent.size();i++) System.out.println(listStudent.get(i));
    }
}
