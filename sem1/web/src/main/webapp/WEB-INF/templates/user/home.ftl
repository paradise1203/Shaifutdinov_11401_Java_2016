<#include "../main_template.ftl"/>

<#macro content>
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Home</h1>
        </div>
    </div>

    <div class="row">
    <div class="col-lg-10">
        <p class="lead">
            <em>Active dialogs with:</em>
        </p>
        <ul>
            <#list penFriends as f>
                <li>
                    <a href="/users/${f.id}/dialog">${f.name} ${f.surname}</a>
                </li>
            </#list>
        </ul>
        <hr>
        <p class="lead">
            <em>My communities</em>
        </p>
        <ul>
            <#list communities as c>
                <li>
                    <a href="/communities/${c.id}">${c.name}</a>
                </li>
            </#list>
        </ul>
        <hr>
        <p class="lead">
            <em>What others think about me</em>
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
</#macro>

<@main title="Home"/>