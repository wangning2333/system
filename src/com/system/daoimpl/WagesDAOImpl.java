package com.system.daoimpl;

import com.system.dao.WagesDAO;
import com.system.model.Wages;
import com.system.utils.JDBCUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 王宁 on 2017/12/20.
 */
public class WagesDAOImpl implements WagesDAO {
    private JDBCUtil jdbcUtil=JDBCUtil.getInitJDBCUtil();
    @Override
    public int insertWages(Wages wages) throws SQLException {
        String  sql="INSERT INTO t_wages VALUES (null,?,?,?,?,?,?,?,?,?,?) ";
        Object[] params={wages.getUserid(),wages.getBasicwages(),wages.getAttendancereward(),wages.getYearwages(),
                            wages.getPublish(),wages.getInsurance(),wages.getTax(),wages.getWages(),wages.getTruewages(),wages.getDate()};
        int n=jdbcUtil.executeUpdate(sql,params);
        return n;
    }

    @Override
    public int updateWages(Wages wages) throws SQLException {
        int n;
        String sql = "UPDATE t_wages SET attendancereward = ?,publish = ? WHERE userid = ? ";
        java.lang.Object[] params = {wages.getAttendancereward(),wages.getPublish(),wages.getUserid()};
        n = jdbcUtil.executeUpdate(sql,params);
        return n;
    }

    @Override
    public Wages search(String account) throws SQLException {
        String sql="SELECT * FROM t_wages WHERE userid = ? ";
        Map<String,Object>map=jdbcUtil.executeQuerySingle(sql,new Object[]{account});
        if (map.size()!=0){
            Wages wages=new Wages((int)map.get("wagesid"),map.get("userid").toString(),(double)map.get("basicwages"),
                    (double)map.get("attendancereward"),(double)map.get("yearwages"),(double)map.get("publish"),
                    (double)map.get("insurance"),(double)map.get("tax"),(double)map.get("wages"),(double)map.get("truewages"),
                    (Date) map.get("date"));
            return wages;
        }else {
            return null;
        }
    }

    @Override
    public List<Wages> getAllWages() throws SQLException {
        String sql="SELECT * FROM t_wages ";
        List<Object>list=jdbcUtil.excuteQuery(sql,null);
        return getWagesList(list);
    }

    private List<Wages> getWagesList(List<Object> list) {
        List<Wages> wages = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = (Map<String, Object>) object;
            Wages wage=new Wages((int)map.get("wagesid"),map.get("userid").toString(),(double)map.get("basicwages"),
                    (double)map.get("attendancereward"),(double)map.get("yearwages"),(double)map.get("publish"),
                    (double)map.get("insurance"),(double)map.get("tax"),(double)map.get("wages"),(double)map.get("truewages"),
                    (Date) map.get("date"));
            wages.add(wage);
        }
        return wages;
    }
}
