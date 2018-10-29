package com.lemon.ssm.web.controller.action;

import com.lemon.ssm.web.controller.dto.StudentDto;
import com.lemon.ssm.web.controller.entity.Grade;
import com.lemon.ssm.web.controller.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Struct;
import java.util.List;

/**
 * <p></p>
 *
 * @author liangchao6 2018/10/29 8:35
 * @version V1.0
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify by user: {修改人} 2018/10/29
 * @modify by reason:{方法名}:{原因}
 */
@Controller
@RequestMapping(value = "/v1")
public class StudentAction {

    @RequestMapping(value = "/simpleObject", method = RequestMethod.POST)
    @ResponseBody
    public String simpleObject(String name, Integer age) {
        System.out.println("学生的姓名：" + name + "；年龄：" + age);
        return name + ":" + age;
    }

    @RequestMapping(value = "/customObject", method = RequestMethod.POST)
    @ResponseBody
    public String customObject(Student student) {
        String name = student.getName();
        Integer age = student.getAge();
        System.out.println("学生的姓名：" + name + "；年龄：" + age);
        return name + ":" + age;
    }

    @RequestMapping(value = "/mixedObject", method = RequestMethod.POST)
    @ResponseBody
    public String mixedObject(Student student, String className, Integer classNum) {
        String stuName = student.getName();
        Integer age = student.getAge();
        System.out.println("学生的姓名：" + stuName + "；年龄：" + age);
        System.out.println("年级：" + className + "；班级数：" + classNum);
        return stuName + ":" + age + ":" + className + ":" + classNum;
    }

    @RequestMapping(value = "/simpleObjectList", method = RequestMethod.POST)
    @ResponseBody
    public String simpleObjectList(@RequestParam(value = "ids[]", required = false) List<Integer> ids) {
        //java8新特性，通过流循环集合
        ids.stream().forEach(id ->
            System.out.print(id)
        );
        return "success";
    }

    @RequestMapping(value = "/mixedSimpleObjectList", method = RequestMethod.POST)
    @ResponseBody
    public String mixedSimpleObjectList(@RequestParam(value = "ids[]", required = false) List<String> ids, Student student,
                                        String className, Integer classNum) {
        ids.stream().forEach(id ->
            System.out.print(id)
        );
        String stuName = student.getName();
        Integer age = student.getAge();
        System.out.println("学生的姓名：" + stuName + "；年龄：" + age);
        System.out.println("年级：" + className + "；班级数：" + classNum);
        return "success";
    }

    @RequestMapping(value = "/customObjectList", method = RequestMethod.POST)
    @ResponseBody
    public String customObjectList(@RequestBody List<Student> list) {
        try {
            list.stream().forEach(student ->
                System.out.println("name:" + student.getName() + " ;age:" + student.getAge())
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    @RequestMapping(value = "/customObjectListByDto", method = RequestMethod.POST)
    @ResponseBody
    public String customObjectListByDto(@RequestBody StudentDto studentDto) {
        try {
            studentDto.getStudentList().stream().forEach(student ->
                    System.out.println("name:" + student.getName() + " ;age:" + student.getAge())
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    @RequestMapping(value = "/mixedCustomObjectListByDto", method = RequestMethod.POST)
    @ResponseBody
    public String mixedCustomObjectListByDto(@RequestBody StudentDto studentDto) {
        studentDto.getStudentList().stream().forEach(student ->
                System.out.println("name:" + student.getName() + " ;age:" + student.getAge())
        );
        studentDto.getGradeList().stream().forEach(grade ->
                System.out.println("className:" + grade.getName() + " ;classNum:" + grade.getClassNum())
        );
        return "success";
    }
}
