package com.lnson.temp.lib.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lnson.temp.db.entity.EbBrand;
import com.lnson.temp.lib.dao.EbBrandDao;
import com.lnson.temp.lib.service.EbBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("ebBrandService")
public class EbBrandServiceImpl extends BaseServiceImpl<EbBrand> implements EbBrandService {

    @Autowired
    private EbBrandDao ebBrandDao;

    public EbBrandServiceImpl() {
        this.setInsertSqlId("mapper.EbBrandMapper.insertSelective");
        this.setDeleteSqlId("mapper.EbBrandMapper.deleteByPrimaryKey");
        this.setUpdateSqlId("mapper.EbBrandMapper.updateByPrimaryKeySelective");
        this.setQuerySqlId("mapper.EbBrandMapper.selectByPrimaryKey");
    }

    @Override
    public int count() {
        return ebBrandDao.count("mapper.EbBrandMapper.count");
    }

    /**
     * 动态查询列表
     */
    @Override
    public List<EbBrand> queryForList(String sqlId, EbBrand object) {
        logger.debug("query list parameter sqlId：" + sqlId + ", object：" + JSON.toJSONString(object,
                SerializerFeature.WRITE_MAP_NULL_FEATURES, SerializerFeature.QuoteFieldNames));
        return ebBrandDao.queryForList(sqlId, object);
    }

    @Override
    public void updateObject(Map<String, Object> map) throws Exception {
        String sqlId = "mapper.EbBrandMapper.updateByPrimaryKeySelective";
        logger.debug("query list parameter sqlId：" + sqlId + ", object：" + JSON.toJSONString(map,
                SerializerFeature.WRITE_MAP_NULL_FEATURES, SerializerFeature.QuoteFieldNames));
        ebBrandDao.updateObject(sqlId, map);
    }

}
