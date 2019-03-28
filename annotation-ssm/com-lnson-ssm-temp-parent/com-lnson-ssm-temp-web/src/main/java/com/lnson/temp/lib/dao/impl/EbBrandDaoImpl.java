package com.lnson.temp.lib.dao.impl;

import com.lnson.temp.db.entity.EbBrand;
import com.lnson.temp.lib.dao.EbBrandDao;
import org.springframework.stereotype.Repository;

@Repository("ebBrandDao")
public class EbBrandDaoImpl extends BaseDaoImpl<EbBrand> implements EbBrandDao {

    @Override
    public int count(String sqlId) {
        logger.debug("count parameter sqlId：" + sqlId);
        return sqlSession.selectOne(sqlId);
    }

}
