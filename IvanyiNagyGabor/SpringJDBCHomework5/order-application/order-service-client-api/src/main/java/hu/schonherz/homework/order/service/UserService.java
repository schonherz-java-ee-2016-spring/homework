package hu.schonherz.homework.order.service;

import java.util.List;

import hu.schonherz.homework.order.vo.UserVo;

public interface UserService {
	
	public List<UserVo> getAllUser() throws Exception;
	
	public void addUser(UserVo userVo) throws Exception;
}
