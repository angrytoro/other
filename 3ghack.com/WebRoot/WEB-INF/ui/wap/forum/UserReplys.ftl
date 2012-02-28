<#assign pageTitle="${name}的回复"/>
<#include "../common/Header.ftl"/>
<#include "../common/MesssgeNotification.ftl"/>
<strong>==回复==</strong>
<br/>
<#if replys??>
	<#assign floor = page * 15 + 1>
	<#list replys as reply>
		#{floor}.<a href="">回复</a>
		<#assign floor = floor + 1>
	</#list>
	<#if page != 0>
		<a href="?sid=${sid}&amp;name=${name}&amp;replyAmount=${replyAmount}&amp;page=${page - 1}">上一页</a>
	</#if>
	<#if replyAmount &gt; 15>
		<a href="?sid=${sid}&amp;name=${name}&amp;replyAmount=${replyAmount}&amp;page=${page + 1}">下一页</a>
	</#if>
</#if>
<#include "../common/Footer.ftl"/>