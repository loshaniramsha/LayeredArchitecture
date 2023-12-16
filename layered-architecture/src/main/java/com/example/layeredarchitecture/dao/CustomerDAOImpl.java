package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAOinterface{
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
        ArrayList<CustomerDTO> getAllCustomer=new ArrayList<>();
        while (rst.next()){
            CustomerDTO customerDTO=new CustomerDTO(rst.getString("id"), rst.getString("name"), rst.getString("address"));
            getAllCustomer.add(customerDTO);
        }
        return getAllCustomer;
    }
    public void saveCustomer (CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");

                pstm.setString(1, customerDTO.getId());
                pstm.setString(2, customerDTO.getName());
                pstm.setString(3, customerDTO.getAddress());
                pstm.executeUpdate();
            }
            public void updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
                Connection connection = DBConnection.getDbConnection().getConnection();
                PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
                pstm.setString(1, customerDTO.getName());
                pstm.setString(2, customerDTO.getAddress());
                pstm.setString(3, customerDTO.getId());
                pstm.executeUpdate();
            }

            public void deleteCustomer(String customerDTO) throws SQLException, ClassNotFoundException {
                Connection connection = DBConnection.getDbConnection().getConnection();
                PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
                pstm.setString(1, customerDTO);
                pstm.executeUpdate();
           }

           public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
               Connection connection = DBConnection.getDbConnection().getConnection();
               PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
               pstm.setString(1, id);
               return pstm.executeQuery().next();
           }
//        public String newId() throws SQLException, ClassNotFoundException {
//            Connection connection = DBConnection.getDbConnection().getConnection();
//            ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
//            if (rst.next()) {
//                String id = rst.getString("id");
//                int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
//                return String.format("C00-%03d", newCustomerId);
//            } else {
//                return "C00-001";
//            }
//
//        }

}






