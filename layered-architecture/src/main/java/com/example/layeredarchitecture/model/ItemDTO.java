//package com.example.layeredarchitecture.model;
//
//import java.io.Serializable;
//import java.math.BigDecimal;
//
//
//
//public class ItemDTO implements Serializable {
//    private static String code;
//    private String description;
//    private BigDecimal unitPrice;
//    private int qtyOnHand;
//
//    public ItemDTO() {
//    }
//
//    public ItemDTO(String code, String description, BigDecimal unitPrice, int qtyOnHand) {
//        this.code = code;
//        this.description = description;
//        this.unitPrice = unitPrice;
//        this.qtyOnHand = qtyOnHand;
//    }
//
//    public static String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public static String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public static BigDecimal getUnitPrice() {
//        return unitPrice;
//    }
//
//    public void setUnitPrice(BigDecimal unitPrice) {
//        this.unitPrice = unitPrice;
//    }
//
//    public static int getQtyOnHand() {
//        return qtyOnHand;
//    }
//
//    public void setQtyOnHand(int qtyOnHand) {
//        this.qtyOnHand = qtyOnHand;
//    }
//
//    @Override
//    public String toString() {
//        return "ItemTM{" +
//                "code='" + code + '\'' +
//                ", description='" + description + '\'' +
//                ", unitPrice=" + unitPrice +
//                ", qtyOnHand=" + qtyOnHand +
//                '}';
//    }
//}
package com.example.layeredarchitecture.model;

import java.io.Serializable;
import java.math.BigDecimal;



public class ItemDTO implements Serializable {
    private static String code;
    private static String description;
    private static BigDecimal unitPrice;
    private static int qtyOnHand;

    public ItemDTO() {
    }

    public ItemDTO(String code, String description, BigDecimal unitPrice, int qtyOnHand) {
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
    }

    public static String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public static int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    @Override
    public String toString() {
        return "ItemTM{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", qtyOnHand=" + qtyOnHand +
                '}';
    }
}
