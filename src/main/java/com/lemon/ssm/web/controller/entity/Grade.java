package com.lemon.ssm.web.controller.entity;

/**
 * <p></p>
 *
 * @author liangchao6 2018/10/29 11:55
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} 2018/10/29
 * @modify by reason:{方法名}:{原因}
 */
public class Grade {
    private Integer id;
    private String name;
    private Integer classNum;

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

    public Integer getClassNum() {
        return classNum;
    }

    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }
}
