package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.model.ItemDTO;

public interface ItemDAO extends CrudDAO<ItemDTO> {
    /* ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;
     boolean deleteItem(String code) throws SQLException, ClassNotFoundException;
     boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
     boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
     boolean existItem(String code) throws SQLException, ClassNotFoundException;
     String nextId() throws SQLException, ClassNotFoundException;
     ItemDTO findItem(String newItemCode) throws SQLException, ClassNotFoundException;*/
}
