<#include "../main_template.ftl"/>

<#macro content>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Dialog with ${friend.name} ${friend.surname}</h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-8">
            <ul id="dialog">
                <#list messages as message>
                    <#if message.sender == friend>
                        <li> ${friend.name} at ${message.createdAt} : ${message.text} </li>
                    <#else>
                        <li> You at ${message.createdAt} : ${message.text} </li>
                    </#if>
                </#list>
            </ul>
            <div class="form-group">
                <label for="dialog">New message</label>
                <textarea name="text" class="text form-control" rows="3" cols="30"></textarea>
            </div>
            <div class="form-group">
                <p class="friend" style="display: none;">${friend.id}</p>
                <button type="button" class="send btn btn-primary">Send</button>
            </div>
    </div>
</div>
</#macro>

<@main title="Dialog" scripts=["/resources/custom/dialog.js"]/>