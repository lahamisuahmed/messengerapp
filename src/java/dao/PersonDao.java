package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Person;

/**
 *
 * @author Lawal
 */
public class PersonDao {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSe;

    public List<Person> persons() {
        List<Person> persons = new ArrayList<>();
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb?useSSL=false&maxReconnects=3&serverTimezone=UTC", "payroll", "payroll");
            preparedStatement = connection.prepareStatement("select * from person");
            resultSe = preparedStatement.executeQuery();
            
            while (resultSe.next()) {
                Person person = new Person.Builder().name(resultSe.getString("name"))
                        .age(resultSe.getInt("age"))
                        .dob(resultSe.getString("dob"))
                        .height(resultSe.getInt("height"))
                        .id(resultSe.getString("id"))
                        .address(resultSe.getString("address"))
                        .salary(resultSe.getDouble("salary")).build();
                
                persons.add(person);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (resultSe != null) {
                    resultSe.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return persons;
    }

}
