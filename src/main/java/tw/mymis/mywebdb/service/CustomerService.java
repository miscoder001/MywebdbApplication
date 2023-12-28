package tw.mymis.mywebdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import tw.mymis.mywebdb.mapper.CustomerMapper;
import tw.mymis.mywebdb.model.Customer;

import java.util.List;

@Service
public class CustomerService{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Customer> getCustomerAll() {
    CustomerMapper cmapper = new CustomerMapper();
        // jdbcTemplate 負責 迴圈(rs.next) 跟蒐集(List)

        List<Customer> allcustomer = jdbcTemplate.query("select * from customers", cmapper);
        return allcustomer;
    }
}
