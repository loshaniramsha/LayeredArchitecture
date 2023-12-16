package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public interface ItemDAOinterface {
    ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;
    public void saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;

    public void deleteItem(String code) throws SQLException, ClassNotFoundException ;
    public void updateitem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;

    public boolean exiistItem(String code) throws SQLException, ClassNotFoundException ;
    public String newId() throws SQLException, ClassNotFoundException ;

}
