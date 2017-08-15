package cn.edu.neu.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.neu.mapper.AddressMapper;
import cn.edu.neu.model.Address;
import cn.edu.neu.service.AddressService;

@Service
@Transactional
public class AddressServiceImpl implements AddressService{
	@Resource
	private AddressMapper mapper;
	

	@Override
	public List<Address> getAddressByUserId(int loginUserId) {
		// TODO Auto-generated method stub
		List<Address> addrs=mapper.findAddrByUserId(loginUserId);
		return addrs;
	}

}
