
# 电影租赁系统

项目地址：[https://github.com/antbuff/Exam-19430-20180813-1](https://github.com/antbuff/Exam-19430-20180813-1)

截图位于screeshot文件夹中，README中已添加

### 开发环境

- OS：Mac OS
- 开发工具：idea
- 数据库：MySQL 8.0.12
    - 数据库配置文件位于***/util/database.properties
- 框架：Servlet + JSP

### 功能完成度

- [x] index.jsp，导航页
- [x] 用户登录
- [x] 列表显示
- [x] 新增页面
- [x] 删除功能
- [x] 编辑功能
- [x] Filter权限校验

### 数据库配置
```
DRIVER=com.mysql.cj.jdbc.Driver
URL=jdbc:mysql://localhost:3306/sakila?useSSL=false
USER_NAME=root
PASSWORD=
```

### 总结
项目整体功能实现度100%，但是时间关系，还有许多地方需要改进：
1. 数据库未采用连接池
2. 缺乏必要的注释
3. 未采用异步模式
    - 使用了一些其他方法弥补效果
    - 单级返回，记录backurl，服务端返回
    - 多级返回，backurl临时记录在cookie或session中，服务器端跳转。
4. 必要的错误页面未添加

### 一些注意事项

1. database.properties文件，打包需要在maven中额外配置，将其添加到war包中
2.  jstl，使用maven添加，idea无法识别语法，使用报错
    - 解决方法：将jst.jar和standard.jar放到WEB-INF/lib/中，将lib添加为Library Directory。
3. 数据库使用的是新版MySQL8.0.12，需要添加额外参数useSSL，部分系统可能还需要添加时区设置


### 功能展示和截图

登录页面

![login](https://raw.githubusercontent.com/antbuff/Exam-19430-20180813-1/master/screenshot/%E7%99%BB%E5%BD%95%E7%95%8C%E9%9D%A2.png)

Filter权限校验失败，都会跳转到登录页面

登录失败

![login fail](https://raw.githubusercontent.com/antbuff/Exam-19430-20180813-1/master/screenshot/%E7%99%BB%E5%BD%95%E5%A4%B1%E8%B4%A5.png)

登录成功，跳转到导航页面

![login success](https://github.com/antbuff/Exam-19430-20180813-1/raw/master/screenshot/%E7%99%BB%E5%BD%95%E6%88%90%E5%8A%9F.png)

额外添加了注销功能。

点击查看，即可跳转到列表展示页面

![list view](https://github.com/antbuff/Exam-19430-20180813-1/raw/master/screenshot/%E5%88%97%E8%A1%A8%E5%B1%95%E7%A4%BA.png)

列表添加了分页功能

分页

![page](https://raw.githubusercontent.com/antbuff/Exam-19430-20180813-1/master/screenshot/%E5%88%86%E9%A1%B5%E6%95%88%E6%9E%9C.png)

点击列表中的编辑按钮，跳转到相应的编辑页面

编辑页面

![edit](https://raw.githubusercontent.com/antbuff/Exam-19430-20180813-1/master/screenshot/%E7%BC%96%E8%BE%91%E9%A1%B5%E9%9D%A2.png)

保存编辑或者取消编辑后，自动返回编辑前的位置

![edit success](https://raw.githubusercontent.com/antbuff/Exam-19430-20180813-1/master/screenshot/%E7%BC%96%E8%BE%91%E5%AE%8C%E6%88%90%EF%BC%8C%E8%BF%94%E5%9B%9E%E5%8E%9F%E6%9D%A5%E7%9A%84%E9%A1%B5%E9%9D%A2.png)

添加功能

添加页面和编辑页面布局大致相同

![add](https://raw.githubusercontent.com/antbuff/Exam-19430-20180813-1/master/screenshot/%E6%B7%BB%E5%8A%A0%E9%A1%B5%E9%9D%A2.png)

添加成功，自动跳转到列表中刚添加对应的位置

![add success](https://raw.githubusercontent.com/antbuff/Exam-19430-20180813-1/master/screenshot/%E6%B7%BB%E5%8A%A0%E6%88%90%E5%8A%9F%EF%BC%8C%E8%B7%B3%E8%BD%AC%E5%88%B0%E6%9C%80%E6%96%B0%E5%88%97%E8%A1%A8%E9%A1%B5.png)

删除功能，删除前确认

![delete](https://raw.githubusercontent.com/antbuff/Exam-19430-20180813-1/master/screenshot/%E5%88%A0%E9%99%A4%E6%8F%90%E7%A4%BA.png)

删除完成，返回到原来的位置

![delete success](https://raw.githubusercontent.com/antbuff/Exam-19430-20180813-1/master/screenshot/%E5%88%A0%E9%99%A4%E5%AE%8C%E6%88%90.png)

---
end