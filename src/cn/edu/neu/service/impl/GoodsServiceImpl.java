package cn.edu.neu.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.neu.core.common.Page;
import cn.edu.neu.mapper.GoodsMapper;
import cn.edu.neu.model.Category;
import cn.edu.neu.model.Goods;
import cn.edu.neu.service.GoodsService;

@Service
@Transactional 
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private GoodsMapper mapper;
	
	
	@Override
	public List<Goods> getNewGoods() {
		// TODO Auto-generated method stub
		List<Goods> newGoods=mapper.findNewGoods();
		//System.out.println(newGoods);
		return newGoods;
	}

	@Override
	public List<Goods> getSalesGoods() {
		// TODO Auto-generated method stub
		List<Goods> salesGoods=mapper.findSalesGoods();
		System.out.println(salesGoods);
		return salesGoods;
	}

	@Override
	public List<Goods> getGoodsByCate(String cateId, String sort) {
		// TODO Auto-generated method stub
		List<Goods> goods=mapper.findAllGoodsByCateId(cateId,sort);
		System.out.println(goods);
		return  goods;
	}

	@Override
	public List<Goods> getsearchGoods(String keyword, String sort) {
		// TODO Auto-generated method stub
		System.out.println("service");
		List<Goods> searchGoods=mapper.findGoodsByKeyword(keyword,sort);
		System.out.println(searchGoods);
		return searchGoods;
	}

	@Override
	public Goods getGoodsDetailById(String goodsId) {
		// TODO Auto-generated method stub
		Goods goodsDetail=mapper.findGoodsDetailById(goodsId);
		return goodsDetail;
	}

	@Override
	public Goods getGoodsSizesById(String goodsId) {
		// TODO Auto-generated method stub
		System.out.println("service");
		Goods goodsSizes=mapper.findGoodsSizesById(goodsId);
		System.out.println(goodsSizes);
		return goodsSizes;
	}

	@Override
	public Goods getGoodsColorsById(String goodsId) {
		// TODO Auto-generated method stub
		System.out.println("service");
		Goods goodsColors=mapper.findGoodsColorsById(goodsId);
		System.out.println(goodsColors);
		return goodsColors;
	}

	

}
