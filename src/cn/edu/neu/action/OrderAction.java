package cn.edu.neu.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import cn.edu.neu.model.Address;
import cn.edu.neu.model.Order;
import cn.edu.neu.model.OrderDetail;
import cn.edu.neu.service.AddressService;
import cn.edu.neu.service.OrderService;


@Controller
@SessionAttributes(types={String[].class})
@RequestMapping("/order")
public class OrderAction extends BaseAction{
	@Autowired
	private AddressService addressService;
	@Autowired
	private OrderService orderService;

	@RequestMapping("/buyGoods")
	public String buyGoods( Map<String,Object> m,@RequestParam(required=false) String[] goodsId,@RequestParam(required=false) String[] goodsName,
			@RequestParam(required=false) String[] goodsPrice,@RequestParam(required=false) String[] goodsDiscount,
			@RequestParam(required=false) String[] num,@RequestParam(required=false) String[] size,
			@RequestParam(required=false) String[] color,@RequestParam(required=false) String[] pic,
			@RequestParam(required=false) String[] goodsPostalfee, HttpSession session){
		
		List<Address> addrs=addressService.getAddressByUserId(this.getLoginUserId());
		m.put("addrs", addrs);
		session.setAttribute("goodsId", goodsId);
		session.setAttribute("goodsName", goodsName);
		session.setAttribute("goodsPrice", goodsPrice);
		session.setAttribute("goodsDiscount", goodsDiscount);
		session.setAttribute("goodsPostalfee", goodsPostalfee);
		session.setAttribute("num", num);
		session.setAttribute("size", size);
		session.setAttribute("color", color);
		session.setAttribute("pic", pic);
		System.out .println("goodsId="+goodsId+";goodsName="+goodsName+";goodsPrice="+goodsPrice+";goodsDiscount="+goodsDiscount+";goodsPostalfee="+goodsPostalfee+";num="+num+";size="+size+";color="+color+";pic="+pic+"");
		return "/order/buyGoods";
		
	}
	
	@RequestMapping("/addOrder")
	public String addOrder(@RequestParam String address, @RequestParam String orderPostalfee, 
			HttpSession session,Map<String,String> m){
		Order order=new Order();
		order.setUserId(this.getLoginUserId());
		order.setOrderAddress(address);
		order.setOrderPostalfee(Float.parseFloat(orderPostalfee));
		List<OrderDetail> orderDetails=new ArrayList<OrderDetail>();
		for(int j=0;j<((String[])session.getAttribute("goodsId")).length;j++){
			OrderDetail od=new OrderDetail();
			od.setGoodsId(Integer.parseInt(((String[])session.getAttribute("goodsId"))[j]));
			od.setOdetailName(((String[])session.getAttribute("goodsName"))[j]);
			od.setOdetailPrice(Float.parseFloat(((String[])session.getAttribute("goodsDiscount"))[j]));
			od.setOdetailSize(((String[])session.getAttribute("size"))[j]);
			od.setOdetailColor(((String[])session.getAttribute("color"))[j]);
			od.setOdetailNum(Integer.parseInt(((String[])session.getAttribute("num"))[j]));
			od.setOdetailPic(((String[])session.getAttribute("pic"))[j]);
			orderDetails.add(od);
		}
		try{
			int orderId=orderService.addOrder(order,orderDetails);
			m.put("orderId", order.getOrderId()+"");
			return "/order/addOrder";
		}
		catch(Exception e){
			e.printStackTrace();
			this.addMessage("提交订单失败");
			this.addRedirURL("返回", "@back");
			return EXECUTE_RESULT;
			
		}
				
		
	}

	
	
}
