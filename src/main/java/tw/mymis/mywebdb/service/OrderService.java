package tw.mymis.mywebdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import tw.mymis.mywebdb.mapper.OrderMapper;
import tw.mymis.mywebdb.model.Order;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    JdbcTemplate template;
    public List<Order> getAll() {
        return template.query("select * from orders", new OrderMapper());
    }

    public List<Order> getOrderById(int ono) {
        return template.query("select * from orders where orderNumber=" + ono, new OrderMapper());
    }
    public List<Order> getOrderByCustomerNumber(int cno) {
        return template.query("select * from orders where customerNumber=" + cno, new OrderMapper());
    }
}
