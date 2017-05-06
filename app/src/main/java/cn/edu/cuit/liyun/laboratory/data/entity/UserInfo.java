package cn.edu.cuit.liyun.laboratory.data.entity;

import java.util.List;

import cn.edu.cuit.liyun.laboratory.utils.LeanEngine;

/**
 * Created by jianglei on 2017/4/25.
 */
@LeanEngine.Entity
public class UserInfo {
    protected String name="";//用户名
    protected Role role=Role.STUDENT;//用户角色
    private String number="";//编号
    private String oriClass="";//所在班级
    private String labClass="";//实验室班级
    private String objectId="";//对象id
    private String createdAt="";//对象创建时间
    private String updatedAt="";//对象更新时间
    private String url="";
    private String nick="";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOriClass() {
        return oriClass;
    }

    public void setOriClass(String oriClass) {
        this.oriClass = oriClass;
    }

    public String getLabClass() {
        return labClass;
    }

    public void setLabClass(String labClass) {
        this.labClass = labClass;
    }
}
