<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索</title>
</head>
<body>
<%@include file="../common/userTopNav.jsp" %>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
	    <%@include file="../common/userLeftNav.jsp" %>		
		</div>
	   <div class="col-md-10">
	   <div class="row">
	   <div class="col-md-12">
		<c:if test="${!empty searchGoods }">
			<c:forEach items="${searchGoods}" var="g">
				<div class="col-md-3">
					<div class="thumbnail">
						<a href="${pageContext.request.contextPath}/goods/getGoodsDetailById?goodsId=${g.goodsId}">
						<img alt="${g.goodsName}" src="${pageContext.request.contextPath}${g.goodsPic}" /></a>
						<div class="caption text-center">
							<h3>
								${g.goodsName}
							</h3>
							<p>
								原价<span class="glyphicon glyphicon-yen" aria-hidden="true"></span>${g.goodsPrice}
								<span class="glyphicon glyphicon-hand-right" aria-hidden="true"></span>
							</p>
							<p>
								现售<span class="label label-pill label-info"><span class="glyphicon glyphicon-yen" aria-hidden="true"></span>${g.goodsDiscount}</span>
							</p>
							<p>
								共售出${g.goodsSales}件
							</p>
							<p>
								<a class="btn btn-primary" href="${pageContext.request.contextPath}/goods/getGoodsDetailById?goodsId=${g.goodsId}&cateId=${g.cateId}" >查看详情</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
			</c:if>		
			</div>
			<c:if test="${empty searchGoods}">
				<div class="alert alert-danger col-md-2" role="alert">对不起，暂无此类商品</div>
			</c:if>	
			</div>
			</div>
			</div>
		</div>
	</div>
</body>
</html>