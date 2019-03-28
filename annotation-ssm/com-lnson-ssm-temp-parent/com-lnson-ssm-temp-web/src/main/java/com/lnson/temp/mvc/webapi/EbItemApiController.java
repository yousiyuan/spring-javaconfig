package com.lnson.temp.mvc.webapi;

import com.lnson.temp.db.entity.EbBrand;
import com.lnson.temp.lib.service.EbBrandService;
import com.lnson.temp.proj.annotations.Permission;
import com.lnson.temp.proj.enums.PermissionEnum;
import com.lnson.temp.proj.enums.StateEnum;
import com.lnson.temp.util.commons.JsonResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Map;

//学习参考链接
//  https://www.cnblogs.com/daimajun/p/7152970.html

/**
 * 注解@ResponseBody使用说明：
 *
 * 注解@ResponseBody是作用在方法上的，@ResponseBody 表示该方法的返回结果直接写入 HTTP response body 中，
 * 一般在异步获取数据时使用【也就是AJAX】，在使用 @RequestMapping后，返回值通常解析为跳转路径， 但是加上 @ResponseBody
 * 后返回结果不会被解析为跳转路径，而是直接写入 HTTP response body 中。 比如异步获取 json 数据，加上 @ResponseBody
 * 后，会直接返回 json 数据。
 *
 * ==================================================================================================================
 *
 * 注解@RequestBody使用说明：
 *
 * 注解@RequestBody是作用在形参列表上，用于将前台发送过来固定格式的数据【xml 格式或者 json等】封装为对应的 JavaBean 对象，
 * 封装时使用到的一个对象是系统默认配置的 HttpMessageConverter进行解析，然后封装到形参上。
 *
 * ==================================================================================================================
 *
 * 注解@RequestParam使用说明：
 *
 * 注解@RequestParam修饰方法中形参，获取请求中特定的请求参数值并赋值给形参，同时可以对特定的请求参数进行验证、设置默认值等等
 */
@Controller
@RequestMapping(value = "/webapi")
//@Permission(permissionTypes = {PermissionEnum.DEVELOPER_VALID, PermissionEnum.DEVELOPER_FREEZE})
public class EbItemApiController {

    @Autowired
    private EbBrandService ebBrandService;

    private final static Logger logger = LogManager.getLogger(EbItemApiController.class);

    // 测试链接===》》http://localhost/ssmweb/webapi/brand?cid=3029
    @RequestMapping(value = "/brand", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    EbBrand queryBrandById(Long cid) {
        logger.debug(cid);
        EbBrand ebBrand = ebBrandService.queryForObject(cid);
        logger.debug(ebBrand);
        return ebBrand;
    }

    // 测试链接===》》http://localhost/ssmweb/webapi/brand2.do?cid=3029
    @RequestMapping(value = "/brand2", method = {RequestMethod.GET})
    public @ResponseBody
    EbBrand queryBrand(@RequestParam(value = "cid") Long id) {
        logger.debug(id);
        EbBrand ebBrand = ebBrandService.queryForObject(id);
        logger.debug(ebBrand);
        return ebBrand;
    }

    // POST MAN 工具测试
    // 测试链接===》》http://localhost/ssmweb/webapi/brand1.do
    // 参数 {"cid":3029}
    @RequestMapping(value = "/brand1", method = {RequestMethod.POST})
    public @ResponseBody
    EbBrand queryBrandById(HttpServletRequest request, @RequestBody Map<String, Object> map) {
        logger.debug(map);
        Long cid = Long.valueOf(map.get("cid").toString());
        logger.debug(cid);
        EbBrand ebBrand = ebBrandService.queryForObject(cid);
        logger.debug(ebBrand);
        return ebBrand;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    @PostMapping("/updateBrand")
    @ResponseBody
    public JsonResult updateBrand(@RequestBody Map<String, Object> map) throws Exception {
        logger.debug(map);
        try {
            ebBrandService.updateObject(map);

            EbBrand ebBrand = new EbBrand();
            ebBrand.setBrandName("king" + System.currentTimeMillis());
            ebBrand.setBrandDesc("desc" + System.currentTimeMillis());
            ebBrand.setImgs(MessageFormat.format("/upload/ecps/resource/{0}.jpg", System.currentTimeMillis()));
            ebBrand.setWebsite("https://www.baidu.com/");
            ebBrand.setBrandSort(0);
            ebBrandService.insertObject(ebBrand);
            return JsonResult.build(StateEnum.SUCCESS, "更新成功");

            //throw new Exception("测试事务回滚");
        } catch (Exception ex) {
            return JsonResult.build(StateEnum.FAIL, "更新失败", ex.toString());
        }
    }

}
