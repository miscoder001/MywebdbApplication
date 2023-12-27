package tw.mymis.mywebdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tw.mymis.mywebdb.Data.DBProvider;
import tw.mymis.mywebdb.model.Orders;

import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class ReportController {
    DBProvider dbProvider = new DBProvider();

    @GetMapping("/orders")
    public String getOrderList(Model model) {
        // 提供一個訂單總覽  點選其中一筆 在顯示 訂單明細
        ResultSet rs = null;
        ArrayList<Orders> orders = new ArrayList<>();
        String sql = """
                SELECT
                  orders.orderNumber,
                  orders.orderDate,
                  orders.requiredDate,
                  orders.comments,
                  customers.customerName 
                FROM
                 orders
                 JOIN
                 customers
                 ON orders.customerNumber = customers.customerNumber                                
                """;
        rs = dbProvider.getData(sql);
        // 打包資料 放入 model
        try {
            while(rs.next()) {
                Orders o = new Orders();
                o.setOrderNumber( rs.getInt("orderNumber"));
                o.setOrderDate( rs.getDate("orderDate"));
                o.setRequiredDate(rs.getDate("requiredDate"));
                o.setComments( rs.getString("comments"));
                o.setCompanyName( rs.getString("customerName"));
                orders.add(o);
            }
            model.addAttribute("orders", orders);
            rs.close();
        }catch(SQLException e) {
            System.err.println("ReportController 處理資料發生異常");
        }
        return "orders_list";
    }


    public String getOrderDetails() {
        // 提供一個訂單總覽  點選其中一筆 在顯示 訂單明細
        return "orderDetail";
    }
}
