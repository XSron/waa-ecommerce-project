package ecommerce.service;

import ecommerce.model.Follower;

public interface FollowService {
	public void follow(Follower follower);
	public void unfollow(Follower follower);
	public Iterable<Follower> getAllFollowersBySellerId(Long id);
	public boolean isFollow(Integer sellerId, Integer buyerId);
	public Integer countFollowerBySellerId(Integer id);
}
