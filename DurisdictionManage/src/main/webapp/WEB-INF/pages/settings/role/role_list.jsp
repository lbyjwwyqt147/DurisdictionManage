<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>角色列表页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <jsp:include page="/WEB-INF/pages/commons/head.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>resources/assets/global/plugins/datatables/datatables.min.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>resources/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.css">
<%--     <link rel="stylesheet" type="text/css" href="<%=basePath%>resources/assets/global/plugins/bootstrap-table/bootstrap-table.css">
 --%>    
    <link rel="stylesheet" type="text/css" href="<%=basePath%>resources/pages/css/tally_common.css">
    
   
    
  </head>
  
  <body class="page-content">
      <div class="row">
            <div class="col-md-12">
                <!-- BEGIN SAMPLE TABLE PORTLET-->
                <div class="portlet box green">
                    <div class="portlet-title">
                        <div class="caption">
                            <i class="fa fa-list" style="font-size: 18px;"></i>列表 </div>
                        <div class="actions">
                            <a href="javascript:;" class="btn btn-default btn-sm">
                                <i class="fa fa-plus"></i> 添加 </a>
                            <a href="javascript:;" class="btn btn-default btn-sm">
                                <i class="fa fa-print"></i> Print </a>
                        </div>
                    </div>
                       <div class="portlet-body">
<!--                            <div class="table-scrollable">
 -->                           
                             <table class="table table-striped table-bordered table-hover table-checkable order-column dataTable no-footer " id="roleGrid" role="grid" height="500px">
                                                <thead>
                                                    <tr role="row" class="heading">
                                                        <th width="2%" >
                                                            <label class="mt-checkbox mt-checkbox-single mt-checkbox-outline">
                                                                <input type="checkbox" class="group-checkable" data-set="#roleGrid .checkboxes" />
                                                                <span></span>
                                                            </label>
                                                        </th>
                                                        <th data-field="id"> id </th>
                                                        <th data-field="name"> name </th>
                                                        <th data-field="column1"> lie </th>
                                                        
                                                    </tr>
                                                    </thead>
                                                    </table>
                           
                           
                              <!-- <table data-toggle="table"
								       data-url="tally/role/roleList"
								       data-query-params="queryParams"
								       data-pagination="true"
								       data-search="true"
								       data-height="300">
								    <thead>
								    <tr>
								        <th data-field="id">id</th>
								        <th data-field="name">name</th>
								        <th data-field="column1">lie</th>
								       
								    </tr>
								    </thead>
								</table> -->
                           </div> 
                                        
                       </div>
                      
                </div>
                <!-- END SAMPLE TABLE PORTLET-->
            </div>
       
       <!--  </div> -->
    
    <jsp:include page="/WEB-INF/pages/commons/bottom.jsp"></jsp:include>
    
    <script type="text/javascript" src="<%=basePath%>resources/assets/global/scripts/datatable.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/assets/global/plugins/datatables/datatables.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js"></script>
<%--  <script type="text/javascript" src="<%=basePath%>resources/assets/global/plugins/bootstrap-table/bootstrap-table.min.js"></script>
 --%> 
<%--  <script type="text/javascript" src="<%=basePath%>resources/assets/global/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
 --%><!-- table-datatables-managed.min.js -->
<%--     <script type="text/javascript" src="<%=basePath%>resources/assets/pages/scripts/table-datatables-ajax.js"></script>
 --%>  
   <script type="text/javascript" src="<%=basePath%>resources/pages/scripts/settings/role/role_list.js"></script>
  </body>
</html>
