<#if fieldErrors??><#t/>
  <#assign eKeys = fieldErrors.keySet()><#t/>
  <#list eKeys as key><#t/>
    <#list fieldErrors[key] as errs><#t/>
      <b>${errs}</b><br/>
    </#list><#t/>
  </#list>
</#if>
<#if actionErrors??><#t/>
  <#list actionErrors as errs>
    <b>${errs}</b><br/>
  </#list>
</#if>
<#if actionMessages??><#t/>
  <#list actionMessages as errs>
    <b>${errs}</b><br/>
  </#list>
</#if>