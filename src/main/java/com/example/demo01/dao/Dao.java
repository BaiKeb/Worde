package com.example.demo01.dao;

import com.example.demo01.entity.Bean;
import com.example.demo01.tools.JDBCTools;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dao {

    @SneakyThrows
    public void add(Bean bean) {
        Connection connection = JDBCTools.getConnection();
        PreparedStatement preparedStatement = null;

        String sql = "insert into s_air_red (sar_id,air_type,air_open_type,air_temp,run_type,air_model,frame,remark,wind_direction,wind_speed) value (?,?,?,?,?,?,?,?,?,?)";
        try {


            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, bean.getSar_id());
            preparedStatement.setString(2, bean.getAir_type());
            preparedStatement.setString(3, bean.getAir_open_type());
            preparedStatement.setString(4, bean.getAir_temp());
            preparedStatement.setString(5, bean.getRun_type());
            preparedStatement.setString(6, bean.getAir_model());
            preparedStatement.setString(7, bean.getFrame());
            preparedStatement.setString(8, bean.getRemark());
            preparedStatement.setString(9, bean.getWind_direction());
            preparedStatement.setString(10, bean.getWind_speed());

            preparedStatement.executeUpdate();
            System.out.println("插入成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
