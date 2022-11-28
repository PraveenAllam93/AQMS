package com.example.air_quality_check;


import jakarta.persistence.*;

@Entity
@Table(name = "air_quality_check")

@IdClass(entityID.class)
public class entity {

    @Id
    @GeneratedValue
    private int id, floor;
    private float  o2_level , co2_level ,so2_level ,co_level , c_level;
    private String air_quality_level;

    public entity() {}

    

    public entity(int id, int floor, float  o2_level , float co2_level ,float so2_level ,float co_level , float c_level, String air_quality_level ) {
        this.id = id;
        this.floor = floor;
        this.o2_level = o2_level;
        this.co2_level = co2_level;
        this.so2_level = so2_level;
        this.co_level = co_level;
        this.c_level = c_level;
        this.air_quality_level = air_quality_level;
    }

    public int getId() { return id; }
    public int getFloor() { return floor; }
    public float getO2_level() { return o2_level; }
    public float getCo2_level() { return co2_level; }
    public float getSo2_level() { return so2_level; }
    public float getCo_level() { return co_level; }
    public float getC_level() { return c_level; }
    public String getAir_quality_level() { return air_quality_level; }

    public void setId(int id) {
        this.id = id;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setO2_level(float o2_level) {
        this.o2_level = o2_level;
    }

    public void setCo2_level(float co2_level) {
        this.co2_level = co2_level;
    }

    public void setSo2_level(float so2_level) {
        this.so2_level = so2_level;
    }

    public void setCo_level(float co_level) {
        this.co_level = co_level;
    }

    public void setC_level(float c_level) {
        this.c_level = c_level;
    }

    public void setAir_quality_level(String air_quality_level) {
        this.air_quality_level = air_quality_level;
    }



}
