package ecommerce.service;

import java.util.List;

import ecommerce.model.Follower;
import ecommerce.model.User;

public interface FollowService {
	public void follow(User seller, User buyer);
	public void unfollow(User seller, User buyer);
	public List<Follower> getAllFollowersBySellerId(Long id);
	public boolean isFollow(User seller, User buyer);
}
