package com.bankia.NA.dao;

import com.bankia.NA.modelo.Saldos;
import com.bankia.NA.modelo.SaldosKey;

public interface SaldosMapper {
    int deleteByPrimaryKey(SaldosKey key);

    int insert(Saldos record);

    int insertSelective(Saldos record);

    Saldos selectByPrimaryKey(SaldosKey key);

    int updateByPrimaryKeySelective(Saldos record);

    int updateByPrimaryKey(Saldos record);
}