package com.lxx.exam.dao;

import com.lxx.exam.domain.Customer;

import java.sql.SQLException;

public interface CustomerDao {
    public Customer find(Integer id) throws SQLException;

    public Customer find(String firstName);
}
