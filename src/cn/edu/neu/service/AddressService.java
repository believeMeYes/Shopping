package cn.edu.neu.service;

import java.util.List;

import cn.edu.neu.model.Address;

public interface AddressService {

	 List<Address> getAddressByUserId(int loginUserId);

}
