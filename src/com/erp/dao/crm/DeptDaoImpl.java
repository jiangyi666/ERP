package com.erp.dao.crm;

import com.erp.Utils.JDBCUtil;
import com.erp.pojo.crm.Dept;
import com.erp.pojo.crm.Employee;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    /**
     * 获得所有的部门编号
     * @return
     */
    @Override
    public List<Dept> getAllDept() {
        List<Dept> list=new LinkedList<>();
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="SELECT deptId,deptname from dept;";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Dept dept = new Dept();
                dept.setDeptId(resultSet.getString("deptId"));
                dept.setDeptname(resultSet.getString("deptname"));
                list.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,resultSet);
        }
        return list;
    }
    /**
     * 根据部门名获得部门编号
     * @param deptName
     * @return
     */
    @Override
    public String getDeptIdByDeptName(String deptName) {
        Employee employee = new Employee();
        String deptId=null;
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="SELECT deptId from dept where deptname=?";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,deptName);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
               deptId=resultSet.getString("deptId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,resultSet);
        }
        return deptId;
    }
}
