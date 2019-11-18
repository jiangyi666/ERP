package com.erp.dao.crm;

import com.erp.Utils.JDBCUtil;
import com.erp.pojo.crm.Employee;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.ejb.EJBMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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

    @Override
    public List<Employee> getAllEmployee() {

        List<Employee> list=new LinkedList<>();
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="SELECT employeeId,employeeName,deptname,headship,salary from employee,dept where employee.deptId=dept.deptId;";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                Employee employee = new Employee();
                employee.setEmployeeId(resultSet.getString("employeeId"));
                employee.setEmployeeName(resultSet.getString("employeeName"));
                employee.setDeptName(resultSet.getString("deptname"));
                employee.setHeadship(resultSet.getString("headship"));
                employee.setSalary(resultSet.getDouble("salary"));
               list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,resultSet);
        }
        return list;
    }
}
