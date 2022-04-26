<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp" %>
<c:url var="buildingListURL" value="/admin/building-list" />

<!-- ISO-8859-1 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách tòa nhà</title>
 
</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>

				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
					</li>
					<li class="active">Dashboard</li>
				</ul>
				<!-- /.breadcrumb -->

			</div>

			<div class="page-content">
				<div class="page-header">
					<h1>
						Dashboard <small> <i
							class="ace-icon fa fa-angle-double-right"></i> overview &amp;
							stats
						</small>
					</h1>
				</div>
				<!-- /.page-header -->

				<div class="row">
					<div class="col-xs-12">
						<div class="widget-box">
							<div class="widget-header">
								<h4 class="widget-title">Tìm kiếm</h4>

								<div class="widget-toolbar">
									<a href="#" data-action="collapse"> <i
										class="ace-icon fa fa-chevron-up"></i>
									</a> <a href="#" data-action="close"> <i
										class="ace-icon fa fa-times"></i>
									</a>
								</div>
							</div>


							<div class="widget-body">
								<div class="widget-main">
									<form:form commandName="modelSearch" action="${buildingListURL}" method="GET"
										id="listForm" >
										<div class="form-horizontal">
											<div class="form-group">
												<!-- PAGE CONTENT BEGINS -->
												<div class="col-sm-6">
													<div>
														<label for="name">Tên tòa nhà</label> <input type="text"
															name="name" id="name" placeholder="" class="form-control" value="${modelSearch.name}"/>
													</div>
												</div>
												<div class="col-sm-6">
													<div>
														<label for="floorArea">Diện tích sàn</label> <input
															type="number" name="floorArea" id="floorArea"
															placeholder="" class="form-control" />
													</div>
												</div>
											</div>
											<div class="form-group">
												<br />
												<div class="col-xs-2">
													<div>
														<label for="district" style="font-weight: bold;">Chọn
															Quận</label><br />
														<select class="form-control" id="district" name="district">
															<option value="">-- Chọn Quận --</option>
															<option value="QUAN_1">Quận 1</option>
															<option value="QUAN_2">Quận 2</option>
															<option value="QUAN_4">Quận 4</option>
														</select>
													</div>
												</div>
												<div class="col-sm-5">
													<div>
														<label for="ward" style="font-weight: bold;">Phường</label>
														<input type="text" id="ward" name="ward"
															class="form-control" />
													</div>
												</div>
												<div class="col-sm-5">
													<div>
														<label for="street" style="font-weight: bold;">Đường</label>
														<input type="text" id="street" name="street"
															class="form-control" />
													</div>
												</div>
											</div>
											<div class="form-group">
												<br />
												<div class="col-sm-4">
													<div>
														<label for="numberOfBaseMent" style="font-weight: bold;">Số
															Tầng Hầm</label> <input type="text" id="numberOfBaseMent"
															name="numberOfBaseMent" class="form-control" />
													</div>
												</div>
												<div class="col-sm-4">
													<div>
														<label for="direction" style="font-weight: bold;">Hướng</label>
														<input type="text" id="direction" name="direction"
															class="form-control" />
													</div>
												</div>
												<div class="col-sm-4">
													<div>
														<label for="level" style="font-weight: bold;">Hạng</label>
														<input type="text" id="level" name="level"
															class="form-control" />
													</div>
												</div>
											</div>
											<div class="form-group">
												<!-- PAGE CONTENT BEGINS -->
												<div class="col-sm-3">
													<div>
														<label for="areaRentFrom">Diện tích từ</label> <input
															type="number" name="areaRentFrom" id="areaRentFrom"
															placeholder="" class="form-control" />
													</div>
												</div>
												<div class="col-sm-3">
													<div>
														<label for="areaRentTo">Diện tích đến</label> <input
															type="number" name="areaRentTo" id="areaRentTo"
															placeholder="" class="form-control" />
													</div>
												</div>
												<div class="col-sm-3">
													<div>
														<label for="costRentFrom">Giá thuê từ</label> <input
															type="number" name="costRentFrom" id="costRentFrom"
															placeholder="" class="form-control" />
													</div>
												</div>
												<div class="col-sm-3">
													<div>
														<label for="costRentTo">Giá thuê đến</label> <input
															type="number" name="costRentTo" id="costRentTo"
															placeholder="" class="form-control" />
													</div>
												</div>
											</div>
											<div class="form-group">
												<br />
												<div class="col-sm-4">
													<div>
														<label for="manager" style="font-weight: bold;">Tên
															Quản Lý</label> <input type="text" id="manager" name="manager"
															class="form-control" />
													</div>
												</div>
												<div class="col-sm-4">
													<div>
														<label for="phone" style="font-weight: bold;">Số
															điện thoại</label> <input type="text" id="phone" name="phone"
															class="form-control" />
													</div>
												</div>
												<div class="col-sm-2">
													<div>
														<label for="staffManagement" style="font-weight: bold;">Chọn
															Nhân Viên Phụ Trách</label><br />
														<select
															class="form-control placeholder" name="staffManagement"
															id="staffManagement">
															<option value="">Chọn nhân viên phụ trách</option>
															<option value="nguyenvana">Nguyễn Văn A</option>
															<option value="nguyenvanb">Nguyễn Văn B</option>
															<option value="nguyenvanc">Nguyễn Văn C</option>
														</select>
													</div>
												</div>
											</div>
											<div class="checkbox">
												<label> <input name="buildingTypes"
													type="checkbox" class="ace" value="TANG_TRET"/> <span class="lbl"
													style="font-weight: bold;" > Tầng Trệt</span>
												</label> <label> <input name="buildingTypes"
													type="checkbox" class="ace" value="NGUYEN_CAN" /> <span class="lbl"
													style="font-weight: bold;"> Nguyên Căn</span>
												</label> <label> <input name="buildingTypes"
													type="checkbox" class="ace" value="NOI_THAT"/> <span class="lbl"
													style="font-weight: bold;"> Nội Thất</span>
												</label>
											</div>
											<br>
											<button type="button" class="btn btn-sm btn-success" id="btnSearch">
												Tìm Kiếm <i
													class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
											</button>
									</form:form>

								</div>
							</div>
						</div>

						<!-- PAGE CONTENT ENDS -->
					</div>

				</div>
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-xs-12">
					<div class="pull-right">
						<button class="btn btn-white btn-info btn-bold"
							data-toggle="tooltip" title="Thêm tòa nhà">
							<i class="fa fa-plus-circle"></i>
						</button>
						<button class="btn btn-white btn-warning btn-bold"
							data-toggle="tooltip" title="Xóa tòa nhà" id="btnDeleteBuilding">
							<i class="fa fa-trash"></i>
						</button>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<table id="buildingList"
						class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th></th>
								<th>Tên sản phẩm</th>
								<th>Địa chỉ</th>
								<th>Tên quản lý</th>
								<th>Số điện thoại</th>
								<th>Diện tích sàn</th>
								<th>Giá thuê</th>
								<th>Phí dịch vụ</th>
								<th>Số điện thoại</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${buildingSearch}" >
								<tr>
									<td><input type="checkbox" value="1" id="checkbox_5"></td>
									<td>${item.name}</td>
									<td>${item.address}</td>
									<td>${item.managername}</td>
									<td>${item.managerphone}</td>
									<td>${item.floorarea}</td>
									<td>${item.rentprice}</td>
									<td>${item.servicefee}</td>
									<td>${item.brokeragefee}</td>
									<td>
										<button class="btn btn-xs btn-info" data-toggle="tooltip"
												title="Giao tòa nhà" onclick="assignmentBuilding(1)">
											<i class="fa fa-bars"></i>
										</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- /.page-content -->
	</div>
	</div>
	<!-- /.main-content -->
	<!-- Modal -->
	<div class="modal fade" id="assignmentBuildingModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Danh sách nhân viên</h4>
				</div>
				<div class="modal-body">
					<table id="staffList" class="table table-bordered">
						<thead>
							<tr>
								<th>Chọn nhân viên</th>
								<th>Tên nhân viên</th>

							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="checkbox" value="1" id="checkbox_1"
									checked></td>
								<td>Doe</td>

							</tr>
							<tr>
								<td><input type="checkbox" value="2" id="checkbox_2"></td>
								<td>Moe</td>

							</tr>

							<tr>
								<td><input type="checkbox" value="3" id="checkbox_3"></td>
								<td>DM</td>

							</tr>

						</tbody>
					</table>
					<input type="hidden" id="buildingId" name="buildingId">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default"
						id="btnAssignBuilding">Giao tòa nhà</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
				</div>

			</div>

		</div>

	</div>
	
	<script src="assets/js/jquery.2.1.1.min.js"></script>
	
	<script>
		function assignmentBuilding(buildingId) {
			openModalAssignmentBuilding();
			$('#buildingId').val(buildingId);
			console.log($('#buildingId').val());
		}

		function openModalAssignmentBuilding() {
			$("#assignmentBuildingModal").modal();
		}

		$("#btnAssignBuilding").click(
				function(e) {
					e.preventDefault();
					var data = {};
					data["buildingId"] = $('#buildingId').val();
					var staffIds = $('#staffList').find(
							'tbody input[type=checkbox]:checked').map(
							function() {
								return $(this).val();
							}).get();
					data['staffIds'] = staffIds;
					assignStaff(data);
				});
		function assignStaff(data) {
			$.ajax({
				type : "POST",
				url : "url",
				data : JSON.stringify(data),
				dataType : "json",
				contentType : "application/json",
				success : function(response) {

				},
				error : function(response) {
					console.log(response);
				}
			});
		}

		$('#btnDeleteBuilding').click(
				function(e) {
					e.preventDefault();
					var data = {};
					var buildingIds = $('#buildingList').find(
							'tbody input[type=checkbox]:checked').map(
							function() {
								return $(this).val();
							}).get();
					data['buildingIds'] = buildingIds;
					deleteBuilding(data);
				});

		function deleteBuilding(data) {
			$.ajax({
				type : "DELETE",
				url : "url",
				data : JSON.stringify(data),
				dataType : "json",
				contentType : "application/json",
				success : function(response) {

				}
			});
		}
		$('#btnSearch').click(function (e) { 
			e.preventDefault();
			alert("Success");
	
			$('#listForm').submit();
		});
	</script>
</body>
</html>