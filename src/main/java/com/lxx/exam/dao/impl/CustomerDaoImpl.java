package com.lxx.exam.dao.impl;

import com.lxx.exam.dao.CustomerDao;
import com.lxx.exam.domain.Customer;
import com.lxx.exam.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImpl implements CustomerDao {

    private Connection conn;
    private PreparedStatement pstat;
    private ResultSet rs;

    @Override
    public Customer find(Integer id){
        Customer ct = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select customer_id,store_id,first_name,last_name,email,address_id,active,create_date,last_update from customer where customer_id=?";
            pstat = conn.prepareStatement(sql);
            pstat.setInt(1,id);
            rs = pstat.executeQuery();
            if (rs.next()){
                ct = rs2ct(rs);
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ct;
    }

    @Override
    public Customer find(String firstName) {
        Customer ct=null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select customer_id,store_id,first_name,last_name,email,address_id,active,create_date,last_update from customer where first_name=?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1,firstName);
            rs = pstat.executeQuery();
            if(rs.next()){
                ct = rs2ct(rs);
            }
            rs.close();
            pstat.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ct;
    }

    private Customer rs2ct(ResultSet rs) throws SQLException {
        Customer ct = new Customer();
        ct.setCustomerId(rs.getInt("customer_id"));
        ct.setStoreId(rs.getInt("store_id"));
        ct.setFirstName(rs.getString("first_name"));
        ct.setLastName(rs.getString("last_name"));
        ct.setEmail(rs.getString("email"));
        ct.setAddressId(rs.getInt("address_id"));
        ct.setActive(rs.getInt("active"));
        ct.setCreateDate(rs.getDate("create_date"));
        ct.setLastUpdate(rs.getDate("last_update"));
        return ct;
    }
}
