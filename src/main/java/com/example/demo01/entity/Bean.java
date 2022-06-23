package com.example.demo01.entity;

public class Bean {

    public int sar_id; // id
    public String air_type; // 品牌
    public String air_open_type; // 开关
    public String air_temp; // 温度
    public String run_type; // 模式
    public String air_model; // 空调型号
    public String frame; // 透传报文
    public String remark; // 备注
    public String wind_direction; // 风向
    public String wind_speed; // 风速

    public Bean() {
    }

    public Bean(int sar_id, String air_type, String air_open_type, String air_temp, String run_type, String air_model, String frame, String remark, String wind_direction, String wind_speed) {
        this.sar_id = sar_id;
        this.air_type = air_type;
        this.air_open_type = air_open_type;
        this.air_temp = air_temp;
        this.run_type = run_type;
        this.air_model = air_model;
        this.frame = frame;
        this.remark = remark;
        this.wind_direction = wind_direction;
        this.wind_speed = wind_speed;
    }

    public int getSar_id() {
        return sar_id;
    }

    public void setSar_id(int sar_id) {
        this.sar_id = sar_id;
    }

    public String getAir_type() {
        return air_type;
    }

    public void setAir_type(String air_type) {
        this.air_type = air_type;
    }

    public String getAir_open_type() {
        return air_open_type;
    }

    public void setAir_open_type(String air_open_type) {
        this.air_open_type = air_open_type;
    }

    public String getAir_temp() {
        return air_temp;
    }

    public void setAir_temp(String air_temp) {
        this.air_temp = air_temp;
    }

    public String getRun_type() {
        return run_type;
    }

    public void setRun_type(String run_type) {
        this.run_type = run_type;
    }

    public String getAir_model() {
        return air_model;
    }

    public void setAir_model(String air_model) {
        this.air_model = air_model;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(String wind_direction) {
        this.wind_direction = wind_direction;
    }

    public String getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(String wind_speed) {
        this.wind_speed = wind_speed;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "sar_id=" + sar_id +
                ", air_type='" + air_type + '\'' +
                ", air_open_type='" + air_open_type + '\'' +
                ", air_temp='" + air_temp + '\'' +
                ", run_type='" + run_type + '\'' +
                ", air_model='" + air_model + '\'' +
                ", frame='" + frame + '\'' +
                ", remark='" + remark + '\'' +
                ", wind_direction='" + wind_direction + '\'' +
                ", wind_speed='" + wind_speed + '\'' +
                '}';
    }
}
