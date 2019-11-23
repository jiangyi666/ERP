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
        String sql="SELECT deptId,deptname from dept order by deptId;";
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

    /**
     * 跟新部门的信息
     * @param dept
     */
    @Override
    public void updateDept(Dept dept) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        String sql="update dept set deptname=? where deptId=?;";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,dept.getDeptname());
            preparedStatement.setString(2,dept.getDeptId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,null);
        }
    }

    /**
     * 根据部门的编号来删除一个部门
     * @param deptId
     */
    @Override
    public void deleteDept(String deptId) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        String sql="delete from dept where deptId=?";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,deptId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,null);
        }
    }
    /**
     * 根据部门的编号来获得部门的信息
     * @param deptId
     * @return
     */
    @Override
    public Dept getDeptById(String deptId) {
        Dept dept = new Dept();
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="SELECT deptname from dept where deptId=?;";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,deptId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                dept.setDeptId(deptId);
                dept.setDeptname(resultSet.getString("deptname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,resultSet);
        }
        return dept;
    }
    /**
     * 新增加部门信息
     */
    @Override
    public void addDept(Dept dept) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        String sql="insert into dept(deptId,deptname) values(?,?)";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,dept.getDeptId());
            preparedStatement.setString(2,dept.getDeptname());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,null);
        }
    }
    /**
     * 查询部门Id是否已经存在（用来新增加部门的时候使用)
     * @param deptId
     * @return
     */
    @Override
    public boolean checkDeptIdIsExist(String deptId) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select deptId from dept where deptId=?";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, deptId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                //有查询到数据
//              empId=resultSet.getString("employeeId");
                return true;//如果存在就返回true
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
