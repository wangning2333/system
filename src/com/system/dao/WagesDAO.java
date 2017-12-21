package com.system.dao;

import com.system.model.Wages;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 王宁
 * 2017/12/19
 * WagesDAO接口
 */
public interface WagesDAO {
    //插入一条工资信息
    int insertWages(Wages wages)throws SQLException;
    //修改工资表信息
    int updateWages(Wages wages)throws SQLException;
    //查看某人工资表信息
    Wages search(String account)throws SQLException;
    //查看工资表所有信息
    List<Wages>getAllWages()throws SQLException;
}
