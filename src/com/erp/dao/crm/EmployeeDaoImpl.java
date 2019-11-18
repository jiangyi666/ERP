package com.erp.dao.crm;

import com.erp.Utils.JDBCUtil;
import com.erp.pojo.crm.Employee;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDaoImpl implements EmployeeDao {
    /**
     *
     * @param employeeId
     * @param password
     * @return
     */
    @Override
    public Employee checkEmployee(String employeeId, String password) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select privilege,employeeName from employee where employeeid=? and password=?";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, employeeId);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                //有查询到数据
                Employee employee = new Employee();
                employee.setPrivilege(resultSet.getInt("privilege"));//先保存权限
                employee.setEmployeeName(resultSet.getString("employeeName"));
                return employee;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(connection, preparedStatement, resultSet);
        }

        return null;
    }
}
