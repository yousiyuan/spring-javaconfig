package com.lnson.demo.webapi;

import com.lnson.demo.entity.Orders;
import org.springframework.web.bind.annotation.*;


/**
 * 注解：@GetMapping       ===>>   @RequestMapping(value = "",method = {RequestMethod.GET})
 * 注解：@PostMapping      ===>>   @RequestMapping(value = "",method = {RequestMethod.POST})
 * 注解：@PutMapping       ===>>   POST请求，更新
 * 注解：@DeleteMapping    ===>>   POST请求，删除
 *
 * 注解：@PathVariable     ===>>   用于将请求URL中的模板变量映射到功能处理方法的参数上，即取出URI模板中的变量作为参数
 */
@RestController
@RequestMapping("order")
public class OrderController {

    //测试链接》》》http://localhost/lnson/order/queryOrder/67
    @GetMapping(value = "/queryOrder/{id}")
    public Orders getOrder(@PathVariable("id") Short orderid) {
        Orders orders = new Orders();
        orders.setOrderid(orderid);
        return orders;
    }

}
