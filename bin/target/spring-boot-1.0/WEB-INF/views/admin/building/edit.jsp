<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="buildingAPI" value="/api/building"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh Sửa Tòa Nhà</title>
</head>
<body>
	<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">Home</a>
							</li>
							<li class="active">Dashboard</li>
						</ul><!-- /.breadcrumb -->

					</div>

					<div class="page-content">

						<div class="row">
							<div class="col-xs-12">
								<form class="form-horizontal" role="form" id="formEdit">
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="name">Tên tòa nhà</label>
										<div class="col-sm-9">
											<input type="text" id="name"  class="form-control" name="name"/>
										</div>
									</div>
                                    
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-select-3">Chọn Quận</label>
										<div class="col-sm-9">
											<select  id="form-field-select-3" name="district">
												<option value="">-- Chọn Quận --</option>
											</select><br><br>
										</div>	
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="name">Phường</label>
										<div class="col-sm-9">
											<input type="text" id="ward"  class="form-control" name="ward"/>
										</div>
									</div>
								
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="name">Đường</label>
										<div class="col-sm-9">
											<input type="text" id="street"  class="form-control" name="street"/>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="name">Kết cấu</label>
										<div class="col-sm-9">
											<input type="text" id="construction"  class="form-control" name="construction"/>
										</div>
									</div>

                                    <div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="numberOfBaseMent">Số tầng hầm</label>

										<div class="col-sm-9">
											<input type="number" id="numberOfBaseMent"  class="form-control" name="numberOfBaseMent"/>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="floorArea">Diện tích sàn</label>

										<div class="col-sm-9">
											<input type="number" id="floorArea"  class="form-control" name="floorArea"/>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="direction">Hướng</label>

										<div class="col-sm-9">
											<input type="text" id="direction"  class="form-control" name="direction"/>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="level">Hạng</label>

										<div class="col-sm-9">
											<input type="text" id="level"  class="form-control" name="level"/>
										</div>
									</div>

                                    <div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="areaRent">Diện tích thuê</label>

										<div class="col-sm-9">
											<input type="text" id="areaRent"  class="form-control" name="areaRent" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="areaRentDescription">Mô tả diện tích</label>

										<div class="col-sm-9">
											<input type="text" id="areaRentDescription"  class="form-control" name="areaRentDescription" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="rentPrice">Giá thuê</label>

										<div class="col-sm-9">
											<input type="number" id="rentPrice"  class="form-control" name="rentPrice" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="rentPriceDescription">Mô tả giá</label>

										<div class="col-sm-9">
											<input type="text" id="rentPriceDescription"  class="form-control" name="rentPriceDescription" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="serviceFee">Phí dịch vụ</label>

										<div class="col-sm-9">
											<input type="text" id="serviceFee"  class="form-control" name="serviceFee" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="carFee">Phí ô tô</label>

										<div class="col-sm-9">
											<input type="text" id="carFee"  class="form-control" name="carFee" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="motorbikeFee">Phí mô tô</label>

										<div class="col-sm-9">
											<input type="text" id="motorbikeFee"  class="form-control" name="motorbikeFee" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="overtimeFee">Phí ngoài giờ</label>

										<div class="col-sm-9">
											<input type="text" id="overtimeFee"  class="form-control" name="overtimeFee" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="electricFee">Tiền điện</label>

										<div class="col-sm-9">
											<input type="text" id="electricFee"  class="form-control" name="electricFee" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="deposit">Đặt cọc</label>

										<div class="col-sm-9">
											<input type="text" id="deposit"  class="form-control" name="deposit" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="payment">Thanh toán</label>

										<div class="col-sm-9">
											<input type="text" id="payment"  class="form-control" name="payment" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="rentTime">Thời hạn thuê</label>

										<div class="col-sm-9">
											<input type="text" id="rentTime"  class="form-control" name="rentTime" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="timeDecoration">Thời gian trang trí</label>

										<div class="col-sm-9">
											<input type="text" id="timeDecoration"  class="form-control" name="timeDecoration" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="managerName">Tên quản lý</label>

										<div class="col-sm-9">
											<input type="text" id="managerName"  class="form-control" name="managerName" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="managerPhone">Số điện thoại quản lý</label>

										<div class="col-sm-9">
											<input type="text" id="managerPhone"  class="form-control" name="managerPhone" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="brokerageFee">Phí môi giới</label>

										<div class="col-sm-9">
											<input type="text" id="brokerageFee"  class="form-control" name="brokerageFee" />
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" >Loại tòa nhà</label>

										<div class="col-sm-9">
                                            <label class="checkbox-inline">
												<input type="checkbox" value="TANG_TRET" id="buildingTypes" name="buildingTypes">
												Tầng trệt
											</label>
                                            <label class="checkbox-inline">
												<input type="checkbox" value="NGUYEN_CAN" id="buildingTypes" name="buildingTypes">
												Nguyên căn
											</label>
                                            <label class="checkbox-inline">
												<input type="checkbox" value="NOI_THAT" id="buildingTypes" name="buildingTypes">
												Nội thất
											</label>
										</div>
									</div>
                                    <div class="form-group">	
										<div class="col-sm-12 center">
											<button type="button" class="btn btn-primary" id="btnAddBuilding">Thêm tòa nhà</button>
                                            <button type="button" class="btn btn-primary">Hủy</button>
										</div>
									</div>
                                    
                                </form>
							</div>
						</div><!-- /.row -->
						
					
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->
			
			<script>
			$('#btnAddBuilding').click(function(e){
				e.preventDefault();
                var data = {};
                var buildingTypes = [];
                var formData = $('#formEdit').serializeArray();
                $.each(formData, function (index, v) { 
                    if(v.name=="buildingTypes")
                    {
                        buildingTypes.push(v.value);
                    }
                    else
                    {
                        data[""+v.name+""] = v.value; 
                    }

					//data[""+v.name+""] = v.value;
				});
                data["buildingTypes"] = buildingTypes;

                $.ajax({
                    type: 'POST',
                    url: '${buildingAPI}',
                    data: JSON.stringify(data),
                    dataType: "json",
                    contentType:"application/json",
                    success: function (response) {
                        console.log("success");
                    },
                    error: function (response) {
                        console.log("failed");
                        console.log(response);
                    }
                });
            })
		</script>
</body>
</html>