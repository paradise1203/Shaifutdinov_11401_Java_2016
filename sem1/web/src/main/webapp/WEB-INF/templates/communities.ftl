<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>

<#include "main_template.ftl"/>

<#macro content>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Communities</h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-info">
            <div class="panel-heading">
                Communities
                <a href="/communities/new" style="float: right">New!</a>
            </div>
            <div class="panel-body">
                <div class="dataTable_wrapper">
                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Founder</th>
                            <th>Created at</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                            <#list communities as community>
                                <td>${community.name}</td>
                                <td>${community.description}</td>
                                <td>${community.founder.name} + ${community.founder.surname}</td>
                                <td>${community.createdAt}</td>
                                <td>
                                    <a href="/requests/${request.id}" class="btn btn-outline btn-primary btn-xs">
                                        info
                                    </a>
                                </td>
                            </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</#macro>

<@main title="Communities"
       styles=["/resources/landing/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css"]
       scripts=["//cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js",
                "/resources/landing/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js",
                "/resources/custom/communities.js"]
/>