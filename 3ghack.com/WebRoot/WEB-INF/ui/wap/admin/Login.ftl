<#assign pageTitle="黑客契约网站管理登录" />
<#include "../common/Header.ftl"/>
<#include "../common/ShowErrors.ftl"/>
管理账号:<br />
<input name="name" type="text" value="" /><br />
<b>管理密码:</b><br />
<input name="password" type="text" /><br />
<anchor>1.登陆网站
	<go href="login.wml" method='post'>
		<postfield name="name" value="$(name)" />
		<postfield name="password" value="$(password)" />
	</go>
</anchor><br />
黑客契约V2.0.0 ©2006-2011 <br />
维护:pizi<br />
维护:weefic<br />
维护:adullboy<br />
<#include "../common/Footer.ftl"/>