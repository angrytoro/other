<#assign pageTitle="登录网站" />
<#include "../common/Header.ftl"/>
<#include "../common/ShowErrors.ftl"/>
请登录后再继续其他操作<br />
请选择登陆方式:<br />
<select name="loginType">
	<#list stack.findValue("@com.pjxy.common.model.constant.LoginType@values()") as loginType>
		<option value="#{loginType.ordinal()}">${loginType.getTypeName()}</option>
	</#list>
</select><br />
<input name="name" type="text" value="" /><br />
<b>密码:</b><br />
<input name="password" type="text" /><br />
<anchor>1.登陆网站
	<go href="../user/login.wml" method='post'>
		<postfield name="loginType" value="$(loginType)" />
		<postfield name="name" value="$(name)" />
		<postfield name="password" value="$(password)" />
	</go>
</anchor><br />
<a href="register">2.免费注册</a><br />
(10秒注册,一步到位)<br />
<a href="findpass">3.找回密码</a><br />
<anchor>4.返回继续浏览<prev /></anchor><br />
说明:如果第一次登录，请选择"免费注册"，登录后本站会将用户信息放在网址的sid=xxxxx中，登录后请加入书签，下次从书签中访问可自动登录。请不要将带有sid=xxx的地址告诉给他人，否则可能造成ID号码被盗！若需要做链接，请去除sid=xxx中的xxx码!<br />
<#include "../common/Footer.ftl"/>