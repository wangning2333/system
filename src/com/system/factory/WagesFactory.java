package com.system.factory;

import com.system.dao.WagesDAO;
import com.system.daoimpl.WagesDAOImpl;
import com.system.model.Wages;

/**
 * Created by 王宁 on 2017/12/20.
 */
public class WagesFactory {
    public static WagesDAO getWagesDAOInstance(){
        return new WagesDAOImpl();
    }
}
