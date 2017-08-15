package cn.edu.neu.mapper;

import java.util.List;
import java.util.Map;
import cn.edu.neu.model.Goods;



public interface GoodsMapper {

	
	List<Goods> findNewGoods();

	List<Goods> findSalesGoods();

	List<Goods> findAllGoodsByCateId(String cateId,String sort);

	List<Goods> findGoodsByKeyword(String keyword, String sort);

	Goods findGoodsDetailById(String goodsId);

	Goods findGoodsColorsById(String goodsId);

	Goods findGoodsSizesById(String goodsId);




}
