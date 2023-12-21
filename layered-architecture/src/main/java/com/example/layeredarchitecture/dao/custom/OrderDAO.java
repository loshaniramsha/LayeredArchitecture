package com.example.layeredarchitecture.dao.custom;


import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderDAO extends CrudDAO<OrderDTO> {
     /*String nextId() throws SQLException, ClassNotFoundException;
     boolean existsOrderid(String orderId ) throws SQLException, ClassNotFoundException;
     boolean saveOrder(String orderId, LocalDate orderDate, String customerId ) throws SQLException, ClassNotFoundException;*/

    boolean save(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException;

}




//public interface OrderDAO {
//    public String generateOID() throws SQLException, ClassNotFoundException;
//    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException;
//    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;
//}