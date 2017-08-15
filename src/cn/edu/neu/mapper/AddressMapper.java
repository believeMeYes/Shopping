package cn.edu.neu.mapper;

import java.util.List;

import cn.edu.neu.model.Address;

public interface AddressMapper {

	 List<Address> findAddrByUserId(int loginUserId); 

}
