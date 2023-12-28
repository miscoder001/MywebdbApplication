package tw.mymis.mywebdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tw.mymis.mywebdb.model.Customer;
import tw.mymis.mywebdb.service.CustomerService;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @GetMapping("/customers")
    public String showCustomers(Model model) {
        // CustomerService 要資料
        List<Customer> custs = customerService.getCustomerAll();
        // 放入 model
        model.addAttribute("custs", custs);
        return "customer_list";
    }

}
