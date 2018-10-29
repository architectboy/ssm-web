<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>springmvc入参</title>
    <script type="text/javascript" src="../../plugin/js/jquery-3.3.1.min.js"></script>
</head>
<body>
    <p>简单对象，java.lang.String、java.lang.Integer</p><button id="simpleObject" onclick="simpleObject()">触发</button>
    <p>自定义对象，Student</p><button id="customObject" onclick="customObject()">触发</button>
    <p>简单对象（String, Integer）和自定义对象Student混合</p><button id="mixedObject" onclick="mixedObject()">触发</button>

    <p>简单对象（String, Integer）列表参数传递</p><button id="simpleObjectList" onclick="simpleObjectList()">触发</button>
    <p>简单对象、自定义对象Student和简单对象（String, Integer）列表参数传递</p><button id="mixedSimpleObjectList" onclick="mixedSimpleObjectList()">触发</button>
    <p>单个自定义对象列表参数传递，通过数组方式</p><button id="customObjectList" onclick="customObjectList()">触发</button>
    <p>单个自定义对象列表参数传递，通过DTO的方式</p><button id="customObjectListByDto" onclick="customObjectListByDto()">触发</button>
    <p>多个自定义对象列表参数传递，通过DTO的方式</p><button id="mixedCustomObjectListByDto" onclick="mixedCustomObjectListByDto()">触发</button>
</body>
<script type="text/javascript" src="./js/student.js"></script>
<script>
    function simpleObject() {
        /*必须与后端参数名保持一致*/
        var data = {
            "name": "张三",
            "age": 12
        };
        var url = "<%=request.getContextPath()%>" + "/v1/simpleObject.action";
        $.ajax({
            url: url,
            type: "POST",
            data: data,
            dataType: "text",
            success: function (result) {
                alert(result);
            }
        });
    }

    function customObject() {
        /*必须与自定义对象的属性名保持一致*/
        var data = {
            "name": "张三",
            "age": 12
        };
        var url = "<%=request.getContextPath()%>" + "/v1/customObject.action";
        $.ajax({
            url: url,
            type: "POST",
            data: data,
            dataType: "text",
            success: function (result) {
                alert(result);
            }
        });
    }

    function mixedObject() {
        /*name、age必须和Student的属性一致，className、classNum必须和后台参数名一致*/
        var data = {
            "name": "张三",
            "age": 12,
            "className" : "二年级",
            "classNum" : 3
        };
        var url = "<%=request.getContextPath()%>" + "/v1/mixedObject.action";
        $.ajax({
            url: url,
            type: "POST",
            data: data,
            dataType: "text",
            success: function (result) {
                alert(result);
            }
        });
    }

    function simpleObjectList() {
        /*必须与自定义对象的属性名保持一致*/
        var data = {
            "ids" : [1, 2, 3, 4]
        };
        var url = "<%=request.getContextPath()%>" + "/v1/simpleObjectList.action";
        $.ajax({
            url: url,
            type: "POST",
            data: data,
            dataType: "text",
            success: function (result) {
                alert(result);
            }
        });
    }

    function mixedSimpleObjectList() {
        /*必须与自定义对象的属性名保持一致*/
        var data = {
            "ids" : [1, 2, 3, 4],
            "name": "张三",
            "age": 12,
            "className" : "二年级",
            "classNum" : 3
        };
        var url = "<%=request.getContextPath()%>" + "/v1/mixedSimpleObjectList.action";
        $.ajax({
            url: url,
            type: "POST",
            data: data,
            dataType: "text",
            success: function (result) {
                alert(result);
            }
        });
    }
    function customObjectList() {
        var studentArray = [];
        var student = new Object();
        student.name = "张三";
        student.age = 12;
        studentArray.push(student);
        var student1 = new Object();
        student1.name = "李四";
        student1.age = 13;
        studentArray.push(student1);
        var url = "<%=request.getContextPath()%>" + "/v1/customObjectList.action";
        $.ajax({
            url: url,
            type: "POST",
            data: JSON.stringify(studentArray),     //将数组转化为json字符串
            dataType: "text",
            contentType: "application/json; charset=utf-8",
            success: function (result) {
                alert(result);
            }
        });
    }
    function customObjectListByDto() {
        /!*必须与自定义对象的属性名保持一致*!/
        var data = {
            "studentList" : [
                {"name" : "张三", "age" : 12},
                {"name" : "李四", "age" : 13}
            ]
        };
        var url = "<%=request.getContextPath()%>" + "/v1/customObjectListByDto.action";
        $.ajax({
            url: url,
            type: "POST",
            data: JSON.stringify(data),     //将数组转化为json字符串
            dataType: "text",
            contentType: "application/json; charset=utf-8",
            success: function (result) {
                alert(result);
            }
        });
    }

    function mixedCustomObjectListByDto() {
        /!*必须与自定义对象的属性名保持一致*!/
        var data = {
            "schoolName" : "东方完小",
            "year" : 2018,
            "studentList" : [
                {"name" : "张三", "age" : 12},
                {"name" : "李四", "age" : 13}
            ],
            "gradeList" : [
                {"name" : "二年级", "classNum" : 2},
                {"name" : "三年级", "classNum" : 3}
            ]
        };
        var url = "<%=request.getContextPath()%>" + "/v1/mixedCustomObjectListByDto.action";
        $.ajax({
            url: url,
            type: "POST",
            data: JSON.stringify(data),     //将数组转化为json字符串
            dataType: "text",
            contentType: "application/json; charset=utf-8",
            success: function (result) {
                alert(result);
            }
        });
    }
</script>
</html>
