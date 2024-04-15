<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="../includes/header.jsp" %>

    
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board List Page
                            <button id='regBtn' type="button" class="btn btn-xs pull-right">
                            Register New Board
                            </button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div id="dataTables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer"><div class="row"><div class="col-sm-6"><div class="dataTables_length" id="dataTables-example_length"><label>Show <select name="dataTables-example_length" aria-controls="dataTables-example" class="form-control input-sm"><option value="10">10</option><option value="25">25</option><option value="50">50</option><option value="100">100</option></select> entries</label></div></div><div class="col-sm-6"><div id="dataTables-example_filter" class="dataTables_filter"><label>Search:<input type="search" class="form-control input-sm" placeholder="" aria-controls="dataTables-example"></label></div></div></div><div class="row"><div class="col-sm-12">
                            <table width="100%" class="table table-striped table-bordered table-hover">
                                
                                <thead>
                                    <tr>
                                    	<th>#번호</th>
                                    	<th>제목</th>
                                    	<th>작성자</th>
                                    	<th>작성일</th>
                                    	<th>수정일</th>
                                    </tr>
                                </thead>
                                <c:forEach items="${list }" var="board">
                                	<tr>
                                		<td><c:out value="${board.bno }"/></td>	
                                		<td><c:out value="${board.title }"/></td>	
                                		<td><c:out value="${board.writer }"/></td>	
                                		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate }"/></td>
                                		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate }"/></td>	
                                	</tr>
                                </c:forEach>
                           
                                </table>
                                 <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                        </div>
                                        <div class="modal-body">
                                        	처리가 완료되었습니다.
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary">Save changes</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->
                                
                                </div>
                                </div>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
            </div>
            <!-- /.row -->
            
            <script type="text/javascript">
            	$(document).ready(function()){
            		var result = '<c:out value="${result}"/>';
            	});
            </script>
			
			
            
           <%@include file="../includes/footer.jsp"  %>
           
            <script type="text/javascript">
            	$(document).ready(function() {
            		var result='<c:out value="${result}"/>';
            		checkModal(result);
            		
            		function checkModal(result) {
            			if(result==='') {
            				return;
            			}
            			
            			if(parseInt(result) > 0) {
            				$(".modal-body").html("게시글 " + parseInt(result) + "번이 등록되었습니다.");
            			}
            			
            			$("#myModal").modal("show");
            		}
            		
            		$("#regBtn").on("click", function(){
            			self.location = "/board/register";
            		})
            	});
            </script>
        