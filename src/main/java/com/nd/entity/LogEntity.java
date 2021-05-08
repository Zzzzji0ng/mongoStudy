package com.nd.entity;

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;


@Document
public class LogEntity {

    @Id
    private String _id;

    private String name;

    private Integer age;

    private Double money;

    private Boolean isChinese;

    private Double price;

    private List<String> hobby;

    private JSONObject pet;

    private Date createTime;

    private String newFields;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Boolean getChinese() {
        return isChinese;
    }

    public void setChinese(Boolean chinese) {
        isChinese = chinese;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public JSONObject getPet() {
        return pet;
    }

    public void setPet(JSONObject pet) {
        this.pet = pet;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNewFields() {
        return newFields;
    }

    public void setNewFields(String newFields) {
        this.newFields = newFields;
    }
}
