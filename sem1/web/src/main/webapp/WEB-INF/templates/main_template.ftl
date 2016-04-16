<#macro main title scripts=[] styles=[]>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${title}</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/landing/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="/resources/landing/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">
    <!-- Timeline CSS -->
    <link href="/resources/landing/dist/css/timeline.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="/resources/landing/dist/css/sb-admin-2.css" rel="stylesheet">
    <!-- Morris Charts CSS -->
    <link href="/resources/landing/bower_components/morrisjs/morris.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="/resources/landing/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <#list styles as style>
        <link rel="stylesheet" type="text/css" href="${style}">
    </#list>
</head>

<body>
    <div class="content">
        <@content/>
    </div>

    <#list scripts as script>
        <script type="application/javascript" src="${script}"></script>
    </#list>

    <!-- jQuery -->
    <script src="/resources/landing/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/landing/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/landing/bower_components/metisMenu/dist/metisMenu.min.js"></script>
    <!-- Morris Charts JavaScript -->
    <script src="/resources/landing/bower_components/raphael/raphael-min.js"></script>
    <script src="/resources/landing/bower_components/morrisjs/morris.min.js"></script>
    <script src="/resources/landing/js/morris-data.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="/resources/landing/dist/js/sb-admin-2.js"></script>
</body>
</#macro>