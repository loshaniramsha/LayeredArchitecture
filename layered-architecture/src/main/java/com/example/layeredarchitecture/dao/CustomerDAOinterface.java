package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAOinterface {
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException ;
    public void saveCustomer (CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;
    public void updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;

    public void deleteCustomer(String customerDTO) throws SQLException, ClassNotFoundException ;

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;

}
