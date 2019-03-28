package com.lnson.temp.lib.dao;

import com.lnson.temp.db.entity.EbBrand;

public interface EbBrandDao extends BaseDao<EbBrand> {

    public abstract int count(String sqlId);

}
