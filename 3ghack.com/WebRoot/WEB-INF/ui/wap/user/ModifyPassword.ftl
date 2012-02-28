<#assign pagaTitle = "修改密码">
<#include "../common/Header.ftl"/>
<#include "../common/MesssgeNotification.ftl"/>
<strong>==修改密码==</strong>
<p>
      当前密码：<input name="oldPassword" type="password" /><br/>
        新密码：<input name="newPassword" type="password" /><br/>
重新输入新密码：<input name="confirmPassword" type="password" /><br/>
</p>
<anchor>修改
	<go href="modifyPassword.wml?sid=${sid}" method="post">
		<postfield name="oldPassword" value="$(oldPassword)" />
		<postfield name="newPassword" value="$(newPassword)" />
		<postfield name="confirmPassword" value="$(confirmPassword)" />
	</go>
</anchor>
<#include "../common/Footer.ftl"/>