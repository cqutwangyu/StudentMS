[👨‍🎓StudentMS👩‍🎓](http://39.108.252.228/StudentMS_war_exploded/ "学生信息管理系统")
====
### 项目背景
* 2018年12月23日加入校实验室ICDIO预备队

* 2018年12月26日接到实验室布置新入成员任务：独立完成《学生信息管理系统》

* 2019年1月28日顺利完成《学生信息管理系统》并参加实验室放假前团年活动

### 要求
* 实现登录注册、增删改查基本功能
* 界面美观
### 涉及技术与工具
* 前端：html、css、JavaScript、jquery、ajax
* 后端：java、jdbc、servlet、org.json
* 数据库:mysql、Navicat for MySQL
* IDE：IntelliJ IDEA、Visual Studio Code
* 服务器：Tomcat
### 项目实现步骤
#### 一、创建Web项目并部署到Tomcat服务器。
* 1、安装JDK、IntelliJ IDEA、Tomcat。
* 2、新建java项目，实现helloworld。
* 3、在IDEA中配置并运行Tomcat。
* 3、新建Web项目，使项目能正常运行在Tomcat服务器上。
#### 二、创建数据库与表。
* 1、安装并配置mysql。
* 2、创建数据库，进入数据库，创建表。
#### 三、后端使用jdbc实现纯java的增删改查功能。
* 1、下载jar包并导入项目：mysql-connector-java-5.1.44-bin.jar。
* 2、使用jdbc的Connection连通数据库。
* 3、将连通数据库的程序封装成一个工具类中的方法，MyDatabaseConnection类中的getConnection()返回值是Connection。
* 4、通过MyDatabaseConnection.getConnection()得到的连接对象实现增删改查。
* 5、将增删改查四个方法封装到一个新类中。
#### 四、后端使用Sevrlet与web页面交互。
* 1、将项目部署到tomcat并启动。
* 2、在页面中请求Servlet，并通过Servlet改变页面内容。
#### 五、前端使用ajax传数据到后端Sevrlet。
* 1、下载并引入jquery到html中。
* 2、使用ajax发送请求到Servlet，并确保后台接收到。
* 3、后台接收请求后进行响应。
#### 六、前端、后端、数据库串通。
* 1、通过按钮点击事件使ajax发送数据库操作请求到Sevrlet。
* 2、后端根据请求内容调用相应的方法，并使用json-20180813.jar将操作结果转换为json格式，将json格式的数据返回给ajax。
* 3、ajax解析json格式的返回值，并在页面上显示操作结果。
#### 七、增删改查基本功能完全实现。
* 1、通过点击事件将输入框中的数据传到ajax，ajax将数据传到Servlet，Servlet将数据添加到数据库并返回操作结果。
#### 八、美化系统界面。
* 1、可通过F12观察你认为好的页面样式，并进行模拟。
* 2、可通过Bootstrap、layui等框架进行界面美化。
#### 九、项目优化。
* 1、后台使用MVC设计模式，并使用Alibaba代码规范检测插件。
* 2、前台将html、css、JavaScript分离。
* 3、增强用户体验，测试并修改系统漏洞。
#### 十、完成项目
* 1、可将项目提交到GitHub(推荐)或码云，并坚持更新项目以及学习笔记。
* 2、后端可继续学习Spring、SpringMVC、SpringBoot、SpringCloud、Dubbo、Docker、SpringData、MyBaties、Hibernate。
* 3、前端可继续学习Vue、element-Ui、iView、AngularJS、React、TypeScript。
### 项目实现过程

* 2018年12月26日~2018年12月28日——实现了界面简陋、数据库字段极简的增删改查、注册登录功能

* 2018年12月29日~2019年1月1日——元旦放假

* 2019年1月2日~2019年1月4日——优化了界面、增加了数据库字段、更新了增删改查的字段，并在这期间学习使用github

* 2019年1月5日——更新登录界面自适应、数据校验、错误提示、信息被清空后自动数据复原

* 2019年1月6日——IDEA中安装了阿里开源的 IDE 代码规约检测插件，并使代码规范化，通过检测。

#### StudentMS 0.7
* update:Standardize the MVC design pattern.

#### StudentMS 0.6:
* update:Added comment information for all methods.
