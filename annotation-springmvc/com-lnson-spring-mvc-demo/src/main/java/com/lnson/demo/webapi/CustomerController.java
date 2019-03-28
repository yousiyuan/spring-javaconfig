package com.lnson.demo.webapi;

import com.lnson.demo.entity.Customers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("customer")
public class CustomerController {

    //测试链接》》》http://localhost/lnson/customer/queryCustomer?id=23
    @RequestMapping("/queryCustomer")
    @ResponseBody
    public Customers getCustomer(@RequestParam("id") String customerid) {
        Customers customers = new Customers();
        customers.setCustomerid(customerid);
        return customers;
    }

    //POSTMAN请求地址》》》http://localhost/lnson/customer/printParams
    //content-type》》》application/json
    //POST请求参数》》》{"customerid":"666","companyname":"xxx","contactname":"zxb","contacttitle":null,"address":null,"city":null,"region":null,"postalcode":null,"country":null,"phone":null,"fax":null}
    @RequestMapping(value = "/printParams", method = {RequestMethod.POST})
    @ResponseBody
    public Customers showRequestParams(@RequestBody Customers customers) {
        return customers;
    }

}
