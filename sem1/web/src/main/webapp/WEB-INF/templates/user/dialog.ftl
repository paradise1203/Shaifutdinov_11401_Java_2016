<#include "../main_template.ftl"/>

<#macro content>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Edit info</h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
            <ul id="dialog">
                <#list messages as message>
                    <#if message.sender == friend>
                        <li> ${friend.firstName} at ${message.createdAt} : ${message.text} </li>
                    <#else>
                        <li> You at ${message.createdAt} : ${message.text} </li>
                    </#if>
                </#list>
            </ul>
            <div class="form-group">
                <label>Write your message:
                    <textarea name="text" class="form-control" rows="3" cols="30"></textarea>
                </label>
            </div>
            <div class="form-group">
                <input class="btn btn-primary" type="submit" value="Add">
            </div>
    </div>
</div>
</#macro>

<@main title="Community"/>