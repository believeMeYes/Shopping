package cn.edu.neu.service;


import java.util.List;
import java.util.Map;
import cn.edu.neu.model.Goods;


public interface GoodsService {


	List<Goods> getNewGoods();

	List<Goods> getSalesGoods();

	List<Goods> getGoodsByCate(String cateId, String sort);

	List<Goods> getsearchGoods(String keyword, String sort);

	Goods getGoodsDetailById(String goodsId);

	Goods getGoodsSizesById(String goodsId);

	Goods getGoodsColorsById(String goodsId);

	


}
