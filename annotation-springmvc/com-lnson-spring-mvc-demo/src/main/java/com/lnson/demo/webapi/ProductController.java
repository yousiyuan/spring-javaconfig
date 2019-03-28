package com.lnson.demo.webapi;

import com.lnson.demo.entity.Products;
import org.springframework.web.bind.annotation.*;

/**
 * 注解@RestController底层实现效果 等同于：@Controller + @ResponseBody
 */
@RestController
@RequestMapping("product")
public class ProductController {

    //测试链接》》》http://localhost/lnson/product/queryProduct?id=19
    @RequestMapping(value = "/queryProduct", method = {RequestMethod.GET})
    public Products getProduct(@RequestParam("id") Integer productid) {
        Products products = new Products();
        products.setProductid(productid);
        return products;
    }


}
