package com.indiv.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.indiv.entity.Customer;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangsongyan on 2017/7/1.
 * email: wangsongyan921@163.com
 */
public class CustomerDao {
    private TxQueryRunner queryRunner = new TxQueryRunner();

    public void add(Customer customer) {
        String sql = "INSERT INTO t_customer VALUES(?,?,?,?,?,?,?)";
        Object[] params = {customer.getCid(), customer.getCname(), customer.getGender(), customer.getBirthday(), customer.getCellphone(), customer.getEmail(), customer.getDescription()};
        try {
            queryRunner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> findAll() {
        try {
            String sql = "SELECT * FROM t_customer ORDER BY cname";
            return queryRunner.query(sql, new BeanListHandler<Customer>(Customer.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Customer load(String cid) {
        try {
            String sql = "SELECT * FROM t_customer WHERE cid=?";
            return queryRunner.query(sql, new BeanHandler<Customer>(Customer.class), cid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void edit(Customer customer) {
        try {
            String sql = "UPDATE t_customer SET cname=?,gender=?,birthday=?,cellphone=?,email=?,description=? where cid=?";
            Object[] params = {customer.getCname(), customer.getGender(), customer.getBirthday(), customer.getCellphone(), customer.getEmail(), customer.getDescription(), customer.getCid()};
            queryRunner.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String cid) {
        String sql = "DELETE FROM t_customer WHERE cid=?";
//        queryRunner
    }

    public List<Customer> query(Customer criteria) {
        StringBuilder sql = new StringBuilder("SELECT * FROM t_customer WHERE 1=1 ");

        List<String> params = new ArrayList<>();
        String cname = criteria.getCname();
        if (cname != null && !cname.trim().isEmpty()) {
            sql.append("and cname LIKE ?");
            params.add("%" + cname + "%");
        }

        String gender = criteria.getGender();
        if (gender != null && !gender.trim().isEmpty()) {
            sql.append("and gender=?");
            params.add(gender);
        }

        String cellphone = criteria.getCellphone();
        if (cellphone != null && !cellphone.trim().isEmpty()) {
            sql.append("and cellphone LIKE ?");
            params.add("%" + cellphone + "%");
        }

        String email = criteria.getEmail();
        if (email != null && !email.trim().isEmpty()) {
            sql.append("and email LIKE ?");
            params.add("%" + email + "%");
        }

        try {
            return queryRunner.query(sql.toString(), new BeanListHandler<Customer>(Customer.class), params.toArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
