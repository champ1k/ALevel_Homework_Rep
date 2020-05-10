package nix.alvl.module.io;

import java.io.*;
import java.sql.*;

public class CsvExport {
    public static void export() {

        String jdbcURL = "jdbc:mysql://localhost:3306/privatefinance";
        String username = "root";
        String password = "123454321";

        String csvFilePath = "resources\\csvexport.csv";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "SELECT u.name,u.phonenumber,u.email,b.id_bill,o.id_operation,o.date,o.description,c.price,ct.typename  FROM privatefinance.user u,privatefinance.bill b,privatefinance.operation o,privatefinance.category c,privatefinance.category_type ct where u.id_bill = b.id_bill and b.id_operation = o.id_operation and o.id_category = c.id_category and c.id_type = ct.id_type";

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(csvFilePath));

            // write header line containing column names
            fileWriter.write("name,phonenumber,email,id_bill,id_operation,date,description,price,typename");

            while (result.next()) {

                String name = result.getString("name");
                String phonenumber = result.getString("phonenumber");
                String email = result.getString("email");
                int id_bill = result.getInt("id_bill");
                int id_operation = result.getInt("id_operation");
                Timestamp timestamp = result.getTimestamp("date");
                String comment = result.getString("description");


                int price = result.getInt("price");

                String type_name = result.getString("typename");




                if (comment == null) {
                    comment = "";   // write empty value for null
                } else {
                    comment = "\"" + comment + "\""; // escape double quotes
                }

                String line = String.format("%s\",%s,\"%s\",%s,%s,%s,\"%s\",\"%s\",\"%s\"",
                        name,phonenumber,email,id_bill,id_operation,timestamp,comment,price,type_name);

                fileWriter.newLine();
                fileWriter.write(line);
            }

            statement.close();
            fileWriter.close();

        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }


    }
}
