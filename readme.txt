

dhcbox@163.com

hz.dhcbox@163.com



搭建struts2的工程环境的步骤：

1、找到struts-blank.war

2、添加相关的jar包到工程lib下

3、修改工程的web.xml(添加一个过滤器)
		
		<filter>
			<filter-name>struts2</filter-name>
			<filter-class>xxxx.StrutsPrepareAndExecuteFilter</filter-class>
		</filter>
		<filter-mapping>
			<filter-name>struts2</filter-name>
			<url-pattern>/*</url-pattern>
		</filter-mapping>
		
4、将struts的主配置放置到src下(放置到类路径之下)
	注意点：主配置的文件名不要修改,使用struts.xml(大小写也不能修改，最好从别的工程复制过来即可)
	
	
5、新建一个简单的登录页面
	确认表单提交的action参数
	这个就是我之前提过的，一切以页面为起源
	
6、创建了一个普通POJO类

	> 根据前台表单控件的name设置成员变量
	> 设置getter/setter方法
	> 创建一个普通方法:a 必须是public b 这个必须不带形参 c 返回值必须是String 
	
7、在struts的主配置文件配置POJO类	

		<!-- 在同一个包下action的name不能重复 class属性里面写的是这个类的全限定名(包名+类名) -->
    	<!-- method属性是指调用UserAction中的哪个方法 -->
		<action name="login" class="com.action.UserAction" method="login">
			<result name="success">welcome.jsp</result>
			<result name="error">error.jsp</result>
		</action>
		
8、创建welcome.jsp和error.jsp
		>从session域中获取用户名
		
		
		
以前在页面取值：JSTL+EL

如果工程中使用了struts2那么页面的取值可以通过以前的用法：JSTL标签+EL表达式
还可以使用新的方法：struts2的标签+OGNL表达式

推荐使用哪个：老方法推荐，可以复用，而且即便是更换struts2框架依然可以使用

log4j
log for java


struts2中Ajax的使用步骤

1、前台页面同以前操作
	$.post(
		"",//url
		{}，//json数据
		function(){},//成功后的回调函数
		"json"//返回类型
	);

2、在struts2的主配置文件中添加Action标签

	<action name="" class="" method="">
		<result name="" type="json">
			<param name="root">result</param>
		</result>
	</action>
	
	<package extends="json-default">
	
	导入相关jar包：struts2-json-plugin-xxxx.jar
	
3、写Action
	
		> 成员变量为result，这个变量应该与struts.xml中的param的内容一致
		> setResult(这个String最好是符合JSON格式)，建议返回到页面是一个JSON对象即可

	

自定义拦截器(内置拦截器)的使用方法：

1> 自定义一个拦截器类(实现一个Interceptor接口，或者继承自AbstractInterceptor)
	> 重写内部的intercept方法
	

2> 在struts.xml中声明拦截器
	<interceptors>
		声明使用的类
		<interceptor-ref name="myInterceptor"/>
	</interceptors>
	
3> 在struts.xml中使用拦截器

	<action>
		<result xxxxxxx>
		<interceptor-ref name="myInterceptor"/>
	</action>
	
	
内置拦截器的使用步骤：所谓内置的意思就是struts2自带的拦截器（默认的类）

1、	在struts.xml中声明拦截器
	<interceptors>
    		<interceptor-stack name="mystack">
    			<interceptor-ref name="defaultStack"/>
    			<interceptor-ref name="timer"/>
    		</interceptor-stack>
    	</interceptors>
    	
    在声明时，一定要添加<interceptor-ref name="defaultStack"/>
	
2、在struts.xml中使用拦截器
		在<action>标签中使用拦截器
		<action name="hello">
			<interceptor-ref name="mystack"/>
		</action>	

3、当前台调用这个hello时，拦截器就会生效





自定义拦截器的使用步骤

1、创建一个拦截器类
	> 继承自AbstractInterceptor(或者实现Interceptor接口)
	> 重写intercept(ActionInvocation inv),里面有个重要的方法inv.invoke();
	> 要做一个String的返回值

2、在struts.xml中声明拦截器
		<interceptors>
			<interceptor name="myInterceptor" class="拦截器类的全限定名">
    		<interceptor-stack name="mystack">
    			<interceptor-ref name="defaultStack"/>
    			<interceptor-ref name="myInterceptor"/>
    		</interceptor-stack>
    	</interceptors>
    	
    	>如果程序员自己定义了多个拦截器，他的执行顺序是按照interceptor-stack的排序执行

3、在struts.xml中使用拦截器
		在<action>标签中使用拦截器
		<action name="hello">
			<interceptor-ref name="mystack"/>
		</action>	

4、当前台调用这个hello时，自定义的拦截器就会生效





