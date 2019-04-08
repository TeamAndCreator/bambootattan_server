package com.ahau.entity.echart;

public class Visit {
    private Integer id;

    private String name;

    private Integer value;

    public Visit(Long value,String name){
        this.name=name;
        this.value= Math.toIntExact(value);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}