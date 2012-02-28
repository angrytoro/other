<#assign pageTitle="论坛首页" />
<#include "../common/Header.ftl"/>
<#if sessionUser??>
<#include "../common/MesssgeNotification.ftl"/>
欢迎你<b>${wml(sessionUser.name)}</b>签到<br/>
空间|信箱|帖子|回复|收藏<br />
好友|相册|日记|搜索|设置<br />
<#else>
欢迎你<a href="../user/login.wml">登录/注册</a><br />
</#if>
<#list hotPostList as post>
	<a href="post.wml?sid=${sid}&amp;postId=#{post.id}">${wml(post.title)}</a><br />
</#list>
看<a href="viewNewPost.wml?sid=${sid}">新</a>.热.精.荐.赏分帖<br />
〓火爆论坛〓 <br />
〓论坛相关〓 申版.<a href="../user/logout.wml">退出</a><br />
排行:发帖|回帖|财富|积分<br />
论坛:帮助|统计|监狱|QQ群<br />
搜索框<br />
搜索:ID.昵称.贴子.论坛<br />
在线8888人/1114会员<br />
<#include "../common/Footer.ftl"/>