<div class="dataTable_wrapper">
    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
        <thead>
            <tr>
                <th>Needy</th>
                <th>Address</th>
                <th>Created at</th>
                <th>Type of service</th>
                <th>Status</th>
                <th>Volunteer</th>
            </tr>
        </thead>
        <tbody class="content">
            <#list requests as request>
                <tr>
                    <td>${request.needy.name} ${request.needy.surname}</td>
                    <td>${request.address}</td>
                    <td>${request.createdAt}</td>
                    <td>${request.serviceType.representation}</td>
                    <td>${request.status}</td>
                    <td>
                        <#if request.volunteer??>
                        ${request.volunteer.name} ${request.volunteer.surname}
                        <#else>
                            No yet
                        </#if>
                    </td>
                <#--<#if request.status == "PENDING">-->
                <#--<td>-->
                <#--<button type="button" class="btn btn-outline btn-primary btn-xs">-->
                <#--help!-->
                <#--</button>-->
                <#--</td>-->
                <#--</#if>-->
                </tr>
            </#list>
        </tbody>
    </table>
</div>