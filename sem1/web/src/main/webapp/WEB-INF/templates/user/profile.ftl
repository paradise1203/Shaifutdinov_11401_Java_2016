<#include "../main_template.ftl"/>

<#macro content>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">${user.name} ${user.surname}</h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-info">
            <div class="panel-heading">
                Profile
                <a href="/users/${user.id}/dialog" class="subscribe" style="float: right">Write message</a>
            </div>
            <div class="panel-body">
                <#if communities?has_content>
                    <p class="lead">
                        <em>Communities:</em>
                    </p>
                    <ul>
                        <#list communities as c>
                            <li>
                                <a href="/communities/${c.id}">${c.name}</a>
                            </li>
                        </#list>
                    </ul>
                    <hr>
                </#if>
                <#if needyReq?has_content>
                    <p class="lead">
                        <em>As needy:</em>
                    </p>
                    <ul>
                        <#list needyReq as r>
                            <li>
                                <a href="/requests/${r.id}">
                                    Was helped by ${r.needy.name} ${r.needy.surname} at ${r.createdAt}
                                </a>
                            </li>
                        </#list>
                    </ul>
                </#if>
                <#if volunteerReq?has_content>
                    <p class="lead">
                        <em>As volunteer:</em>
                    </p>
                    <ul>
                        <#list volunteerReq as r>
                            <li>
                                <a href="/requests/${r.id}">
                                    Helped ${r.needy.name} ${r.needy.surname} at ${r.createdAt}
                                </a>
                            </li>
                        </#list>
                    </ul>
                </#if>
                <p class="lead">
                    <em>What others think about ${user.name}</em>
                </p>
                <p>
                    <strong>Bad-</strong><em>${assessments.bad}</em>
                </p>
                <p>
                    <strong>Normal-</strong><em>${assessments.normal}</em>
                </p>
                <p>
                    <strong>Good-</strong><em>${assessments.good}</em>
                </p>
            </div>
        </div>
    </div>
</div>
</#macro>

<@main title="${user.name}"/>