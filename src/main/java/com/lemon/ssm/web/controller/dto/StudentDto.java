package com.lemon.ssm.web.controller.dto;

import com.lemon.ssm.web.controller.entity.Grade;
import com.lemon.ssm.web.controller.entity.Student;

import java.util.List;

/**
 * <p></p>
 *
 * @author liangchao6 2018/10/29 8:38
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} 2018/10/29
 * @modify by reason:{方法名}:{原因}
 */
public class StudentDto {
    private String schoolName;

    private Integer year;

    private List<Student> studentList;

    private List<Grade> gradeList;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }

    public void setGradeList(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }
}
