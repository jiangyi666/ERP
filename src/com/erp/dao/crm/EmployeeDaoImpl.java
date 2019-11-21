package com.erp.dao.crm;

import com.erp.Utils.JDBCUtil;
import com.erp.pojo.crm.Employee;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.ejb.EJBMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String sql = "select privilege,employeeName,deptname,headship from employee,dept where employeeid=? and password=? and employee.deptId=dept.deptId";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, employeeId);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                //有查询到数据
                Employee employee = new Employee();
                employee.setPrivilege(resultSet.getInt("privilege"));//先保存权限
                employee.setEmployeeName(resultSet.getString("employeeName"));//保存姓名
                employee.setDeptName(resultSet.getString("deptname"));//保存部门名称
                employee.setHeadship(resultSet.getString("headship"));//保存职位
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
        String sql="SELECT employeeId,employeeName,deptname,headship,salary from employee,dept where employee.deptId=dept.deptId ORDER BY employeeId;";
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
    /**
     * 通过员工的编号来获得职工的信息
     * @param employeeId
     * @return
     */
    @Override
    public Employee getEmployeeById(String employeeId) {
        Employee employee = new Employee();
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="SELECT employeeId,employeeName,deptname,employee.deptId,headship,salary from employee,dept where employeeId=? and employee.deptId=dept.deptId;";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,employeeId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                employee.setEmployeeId(resultSet.getString("employeeId"));
                employee.setEmployeeName(resultSet.getString("employeeName"));
                employee.setDeptName(resultSet.getString("deptname"));
                employee.setHeadship(resultSet.getString("headship"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setDeptId(resultSet.getString("deptId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,resultSet);
        }
        return employee;
    }

    /**
     * 根据employeeId来更新员工信息
     * @param employee
     */
    @Override
    public void updateEmployeeById(Employee employee) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        String sql="update employee set employeeName=?,deptId=(select deptId from dept where deptname=?),headship=?,salary=?,privilege=? where employeeId=?;";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            //preparedStatement.setString(1,title.getTitleNumber());
            preparedStatement.setString(1,employee.getEmployeeName());
            preparedStatement.setString(2,employee.getDeptName());
            preparedStatement.setString(3,employee.getHeadship());
            preparedStatement.setDouble(4,employee.getSalary());
            preparedStatement.setInt(5,employee.getPrivilege());
            preparedStatement.setString(6,employee.getEmployeeId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,null);
        }
    }
    /**
     * 根据职工ID来删除职工
     * @param employeeId
     */
    @Override
    public void deleteEmployeeById(String employeeId) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        String sql="delete from employee where employeeId=?";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,employeeId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,null);
        }
    }

    /**
     * 添加新的职工
     * @param employee
     */
    @Override
    public void addEmployee(Employee employee) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        String sql="insert into employee(employeeId,employeeName,password,deptId,headship,salary,privilege) values(?,?,?,?,?,?,?)";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,employee.getEmployeeId());
            preparedStatement.setString(2,employee.getEmployeeName());
            preparedStatement.setString(3,employee.getPassword());
            preparedStatement.setString(4,employee.getDeptId());
            preparedStatement.setString(5,employee.getHeadship());
            preparedStatement.setDouble(5,employee.getSalary());
            preparedStatement.setInt(5,employee.getPrivilege());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,null);
        }
    }
    /**
     * 用来查看一个职工编号是否已经存在
     * @param employeeId
     * @return
     */
    @Override
    public boolean checkEmpIdIsExist(String employeeId) {
//        String empId=null;
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select employeeId from employee where employeeId=?";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, employeeId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                //有查询到数据
//              empId=resultSet.getString("employeeId");
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(connection, preparedStatement, resultSet);
        }

        return false;
    }
}
