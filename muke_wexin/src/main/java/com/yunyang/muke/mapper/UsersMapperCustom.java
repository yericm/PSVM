package com.yunyang.muke.mapper;

import com.yunyang.muke.pojo.Users;
import com.yunyang.muke.pojo.vo.FriendRequestVO;
import com.yunyang.muke.pojo.vo.MyFriendsVO;
import com.yunyang.muke.utils.MyMapper;

import java.util.List;


public interface UsersMapperCustom extends MyMapper<Users> {
	
	public List<FriendRequestVO> queryFriendRequestList(String acceptUserId);
	
	public List<MyFriendsVO> queryMyFriends(String userId);
	
	public void batchUpdateMsgSigned(List<String> msgIdList);
	
}