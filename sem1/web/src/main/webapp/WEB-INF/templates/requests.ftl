<#include "main_template.ftl"/>

<#macro content>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Requests</h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Requests
            </div>
            <div class="panel-body">
                <div class="dataTable_wrapper">
                    <button class="all" value="All"></button>
                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                        <tr>
                            <th>Needy</th>
                            <th>Address</th>
                            <th>Created at</th>
                            <th>Type of service</th>
                            <th>Status</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody class="content">
                            <#--<#list requests as request>-->
                                <#--<tr>-->
                                    <#--<td>${request.needy.name} ${request.needy.surname}</td>-->
                                    <#--<td>${request.address}</td>-->
                                    <#--<td>${request.createdAt}</td>-->
                                    <#--<td>${request.serviceType.representation}</td>-->
                                    <#--<td>${request.status}</td>-->
                                    <#--<#if request.status == "PENDING">-->
                                        <#--<td>-->
                                            <#--<button type="button" class="btn btn-outline btn-primary btn-xs">-->
                                                <#--help!-->
                                            <#--</button>-->
                                        <#--</td>-->
                                    <#--</#if>-->
                                <#--</tr>-->
                            <#--</#list>-->
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</#macro>

<@main title="Users"
styles=["/resources/landing/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css"]
scripts=["//cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js",
"/resources/landing/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js",
"/resources/custom/users.js"]
/>