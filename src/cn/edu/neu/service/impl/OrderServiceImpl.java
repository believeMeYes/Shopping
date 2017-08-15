package cn.edu.neu.service.impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.neu.core.common.Page;
import cn.edu.neu.mapper.OrderMapper;
import cn.edu.neu.model.Order;
import cn.edu.neu.model.OrderDetail;
import cn.edu.neu.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	@Resource
	private OrderMapper mapper;

	@Override
	public int addOrder(Order order, List<OrderDetail> orderDetails) {
		// TODO Auto-generated method stub
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String code=df.format(new Date());
		Random ran=new Random();
		int r=ran.nextInt(90)+10;
		code=code+r;
		order.setOrderCode(code);		
		//保存订单
		mapper.saveOrder(order);
		//保存订单明细
		for(int i=0;i<orderDetails.size();i++){
			OrderDetail od=orderDetails.get(i);
			od.setOrderId(order.getOrderId());
			mapper.saveOrderDetail(od);
		}
		return order.getOrderId();
	}

	@Override
	public Page<Order> getMyOrders(int loginUserId, String status) {
		// TODO Auto-generated method stub
		Page<Order> orders = new Page<Order>(5);
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("userId", loginUserId);
		params.put("status", status);
		orders.setParams(params);
		List<Order> orderList = mapper.findMyOrders(orders);
		orders.setList(orderList);
		return orders;
	}

	@Override
	public void delOrder(String orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeOrderStatus(String orderId, int status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getOrderStatusById(String orderId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Order getOrderDetailById(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Order> getAdminOrders(String orderCode, String userName,
			String orderStatus, String startDate, String endDate, String sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOrderPostInfo(String orderId, String orderPostname,
			String orderPostcode, int status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delOrderByIds(String[] orderIds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer[] getOrderStatusByIds(String[] orderIds) {
		// TODO Auto-generated method stub
		return null;
	}

}
