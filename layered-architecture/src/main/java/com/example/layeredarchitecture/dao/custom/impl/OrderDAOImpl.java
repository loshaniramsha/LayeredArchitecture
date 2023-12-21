package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public String nextId() throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();*/

        ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    @Override
    public OrderDTO search(String newValue) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Orders WHERE oid=?",newValue + "");

        rst.next();
        OrderDTO orderDTO = new OrderDTO(newValue + "", rst.getString("date"), rst.getString("customerID"));

        return orderDTO;
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Orders");

        ArrayList<OrderDTO> getAllOrders = new ArrayList<>();

        while (rst.next()) {
            OrderDTO orderDTO = new OrderDTO(rst.getString("oid"), rst.getString("date"), rst.getString("customerID"));
            getAllOrders.add(orderDTO);
        }

        return getAllOrders;
    }

    @Override
    public boolean save(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String orderId ) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
        stm.setString(1, orderId);*/

        ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` WHERE oid=?",orderId);
        return rst.next();



    }
    @Override
    public boolean save(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
        stm.setString(1, orderId);
        stm.setDate(2, Date.valueOf(orderDate));
        stm.setString(3, customerId);

        return stm.executeUpdate() > 0;*/

        return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",
                orderId,orderDate,customerId);

    }
}































//public class OrderDAOImpl implements OrderDAO {
//    @Override
//    public String generateOID() throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        Statement stm = connection.createStatement();
////        ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
////        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
//        return SQLUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
//    }
//
//
//    @Override
//    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
////        stm.setString(1, orderId);
////        return stm.executeQuery().next();
//    ResultSet resultSet=SQLUtil.execute("SELECT oid FROM `Orders` WHERE oid=?",orderId);
//        return resultSet.next();
//    }
//
//
//    @Override
//    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
////        stm.setString(1, dto.getOrderId());
////        stm.setDate(2, Date.valueOf(dto.getOrderDate()));
////        stm.setString(3, dto.getCustomerId());
////        return stm.executeUpdate()>0;
//      //  return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",dto.getOrderId(),dto.getOrderDate(),dto.getCustomerId());
//        return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",dto.getOrderId(),dto.getOrderDate(),dto.getCustomerId());
//    }
//}


//public class OrderDAOimpl implements OrderDAOinterface {
//    public boolean existsItem(String code) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
//        pstm.setString(1, code);
//        return pstm.executeQuery().next();
//    }
//
//    public boolean existsCustomer(String id) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
//        pstm.setString(1, id);
//        return pstm.executeQuery().next();
//    }
//
//    public String newOrderId() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
//
//        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
//    }
//
//    public void loadAllCustomer(JFXComboBox<String> cmbCustomerId) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");
//
//        while (rst.next()) {
//            cmbCustomerId.getItems().add(rst.getString("id"));
//        }
//    }
//
//    public void loadAllItemCode(JFXComboBox<String> cmbItemCode) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rst = stm.executeQuery("SELECT * FROM Item");
//        while (rst.next()) {
//            cmbItemCode.getItems().add(rst.getString("code"));
//        }
//    }
//
//    public ItemDTO findItem(String code) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
//        pstm.setString(1, code);
//        ResultSet rst = pstm.executeQuery();
//        rst.next();
//        return new ItemDTO(code, rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
//    }
//
////    public boolean saveOrder() throws SQLException, ClassNotFoundException {
////        Connection connection = null;
////
////            connection = DBConnection.getDbConnection().getConnection();
////            PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
////            stm.setString(1, orderId);
////            /*if order id already exist*/
////            if (stm.executeQuery().next()) {
////
////            }
////        connection.setAutoCommit(false);
////        stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
////        stm.setString(1, orderId);
////        stm.setDate(2, Date.valueOf(orderDate));
////        stm.setString(3, customerId);
////
////        if (stm.executeUpdate() != 1) {
////            connection.rollback();
////            connection.setAutoCommit(true);
////            return false;
////        }
////    }
//public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
//    Connection connection = DBConnection.getDbConnection().getConnection();
//    PreparedStatement stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
//    stm.setString(1, dto.getOrderId());
//    stm.setDate(2, Date.valueOf(dto.getOrderDate()));
//    stm.setString(3, dto.getCustomerId());
//    return stm.executeUpdate()>0;
//}
// }