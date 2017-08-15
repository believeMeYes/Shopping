package cn.edu.neu.mapper;

import java.util.List;
import cn.edu.neu.core.common.Page;
import cn.edu.neu.model.Order;
import cn.edu.neu.model.OrderDetail;

public interface OrderMapper {

	void saveOrder(Order order);

	void saveOrderDetail(OrderDetail od);

	List<Order> findMyOrders(Page<Order> orders);

}
