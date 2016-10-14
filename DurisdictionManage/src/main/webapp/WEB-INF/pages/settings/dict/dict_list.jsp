<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>业务字典列表</title>
    
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
    <link rel="stylesheet" type="text/css" href="<%=basePath%>resources/pages/css/tally_common.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>resources/assets/global/plugins/zTree_v3/css/zTreeStyle/zTreeStyle.css">
    
    <style type="text/css">
      .col-md-8{
        padding-right: 0;
      }
      label.col-md-3{
        padding-right: 0;
      }
    </style>

  </head>
  
  <body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white" style="background-color: white;">
    
    <div class="row" style="margin-top: 20px;">
          <!-- 字典树 div 开始 -->
         <div class="col-md-3" style="padding-right: 0px;">
             <div class="portlet box green" style="padding-left: 0px;padding-right: 0px;">
                 <div class="portlet-title">
                     <div class="caption">
                         <i class="fa fa-folder-open"></i>
                                                              字典结构
                     </div>
                     <div class="tools">
                         <a href="" class="reload" data-original-title="" title=""> </a>
                     </div>
                 </div>
                 <div class="portlet-body">
                     <div class="row">
                         <div class="col-md-12">
                               <!-- 字典树 -->
                               <div id="dictTree" class="ztree"></div>
                         </div>    
                     </div>
                </div>
             </div>
         </div>
         <!-- 字典树 div 结束 -->
         
         <!-- 字典数据列表 div 开始 -->
         <div class="col-md-5"  style="padding-left: 0px;padding-right: 0px;">
             <div class="portlet box green"  style="padding-left: 0px;padding-right: 0px;border-left: 0px !important;border-right: 0px !important;">
                 <div class="portlet-title">
                     <div class="caption">
                         <i class="fa fa-list"></i>
                                                              字典数据列表
                     </div>
                     <div class="tools">
                         <a href="" class="reload" data-original-title="" title=""> </a>
                     </div>
                 </div>
                 <div class="portlet-body">
                     <div class="row">
                         <div class="col-md-12">
                             <!-- 字典数据列表 -->
                         </div>
                     </div>
                 </div>
             </div>
         </div>
         <!-- 字典数据列表 div 结束 -->
    
         <!-- 字典表单 div 开始 -->
         <div class="col-md-4" style="padding-left: 0px;">
             <div class="portlet box green" style="padding-left: 0px;padding-right: 0px;">
                 <div class="portlet-title">
                     <div class="caption">
                         <i class="fa fa-building-o"></i>
                                                               字典表单
                     </div>
                 </div>
                 <div class="portlet-body">
                     <div class="row">
                         <div class="col-md-12">
                            <form action="" id="dict-form" class="form-horizontal" >
                                 <div class="form-body">
                                     <div class="form-group">
                                         <label class="control-label col-md-3">字典代码
                                             <span class="required">*</span>
                                         </label>
                                         <div class="col-md-8">
                                             <div class="input-icon right">
                                                 <i class="fa "></i>
                                                 <input type="text" class="form-control" name="dictWord" id="dictWord" > </div>
                                         </div>
                                     </div>
                                     <div class="form-group">
                                         <label class="control-label col-md-3">字典名称
                                             <span class="required" >*</span>
                                         </label>
                                         <div class="col-md-8">
                                             <div class="input-icon right">
                                                 <i class="fa " ></i>
                                                 <input type="text" class="form-control" name="dictName" id="dictName"> </div>
                                         </div>
                                     </div>
                                     <div class="form-group ">
                                         <label class="control-label col-md-3">所属上级
                                             <span class="required">*</span>
                                         </label>
                                         <div class="col-md-8">
                                             <div class="input-icon right">
                                                 <i class="fa " data-original-title="请选择所属上级."></i>
                                                 <input type="text" class="form-control" name="parentText" id="parentText"> </div>
                                                 <input type="hidden" name="parentCode" id="parentCode">
                                         </div>
                                     </div>
                                     <div class="form-group">
                                         <label class="control-label col-md-3">节点层次
                                            
                                         </label>
                                         <div class="col-md-8">
                                             <select class="form-control js-example-data-array" name="isParent" id="isParent" >
                                                       <option value="0">子节点</option>
                                                       <option value="1">父节点</option>
                                              </select>
                                              
                                         </div>
                                     </div>
                                     <div class="form-group">
                                         <label class="control-label col-md-3 labelcustom">实体名称
                                            
                                         </label>
                                         <div class="col-md-8">
                                             <div class="input-icon right">
                                                 <i class="fa facustom"></i>
                                                 <input type="text" class="form-control" name="entityName" id="entityName" > </div>
                                         </div>
                                     </div>
                                     <div class="form-group ">
                                         <label class="control-label col-md-3 labelcustom">字段名称
                                            
                                         </label>
                                         <div class="col-md-8">
                                             <div class="input-icon right">
                                                 <i class="fa facustom"></i>
                                                 <input type="text" class="form-control" name="entityFieldName" id="entityFieldName"  > </div>
                                         </div>
                                     </div>
                                     <div class="form-group ">
                                         <label class="control-label col-md-3" style="margin-top: 20px;">字典描述
                                     
                                         </label>
                                         <div class="col-md-8">
                                             <div class="input-icon right">
                                                 <textarea rows="3" cols="" class="form-control" name="dictDescription" id="dictDescription" style="resize:none" ></textarea>
                                            </div>
                                         </div>
                                     </div>
                                     <div class="form-group">
                                         <label class="control-label col-md-3">是否有效
                                            
                                         </label>
                                         <div class="col-md-8">
                                             <div class="mt-radio-inline">
                                                  <label class="mt-radio">
                                                      <input type="radio" name="isActivate" id="isActivate1" value="1001" checked="checked">是
                                                      <span></span>
                                                  </label>
                                                  <label class="mt-radio">
                                                      <input type="radio" name="isActivate" id="isActivate2" value="1002">否
                                                      <span></span>
                                                  </label>   
                                             </div>
                                         </div>
                                     </div>
                                     
                                 </div>
                                 <div class="form-actions">
                                     <div class="row">
                                         <div class="col-md-offset-3 col-md-9">
                                             <button type="submit" class="btn green"> <i class="fa fa-check"></i>保存</button>
                                             <button type="button" class="btn default"><i class="fa fa-circle-o-notch"></i>清空</button>
                                         </div>
                                     </div>
                                 </div>
                             </form>
                         </div>
                     </div>
                </div>
         </div>
         <!-- 字典表单 div 结束 -->
      </div>
    </div>
        
   
    
    <jsp:include page="/WEB-INF/pages/commons/bottom.jsp"></jsp:include>    
    <script type="text/javascript" src="<%=basePath%>resources/assets/global/scripts/datatable.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/assets/global/plugins/datatables/datatables.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js"></script> 
    <script type="text/javascript" src="<%=basePath%>resources/assets/global/plugins/zTree_v3/js/jquery.ztree.core.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/assets/global/plugins/zTree_v3/js/jquery.ztree.excheck.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/assets/global/plugins/zTree_v3/js/zTreeUtil.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/pages/scripts/settings/dict/dict_list.js"></script>
  </body>
</html>
