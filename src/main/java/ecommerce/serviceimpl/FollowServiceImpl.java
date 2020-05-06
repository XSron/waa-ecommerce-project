package ecommerce.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.model.Follower;
import ecommerce.repository.FollowerRepository;
import ecommerce.service.FollowService;

@Service
public class FollowServiceImpl implements FollowService {
	@Autowired
	private FollowerRepository followerRepo;

	@Override
	public void follow(Follower follower) {
		followerRepo.save(follower);
	}

	@Override
	public void unfollow(Follower follower) {
		followerRepo.delete(follower);
	}

	@Override
	public Iterable<Follower> getAllFollowersBySellerId(Long id) {
		return followerRepo.getAllFollowersBySellerId(id);
	}

	@Override
	public boolean isFollow(Integer sellerId, Integer buyerId) {
		return followerRepo.isFollow(sellerId, buyerId) > 0;
	}
	
}